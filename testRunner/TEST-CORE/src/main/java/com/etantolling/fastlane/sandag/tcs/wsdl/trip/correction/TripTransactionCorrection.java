
package com.etantolling.fastlane.sandag.tcs.wsdl.trip.correction;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tripSequenceNumber" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="oldFareAmount" type="{http://correction.trip.wsdl.tcs.sandag.fastlane.etantolling.com}OldFareAmountType"/&gt;
 *         &lt;element name="newFareAmount" type="{http://correction.trip.wsdl.tcs.sandag.fastlane.etantolling.com}NewFareAmountType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tripSequenceNumber",
    "oldFareAmount",
    "newFareAmount"
})
@XmlRootElement(name = "TripTransactionCorrection")
public class TripTransactionCorrection {

    protected long tripSequenceNumber;
    @XmlElement(required = true)
    protected BigDecimal oldFareAmount;
    @XmlElement(required = true)
    protected BigDecimal newFareAmount;

    /**
     * Obtiene el valor de la propiedad tripSequenceNumber.
     * 
     */
    public long getTripSequenceNumber() {
        return tripSequenceNumber;
    }

    /**
     * Define el valor de la propiedad tripSequenceNumber.
     * 
     */
    public void setTripSequenceNumber(long value) {
        this.tripSequenceNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad oldFareAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOldFareAmount() {
        return oldFareAmount;
    }

    /**
     * Define el valor de la propiedad oldFareAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOldFareAmount(BigDecimal value) {
        this.oldFareAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad newFareAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNewFareAmount() {
        return newFareAmount;
    }

    /**
     * Define el valor de la propiedad newFareAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNewFareAmount(BigDecimal value) {
        this.newFareAmount = value;
    }

}
