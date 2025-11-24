package com.etantolling.fastlane.sandag.tcs.wsdl.tripTransaction.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

import com.etantolling.fastlane.wsdot.tcs.wsdl.client.v2.TransactionPortV2Service;

import javax.xml.ws.Service;

@WebServiceClient(name = "TripTransactionInterface",
//wsdlLocation = "file:/C:/Users/javi/AppData/Local/Temp/tempdir7772626047070467715.tmp/TripTransaction_1.wsdl",
wsdlLocation = "wsdl/TripTransaction.wsdl",
targetNamespace = "http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com")
public class TripTransactionInterfaceService extends Service{
	 public final static URL WSDL_LOCATION;

	    public final static QName SERVICE = new QName("http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com", "TripTransactionInterface");
	    public final static QName TripTransactionInterfaceHttpPort = new QName("http://tripTransaction.wsdl.tcs.sandag.fastlane.etantolling.com", "TripTransactionInterfaceHttpPort");
	    static {
	        URL url = null;
	        try {
	            //url = new URL("file:/C:/Users/javi/AppData/Local/Temp/tempdir7772626047070467715.tmp/TripTransaction_1.wsdl");
	         	  url = TripTransactionInterfaceService.class.getClassLoader().getResource("wsdl/TripTransaction.wsdl");
	            
	        } catch (Exception e) {
	            java.util.logging.Logger.getLogger(TripTransactionInterfaceService.class.getName())
	                .log(java.util.logging.Level.INFO,
	                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/javi/AppData/Local/Temp/tempdir7772626047070467715.tmp/TripTransaction_1.wsdl");
	        }
	        WSDL_LOCATION = url;
	    }

	    public TripTransactionInterfaceService(URL wsdlLocation) {
	        super(wsdlLocation, SERVICE);
	    }

	    public TripTransactionInterfaceService(URL wsdlLocation, QName serviceName) {
	        super(wsdlLocation, serviceName);
	    }

	    public TripTransactionInterfaceService() {
	        super(WSDL_LOCATION, SERVICE);
	    }

	    public TripTransactionInterfaceService(WebServiceFeature ... features) {
	        super(WSDL_LOCATION, SERVICE, features);
	    }

	    public TripTransactionInterfaceService(URL wsdlLocation, WebServiceFeature ... features) {
	        super(wsdlLocation, SERVICE, features);
	    }

	    public TripTransactionInterfaceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
	        super(wsdlLocation, serviceName, features);
	    }




	    /**
	     *
	     * @return
	     *     returns TripTransactionInterfacePortType
	     */
	    @WebEndpoint(name = "TripTransactionInterfaceHttpPort")
	    public TripTransactionInterfacePort getTripTransactionInterfaceHttpPort() {
	        return super.getPort(TripTransactionInterfaceHttpPort, TripTransactionInterfacePort.class);
	    }

	    /**
	     *
	     * @param features
	     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
	     * @return
	     *     returns TripTransactionInterfacePortType
	     */
	    @WebEndpoint(name = "TripTransactionInterfaceHttpPort")
	    public TripTransactionInterfacePort getTripTransactionInterfaceHttpPort(WebServiceFeature... features) {
	        return super.getPort(TripTransactionInterfaceHttpPort, TripTransactionInterfacePort.class, features);
	    }
}
