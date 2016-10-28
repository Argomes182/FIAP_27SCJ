package br.com.fiap;

import javax.ejb.Local;

@Local
public interface CalculadoraLocal {
	double somar(double x, double y);
	double subtrair(double x, double y);
	double multiplicar(double x, double y);
	double dividir(double x, double y);
}
