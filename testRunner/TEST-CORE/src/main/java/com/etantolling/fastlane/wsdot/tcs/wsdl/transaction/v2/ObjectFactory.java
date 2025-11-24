
package com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2 package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.etantolling.fastlane.wsdot.tcs.wsdl.transaction.v2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TollTransactionV2Request }
     * 
     */
    public TollTransactionV2Request createTollTransactionV2Request() {
        return new TollTransactionV2Request();
    }

    /**
     * Create an instance of {@link TransponderType }
     * 
     */
    public TransponderType createTransponderType() {
        return new TransponderType();
    }

    /**
     * Create an instance of {@link ImageListType }
     * 
     */
    public ImageListType createImageListType() {
        return new ImageListType();
    }

    /**
     * Create an instance of {@link TollTransactionV2Response }
     * 
     */
    public TollTransactionV2Response createTollTransactionV2Response() {
        return new TollTransactionV2Response();
    }

    /**
     * Create an instance of {@link ImageOCRType }
     * 
     */
    public ImageOCRType createImageOCRType() {
        return new ImageOCRType();
    }

    /**
     * Create an instance of {@link ImageOCRsType }
     * 
     */
    public ImageOCRsType createImageOCRsType() {
        return new ImageOCRsType();
    }

}
