package br.com.tt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.tt.jpa.Jpa;
import br.com.tt.model.Cliente;

public class ClienteDao {
	
	public static List<Cliente> consultar(){
		String consulta = "SELECT c FROM Cliente c";
		TypedQuery<Cliente> query = Jpa.getEm().createQuery(consulta, Cliente.class);
		List<Cliente> resultList = query.getResultList();
		return resultList;
	}

	public static List<Cliente> consultar(String tabela, String filtro){
		
		String consulta = "SELECT c FROM Cliente c Where ";
		TypedQuery<Cliente> query = Jpa.getEm().createQuery(consulta+tabela+"="+filtro, Cliente.class);
		List<Cliente> resultList = query.getResultList();
		return resultList;
	}
	
	public static void salvar(Cliente cliente) {
		Jpa.getEm().getTransaction().begin();
		Jpa.getEm().persist(cliente);
		Jpa.getEm().getTransaction().commit();
		
	}

}
