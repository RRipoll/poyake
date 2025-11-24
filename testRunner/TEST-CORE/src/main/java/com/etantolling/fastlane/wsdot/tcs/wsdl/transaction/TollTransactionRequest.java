
package com.etantolling.fastlane.wsdot.tcs.wsdl.transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="facilityCode"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="TNB"/&gt;
 *               &lt;enumeration value="SR167"/&gt;
 *               &lt;enumeration value="SR520"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="plazaCode"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;length value="5"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="laneNumber"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *               &lt;minInclusive value="1"/&gt;
 *               &lt;maxInclusive value="99"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="TransactionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="EntryFacilityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EntryPlazaCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EntryLaneNumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="EntryTransactionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="ExitFacilityCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ExitPlazaCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ExitLaneNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="ExitTransactionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="SequenceNumber" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="TransactionType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="AVCClassification" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="CSCClassification" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Transponder" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="TransponderID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="AgencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="DeclarationState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="LowBattery" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ImageList" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="ImageLocation" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="SelectedImageName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="SelectedROIImageName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Image" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ImageName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="ImageType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="OCRPlateNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="OCRPlateState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="OCRPlateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                             &lt;element name="OCRConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *                             &lt;element name="OCRPlateNumberConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *                             &lt;element name="OCRPlateStateConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *                             &lt;element name="OCRPlateTypeConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="FareAmount" minOccurs="0"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *               &lt;totalDigits value="5"/&gt;
 *               &lt;fractionDigits value="2"/&gt;
 *               &lt;minInclusive value="0"/&gt;
 *               &lt;maxInclusive value="100"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="VehicleSpeed" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="TCSStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ReverseDirectionFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="LaneMode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="AxleCount" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "facilityCode",
    "plazaCode",
    "laneNumber",
    "transactionDateTime",
    "entryFacilityCode",
    "entryPlazaCode",
    "entryLaneNumber",
    "entryTransactionDateTime",
    "exitFacilityCode",
    "exitPlazaCode",
    "exitLaneNumber",
    "exitTransactionDateTime",
    "sequenceNumber",
    "transactionType",
    "avcClassification",
    "cscClassification",
    "transponder",
    "imageList",
    "fareAmount",
    "vehicleSpeed",
    "tcsStatus",
    "reverseDirectionFlag",
    "laneMode",
    "axleCount"
})
@XmlRootElement(name = "TollTransactionRequest")
public class TollTransactionRequest {

    @XmlElement(required = true)
    protected String facilityCode;
    @XmlElement(required = true)
    protected String plazaCode;
    protected int laneNumber;
    @XmlElement(name = "TransactionDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar transactionDateTime;
    @XmlElement(name = "EntryFacilityCode")
    protected String entryFacilityCode;
    @XmlElement(name = "EntryPlazaCode")
    protected String entryPlazaCode;
    @XmlElement(name = "EntryLaneNumber")
    protected Integer entryLaneNumber;
    @XmlElement(name = "EntryTransactionDateTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar entryTransactionDateTime;
    @XmlElement(name = "ExitFacilityCode", required = true)
    protected String exitFacilityCode;
    @XmlElement(name = "ExitPlazaCode", required = true)
    protected String exitPlazaCode;
    @XmlElement(name = "ExitLaneNumber")
    protected int exitLaneNumber;
    @XmlElement(name = "ExitTransactionDateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar exitTransactionDateTime;
    @XmlElement(name = "SequenceNumber")
    protected long sequenceNumber;
    @XmlElement(name = "TransactionType", required = true)
    protected String transactionType;
    @XmlElement(name = "AVCClassification", required = true)
    protected String avcClassification;
    @XmlElement(name = "CSCClassification", required = true)
    protected String cscClassification;
    @XmlElement(name = "Transponder")
    protected TollTransactionRequest.Transponder transponder;
    @XmlElement(name = "ImageList")
    protected TollTransactionRequest.ImageList imageList;
    @XmlElement(name = "FareAmount")
    protected BigDecimal fareAmount;
    @XmlElement(name = "VehicleSpeed")
    protected Integer vehicleSpeed;
    @XmlElement(name = "TCSStatus")
    protected String tcsStatus;
    @XmlElement(name = "ReverseDirectionFlag")
    protected Boolean reverseDirectionFlag;
    @XmlElement(name = "LaneMode", required = true)
    protected String laneMode;
    @XmlElement(name = "AxleCount")
    protected int axleCount;

    /**
     * Gets the value of the facilityCode property.
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
     * Sets the value of the facilityCode property.
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
     * Gets the value of the plazaCode property.
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
     * Sets the value of the plazaCode property.
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
     * Gets the value of the laneNumber property.
     * 
     */
    public int getLaneNumber() {
        return laneNumber;
    }

    /**
     * Sets the value of the laneNumber property.
     * 
     */
    public void setLaneNumber(int value) {
        this.laneNumber = value;
    }

    /**
     * Gets the value of the transactionDateTime property.
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
     * Sets the value of the transactionDateTime property.
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
     * Gets the value of the entryFacilityCode property.
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
     * Sets the value of the entryFacilityCode property.
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
     * Gets the value of the entryPlazaCode property.
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
     * Sets the value of the entryPlazaCode property.
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
     * Gets the value of the entryLaneNumber property.
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
     * Sets the value of the entryLaneNumber property.
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
     * Gets the value of the entryTransactionDateTime property.
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
     * Sets the value of the entryTransactionDateTime property.
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
     * Gets the value of the exitFacilityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExitFacilityCode() {
        return exitFacilityCode;
    }

    /**
     * Sets the value of the exitFacilityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExitFacilityCode(String value) {
        this.exitFacilityCode = value;
    }

    /**
     * Gets the value of the exitPlazaCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExitPlazaCode() {
        return exitPlazaCode;
    }

    /**
     * Sets the value of the exitPlazaCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExitPlazaCode(String value) {
        this.exitPlazaCode = value;
    }

    /**
     * Gets the value of the exitLaneNumber property.
     * 
     */
    public int getExitLaneNumber() {
        return exitLaneNumber;
    }

    /**
     * Sets the value of the exitLaneNumber property.
     * 
     */
    public void setExitLaneNumber(int value) {
        this.exitLaneNumber = value;
    }

    /**
     * Gets the value of the exitTransactionDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExitTransactionDateTime() {
        return exitTransactionDateTime;
    }

    /**
     * Sets the value of the exitTransactionDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExitTransactionDateTime(XMLGregorianCalendar value) {
        this.exitTransactionDateTime = value;
    }

    /**
     * Gets the value of the sequenceNumber property.
     * 
     */
    public long getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Sets the value of the sequenceNumber property.
     * 
     */
    public void setSequenceNumber(long value) {
        this.sequenceNumber = value;
    }

    /**
     * Gets the value of the transactionType property.
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
     * Sets the value of the transactionType property.
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
     * Gets the value of the avcClassification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAVCClassification() {
        return avcClassification;
    }

    /**
     * Sets the value of the avcClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAVCClassification(String value) {
        this.avcClassification = value;
    }

    /**
     * Gets the value of the cscClassification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSCClassification() {
        return cscClassification;
    }

    /**
     * Sets the value of the cscClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSCClassification(String value) {
        this.cscClassification = value;
    }

    /**
     * Gets the value of the transponder property.
     * 
     * @return
     *     possible object is
     *     {@link TollTransactionRequest.Transponder }
     *     
     */
    public TollTransactionRequest.Transponder getTransponder() {
        return transponder;
    }

    /**
     * Sets the value of the transponder property.
     * 
     * @param value
     *     allowed object is
     *     {@link TollTransactionRequest.Transponder }
     *     
     */
    public void setTransponder(TollTransactionRequest.Transponder value) {
        this.transponder = value;
    }

    /**
     * Gets the value of the imageList property.
     * 
     * @return
     *     possible object is
     *     {@link TollTransactionRequest.ImageList }
     *     
     */
    public TollTransactionRequest.ImageList getImageList() {
        return imageList;
    }

    /**
     * Sets the value of the imageList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TollTransactionRequest.ImageList }
     *     
     */
    public void setImageList(TollTransactionRequest.ImageList value) {
        this.imageList = value;
    }

    /**
     * Gets the value of the fareAmount property.
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
     * Sets the value of the fareAmount property.
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
     * Gets the value of the vehicleSpeed property.
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
     * Sets the value of the vehicleSpeed property.
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
     * Gets the value of the tcsStatus property.
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
     * Sets the value of the tcsStatus property.
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
     * Gets the value of the reverseDirectionFlag property.
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
     * Sets the value of the reverseDirectionFlag property.
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
     * Gets the value of the laneMode property.
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
     * Sets the value of the laneMode property.
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
     * Gets the value of the axleCount property.
     * 
     */
    public int getAxleCount() {
        return axleCount;
    }

    /**
     * Sets the value of the axleCount property.
     * 
     */
    public void setAxleCount(int value) {
        this.axleCount = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="ImageLocation" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="SelectedImageName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="SelectedROIImageName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Image" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ImageName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="ImageType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="OCRPlateNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="OCRPlateState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="OCRPlateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *                   &lt;element name="OCRConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
     *                   &lt;element name="OCRPlateNumberConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
     *                   &lt;element name="OCRPlateStateConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
     *                   &lt;element name="OCRPlateTypeConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "imageLocation",
        "selectedImageName",
        "selectedROIImageName",
        "image"
    })
    public static class ImageList {

        @XmlElement(name = "ImageLocation", required = true)
        protected String imageLocation;
        @XmlElement(name = "SelectedImageName", required = true)
        protected String selectedImageName;
        @XmlElement(name = "SelectedROIImageName", required = true)
        protected String selectedROIImageName;
        @XmlElement(name = "Image")
        protected List<TollTransactionRequest.ImageList.Image> image;

        /**
         * Gets the value of the imageLocation property.
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
         * Sets the value of the imageLocation property.
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
         * Gets the value of the selectedImageName property.
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
         * Sets the value of the selectedImageName property.
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
         * Gets the value of the selectedROIImageName property.
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
         * Sets the value of the selectedROIImageName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSelectedROIImageName(String value) {
            this.selectedROIImageName = value;
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
         * {@link TollTransactionRequest.ImageList.Image }
         * 
         * 
         */
        public List<TollTransactionRequest.ImageList.Image> getImage() {
            if (image == null) {
                image = new ArrayList<TollTransactionRequest.ImageList.Image>();
            }
            return this.image;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="ImageName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="ImageType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="OCRPlateNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="OCRPlateState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="OCRPlateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
         *         &lt;element name="OCRConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
         *         &lt;element name="OCRPlateNumberConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
         *         &lt;element name="OCRPlateStateConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
         *         &lt;element name="OCRPlateTypeConfidence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "imageName",
            "imageType",
            "ocrPlateNumber",
            "ocrPlateState",
            "ocrPlateType",
            "ocrConfidence",
            "ocrPlateNumberConfidence",
            "ocrPlateStateConfidence",
            "ocrPlateTypeConfidence"
        })
        public static class Image {

            @XmlElement(name = "ImageName", required = true)
            protected String imageName;
            @XmlElement(name = "ImageType", required = true)
            protected String imageType;
            @XmlElement(name = "OCRPlateNumber")
            protected String ocrPlateNumber;
            @XmlElement(name = "OCRPlateState")
            protected String ocrPlateState;
            @XmlElement(name = "OCRPlateType")
            protected String ocrPlateType;
            @XmlElement(name = "OCRConfidence")
            protected Integer ocrConfidence;
            @XmlElement(name = "OCRPlateNumberConfidence")
            protected Integer ocrPlateNumberConfidence;
            @XmlElement(name = "OCRPlateStateConfidence")
            protected Integer ocrPlateStateConfidence;
            @XmlElement(name = "OCRPlateTypeConfidence")
            protected Integer ocrPlateTypeConfidence;

            /**
             * Gets the value of the imageName property.
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
             * Sets the value of the imageName property.
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
             * Gets the value of the imageType property.
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
             * Sets the value of the imageType property.
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
             * Gets the value of the ocrPlateNumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOCRPlateNumber() {
                return ocrPlateNumber;
            }

            /**
             * Sets the value of the ocrPlateNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOCRPlateNumber(String value) {
                this.ocrPlateNumber = value;
            }

            /**
             * Gets the value of the ocrPlateState property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOCRPlateState() {
                return ocrPlateState;
            }

            /**
             * Sets the value of the ocrPlateState property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOCRPlateState(String value) {
                this.ocrPlateState = value;
            }

            /**
             * Gets the value of the ocrPlateType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOCRPlateType() {
                return ocrPlateType;
            }

            /**
             * Sets the value of the ocrPlateType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOCRPlateType(String value) {
                this.ocrPlateType = value;
            }

            /**
             * Gets the value of the ocrConfidence property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getOCRConfidence() {
                return ocrConfidence;
            }

            /**
             * Sets the value of the ocrConfidence property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setOCRConfidence(Integer value) {
                this.ocrConfidence = value;
            }

            /**
             * Gets the value of the ocrPlateNumberConfidence property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getOCRPlateNumberConfidence() {
                return ocrPlateNumberConfidence;
            }

            /**
             * Sets the value of the ocrPlateNumberConfidence property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setOCRPlateNumberConfidence(Integer value) {
                this.ocrPlateNumberConfidence = value;
            }

            /**
             * Gets the value of the ocrPlateStateConfidence property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getOCRPlateStateConfidence() {
                return ocrPlateStateConfidence;
            }

            /**
             * Sets the value of the ocrPlateStateConfidence property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setOCRPlateStateConfidence(Integer value) {
                this.ocrPlateStateConfidence = value;
            }

            /**
             * Gets the value of the ocrPlateTypeConfidence property.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getOCRPlateTypeConfidence() {
                return ocrPlateTypeConfidence;
            }

            /**
             * Sets the value of the ocrPlateTypeConfidence property.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setOCRPlateTypeConfidence(Integer value) {
                this.ocrPlateTypeConfidence = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="TransponderID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="AgencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="DeclarationState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="LowBattery" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "transponderID",
        "agencyCode",
        "status",
        "declarationState",
        "lowBattery"
    })
    public static class Transponder {

        @XmlElement(name = "TransponderID", required = true)
        protected String transponderID;
        @XmlElement(name = "AgencyCode", required = true)
        protected String agencyCode;
        @XmlElement(name = "Status", required = true)
        protected String status;
        @XmlElement(name = "DeclarationState")
        protected String declarationState;
        @XmlElement(name = "LowBattery")
        protected Boolean lowBattery;

        /**
         * Gets the value of the transponderID property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTransponderID() {
            return transponderID;
        }

        /**
         * Sets the value of the transponderID property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTransponderID(String value) {
            this.transponderID = value;
        }

        /**
         * Gets the value of the agencyCode property.
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
         * Sets the value of the agencyCode property.
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
         * Gets the value of the status property.
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
         * Sets the value of the status property.
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
         * Gets the value of the declarationState property.
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
         * Sets the value of the declarationState property.
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
         * Gets the value of the lowBattery property.
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
         * Sets the value of the lowBattery property.
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

}
