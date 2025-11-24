
package com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para TransactionListType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TransactionListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="facilityCode" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}FacilityCodeType"/&gt;
 *         &lt;element name="plazaCode" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}PlazaCodeType"/&gt;
 *         &lt;element name="laneNumber" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}LaneNumberType"/&gt;
 *         &lt;element name="transactionTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tagId" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}TransponderType" minOccurs="0"/&gt;
 *         &lt;element name="imageList" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}ImageListType"/&gt;
 *         &lt;element name="vehicleSpeed" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}VehicleSpeedType" minOccurs="0"/&gt;
 *         &lt;element name="aviClassification" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionListType", propOrder = {
    "facilityCode",
    "plazaCode",
    "laneNumber",
    "transactionTimestamp",
    "transactionId",
    "tagId",
    "imageList",
    "vehicleSpeed",
    "aviClassification"
})
public class TransactionListType {

    @XmlElement(required = true)
    protected String facilityCode;
    @XmlElement(required = true)
    protected String plazaCode;
    protected int laneNumber;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transactionTimestamp;
    protected int transactionId;
    protected TransponderType tagId;
    @XmlElement(required = true)
    protected ImageListType imageList;
    protected Integer vehicleSpeed;
    protected BigInteger aviClassification;

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
     * Obtiene el valor de la propiedad transactionTimestamp.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransactionTimestamp() {
        return transactionTimestamp;
    }

    /**
     * Define el valor de la propiedad transactionTimestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransactionTimestamp(XMLGregorianCalendar value) {
        this.transactionTimestamp = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionId.
     * 
     */
    public int getTransactionId() {
        return transactionId;
    }

    /**
     * Define el valor de la propiedad transactionId.
     * 
     */
    public void setTransactionId(int value) {
        this.transactionId = value;
    }

    /**
     * Obtiene el valor de la propiedad tagId.
     * 
     * @return
     *     possible object is
     *     {@link TransponderType }
     *     
     */
    public TransponderType getTagId() {
        return tagId;
    }

    /**
     * Define el valor de la propiedad tagId.
     * 
     * @param value
     *     allowed object is
     *     {@link TransponderType }
     *     
     */
    public void setTagId(TransponderType value) {
        this.tagId = value;
    }

    /**
     * Obtiene el valor de la propiedad imageList.
     * 
     * @return
     *     possible object is
     *     {@link ImageListType }
     *     
     */
    public ImageListType getImageList() {
        return imageList;
    }

    /**
     * Define el valor de la propiedad imageList.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageListType }
     *     
     */
    public void setImageList(ImageListType value) {
        this.imageList = value;
    }

    /**
     * Obtiene el valor de la propiedad vehicleSpeed.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVehicleSpeed() {
        return vehicleSpeed;
    }

    /**
     * Define el valor de la propiedad vehicleSpeed.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVehicleSpeed(Integer value) {
        this.vehicleSpeed = value;
    }

    /**
     * Obtiene el valor de la propiedad aviClassification.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getAviClassification() {
        return aviClassification;
    }

    /**
     * Define el valor de la propiedad aviClassification.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setAviClassification(BigInteger value) {
        this.aviClassification = value;
    }

}
