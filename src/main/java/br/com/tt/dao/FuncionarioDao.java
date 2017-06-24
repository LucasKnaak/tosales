package br.com.tt.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.tt.jpa.Jpa;
import br.com.tt.model.Cliente;
import br.com.tt.model.Funcionario;

public class FuncionarioDao {
	
	public static List<Funcionario> consultar(){
		String consulta = "SELECT c FROM Funcionario c";
		TypedQuery<Funcionario> query = Jpa.getEm().createQuery(consulta, Funcionario.class);
		List<Funcionario> resultList = query.getResultList();
		return resultList;
	}

	public static void salvar(Funcionario funcionario) {
		Jpa.getEm().getTransaction().begin();
		Jpa.getEm().persist(funcionario);
		Jpa.getEm().getTransaction().commit();
		
	}
	
	public static void deletar(Funcionario funcionario) {
		Jpa.getEm().getTransaction().begin();
		Jpa.getEm().remove(funcionario);
		Jpa.getEm().getTransaction().commit();
		
	}

}
