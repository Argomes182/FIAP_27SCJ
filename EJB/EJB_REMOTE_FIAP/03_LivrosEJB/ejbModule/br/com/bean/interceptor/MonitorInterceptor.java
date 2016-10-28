package br.com.bean.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class MonitorInterceptor {

	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		long ms = System.currentTimeMillis();

		// metodo a ser executado e monitorado
		Object obj = context.proceed();

		System.out.println("Tempo na consulta : " + (System.currentTimeMillis() - ms));
		String nomeMetodo = context.getMethod().getName();
		String nomeClasse = context.getTarget().getClass().getName();

		System.out.println("Método: " + nomeMetodo);
		System.out.println("Classe: " + nomeClasse);

		return obj;
	}
}
