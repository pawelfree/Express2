package pl.bsb.elixir.express.enterprise.agent;

import iso.std.iso._20022.tech.xsd.pacs_002_001.Document;
import iso.std.iso._20022.tech.xsd.pacs_002_001.TransactionIndividualStatus3Code;
import iso.std.iso._20022.tech.xsd.pacs_008_001.FIToFICustomerCreditTransferV02;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.OptimisticLockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.bsb.elixir.express.enterprise.agent.interfaces.IAcknowledgeCredit;
import pl.bsb.elixir.express.entity.agent.InternalStatus;
import pl.bsb.elixir.express.entity.agent.Money;
import pl.bsb.elixir.express.entity.agent.TransactionIncoming;
import pl.bsb.elixir.express.entity.agent.provider.AccountProvider;
import pl.bsb.elixir.express.entity.agent.provider.TransactionIncomingProvider;
import pl.bsb.elixir.express.util.ExternalStatusReason1Code;
import pl.bsb.elixir.express.util.Instruction;
import pl.bsb.elixir.express.util.ResponseDocumentCreator;

/**
 *
 * @author paweld
 */
@Stateless
@Local
public class AcknowledgeCredit implements IAcknowledgeCredit {

    private static final Logger logger = LoggerFactory.getLogger(AcknowledgeCredit.class);
    private static final int OPTIMISTIC_LOCK_RETRIES = 3;    
    private static final long serialVersionUID = 16L;
    @EJB
    TransactionIncomingProvider transactionIncomingProvider;
    @EJB
    AccountProvider accountProvider;

    //test only
    void setTransactionIncomingProvider(TransactionIncomingProvider transactionIncomingProvider) {
        this.transactionIncomingProvider = transactionIncomingProvider;
    }

    //test only
    void setAccountProvider(AccountProvider accountProvider) {
        this.accountProvider = accountProvider;
    }

    private boolean creditTransaction(TransactionIncoming transaction) {
        boolean result = false;
        for (int i = 0; i < OPTIMISTIC_LOCK_RETRIES; i++) {
            try {
                accountProvider.creditTransaction(transaction);
                result = true;
                logger.debug("Credited account for transaction "
                        .concat(transaction.getTransactionId())
                        .concat(" at attempt ")
                        .concat(String.valueOf(i + 1)));
                break;
            } catch (Exception e) {
                if (isOptimisticLockException(e)) {
                    logger.info("Optimistic lock while crediting account for transaction "
                            .concat(transaction.getTransactionId())
                            .concat(", attempt ")
                            .concat(String.valueOf(i + 1))
                            .concat(", cause ") + e.getCause());
                    continue;
                } else {
                    logger.error("Exception " + e.getClass() + " while crediting account for transaction "
                            .concat(transaction.getTransactionId())
                            .concat(", attempt ")
                            .concat(String.valueOf(i + 1))
                            .concat(", cause ") + e.getCause());
                    break;
                }
            }
        }
        return result;
    }

    private boolean isOptimisticLockException(Exception exception) {
        boolean result = false;
        if (exception instanceof EJBException) {
            Throwable  t = exception.getCause();
            while(t != null ) {
                if (t instanceof OptimisticLockException) {
                    result = true;
                    break;
                } else {
                    t = t.getCause();
                }
            }
        } 
        return result;
    }    
    
    //TODO obsługa powtórnego przysłania żądania uznania rachunku
    //TODO czy własciwy typ komunikatu
    @Override
    public Document process(iso.std.iso._20022.tech.xsd.pacs_008_001.Document document) {
        Document response;

        FIToFICustomerCreditTransferV02 transfer = document.getFIToFICstmrCdtTrf();
        String transactionId = transfer.getCdtTrfTxInf().getPmtId().getTxId();

        TransactionIncoming transactionIncoming = transactionIncomingProvider.getTransactionById(transactionId);

        boolean result;
        if (isTransactionValidToCredit(transactionIncoming, transactionId, transfer)) {
            if (transactionIncoming.getStatus().equals(InternalStatus.AUTHORIZE_ACCEPTED)) {
                //przelew nie został jeszcze zrealizowany
                if (creditTransaction(transactionIncoming)) {
                    logger.info("Account ".concat(transactionIncoming.getReceiverAccount().getFormattedAccountNumber())
                            .concat(" credited with amount ")
                            .concat(transactionIncoming.getTransactionAmount().getAmount().toString()));
                    result = true;
                } else {
                    logger.warn("Cant credit account "
                            .concat(transactionIncoming.getReceiverAccount().getFormattedAccountNumber())
                            .concat(" for transaction ").concat(transactionId)
                            .concat(" Consult log for more information"));
                    transactionIncoming.setStatus(InternalStatus.ACKNOWLEDGE_CREDIT_REJECTED);
                    result = false;
                }
            } else {//if (transactionIncoming.getStatus().equals(InternalStatus.ACKNOWLEDGE_CREDIT_ACCEPTED)) 
                //przelew został zrealizowany wobec czego mamy do czynienia z duplikatem
                logger.warn("Duplicate transaction found - transaction id : ".concat(transactionId)
                        .concat(" Original transaction status ").concat(transactionIncoming.getStatus().toString()));
                result = true;
            }
        } else {
            result = false;
        }

        if (result) {
            response = ResponseDocumentCreator.createAcknowledgeCreditDebitResponse(transfer, TransactionIndividualStatus3Code.ACSC);
        } else {
            response = ResponseDocumentCreator.createAcknowledgeCreditDebitResponse(ExternalStatusReason1Code.FF01,
                    transfer, TransactionIndividualStatus3Code.RJCT);
        }
        return response;
    }

    private boolean isTransactionValidToCredit(TransactionIncoming transactionIncoming,
            String transactionId,
            FIToFICustomerCreditTransferV02 transfer) {
        boolean result = true;
        if (!transfer.getCdtTrfTxInf().getPmtId().getInstrId().equalsIgnoreCase(Instruction.ackCrdt.toString())) {
            //weryfikacja kodu instrukcji
            result = false;
            logger.warn("Expected instruction is ".concat(Instruction.ackCrdt.toString())
                    .concat(" but received is ").concat(transfer.getCdtTrfTxInf().getPmtId().getInstrId()));
        } else if (transactionIncoming == null) {
            //weryfikacja czy obciążenie dotyczy wcześniej zapoczątkowanego przelewu
            result = false;
            logger.warn("Cant find transaction with id : ".concat(transactionId).concat(" to acknowledge credit."));
        } else {
            InternalStatus status = transactionIncoming.getStatus();
            //weryfikacja czy status transakcji jest odpowiedni aby wykonać obciążenie
            if ((!status.equals(InternalStatus.AUTHORIZE_ACCEPTED)) && (!status.equals(InternalStatus.ACKNOWLEDGE_CREDIT_ACCEPTED))) {
                result = false;
                logger.warn("Transaction with id : ".concat(transactionId).concat(" found but it has ")
                        .concat(status.value()).concat(" status, but should have staus of ")
                        .concat(InternalStatus.AUTHORIZE_ACCEPTED.value()).concat(" or ")
                        .concat(InternalStatus.ACKNOWLEDGE_CREDIT_ACCEPTED.value()).concat(" (for duplicate)"));
            } else if (status.equals(InternalStatus.AUTHORIZE_ACCEPTED)) {
                Money transactionExpectedAmount = transactionIncoming.getTransactionAmount();
                Money transactionDebitAmount = new Money(transfer.getCdtTrfTxInf().getInstdAmt().getValue());
                //weryfikacja czy kwota w zleceniu przelewu jest taka sama jak w  (tym) żadaniu obciążenia rachunku
                if (transactionExpectedAmount.compareTo(transactionDebitAmount) != 0) {
                    result = false;
                    logger.warn("Cant acknowledge credit for transaction with id : ".concat(transactionId)
                            .concat(" Ordered amount ").concat(transactionIncoming.getTransactionAmount().toString())
                            .concat(" but expectet to credit ")
                            .concat(transfer.getCdtTrfTxInf().getInstdAmt().getValue().toString()));
                }
            }
        }

        return result;
    }
}
