/**
 * LivrosWebService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.fiap.webservice;

public interface LivrosWebService extends java.rmi.Remote {
    public void add(br.com.fiap.webservice.Livro arg0) throws java.rmi.RemoteException;
    public br.com.fiap.webservice.Livro[] getAll() throws java.rmi.RemoteException;
}
