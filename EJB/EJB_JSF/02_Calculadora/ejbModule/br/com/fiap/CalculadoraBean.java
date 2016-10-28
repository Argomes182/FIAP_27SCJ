package br.com.fiap;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class CalculadoraBean
 */
@Stateless
public class CalculadoraBean implements CalculadoraLocal {

	public CalculadoraBean() {

	}

	@Override
	public double somar(double x, double y) {
		return x + y;
	}

	@Override
	public double subtrair(double x, double y) {
		return x - y;
	}

	@Override
	public double multiplicar(double x, double y) {
		return x * y;
	}

	@Override
	public double dividir(double x, double y) {
		return x / y;
	}

}
