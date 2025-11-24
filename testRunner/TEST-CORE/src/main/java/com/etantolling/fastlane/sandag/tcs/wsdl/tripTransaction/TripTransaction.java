
package com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction;

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
 *       &lt;sequence&gt;
 *         &lt;element name="exitFacilityCode" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}FacilityCodeType"/&gt;
 *         &lt;element name="exitPlazaCode" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}PlazaCodeType"/&gt;
 *         &lt;element name="exitLaneNumber" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}ExitLaneNumberType"/&gt;
 *         &lt;element name="exitTransactionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="entryFacilityCode" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}FacilityCodeType"/&gt;
 *         &lt;element name="entryPlazaCode" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}PlazaCodeType"/&gt;
 *         &lt;element name="entryLaneNumber" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}EntryLaneNumberType"/&gt;
 *         &lt;element name="entryTransactionDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="tripSequenceNumber" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="transactionType" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}TransactionType"/&gt;
 *         &lt;element name="preAVCclassification" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}ClassificationTypeCodesType" minOccurs="0"/&gt;
 *         &lt;element name="postAVCclassification" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}ClassificationTypeCodesType" minOccurs="0"/&gt;
 *         &lt;element name="indicatedClassification" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}ClassificationTypeCodesType" minOccurs="0"/&gt;
 *         &lt;element name="transponder" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}TransponderType" minOccurs="0"/&gt;
 *         &lt;element name="tripPlateNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tripPlateState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tripPlateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="transactionList" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}TransactionListType"/&gt;
 *         &lt;element name="expectedFareAmount" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}ExpectedFareAmountType"/&gt;
 *         &lt;element name="fareAmount" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}FareAmountType"/&gt;
 *         &lt;element name="currency" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}CurrencyType"/&gt;
 *         &lt;element name="ccReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nonRevenue" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="repeatViolator" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="repeatViolatorNotificationSent" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="reverseDirectionFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="HOVviolationFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="laneMode" type="{http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com}LaneModeType"/&gt;
 *         &lt;element name="degradedMode" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="degradedPayment" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="nonRevenuePresent" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
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
    "exitFacilityCode",
    "exitPlazaCode",
    "exitLaneNumber",
    "exitTransactionDateTime",
    "entryFacilityCode",
    "entryPlazaCode",
    "entryLaneNumber",
    "entryTransactionDateTime",
    "tripSequenceNumber",
    "transactionType",
    "preAVCclassification",
    "postAVCclassification",
    "indicatedClassification",
    "transponder",
    "tripPlateNumber",
    "tripPlateState",
    "tripPlateType",
    "transactionList",
    "expectedFareAmount",
    "fareAmount",
    "currency",
    "ccReferenceNumber",
    "nonRevenue",
    "repeatViolator",
    "repeatViolatorNotificationSent",
    "reverseDirectionFlag",
    "hoVviolationFlag",
    "laneMode",
    "degradedMode",
    "degradedPayment",
    "nonRevenuePresent"
})
@XmlRootElement(name = "TripTransaction")
public class TripTransaction {

    @XmlElement(required = true)
    protected String exitFacilityCode;
    @XmlElement(required = true)
    protected String exitPlazaCode;
    protected int exitLaneNumber;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar exitTransactionDateTime;
    @XmlElement(required = true)
    protected String entryFacilityCode;
    @XmlElement(required = true)
    protected String entryPlazaCode;
    protected int entryLaneNumber;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar entryTransactionDateTime;
    protected long tripSequenceNumber;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TransactionType transactionType;
    protected String preAVCclassification;
    protected String postAVCclassification;
    protected String indicatedClassification;
    protected TransponderType transponder;
    protected String tripPlateNumber;
    protected String tripPlateState;
    protected String tripPlateType;
    @XmlElement(required = true)
    protected TransactionListType transactionList;
    @XmlElement(required = true)
    protected BigDecimal expectedFareAmount;
    @XmlElement(required = true)
    protected BigDecimal fareAmount;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected CurrencyType currency;
    protected String ccReferenceNumber;
    protected boolean nonRevenue;
    protected boolean repeatViolator;
    protected boolean repeatViolatorNotificationSent;
    protected boolean reverseDirectionFlag;
    @XmlElement(name = "HOVviolationFlag")
    protected boolean hoVviolationFlag;
    @XmlElement(required = true)
    protected String laneMode;
    protected boolean degradedMode;
    protected Boolean degradedPayment;
    protected boolean nonRevenuePresent;

    /**
     * Obtiene el valor de la propiedad exitFacilityCode.
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
     * Define el valor de la propiedad exitFacilityCode.
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
     * Obtiene el valor de la propiedad exitPlazaCode.
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
     * Define el valor de la propiedad exitPlazaCode.
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
     * Obtiene el valor de la propiedad exitLaneNumber.
     * 
     */
    public int getExitLaneNumber() {
        return exitLaneNumber;
    }

    /**
     * Define el valor de la propiedad exitLaneNumber.
     * 
     */
    public void setExitLaneNumber(int value) {
        this.exitLaneNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad exitTransactionDateTime.
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
     * Define el valor de la propiedad exitTransactionDateTime.
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
     */
    public int getEntryLaneNumber() {
        return entryLaneNumber;
    }

    /**
     * Define el valor de la propiedad entryLaneNumber.
     * 
     */
    public void setEntryLaneNumber(int value) {
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
     * Obtiene el valor de la propiedad tripSequenceNumber.
     * 
     */
    public long getTripSequenceNumber() {
        return tripSequenceNumber;
    }

    /**
     * Define el valor de la propiedad tripSequenceNumber.
     * 
     */
    public void setTripSequenceNumber(long value) {
        this.tripSequenceNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionType.
     * 
     * @return
     *     possible object is
     *     {@link TransactionType }
     *     
     */
    public TransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * Define el valor de la propiedad transactionType.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionType }
     *     
     */
    public void setTransactionType(TransactionType value) {
        this.transactionType = value;
    }

    /**
     * Obtiene el valor de la propiedad preAVCclassification.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPreAVCclassification() {
        return preAVCclassification;
    }

    /**
     * Define el valor de la propiedad preAVCclassification.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPreAVCclassification(String value) {
        this.preAVCclassification = value;
    }

    /**
     * Obtiene el valor de la propiedad postAVCclassification.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostAVCclassification() {
        return postAVCclassification;
    }

    /**
     * Define el valor de la propiedad postAVCclassification.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostAVCclassification(String value) {
        this.postAVCclassification = value;
    }

    /**
     * Obtiene el valor de la propiedad indicatedClassification.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicatedClassification() {
        return indicatedClassification;
    }

    /**
     * Define el valor de la propiedad indicatedClassification.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicatedClassification(String value) {
        this.indicatedClassification = value;
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
     * Obtiene el valor de la propiedad tripPlateNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripPlateNumber() {
        return tripPlateNumber;
    }

    /**
     * Define el valor de la propiedad tripPlateNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripPlateNumber(String value) {
        this.tripPlateNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad tripPlateState.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripPlateState() {
        return tripPlateState;
    }

    /**
     * Define el valor de la propiedad tripPlateState.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripPlateState(String value) {
        this.tripPlateState = value;
    }

    /**
     * Obtiene el valor de la propiedad tripPlateType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripPlateType() {
        return tripPlateType;
    }

    /**
     * Define el valor de la propiedad tripPlateType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripPlateType(String value) {
        this.tripPlateType = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionList.
     * 
     * @return
     *     possible object is
     *     {@link TransactionListType }
     *     
     */
    public TransactionListType getTransactionList() {
        return transactionList;
    }

    /**
     * Define el valor de la propiedad transactionList.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionListType }
     *     
     */
    public void setTransactionList(TransactionListType value) {
        this.transactionList = value;
    }

    /**
     * Obtiene el valor de la propiedad expectedFareAmount.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getExpectedFareAmount() {
        return expectedFareAmount;
    }

    /**
     * Define el valor de la propiedad expectedFareAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setExpectedFareAmount(BigDecimal value) {
        this.expectedFareAmount = value;
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
     * Obtiene el valor de la propiedad currency.
     * 
     * @return
     *     possible object is
     *     {@link CurrencyType }
     *     
     */
    public CurrencyType getCurrency() {
        return currency;
    }

    /**
     * Define el valor de la propiedad currency.
     * 
     * @param value
     *     allowed object is
     *     {@link CurrencyType }
     *     
     */
    public void setCurrency(CurrencyType value) {
        this.currency = value;
    }

    /**
     * Obtiene el valor de la propiedad ccReferenceNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCcReferenceNumber() {
        return ccReferenceNumber;
    }

    /**
     * Define el valor de la propiedad ccReferenceNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCcReferenceNumber(String value) {
        this.ccReferenceNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad nonRevenue.
     * 
     */
    public boolean isNonRevenue() {
        return nonRevenue;
    }

    /**
     * Define el valor de la propiedad nonRevenue.
     * 
     */
    public void setNonRevenue(boolean value) {
        this.nonRevenue = value;
    }

    /**
     * Obtiene el valor de la propiedad repeatViolator.
     * 
     */
    public boolean isRepeatViolator() {
        return repeatViolator;
    }

    /**
     * Define el valor de la propiedad repeatViolator.
     * 
     */
    public void setRepeatViolator(boolean value) {
        this.repeatViolator = value;
    }

    /**
     * Obtiene el valor de la propiedad repeatViolatorNotificationSent.
     * 
     */
    public boolean isRepeatViolatorNotificationSent() {
        return repeatViolatorNotificationSent;
    }

    /**
     * Define el valor de la propiedad repeatViolatorNotificationSent.
     * 
     */
    public void setRepeatViolatorNotificationSent(boolean value) {
        this.repeatViolatorNotificationSent = value;
    }

    /**
     * Obtiene el valor de la propiedad reverseDirectionFlag.
     * 
     */
    public boolean isReverseDirectionFlag() {
        return reverseDirectionFlag;
    }

    /**
     * Define el valor de la propiedad reverseDirectionFlag.
     * 
     */
    public void setReverseDirectionFlag(boolean value) {
        this.reverseDirectionFlag = value;
    }

    /**
     * Obtiene el valor de la propiedad hoVviolationFlag.
     * 
     */
    public boolean isHOVviolationFlag() {
        return hoVviolationFlag;
    }

    /**
     * Define el valor de la propiedad hoVviolationFlag.
     * 
     */
    public void setHOVviolationFlag(boolean value) {
        this.hoVviolationFlag = value;
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
     * Obtiene el valor de la propiedad degradedMode.
     * 
     */
    public boolean isDegradedMode() {
        return degradedMode;
    }

    /**
     * Define el valor de la propiedad degradedMode.
     * 
     */
    public void setDegradedMode(boolean value) {
        this.degradedMode = value;
    }

    /**
     * Obtiene el valor de la propiedad degradedPayment.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDegradedPayment() {
        return degradedPayment;
    }

    /**
     * Define el valor de la propiedad degradedPayment.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDegradedPayment(Boolean value) {
        this.degradedPayment = value;
    }

    /**
     * Obtiene el valor de la propiedad nonRevenuePresent.
     * 
     */
    public boolean isNonRevenuePresent() {
        return nonRevenuePresent;
    }

    /**
     * Define el valor de la propiedad nonRevenuePresent.
     * 
     */
    public void setNonRevenuePresent(boolean value) {
        this.nonRevenuePresent = value;
    }

}
