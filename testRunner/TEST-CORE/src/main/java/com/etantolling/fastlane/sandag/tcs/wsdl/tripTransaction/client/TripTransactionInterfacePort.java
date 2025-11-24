package com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.ObjectFactory;
import com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.ReturnCode;
import com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.TripTransaction;

@WebService(targetNamespace = "http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com", name = "TripTransactionInterfacePortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TripTransactionInterfacePort {
	@WebMethod(action = "http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com/sendTripTransaction")
    @WebResult(name = "ReturnCode", targetNamespace = "http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com", partName = "response")
    public ReturnCode sendTransactionData(
        @WebParam(partName = "request", name = "TripTransaction", targetNamespace = "http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com")
        TripTransaction request
    );
}
