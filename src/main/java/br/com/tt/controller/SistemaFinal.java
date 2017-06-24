package br.com.tt.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import br.com.tt.controller.spark.template.velocity.VelocityTemplateEngine;
import br.com.tt.dao.ClienteDao;
import br.com.tt.dao.EnderecoDao;
import br.com.tt.dao.FuncionarioDao;
import br.com.tt.dao.ProdutoDao;
import br.com.tt.dao.UsuarioDao;
import br.com.tt.model.Cliente;
import br.com.tt.model.Endereco;
import br.com.tt.model.Funcionario;
import br.com.tt.model.Sexo;
import br.com.tt.model.Usuario;
import spark.ModelAndView;

import static spark.Spark.*;

public class SistemaFinal {
	public static void main(String[] args) {
		staticFileLocation("/public");
		String layout = "templates/layout.vtl";
		String telaLogin = "templates/tLogin.vtl";
		
		get("/", (request, response) -> {
			Map model = new HashMap();
			model.put("template", "templates/login.vtl");
			return new ModelAndView(model, telaLogin);
		}, new VelocityTemplateEngine());
		
		get("/inicio", (request, response) -> {
			Map model = new HashMap();
			model.put("template", "templates/inicio.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		
		get("/cliente", (request, response) -> {
			Map model = new HashMap();
		//	model.put("clientes", ClienteDao.consultar());
			model.put("template", "templates/cliente.vtl");

			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		
		get("/produtos", (request, response) -> {
			Map model = new HashMap();
		//	model.put("produtoss", ProdutoDao.consultar());
			model.put("template", "templates/produtos.vtl");
			
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		
		get("/usuario", (request, response) -> {
			Map model = new HashMap();
		//	model.put("usuarios", UsuarioDao.consultar());
			model.put("template", "templates/usuario.vtl");
			
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		
		get("/orcamento", (request, response) -> {
			Map model = new HashMap();
			model.put("template", "templates/orcamento.vtl");
			
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());


		
		post("/cliente-cadastro", (request, response) -> {

			String contato = "";
			String cnpj = "";
			String rSocial = "";
			String nFantasia = "";
			String email = "";
			String telefone = "";
			String inscEstadual = "";
			String inscMunicipal = "";
			String obs = "";
			String status = "";
			String cidade = "";
			
			try {
				contato = request.queryParams("contato");
				cnpj = request.queryParams("cnpj");
				rSocial = request.queryParams("rSocial");
				nFantasia = request.queryParams("nFantasia");
				email = request.queryParams("email");
				telefone = request.queryParams("telefone");
				inscEstadual = request.queryParams("inscEstadual");
				inscMunicipal = request.queryParams("inscMunicipal");
				obs = request.queryParams("obs");
				status = request.queryParams("status");
				cidade = request.queryParams("cidade");
			} catch (Exception e) {
				e.printStackTrace();
			}
		//	Endereco endereco = new Endereco();
			Cliente cliente = new Cliente();
			cliente.setContato(contato);
			cliente.setCnpj(cnpj);
			cliente.setrSocial(rSocial);
			cliente.setnFantasia(nFantasia);
			cliente.setEmail(email);
			cliente.setStatus(status);
		//	endereco.setCidade(cidade);
		//	EnderecoDao.salvar(endereco);
			ClienteDao.salvar(cliente);
			
			Map model = new HashMap();
			model.put("cadastros", ClienteDao.consultar());
			model.put("template", "templates/cliente.vtl");
			
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		
		post("/cliente_cadastro", (request, response) -> {
			Map model = new HashMap();
		//	model.put("clientes", ClienteDao.consultar());
			model.put("template", "templates/cliente_cadastro.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		
		post("/cliente-listar", (request, response) -> {

			Map model = new HashMap();
			model.put("clientes", ClienteDao.consultar());
			model.put("template", "templates/cliente.vtl");
			
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		
		post("/cliente-filtrar", (request, response) -> {

			String tabela = request.queryParams("tabela");
			String filtro = request.queryParams("filtro");
			
			System.out.println(tabela+" "+filtro);
			
			Map model = new HashMap();
			model.put("clientes", ClienteDao.consultar(tabela,filtro));
			model.put("template", "templates/cliente.vtl");
			
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		
		
		
		post("/produto-listar", (request, response) -> {

			Map model = new HashMap();
			model.put("produtos", ProdutoDao.consultar());
			model.put("template", "templates/produtos.vtl");
			
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		
		
		
		
		post("/usuario-cadastro", (request, response) -> {

			String nome = "";
			String cpf = "";
			String cargo = "";
			Calendar dataNascimento;
			Sexo sexo;
			String email = "";
			String login = "";
			String senha = "";
			
			try {
				nome = request.queryParams("nome");
				cpf = request.queryParams("cpf");
				cargo = request.queryParams("cargo");
				
				email = request.queryParams("email");
				login = request.queryParams("login");
				senha = request.queryParams("senha");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setCpf(cpf);
			usuario.setCargo(cargo);
			
			usuario.setEmail(email);
			usuario.setLogin(telaLogin);
			usuario.setSenha(senha);
			
			UsuarioDao.salvar(usuario);
			Map model = new HashMap();
			model.put("usuarios", UsuarioDao.consultar());
			model.put("template", "templates/usuario.vtl");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
		
		
		
	}
}
