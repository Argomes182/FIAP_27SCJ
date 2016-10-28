package br.com.fiap.controller;

import br.com.fiap.webservice.CartaoWebService;
import br.com.fiap.webservice.CartaoWebServiceProxy;

public class ClienteWS {
	public static void main(String[] args) {
		CartaoWebService ws = new CartaoWebServiceProxy();
		try {
			String cartao = "1234123412341234";
			double valor = 120;
			System.out.println(ws.validarCartao(cartao, valor));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}