/**
 * Conversor.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.fiap.exemplos.jaxws;

public interface Conversor extends javax.xml.rpc.Service {
    public java.lang.String getConversorPortAddress();

    public br.com.fiap.exemplos.jaxws.ConversorPortType getConversorPort() throws javax.xml.rpc.ServiceException;

    public br.com.fiap.exemplos.jaxws.ConversorPortType getConversorPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
