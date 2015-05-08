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

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Producto> getProductList() {
        return em.createQuery("select p from Producto p order by p.id").getResultList();
    }

    @Transactional(readOnly = false)
    public void saveProduct(Producto prod) {
        em.merge(prod);
    }

}
