
package com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *       &lt;all&gt;
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="endpointReference" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}endpointReferenceType"/&gt;
 *         &lt;element name="responseMessage" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="transactionSequenceNumber" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "TollTransactionV2Response")
public class TollTransactionV2Response {

    @XmlElement(required = true)
    protected String responseCode;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected EndpointReferenceType endpointReference;
    @XmlElement(required = true)
    protected String responseMessage;
    protected long transactionSequenceNumber;
    protected long transactionId;

    /**
     * Obtiene el valor de la propiedad responseCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * Define el valor de la propiedad responseCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseCode(String value) {
        this.responseCode = value;
    }

    /**
     * Obtiene el valor de la propiedad endpointReference.
     * 
     * @return
     *     possible object is
     *     {@link EndpointReferenceType }
     *     
     */
    public EndpointReferenceType getEndpointReference() {
        return endpointReference;
    }

    /**
     * Define el valor de la propiedad endpointReference.
     * 
     * @param value
     *     allowed object is
     *     {@link EndpointReferenceType }
     *     
     */
    public void setEndpointReference(EndpointReferenceType value) {
        this.endpointReference = value;
    }

    /**
     * Obtiene el valor de la propiedad responseMessage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * Define el valor de la propiedad responseMessage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseMessage(String value) {
        this.responseMessage = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionSequenceNumber.
     * 
     */
    public long getTransactionSequenceNumber() {
        return transactionSequenceNumber;
    }

    /**
     * Define el valor de la propiedad transactionSequenceNumber.
     * 
     */
    public void setTransactionSequenceNumber(long value) {
        this.transactionSequenceNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionId.
     * 
     */
    public long getTransactionId() {
        return transactionId;
    }

    /**
     * Define el valor de la propiedad transactionId.
     * 
     */
    public void setTransactionId(long value) {
        this.transactionId = value;
    }

}
