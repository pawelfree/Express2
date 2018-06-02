package pl.bsb.elixir.express.entity.agent.provider;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.bsb.elixir.express.entity.agent.Statement;
import pl.bsb.proELIX.common.utils.criteria.BaseSearchCriteria;

/**
 *
 * @author paweld
 */
@Stateless
@LocalBean
public class StatementProvider extends Provider<Statement, BaseSearchCriteria> {

    private static final long serialVersionUID = 5L;
    private static final Logger LOGGER = LoggerFactory.getLogger(StatementProvider.class);

    public StatementProvider() {
        super(Statement.class);
    }

    public List<Statement> getStatementsByTransactionId(String transactionId) {
        return this.getEntityManager().createNamedQuery("getStatementsByTransactionId", Statement.class)
                .setParameter("transactionId", transactionId)
                .getResultList();
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void add(Statement statement) {
        try {
            super.add(statement);
        } catch (Exception ex) {
            LOGGER.warn("Exception while adding statement " + ex.getCause());
        }
    }
}
