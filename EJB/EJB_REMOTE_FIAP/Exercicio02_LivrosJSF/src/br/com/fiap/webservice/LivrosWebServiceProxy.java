package br.com.fiap.webservice;

public class LivrosWebServiceProxy implements br.com.fiap.webservice.LivrosWebService {
  private String _endpoint = null;
  private br.com.fiap.webservice.LivrosWebService livrosWebService = null;
  
  public LivrosWebServiceProxy() {
    _initLivrosWebServiceProxy();
  }
  
  public LivrosWebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initLivrosWebServiceProxy();
  }
  
  private void _initLivrosWebServiceProxy() {
    try {
      livrosWebService = (new br.com.fiap.webservice.LivroendpointLocator()).getLivrosWebServiceImplPort();
      if (livrosWebService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)livrosWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)livrosWebService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (livrosWebService != null)
      ((javax.xml.rpc.Stub)livrosWebService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.fiap.webservice.LivrosWebService getLivrosWebService() {
    if (livrosWebService == null)
      _initLivrosWebServiceProxy();
    return livrosWebService;
  }
  
  public void add(br.com.fiap.webservice.Livro arg0) throws java.rmi.RemoteException{
    if (livrosWebService == null)
      _initLivrosWebServiceProxy();
    livrosWebService.add(arg0);
  }
  
  public br.com.fiap.webservice.Livro[] getAll() throws java.rmi.RemoteException{
    if (livrosWebService == null)
      _initLivrosWebServiceProxy();
    return livrosWebService.getAll();
  }
  
  
}