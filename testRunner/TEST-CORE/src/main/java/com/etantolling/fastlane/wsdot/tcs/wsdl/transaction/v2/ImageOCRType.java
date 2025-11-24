
package com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para imageOCRType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="imageOCRType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="imageName" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}imageNameType"/&gt;
 *         &lt;element name="imageType" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}imageTypeType"/&gt;
 *         &lt;element name="ocrPlateNumber" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}plateNumberType" minOccurs="0"/&gt;
 *         &lt;element name="ocrPlateState" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}plateStateType" minOccurs="0"/&gt;
 *         &lt;element name="ocrPlateType" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}plateTypeType" minOccurs="0"/&gt;
 *         &lt;element name="ocrPlateNumberConfidence" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}percentType" minOccurs="0"/&gt;
 *         &lt;element name="ocrPlateStateConfidence" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}percentType" minOccurs="0"/&gt;
 *         &lt;element name="ocrPlateTypeConfidence" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}percentType" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "imageOCRType", propOrder = {

})
public class ImageOCRType {

    @XmlElement(required = true)
    protected String imageName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ImageTypeType imageType;
    protected String ocrPlateNumber;
    @XmlSchemaType(name = "string")
    protected PlateStateType ocrPlateState;
    protected String ocrPlateType;
    protected Integer ocrPlateNumberConfidence;
    protected Integer ocrPlateStateConfidence;
    protected Integer ocrPlateTypeConfidence;

    /**
     * Obtiene el valor de la propiedad imageName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * Define el valor de la propiedad imageName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageName(String value) {
        this.imageName = value;
    }

    /**
     * Obtiene el valor de la propiedad imageType.
     * 
     * @return
     *     possible object is
     *     {@link ImageTypeType }
     *     
     */
    public ImageTypeType getImageType() {
        return imageType;
    }

    /**
     * Define el valor de la propiedad imageType.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageTypeType }
     *     
     */
    public void setImageType(ImageTypeType value) {
        this.imageType = value;
    }

    /**
     * Obtiene el valor de la propiedad ocrPlateNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOcrPlateNumber() {
        return ocrPlateNumber;
    }

    /**
     * Define el valor de la propiedad ocrPlateNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOcrPlateNumber(String value) {
        this.ocrPlateNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad ocrPlateState.
     * 
     * @return
     *     possible object is
     *     {@link PlateStateType }
     *     
     */
    public PlateStateType getOcrPlateState() {
        return ocrPlateState;
    }

    /**
     * Define el valor de la propiedad ocrPlateState.
     * 
     * @param value
     *     allowed object is
     *     {@link PlateStateType }
     *     
     */
    public void setOcrPlateState(PlateStateType value) {
        this.ocrPlateState = value;
    }

    /**
     * Obtiene el valor de la propiedad ocrPlateType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOcrPlateType() {
        return ocrPlateType;
    }

    /**
     * Define el valor de la propiedad ocrPlateType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOcrPlateType(String value) {
        this.ocrPlateType = value;
    }

    /**
     * Obtiene el valor de la propiedad ocrPlateNumberConfidence.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOcrPlateNumberConfidence() {
        return ocrPlateNumberConfidence;
    }

    /**
     * Define el valor de la propiedad ocrPlateNumberConfidence.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOcrPlateNumberConfidence(Integer value) {
        this.ocrPlateNumberConfidence = value;
    }

    /**
     * Obtiene el valor de la propiedad ocrPlateStateConfidence.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOcrPlateStateConfidence() {
        return ocrPlateStateConfidence;
    }

    /**
     * Define el valor de la propiedad ocrPlateStateConfidence.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOcrPlateStateConfidence(Integer value) {
        this.ocrPlateStateConfidence = value;
    }

    /**
     * Obtiene el valor de la propiedad ocrPlateTypeConfidence.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOcrPlateTypeConfidence() {
        return ocrPlateTypeConfidence;
    }

    /**
     * Define el valor de la propiedad ocrPlateTypeConfidence.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOcrPlateTypeConfidence(Integer value) {
        this.ocrPlateTypeConfidence = value;
    }

}
