
package com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.etantolling.fastlane.sandag.tcs.wsdl.triptransaction package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.etantolling.fastlane.sandag.tcs.wsdl.triptransaction
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TripTransaction }
     * 
     */
    public TripTransaction createTripTransaction() {
        return new TripTransaction();
    }

    /**
     * Create an instance of {@link TransponderType }
     * 
     */
    public TransponderType createTransponderType() {
        return new TransponderType();
    }

    /**
     * Create an instance of {@link TransactionListType }
     * 
     */
    public TransactionListType createTransactionListType() {
        return new TransactionListType();
    }

    /**
     * Create an instance of {@link ReturnCode }
     * 
     */
    public ReturnCode createReturnCode() {
        return new ReturnCode();
    }

    /**
     * Create an instance of {@link ImageListType }
     * 
     */
    public ImageListType createImageListType() {
        return new ImageListType();
    }

    /**
     * Create an instance of {@link Image }
     * 
     */
    public Image createImage() {
        return new Image();
    }

}
