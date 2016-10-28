package br.com.fiap.rs.exemplo;

import static javax.ws.rs.core.MediaType.APPLICATION_XML;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path(value="alunos")
public class AlunoWeb {

	static private List<Aluno> alunos;
	
	static{
		alunos = new ArrayList<>();
		Aluno aluno1 = new Aluno("Thiago","27SCJ",10);
		Aluno aluno2 = new Aluno("XING","27SCJ",10);
		alunos.add(aluno1);
		alunos.add(aluno2);
	}
	
	@GET
	@Produces(APPLICATION_XML)
	public List<Aluno> getAlunos(){
		return alunos;
	}
	
	@Path("{indice}")
	@GET
	@Produces(APPLICATION_XML)
	public Aluno geAluno(@PathParam("indice") int indice){
		return alunos.get(indice);
	}

	@POST
	@Consumes(APPLICATION_XML)
	@Produces(APPLICATION_XML)
	public Retorno novo(Aluno aluno){
		alunos.add(aluno);
		return new Retorno("Aluno Cadastrado com Sucesso.");
	}
	
	@Path("{indice}")
	@DELETE
	@Produces(APPLICATION_XML)
	public Retorno remover(@PathParam("indice") int indice){
		alunos.remove(indice);
		return new Retorno("Aluno Removido com Sucesso.");
	}

	@Path("{indice}")
	@PUT
	@Consumes(APPLICATION_XML)
	@Produces(APPLICATION_XML)
	public Retorno atualizar(Aluno aluno, @PathParam("indice") int indice){
		alunos.set(indice,aluno);
		return new Retorno("Aluno Atualizado com Sucesso.");
	}
	
	
	
	
}
