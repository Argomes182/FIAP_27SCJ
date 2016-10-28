package br.com.fiap.webservice;

public class CartaoWebServiceProxy implements br.com.fiap.webservice.CartaoWebService {
  private String _endpoint = null;
  private br.com.fiap.webservice.CartaoWebService cartaoWebService = null;
  
  public CartaoWebServiceProxy() {
    _initCartaoWebServiceProxy();
  }
  
  public CartaoWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCartaoWebServiceProxy();
  }
  
  private void _initCartaoWebServiceProxy() {
    try {
      cartaoWebService = (new br.com.fiap.webservice.CartaoendpointLocator()).getCartaoWebServiceImplPort();
      if (cartaoWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cartaoWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cartaoWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cartaoWebService != null)
      ((javax.xml.rpc.Stub)cartaoWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.fiap.webservice.CartaoWebService getCartaoWebService() {
    if (cartaoWebService == null)
      _initCartaoWebServiceProxy();
    return cartaoWebService;
  }
  
  public java.lang.String validarCartao(java.lang.String numero, double valor) throws java.rmi.RemoteException{
    if (cartaoWebService == null)
      _initCartaoWebServiceProxy();
    return cartaoWebService.validarCartao(numero, valor);
  }
  
  
}