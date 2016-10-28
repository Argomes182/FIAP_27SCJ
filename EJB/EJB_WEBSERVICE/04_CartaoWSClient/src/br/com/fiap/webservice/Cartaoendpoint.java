/**
 * Cartaoendpoint.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.fiap.webservice;

public interface Cartaoendpoint extends javax.xml.rpc.Service {
    public java.lang.String getCartaoWebServiceImplPortAddress();

    public br.com.fiap.webservice.CartaoWebService getCartaoWebServiceImplPort() throws javax.xml.rpc.ServiceException;

    public br.com.fiap.webservice.CartaoWebService getCartaoWebServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
