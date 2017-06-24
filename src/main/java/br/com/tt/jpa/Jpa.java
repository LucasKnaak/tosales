package br.com.tt.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Jpa {

	private static EntityManagerFactory emf;
	private static EntityManager em;

	public static EntityManager getEm() {
		if (em == null || !em.isOpen()){
		emf = Persistence.createEntityManagerFactory("pu_jpa");
		em = emf.createEntityManager();
		}
		return em;
	}
	
	
}
