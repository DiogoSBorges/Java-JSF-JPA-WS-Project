package br.com.diogo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.diogo.model.Organizacao;
import br.com.diogo.util.JPAUtil;

public class OrganizacaoRepository {

	public Organizacao salvarOrganizacao(Organizacao organizacao) {
		
		EntityManager em = JPAUtil.getEM();
		em.getTransaction().begin();
		em.persist(organizacao);
		em.getTransaction().commit();
		em.close();

		return organizacao;
	}

	public List<Organizacao> buscarTodasOrganizacao() {
		EntityManager em = JPAUtil.getEM();

		return em.createNamedQuery("Organizacao.getAll", Organizacao.class).getResultList();
	}

}
