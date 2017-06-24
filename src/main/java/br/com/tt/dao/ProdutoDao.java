package br.com.tt.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.tt.jpa.Jpa;
import br.com.tt.model.Cliente;
import br.com.tt.model.Produtos;

public class ProdutoDao {
	
	public static List<Produtos> consultar(){
		String consulta = "SELECT c FROM Funcionario c";
		TypedQuery<Produtos> query = Jpa.getEm().createQuery(consulta, Produtos.class);
		List<Produtos> resultList = query.getResultList();
		return resultList;
	}

	public static void salvar(Produtos produto) {
		Jpa.getEm().getTransaction().begin();
		Jpa.getEm().persist(produto);
		Jpa.getEm().getTransaction().commit();
		
	}
	
	public static void deletar(Produtos produto) {
		Jpa.getEm().getTransaction().begin();
		Jpa.getEm().remove(produto);
		Jpa.getEm().getTransaction().commit();
		
	}

}
