package br.com.fiap.client.teste;

import br.com.fiap.clientheader.Aluno;
import br.com.fiap.clientheader.AlunoWeb;
import br.com.fiap.clientheader.AlunoWebService;
import br.com.fiap.clientheader.Novo;
import br.com.fiap.clientheader.NovoResponse;

public class TesteChamadaHeader {

	
	public static void main(String[] args) {
			Aluno aluno = new Aluno();
			aluno.setNome("Thiago");
			aluno.setTurma("27SCJ");;
			aluno.setMedia(10);
			
		AlunoWeb port = new AlunoWebService().getAlunoWebPort();
		Novo parametro = new Novo();
		parametro.setAluno(aluno);
		
		NovoResponse resposta = port.novo(parametro, "Thiago", "123");
		System.out.println(resposta.getReturn());
			
	}
	
}
