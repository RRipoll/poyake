
package com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para imageListType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="imageListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="image" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}imageOCRsType"/&gt;
 *         &lt;element name="imageLocation" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}imageLocationType"/&gt;
 *         &lt;element name="selectedImageName" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}imageNameType"/&gt;
 *         &lt;element name="selectedROIImageName" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}imageNameType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "imageListType", propOrder = {
    "image",
    "imageLocation",
    "selectedImageName",
    "selectedROIImageName"
})
public class ImageListType {

    @XmlElement(required = true)
    protected ImageOCRsType image;
    @XmlElement(required = true)
    protected String imageLocation;
    @XmlElement(required = true)
    protected String selectedImageName;
    @XmlElement(required = true)
    protected String selectedROIImageName;

    /**
     * Obtiene el valor de la propiedad image.
     * 
     * @return
     *     possible object is
     *     {@link ImageOCRsType }
     *     
     */
    public ImageOCRsType getImage() {
        return image;
    }

    /**
     * Define el valor de la propiedad image.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageOCRsType }
     *     
     */
    public void setImage(ImageOCRsType value) {
        this.image = value;
    }

    /**
     * Obtiene el valor de la propiedad imageLocation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageLocation() {
        return imageLocation;
    }

    /**
     * Define el valor de la propiedad imageLocation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageLocation(String value) {
        this.imageLocation = value;
    }

    /**
     * Obtiene el valor de la propiedad selectedImageName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelectedImageName() {
        return selectedImageName;
    }

    /**
     * Define el valor de la propiedad selectedImageName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelectedImageName(String value) {
        this.selectedImageName = value;
    }

    /**
     * Obtiene el valor de la propiedad selectedROIImageName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelectedROIImageName() {
        return selectedROIImageName;
    }

    /**
     * Define el valor de la propiedad selectedROIImageName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelectedROIImageName(String value) {
        this.selectedROIImageName = value;
    }

}
