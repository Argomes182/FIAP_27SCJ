package br.com.fiap.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName = "cartaoendpoint")
public class CartaoWebServiceImpl implements CartaoWebService {
	@Override
	@WebMethod
	public String validarCartao(@WebParam(name = "numero") String numCartao, @WebParam(name = "valor") double valor) {
		if (numCartao.length() != 16) {
			return "Cartão inválido";
		} else {
			return "Débito de " + valor + " efetuado com sucesso";
		}
	}
}
