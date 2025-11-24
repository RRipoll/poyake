
package com.etantolling.fastlane.wsdot.tcs.wsdl.reconciliation.daily;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para arrayElement complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="arrayElement"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="facilityCode" type="{http://daily.reconciliation.wsdl.tcs.wsdot.fastlane.etantolling.com}facilityCodeType"/&gt;
 *         &lt;element name="plazaCode" type="{http://daily.reconciliation.wsdl.tcs.wsdot.fastlane.etantolling.com}plazaCodeType"/&gt;
 *         &lt;element name="laneNumber" type="{http://daily.reconciliation.wsdl.tcs.wsdot.fastlane.etantolling.com}laneNumberType"/&gt;
 *         &lt;element name="transactionType" type="{http://daily.reconciliation.wsdl.tcs.wsdot.fastlane.etantolling.com}transactionTypeType"/&gt;
 *         &lt;element name="avcClassification" type="{http://daily.reconciliation.wsdl.tcs.wsdot.fastlane.etantolling.com}vehicleClassType"/&gt;
 *         &lt;element name="transactionCount" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "arrayElement", propOrder = {

})
public class ArrayElement {

    @XmlElement(required = true)
    protected String facilityCode;
    @XmlElement(required = true)
    protected String plazaCode;
    protected int laneNumber;
    @XmlElement(required = true)
    protected String transactionType;
    @XmlElement(required = true)
    protected String avcClassification;
    protected long transactionCount;

    /**
     * Obtiene el valor de la propiedad facilityCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacilityCode() {
        return facilityCode;
    }

    /**
     * Define el valor de la propiedad facilityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacilityCode(String value) {
        this.facilityCode = value;
    }

    /**
     * Obtiene el valor de la propiedad plazaCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlazaCode() {
        return plazaCode;
    }

    /**
     * Define el valor de la propiedad plazaCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlazaCode(String value) {
        this.plazaCode = value;
    }

    /**
     * Obtiene el valor de la propiedad laneNumber.
     * 
     */
    public int getLaneNumber() {
        return laneNumber;
    }

    /**
     * Define el valor de la propiedad laneNumber.
     * 
     */
    public void setLaneNumber(int value) {
        this.laneNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Define el valor de la propiedad transactionType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionType(String value) {
        this.transactionType = value;
    }

    /**
     * Obtiene el valor de la propiedad avcClassification.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvcClassification() {
        return avcClassification;
    }

    /**
     * Define el valor de la propiedad avcClassification.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvcClassification(String value) {
        this.avcClassification = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionCount.
     * 
     */
    public long getTransactionCount() {
        return transactionCount;
    }

    /**
     * Define el valor de la propiedad transactionCount.
     * 
     */
    public void setTransactionCount(long value) {
        this.transactionCount = value;
    }

}
