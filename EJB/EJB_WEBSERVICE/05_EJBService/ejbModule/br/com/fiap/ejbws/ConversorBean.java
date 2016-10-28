package br.com.fiap.ejbws;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Stateless
@WebService(serviceName = "Conversor", portName = "ConversorPort", endpointInterface = "br.com.fiap.ejbws.Conversor", targetNamespace = "http://jaxws.exemplos.fiap.com.br")
public class ConversorBean implements Conversor {

	private double valorDolar = 2.25;

	@Override
	public double DolarParaReal(double dolar) {
		return dolar * valorDolar;
	}

	@Override
	public double RealParaDolar(double real) {
		return real / valorDolar;
	}
}
