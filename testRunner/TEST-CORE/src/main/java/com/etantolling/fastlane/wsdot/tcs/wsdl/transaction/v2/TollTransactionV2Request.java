
package com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element name="facilityCode" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}facilityCodeType"/&gt;
 *         &lt;element name="plazaCode" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}plazaCodeType"/&gt;
 *         &lt;element name="laneNumber" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}laneNumberType"/&gt;
 *         &lt;element name="transactionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="entryFacilityCode" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}facilityCodeType" minOccurs="0"/&gt;
 *         &lt;element name="entryPlazaCode" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}plazaCodeType" minOccurs="0"/&gt;
 *         &lt;element name="entryLaneNumber" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}laneNumberType" minOccurs="0"/&gt;
 *         &lt;element name="entryTransactionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="sequenceNumber" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}sequenceNumberType"/&gt;
 *         &lt;element name="transactionType" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}transactionTypeType"/&gt;
 *         &lt;element name="avcClassification" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}vehicleClassType"/&gt;
 *         &lt;element name="cscClassification" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}vehicleClassType" minOccurs="0"/&gt;
 *         &lt;element name="transponder" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}transponderType" minOccurs="0"/&gt;
 *         &lt;element name="imageList" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}imageListType" minOccurs="0"/&gt;
 *         &lt;element name="fareAmount" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}fareAmountType" minOccurs="0"/&gt;
 *         &lt;element name="vehicleSpeed" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}vehicleSpeedType" minOccurs="0"/&gt;
 *         &lt;element name="unusualOccurrences" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}unusualOccurrencesType" minOccurs="0"/&gt;
 *         &lt;element name="TCSStatus" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}TCSStatusType" minOccurs="0"/&gt;
 *         &lt;element name="reverseDirectionFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="laneMode" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}laneModeType"/&gt;
 *         &lt;element name="axleCount" type="{http://v2.transaction.wsdl.tcs.wsdot.fastlane.etantolling.com}axleCountType" minOccurs="0"/&gt;
 *         &lt;element name="vehicleHeight" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="vehicleWidth" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="vehicleLength" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
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
@XmlRootElement(name = "TollTransactionV2Request")
public class TollTransactionV2Request {

    @XmlElement(required = true)
    protected String facilityCode;
    @XmlElement(required = true)
    protected String plazaCode;
    protected int laneNumber;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transactionDateTime;
    protected String entryFacilityCode;
    protected String entryPlazaCode;
    protected Integer entryLaneNumber;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar entryTransactionDateTime;
    protected long sequenceNumber;
    @XmlElement(required = true)
    protected String transactionType;
    @XmlElement(required = true)
    protected String avcClassification;
    protected String cscClassification;
    protected TransponderType transponder;
    protected ImageListType imageList;
    protected BigDecimal fareAmount;
    protected Integer vehicleSpeed;
    protected String unusualOccurrences;
    @XmlElement(name = "TCSStatus")
    protected String tcsStatus;
    protected Boolean reverseDirectionFlag;
    @XmlElement(required = true)
    protected String laneMode;
    protected Integer axleCount;
    protected BigDecimal vehicleHeight;
    protected BigDecimal vehicleWidth;
    protected BigDecimal vehicleLength;

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
     * Obtiene el valor de la propiedad transactionDateTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransactionDateTime() {
        return transactionDateTime;
    }

    /**
     * Define el valor de la propiedad transactionDateTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransactionDateTime(XMLGregorianCalendar value) {
        this.transactionDateTime = value;
    }

    /**
     * Obtiene el valor de la propiedad entryFacilityCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntryFacilityCode() {
        return entryFacilityCode;
    }

    /**
     * Define el valor de la propiedad entryFacilityCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntryFacilityCode(String value) {
        this.entryFacilityCode = value;
    }

    /**
     * Obtiene el valor de la propiedad entryPlazaCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntryPlazaCode() {
        return entryPlazaCode;
    }

    /**
     * Define el valor de la propiedad entryPlazaCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntryPlazaCode(String value) {
        this.entryPlazaCode = value;
    }

    /**
     * Obtiene el valor de la propiedad entryLaneNumber.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEntryLaneNumber() {
        return entryLaneNumber;
    }

    /**
     * Define el valor de la propiedad entryLaneNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEntryLaneNumber(Integer value) {
        this.entryLaneNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad entryTransactionDateTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEntryTransactionDateTime() {
        return entryTransactionDateTime;
    }

    /**
     * Define el valor de la propiedad entryTransactionDateTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEntryTransactionDateTime(XMLGregorianCalendar value) {
        this.entryTransactionDateTime = value;
    }

    /**
     * Obtiene el valor de la propiedad sequenceNumber.
     * 
     */
    public long getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Define el valor de la propiedad sequenceNumber.
     * 
     */
    public void setSequenceNumber(long value) {
        this.sequenceNumber = value;
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
     * Obtiene el valor de la propiedad cscClassification.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCscClassification() {
        return cscClassification;
    }

    /**
     * Define el valor de la propiedad cscClassification.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCscClassification(String value) {
        this.cscClassification = value;
    }

    /**
     * Obtiene el valor de la propiedad transponder.
     * 
     * @return
     *     possible object is
     *     {@link TransponderType }
     *     
     */
    public TransponderType getTransponder() {
        return transponder;
    }

    /**
     * Define el valor de la propiedad transponder.
     * 
     * @param value
     *     allowed object is
     *     {@link TransponderType }
     *     
     */
    public void setTransponder(TransponderType value) {
        this.transponder = value;
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
     * Obtiene el valor de la propiedad fareAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFareAmount() {
        return fareAmount;
    }

    /**
     * Define el valor de la propiedad fareAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFareAmount(BigDecimal value) {
        this.fareAmount = value;
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
     * Obtiene el valor de la propiedad unusualOccurrences.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnusualOccurrences() {
        return unusualOccurrences;
    }

    /**
     * Define el valor de la propiedad unusualOccurrences.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnusualOccurrences(String value) {
        this.unusualOccurrences = value;
    }

    /**
     * Obtiene el valor de la propiedad tcsStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTCSStatus() {
        return tcsStatus;
    }

    /**
     * Define el valor de la propiedad tcsStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTCSStatus(String value) {
        this.tcsStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad reverseDirectionFlag.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReverseDirectionFlag() {
        return reverseDirectionFlag;
    }

    /**
     * Define el valor de la propiedad reverseDirectionFlag.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReverseDirectionFlag(Boolean value) {
        this.reverseDirectionFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad laneMode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaneMode() {
        return laneMode;
    }

    /**
     * Define el valor de la propiedad laneMode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaneMode(String value) {
        this.laneMode = value;
    }

    /**
     * Obtiene el valor de la propiedad axleCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAxleCount() {
        return axleCount;
    }

    /**
     * Define el valor de la propiedad axleCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAxleCount(Integer value) {
        this.axleCount = value;
    }

    /**
     * Obtiene el valor de la propiedad vehicleHeight.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVehicleHeight() {
        return vehicleHeight;
    }

    /**
     * Define el valor de la propiedad vehicleHeight.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVehicleHeight(BigDecimal value) {
        this.vehicleHeight = value;
    }

    /**
     * Obtiene el valor de la propiedad vehicleWidth.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVehicleWidth() {
        return vehicleWidth;
    }

    /**
     * Define el valor de la propiedad vehicleWidth.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVehicleWidth(BigDecimal value) {
        this.vehicleWidth = value;
    }

    /**
     * Obtiene el valor de la propiedad vehicleLength.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getVehicleLength() {
        return vehicleLength;
    }

    /**
     * Define el valor de la propiedad vehicleLength.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setVehicleLength(BigDecimal value) {
        this.vehicleLength = value;
    }

}
