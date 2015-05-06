package com.spring.mvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.domain.Producto;

@Repository(value = "productDAO")
public class JPAProductoDAO implements ProductDAO {

	private EntityManager em = null;
	
	/**
	 * Set the entity manager
	 * @param em
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.em = em;
	}
	
	
	/**
	 * @return list
	 */
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Producto> getProductoList() {
		return em.createQuery("select p from Product p order by p.id").getResultList();
	}

	@Transactional(readOnly = false)
	public void saveProduct(Producto prod) {
		em.merge(prod);
	}

}
