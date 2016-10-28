package br.com.fiap.exemplo.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
public class AlunoWeb {
	
	@Resource
	WebServiceContext wsctx;
	
	private List<Aluno> alunos;
 
	public AlunoWeb() {
		alunos = new ArrayList<>();
	}
	
	@WebMethod
	public String novo(@WebParam(name="aluno",header=false) Aluno aluno,
			@WebParam(name="Username",header=true) String usuario, 
			@WebParam(name="Password",header=true)String senha){
		if(autenticado(usuario,senha)){
			alunos.add(aluno);
			return "Aluno cadastrado com sucesso.";
		}
		return "Falha de Autenticação" ;
	}
	
	@WebMethod(exclude=true)
	public boolean autenticado(String usuario, String senha){
		MessageContext messageContext = wsctx.getMessageContext();
		Map http_headers = (Map) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
		List usuarios = (List) http_headers.get("Username");
		List senhas = (List) http_headers.get("Password");
	
		if(usuarios != null) usuario = usuarios.get(0).toString();
		if(senhas != null) senha = senhas.get(0).toString();
		
		return (usuario.equals("Thiago") &&  senha.equals("123"));
	}
	
	
	@WebMethod
	public List<Aluno> listar(
			@WebParam(name="Username",header=true ) String usuario, 
			@WebParam(name="Password",header=true)String senha) throws Exception{
		if(autenticado(usuario,senha)){
			return alunos;
		}
		throw new Exception("Falha de Autenticação");
	}
	
}
