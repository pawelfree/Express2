//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.07.25 at 02:34:50 PM CEST 
//


package pl.com.kir.srpn.soap.availability;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PeriodMonthType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PeriodMonthType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="validFrom" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="validTo" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="cycleFrom" use="required" type="{http://soap.srpn.kir.com.pl/availability}DayOfWeekType" />
 *       &lt;attribute name="cycleTo" use="required" type="{http://soap.srpn.kir.com.pl/availability}DayOfWeekType" />
 *       &lt;attribute name="unavailableFrom" use="required" type="{http://www.w3.org/2001/XMLSchema}time" />
 *       &lt;attribute name="unavailableTo" use="required" type="{http://www.w3.org/2001/XMLSchema}time" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PeriodMonthType")
public class PeriodMonthType {

    @XmlAttribute(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validFrom;
    @XmlAttribute
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validTo;
    @XmlAttribute(required = true)
    protected short cycleFrom;
    @XmlAttribute(required = true)
    protected short cycleTo;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar unavailableFrom;
    @XmlAttribute(required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar unavailableTo;

    /**
     * Gets the value of the validFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidFrom() {
        return validFrom;
    }

    /**
     * Sets the value of the validFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidFrom(XMLGregorianCalendar value) {
        this.validFrom = value;
    }

    /**
     * Gets the value of the validTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidTo() {
        return validTo;
    }

    /**
     * Sets the value of the validTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidTo(XMLGregorianCalendar value) {
        this.validTo = value;
    }

    /**
     * Gets the value of the cycleFrom property.
     * 
     */
    public short getCycleFrom() {
        return cycleFrom;
    }

    /**
     * Sets the value of the cycleFrom property.
     * 
     */
    public void setCycleFrom(short value) {
        this.cycleFrom = value;
    }

    /**
     * Gets the value of the cycleTo property.
     * 
     */
    public short getCycleTo() {
        return cycleTo;
    }

    /**
     * Sets the value of the cycleTo property.
     * 
     */
    public void setCycleTo(short value) {
        this.cycleTo = value;
    }

    /**
     * Gets the value of the unavailableFrom property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUnavailableFrom() {
        return unavailableFrom;
    }

    /**
     * Sets the value of the unavailableFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUnavailableFrom(XMLGregorianCalendar value) {
        this.unavailableFrom = value;
    }

    /**
     * Gets the value of the unavailableTo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUnavailableTo() {
        return unavailableTo;
    }

    /**
     * Sets the value of the unavailableTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUnavailableTo(XMLGregorianCalendar value) {
        this.unavailableTo = value;
    }

}