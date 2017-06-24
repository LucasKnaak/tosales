package br.com.tt.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.tt.jpa.Jpa;
import br.com.tt.model.Cliente;
import br.com.tt.model.Usuario;

public class UsuarioDao {
	
	public static List<Usuario> consultar(){
		String consulta = "SELECT c FROM Funcionario c";
		TypedQuery<Usuario> query = Jpa.getEm().createQuery(consulta, Usuario.class);
		List<Usuario> resultList = query.getResultList();
		return resultList;
	}

	public static void salvar(Usuario usuario) {
		Jpa.getEm().getTransaction().begin();
		Jpa.getEm().persist(usuario);
		Jpa.getEm().getTransaction().commit();
		
	}
	
	public static void deletar(Usuario usuario) {
		Jpa.getEm().getTransaction().begin();
		Jpa.getEm().remove(usuario);
		Jpa.getEm().getTransaction().commit();
		
	}

}
