package br.com.fiap.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface CartaoWebService {

	@WebMethod
	String validarCartao(@WebParam(name="numero") String numCartao,@WebParam(name="valor") double valor);
	
}
