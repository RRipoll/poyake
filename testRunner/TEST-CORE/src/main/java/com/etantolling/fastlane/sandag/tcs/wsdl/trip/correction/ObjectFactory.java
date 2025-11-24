
package com.etantolling.fastlane.sandag.tcs.wsdl.trip.correction;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.etantolling.fastlane.sandag.tcs.wsdl.trip.correction package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReturnCodeDescription_QNAME = new QName("", "Description");
    private final static QName _ReturnCodeSeverityCode_QNAME = new QName("", "SeverityCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.etantolling.fastlane.sandag.tcs.wsdl.trip.correction
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TripTransactionCorrection }
     * 
     */
    public TripTransactionCorrection createTripTransactionCorrection() {
        return new TripTransactionCorrection();
    }

    /**
     * Create an instance of {@link ReturnCode }
     * 
     */
    public ReturnCode createReturnCode() {
        return new ReturnCode();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "Description", scope = ReturnCode.class)
    public JAXBElement<String> createReturnCodeDescription(String value) {
        return new JAXBElement<String>(_ReturnCodeDescription_QNAME, String.class, ReturnCode.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "SeverityCode", scope = ReturnCode.class)
    public JAXBElement<String> createReturnCodeSeverityCode(String value) {
        return new JAXBElement<String>(_ReturnCodeSeverityCode_QNAME, String.class, ReturnCode.class, value);
    }

}
