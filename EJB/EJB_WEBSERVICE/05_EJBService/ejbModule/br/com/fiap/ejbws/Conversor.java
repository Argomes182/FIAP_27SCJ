package br.com.fiap.ejbws;

import javax.ejb.Remote;
import javax.jws.WebService;

@Remote
@WebService(name = "ConversorPortType", targetNamespace = "http://jaxws.exemplos.fiap.com.br")
public interface Conversor {
	double DolarParaReal(double dolar);

	double RealParaDolar(double real);
}
