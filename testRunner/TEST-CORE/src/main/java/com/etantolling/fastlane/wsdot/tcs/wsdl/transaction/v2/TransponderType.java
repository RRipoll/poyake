
package com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para transponderType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="transponderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="transponderID" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}transponderIDType"/&gt;
 *         &lt;element name="agencyCode" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}issuingAgencyCodeType"/&gt;
 *         &lt;element name="status" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}transponderStatusType"/&gt;
 *         &lt;element name="transponderProtocol" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}transponderProtocolType" minOccurs="0"/&gt;
 *         &lt;element name="declarationState" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}declarationStateType" minOccurs="0"/&gt;
 *         &lt;element name="lowBattery" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transponderType", propOrder = {

})
public class TransponderType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger transponderID;
    @XmlElement(required = true)
    protected String agencyCode;
    @XmlElement(required = true)
    protected String status;
    protected String transponderProtocol;
    protected String declarationState;
    protected Boolean lowBattery;

    /**
     * Obtiene el valor de la propiedad transponderID.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTransponderID() {
        return transponderID;
    }

    /**
     * Define el valor de la propiedad transponderID.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTransponderID(BigInteger value) {
        this.transponderID = value;
    }

    /**
     * Obtiene el valor de la propiedad agencyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyCode() {
        return agencyCode;
    }

    /**
     * Define el valor de la propiedad agencyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyCode(String value) {
        this.agencyCode = value;
    }

    /**
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Obtiene el valor de la propiedad transponderProtocol.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransponderProtocol() {
        return transponderProtocol;
    }

    /**
     * Define el valor de la propiedad transponderProtocol.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransponderProtocol(String value) {
        this.transponderProtocol = value;
    }

    /**
     * Obtiene el valor de la propiedad declarationState.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeclarationState() {
        return declarationState;
    }

    /**
     * Define el valor de la propiedad declarationState.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeclarationState(String value) {
        this.declarationState = value;
    }

    /**
     * Obtiene el valor de la propiedad lowBattery.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLowBattery() {
        return lowBattery;
    }

    /**
     * Define el valor de la propiedad lowBattery.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLowBattery(Boolean value) {
        this.lowBattery = value;
    }

}
