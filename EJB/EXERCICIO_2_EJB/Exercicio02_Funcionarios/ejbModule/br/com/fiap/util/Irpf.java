package br.com.fiap.util;

public class Irpf {
	public double calcularIrpf(double salario) {
		double[] taxas = { 0, 7.5, 15, 22.5, 27.5 };
		double[] valores = { 0, 1499.15, 2246.75, 2995.7, 3743.19 };

		double imposto = 0;

		for (int i = taxas.length - 1; i >= 0; i--) {
			if (salario > valores[i]) {
				imposto += (salario - valores[i]) * taxas[i] / 100;
				salario = valores[i];
			}
		}
		return imposto;
	}
}