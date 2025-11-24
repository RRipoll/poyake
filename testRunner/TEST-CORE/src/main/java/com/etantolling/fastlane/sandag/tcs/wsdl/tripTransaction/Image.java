
package com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Image complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Image"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="imageName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="imageType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ocrPlateNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ocrPlateNumberConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ocrPlateState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ocrPlateStateConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="ocrPlateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ocrPlateTypeConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Image", propOrder = {
    "imageName",
    "imageType",
    "ocrPlateNumber",
    "ocrPlateNumberConfidence",
    "ocrPlateState",
    "ocrPlateStateConfidence",
    "ocrPlateType",
    "ocrPlateTypeConfidence"
})
public class Image {

    @XmlElement(required = true)
    protected String imageName;
    @XmlElement(required = true)
    protected String imageType;
    protected String ocrPlateNumber;
    protected Integer ocrPlateNumberConfidence;
    protected String ocrPlateState;
    protected Integer ocrPlateStateConfidence;
    protected String ocrPlateType;
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
     *     {@link String }
     *     
     */
    public String getImageType() {
        return imageType;
    }

    /**
     * Define el valor de la propiedad imageType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageType(String value) {
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
     * Obtiene el valor de la propiedad ocrPlateState.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOcrPlateState() {
        return ocrPlateState;
    }

    /**
     * Define el valor de la propiedad ocrPlateState.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOcrPlateState(String value) {
        this.ocrPlateState = value;
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
