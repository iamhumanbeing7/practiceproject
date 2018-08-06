package com.java.daocaas;

import com.java.entity.OffcrProfile;

import javax.persistence.EntityManager;
import java.util.List;

public class OffcrProfileDAOImpl implements OffcrProfileDAO{
    private EntityManager em;
    public OffcrProfileDAOImpl(EntityManager em){
        this.em = em;
    }

    public void create(OffcrProfile entity){
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public List<OffcrProfile> retrieveAll(){
        return em.createQuery("SELECT t_op FROM OffcrProfile t_op",OffcrProfile.class).getResultList();
    }

    public OffcrProfile retrieve(String sid){
        return em.find(OffcrProfile.class,sid);
    }

    public void update(OffcrProfile entity){
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public void delete(String sid){
        em.getTransaction().begin();
        OffcrProfile AnEntity = retrieve(sid);
        em.remove(AnEntity);
        em.getTransaction().commit();
    }
}
