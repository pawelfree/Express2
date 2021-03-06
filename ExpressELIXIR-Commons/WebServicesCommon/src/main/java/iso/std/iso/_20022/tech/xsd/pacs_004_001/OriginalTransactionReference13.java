package iso.std.iso._20022.tech.xsd.pacs_004_001;

import iso.std.iso._20022.tech.xsd.pacs_008_001.CreditTransferTransactionInformation11;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for OriginalTransactionReference13 complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OriginalTransactionReference13">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Amt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.02}AmountType3Choice"/>
 *         &lt;element name="Dbtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.02}PartyIdentification32"/>
 *         &lt;element name="DbtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.02}CashAccount16"/>
 *         &lt;element name="DbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.02}BranchAndFinancialInstitutionIdentification4"/>
 *         &lt;element name="CdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.02}BranchAndFinancialInstitutionIdentification4"/>
 *         &lt;element name="Cdtr" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.02}PartyIdentification32"/>
 *         &lt;element name="CdtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pacs.004.001.02}CashAccount16"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalTransactionReference13", propOrder = {
  "amt",
  "dbtr",
  "dbtrAcct",
  "dbtrAgt",
  "cdtrAgt",
  "cdtr",
  "cdtrAcct"
})
public class OriginalTransactionReference13 {

  @XmlElement(name = "Amt", required = true)
  protected AmountType3Choice amt;
  @XmlElement(name = "Dbtr", required = true)
  protected PartyIdentification32 dbtr;
  @XmlElement(name = "DbtrAcct", required = true)
  protected CashAccount16 dbtrAcct;
  @XmlElement(name = "DbtrAgt", required = true)
  protected BranchAndFinancialInstitutionIdentification4 dbtrAgt;
  @XmlElement(name = "CdtrAgt", required = true)
  protected BranchAndFinancialInstitutionIdentification4 cdtrAgt;
  @XmlElement(name = "Cdtr", required = true)
  protected PartyIdentification32 cdtr;
  @XmlElement(name = "CdtrAcct", required = true)
  protected CashAccount16 cdtrAcct;

  /**
   * Gets the value of the amt property.
   *
   * @return possible object is {@link AmountType3Choice }
   *
   */
  public AmountType3Choice getAmt() {
    return amt;
  }

  /**
   * Sets the value of the amt property.
   *
   * @param value allowed object is {@link AmountType3Choice }
   *
   */
  public void setAmt(AmountType3Choice value) {
    this.amt = value;
  }

  /**
   * Gets the value of the dbtr property.
   *
   * @return possible object is {@link PartyIdentification32 }
   *
   */
  public PartyIdentification32 getDbtr() {
    return dbtr;
  }

  /**
   * Sets the value of the dbtr property.
   *
   * @param value allowed object is {@link PartyIdentification32 }
   *
   */
  public void setDbtr(PartyIdentification32 value) {
    this.dbtr = value;
  }

  /**
   * Gets the value of the dbtrAcct property.
   *
   * @return possible object is {@link CashAccount16 }
   *
   */
  public CashAccount16 getDbtrAcct() {
    return dbtrAcct;
  }

  /**
   * Sets the value of the dbtrAcct property.
   *
   * @param value allowed object is {@link CashAccount16 }
   *
   */
  public void setDbtrAcct(CashAccount16 value) {
    this.dbtrAcct = value;
  }

  /**
   * Gets the value of the dbtrAgt property.
   *
   * @return possible object is {@link BranchAndFinancialInstitutionIdentification4 }
   *
   */
  public BranchAndFinancialInstitutionIdentification4 getDbtrAgt() {
    return dbtrAgt;
  }

  /**
   * Sets the value of the dbtrAgt property.
   *
   * @param value allowed object is {@link BranchAndFinancialInstitutionIdentification4 }
   *
   */
  public void setDbtrAgt(BranchAndFinancialInstitutionIdentification4 value) {
    this.dbtrAgt = value;
  }

  /**
   * Gets the value of the cdtrAgt property.
   *
   * @return possible object is {@link BranchAndFinancialInstitutionIdentification4 }
   *
   */
  public BranchAndFinancialInstitutionIdentification4 getCdtrAgt() {
    return cdtrAgt;
  }

  /**
   * Sets the value of the cdtrAgt property.
   *
   * @param value allowed object is {@link BranchAndFinancialInstitutionIdentification4 }
   *
   */
  public void setCdtrAgt(BranchAndFinancialInstitutionIdentification4 value) {
    this.cdtrAgt = value;
  }

  /**
   * Gets the value of the cdtr property.
   *
   * @return possible object is {@link PartyIdentification32 }
   *
   */
  public PartyIdentification32 getCdtr() {
    return cdtr;
  }

  /**
   * Sets the value of the cdtr property.
   *
   * @param value allowed object is {@link PartyIdentification32 }
   *
   */
  public void setCdtr(PartyIdentification32 value) {
    this.cdtr = value;
  }

  /**
   * Gets the value of the cdtrAcct property.
   *
   * @return possible object is {@link CashAccount16 }
   *
   */
  public CashAccount16 getCdtrAcct() {
    return cdtrAcct;
  }

  /**
   * Sets the value of the cdtrAcct property.
   *
   * @param value allowed object is {@link CashAccount16 }
   *
   */
  public void setCdtrAcct(CashAccount16 value) {
    this.cdtrAcct = value;
  }

  public static OriginalTransactionReference13 buildFromCreditTransferReference(CreditTransferTransactionInformation11 ctti) {
    OriginalTransactionReference13 otr = new OriginalTransactionReference13();
    //TODO required nulls
    otr.amt = AmountType3Choice.instance(ctti.getInstdAmt().getValue());
    //TODO poprawić z adresem
    otr.cdtr = PartyIdentification32.instance(ctti.getCdtr().getNm());
    otr.cdtrAcct = CashAccount16.instance(ctti.getCdtrAcct().getId().getIBAN());
    otr.cdtrAgt = BranchAndFinancialInstitutionIdentification4.instance(ctti.getCdtrAgt().getFinInstnId().getOthr().getId());
    //TODO poprawić z adresem
    otr.dbtr = PartyIdentification32.instance(ctti.getDbtr().getNm());
    otr.dbtrAcct = CashAccount16.instance(ctti.getDbtrAcct().getId().getIBAN());
    otr.dbtrAgt = BranchAndFinancialInstitutionIdentification4.instance(ctti.getDbtrAgt().getFinInstnId().getOthr().getId());
    return otr;
  }
}
