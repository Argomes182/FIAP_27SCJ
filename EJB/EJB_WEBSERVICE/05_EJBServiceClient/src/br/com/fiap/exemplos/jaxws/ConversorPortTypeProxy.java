package br.com.fiap.exemplos.jaxws;

public class ConversorPortTypeProxy implements br.com.fiap.exemplos.jaxws.ConversorPortType {
  private String _endpoint = null;
  private br.com.fiap.exemplos.jaxws.ConversorPortType conversorPortType = null;
  
  public ConversorPortTypeProxy() {
    _initConversorPortTypeProxy();
  }
  
  public ConversorPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initConversorPortTypeProxy();
  }
  
  private void _initConversorPortTypeProxy() {
    try {
      conversorPortType = (new br.com.fiap.exemplos.jaxws.ConversorLocator()).getConversorPort();
      if (conversorPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)conversorPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)conversorPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (conversorPortType != null)
      ((javax.xml.rpc.Stub)conversorPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.fiap.exemplos.jaxws.ConversorPortType getConversorPortType() {
    if (conversorPortType == null)
      _initConversorPortTypeProxy();
    return conversorPortType;
  }
  
  public double dolarParaReal(double arg0) throws java.rmi.RemoteException{
    if (conversorPortType == null)
      _initConversorPortTypeProxy();
    return conversorPortType.dolarParaReal(arg0);
  }
  
  public double realParaDolar(double arg0) throws java.rmi.RemoteException{
    if (conversorPortType == null)
      _initConversorPortTypeProxy();
    return conversorPortType.realParaDolar(arg0);
  }
  
  
}