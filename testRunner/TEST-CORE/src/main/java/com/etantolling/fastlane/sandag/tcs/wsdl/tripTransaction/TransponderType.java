
package com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para TransponderType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TransponderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="transponderId" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}TransponderIdType"/&gt;
 *         &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *         &lt;element name="issuingAgencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="transponderProtocol" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}TransponderProtocolCodesType"/&gt;
 *         &lt;element name="transponderTypeCode" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}TransponderTypeCodesType"/&gt;
 *         &lt;element name="TransponderStatusCode" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}TransponderStatusCodesType"/&gt;
 *         &lt;element name="SecondaryTransponderStatusCode" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}TransponderStatusCodesType" minOccurs="0"/&gt;
 *         &lt;element name="DeclarationState" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}DeclarationStateType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransponderType", propOrder = {
    "transponderId",
    "tag",
    "issuingAgencyCode",
    "transponderProtocol",
    "transponderTypeCode",
    "transponderStatusCode",
    "secondaryTransponderStatusCode",
    "declarationState"
})
public class TransponderType {

    @XmlElement(required = true)
    protected String transponderId;
    @XmlElement(required = true)
    protected List<String> tag;
    @XmlElement(required = true)
    protected String issuingAgencyCode;
    @XmlElement(required = true)
    protected String transponderProtocol;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TransponderTypeCodesType transponderTypeCode;
    @XmlElement(name = "TransponderStatusCode", required = true)
    @XmlSchemaType(name = "string")
    protected TransponderStatusCodesType transponderStatusCode;
    @XmlElement(name = "SecondaryTransponderStatusCode")
    @XmlSchemaType(name = "string")
    protected TransponderStatusCodesType secondaryTransponderStatusCode;
    @XmlElement(name = "DeclarationState")
    protected String declarationState;

    /**
     * Obtiene el valor de la propiedad transponderId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransponderId() {
        return transponderId;
    }

    /**
     * Define el valor de la propiedad transponderId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransponderId(String value) {
        this.transponderId = value;
    }

    /**
     * Gets the value of the tag property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tag property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTag().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTag() {
        if (tag == null) {
            tag = new ArrayList<String>();
        }
        return this.tag;
    }

    /**
     * Obtiene el valor de la propiedad issuingAgencyCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuingAgencyCode() {
        return issuingAgencyCode;
    }

    /**
     * Define el valor de la propiedad issuingAgencyCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuingAgencyCode(String value) {
        this.issuingAgencyCode = value;
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
     * Obtiene el valor de la propiedad transponderTypeCode.
     * 
     * @return
     *     possible object is
     *     {@link TransponderTypeCodesType }
     *     
     */
    public TransponderTypeCodesType getTransponderTypeCode() {
        return transponderTypeCode;
    }

    /**
     * Define el valor de la propiedad transponderTypeCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TransponderTypeCodesType }
     *     
     */
    public void setTransponderTypeCode(TransponderTypeCodesType value) {
        this.transponderTypeCode = value;
    }

    /**
     * Obtiene el valor de la propiedad transponderStatusCode.
     * 
     * @return
     *     possible object is
     *     {@link TransponderStatusCodesType }
     *     
     */
    public TransponderStatusCodesType getTransponderStatusCode() {
        return transponderStatusCode;
    }

    /**
     * Define el valor de la propiedad transponderStatusCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TransponderStatusCodesType }
     *     
     */
    public void setTransponderStatusCode(TransponderStatusCodesType value) {
        this.transponderStatusCode = value;
    }

    /**
     * Obtiene el valor de la propiedad secondaryTransponderStatusCode.
     * 
     * @return
     *     possible object is
     *     {@link TransponderStatusCodesType }
     *     
     */
    public TransponderStatusCodesType getSecondaryTransponderStatusCode() {
        return secondaryTransponderStatusCode;
    }

    /**
     * Define el valor de la propiedad secondaryTransponderStatusCode.
     * 
     * @param value
     *     allowed object is
     *     {@link TransponderStatusCodesType }
     *     
     */
    public void setSecondaryTransponderStatusCode(TransponderStatusCodesType value) {
        this.secondaryTransponderStatusCode = value;
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

}
