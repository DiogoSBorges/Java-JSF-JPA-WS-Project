package br.com.diogo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	public static EntityManager getEM() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("webservicePersist");
		return factory.createEntityManager();
	}

}
