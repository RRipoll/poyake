
package com.etantolling.fastlane.wsdot.tcs.wsdl.reconciliation.daily;

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
 *         &lt;element name="fromDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="toDateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="arrayList" type="{http://daily.reconciliation.wsdl.tcs.wsdot.fastlane.etantolling.com}arrayListType"/&gt;
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
@XmlRootElement(name = "DailyReconciliationRequest")
public class DailyReconciliationRequest {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fromDateTime;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar toDateTime;
    @XmlElement(required = true)
    protected ArrayListType arrayList;

    /**
     * Obtiene el valor de la propiedad fromDateTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFromDateTime() {
        return fromDateTime;
    }

    /**
     * Define el valor de la propiedad fromDateTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFromDateTime(XMLGregorianCalendar value) {
        this.fromDateTime = value;
    }

    /**
     * Obtiene el valor de la propiedad toDateTime.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getToDateTime() {
        return toDateTime;
    }

    /**
     * Define el valor de la propiedad toDateTime.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setToDateTime(XMLGregorianCalendar value) {
        this.toDateTime = value;
    }

    /**
     * Obtiene el valor de la propiedad arrayList.
     * 
     * @return
     *     possible object is
     *     {@link ArrayListType }
     *     
     */
    public ArrayListType getArrayList() {
        return arrayList;
    }

    /**
     * Define el valor de la propiedad arrayList.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayListType }
     *     
     */
    public void setArrayList(ArrayListType value) {
        this.arrayList = value;
    }

}
