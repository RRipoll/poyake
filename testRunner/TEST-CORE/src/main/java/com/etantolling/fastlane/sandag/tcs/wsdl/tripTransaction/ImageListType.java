
package com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ImageListType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ImageListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="imageLocation" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="image" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}Image" maxOccurs="unbounded"/&gt;
 *         &lt;element name="imageName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="imageAttribute" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="plateNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="plateState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="plateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="plateNumberConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="plateStateConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="plateTypeConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="primeImage" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageListType", propOrder = {
    "imageLocation",
    "image",
    "imageName",
    "imageAttribute",
    "plateNumber",
    "plateState",
    "plateType",
    "plateNumberConfidence",
    "plateStateConfidence",
    "plateTypeConfidence",
    "primeImage"
})
public class ImageListType {

    @XmlElement(required = true)
    protected String imageLocation;
    @XmlElement(required = true)
    protected List<Image> image;
    @XmlElement(required = true)
    protected String imageName;
    @XmlElement(required = true)
    protected String imageAttribute;
    protected String plateNumber;
    protected String plateState;
    protected String plateType;
    protected Integer plateNumberConfidence;
    protected Integer plateStateConfidence;
    protected Integer plateTypeConfidence;
    protected boolean primeImage;

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
     * Gets the value of the image property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the image property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Image }
     * 
     * 
     */
    public List<Image> getImage() {
        if (image == null) {
            image = new ArrayList<Image>();
        }
        return this.image;
    }

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
     * Obtiene el valor de la propiedad imageAttribute.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageAttribute() {
        return imageAttribute;
    }

    /**
     * Define el valor de la propiedad imageAttribute.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageAttribute(String value) {
        this.imageAttribute = value;
    }

    /**
     * Obtiene el valor de la propiedad plateNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * Define el valor de la propiedad plateNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlateNumber(String value) {
        this.plateNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad plateState.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlateState() {
        return plateState;
    }

    /**
     * Define el valor de la propiedad plateState.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlateState(String value) {
        this.plateState = value;
    }

    /**
     * Obtiene el valor de la propiedad plateType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlateType() {
        return plateType;
    }

    /**
     * Define el valor de la propiedad plateType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlateType(String value) {
        this.plateType = value;
    }

    /**
     * Obtiene el valor de la propiedad plateNumberConfidence.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPlateNumberConfidence() {
        return plateNumberConfidence;
    }

    /**
     * Define el valor de la propiedad plateNumberConfidence.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPlateNumberConfidence(Integer value) {
        this.plateNumberConfidence = value;
    }

    /**
     * Obtiene el valor de la propiedad plateStateConfidence.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPlateStateConfidence() {
        return plateStateConfidence;
    }

    /**
     * Define el valor de la propiedad plateStateConfidence.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPlateStateConfidence(Integer value) {
        this.plateStateConfidence = value;
    }

    /**
     * Obtiene el valor de la propiedad plateTypeConfidence.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPlateTypeConfidence() {
        return plateTypeConfidence;
    }

    /**
     * Define el valor de la propiedad plateTypeConfidence.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPlateTypeConfidence(Integer value) {
        this.plateTypeConfidence = value;
    }

    /**
     * Obtiene el valor de la propiedad primeImage.
     * 
     */
    public boolean isPrimeImage() {
        return primeImage;
    }

    /**
     * Define el valor de la propiedad primeImage.
     * 
     */
    public void setPrimeImage(boolean value) {
        this.primeImage = value;
    }

}
