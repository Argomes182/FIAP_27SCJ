package br.com.fiap;

import java.util.Date;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class AgendaTarefas {

	public AgendaTarefas() {
	}

	@Schedule(second = "*/5", minute = "*", hour = "*")
	public void agendar() {
		System.out.println("[" + new Date() + "]");
	}

}
