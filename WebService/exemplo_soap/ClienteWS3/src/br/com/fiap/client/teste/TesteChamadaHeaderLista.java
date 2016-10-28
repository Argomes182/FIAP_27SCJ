package br.com.fiap.client.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.clientheader.Aluno;
import br.com.fiap.clientheader.AlunoWeb;
import br.com.fiap.clientheader.AlunoWebService;
import br.com.fiap.clientheader.Exception_Exception;
import br.com.fiap.clientheader.Listar;
import br.com.fiap.clientheader.ListarResponse;

public class TesteChamadaHeaderLista {

	public static void main(String[] args) {
		List<Aluno> alunos = new ArrayList<>();
		AlunoWeb port = new AlunoWebService().getAlunoWebPort();
		Listar parametros = new Listar();
		
		try {
			ListarResponse resposta = port.listar(parametros, "Thiago", "123");
			alunos = resposta.getReturn();
			
			for (Aluno aluno : alunos) {
				System.out.println("Nome: " +aluno.getNome());
				System.out.println("Turma: " +aluno.getTurma());
				System.out.println("Media: " +aluno.getMedia());
				System.out.println("-----------------------------");
			}
		} catch (Exception_Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
