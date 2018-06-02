
package pl.com.kir.srpn.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6b21 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SRPNService", targetNamespace = "http://soap.srpn.kir.com.pl/")
public class SRPNService_Service
    extends Service
{

    private final static URL SRPNSERVICE_WSDL_LOCATION;
    private final static WebServiceException SRPNSERVICE_EXCEPTION;
    private final static QName SRPNSERVICE_QNAME = new QName("http://soap.srpn.kir.com.pl/", "SRPNService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/D:/zabawy/netbeansprojects/ExpressELIXIR/src/wsdl/SRPNService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SRPNSERVICE_WSDL_LOCATION = url;
        SRPNSERVICE_EXCEPTION = e;
    }

    public SRPNService_Service() {
        super(__getWsdlLocation(), SRPNSERVICE_QNAME);
    }

    public SRPNService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SRPNSERVICE_QNAME, features);
    }

    public SRPNService_Service(URL wsdlLocation) {
        super(wsdlLocation, SRPNSERVICE_QNAME);
    }

    public SRPNService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SRPNSERVICE_QNAME, features);
    }

    public SRPNService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SRPNService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SRPNService
     */
    @WebEndpoint(name = "SRPNServicePort")
    public SRPNService getSRPNServicePort() {
        return super.getPort(new QName("http://soap.srpn.kir.com.pl/", "SRPNServicePort"), SRPNService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SRPNService
     */
    @WebEndpoint(name = "SRPNServicePort")
    public SRPNService getSRPNServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://soap.srpn.kir.com.pl/", "SRPNServicePort"), SRPNService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SRPNSERVICE_EXCEPTION!= null) {
            throw SRPNSERVICE_EXCEPTION;
        }
        return SRPNSERVICE_WSDL_LOCATION;
    }

}