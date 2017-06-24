package br.com.tt.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.tt.jpa.Jpa;
import br.com.tt.model.Endereco;

public class EnderecoDao {

	public static List<Endereco> consultar(){
		String consulta = "SELECT c FROM Cliente c";
		TypedQuery<Endereco> query = Jpa.getEm().createQuery(consulta, Endereco.class);
		List<Endereco> resultList = query.getResultList();
		return resultList;
	}

	public static void salvar(Endereco endereco) {
		Jpa.getEm().getTransaction().begin();
		Jpa.getEm().persist(endereco);
		Jpa.getEm().getTransaction().commit();
		
	}

}
