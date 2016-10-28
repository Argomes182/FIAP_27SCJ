/**
 * CartaoendpointLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.fiap.webservice;

public class CartaoendpointLocator extends org.apache.axis.client.Service implements br.com.fiap.webservice.Cartaoendpoint {

    public CartaoendpointLocator() {
    }


    public CartaoendpointLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CartaoendpointLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CartaoWebServiceImplPort
    private java.lang.String CartaoWebServiceImplPort_address = "http://localhost:8080/04_CartaoWS/cartaoendpoint";

    public java.lang.String getCartaoWebServiceImplPortAddress() {
        return CartaoWebServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CartaoWebServiceImplPortWSDDServiceName = "CartaoWebServiceImplPort";

    public java.lang.String getCartaoWebServiceImplPortWSDDServiceName() {
        return CartaoWebServiceImplPortWSDDServiceName;
    }

    public void setCartaoWebServiceImplPortWSDDServiceName(java.lang.String name) {
        CartaoWebServiceImplPortWSDDServiceName = name;
    }

    public br.com.fiap.webservice.CartaoWebService getCartaoWebServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CartaoWebServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCartaoWebServiceImplPort(endpoint);
    }

    public br.com.fiap.webservice.CartaoWebService getCartaoWebServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.fiap.webservice.CartaoendpointSoapBindingStub _stub = new br.com.fiap.webservice.CartaoendpointSoapBindingStub(portAddress, this);
            _stub.setPortName(getCartaoWebServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCartaoWebServiceImplPortEndpointAddress(java.lang.String address) {
        CartaoWebServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.fiap.webservice.CartaoWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.fiap.webservice.CartaoendpointSoapBindingStub _stub = new br.com.fiap.webservice.CartaoendpointSoapBindingStub(new java.net.URL(CartaoWebServiceImplPort_address), this);
                _stub.setPortName(getCartaoWebServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CartaoWebServiceImplPort".equals(inputPortName)) {
            return getCartaoWebServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.fiap.com.br/", "cartaoendpoint");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.fiap.com.br/", "CartaoWebServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CartaoWebServiceImplPort".equals(portName)) {
            setCartaoWebServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
