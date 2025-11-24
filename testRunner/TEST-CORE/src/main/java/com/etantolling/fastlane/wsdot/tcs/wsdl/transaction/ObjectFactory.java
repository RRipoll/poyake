
package com.etantolling.fastlane.wsdot.tcs.wsdl.transaction;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.etantolling.fastlane.wsdot.tcs.wsdl.transaction package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.etantolling.fastlane.wsdot.tcs.wsdl.transaction
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TollTransactionRequest }
     * 
     */
    public TollTransactionRequest createTollTransactionRequest() {
        return new TollTransactionRequest();
    }

    /**
     * Create an instance of {@link TollTransactionRequest.ImageList }
     * 
     */
    public TollTransactionRequest.ImageList createTollTransactionRequestImageList() {
        return new TollTransactionRequest.ImageList();
    }

    /**
     * Create an instance of {@link TollTransactionRequest.Transponder }
     * 
     */
    public TollTransactionRequest.Transponder createTollTransactionRequestTransponder() {
        return new TollTransactionRequest.Transponder();
    }

    /**
     * Create an instance of {@link TollTransactionResponse }
     * 
     */
    public TollTransactionResponse createTollTransactionResponse() {
        return new TollTransactionResponse();
    }

    /**
     * Create an instance of {@link TollTransactionRequest.ImageList.Image }
     * 
     */
    public TollTransactionRequest.ImageList.Image createTollTransactionRequestImageListImage() {
        return new TollTransactionRequest.ImageList.Image();
    }

}
