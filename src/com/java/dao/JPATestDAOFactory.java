package com.java.dao;

//import javax.enterprise.context.ApplicationScoped;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import javax.persistence.PersistenceContext;

public class JPATestDAOFactory {
    private EntityManager em;
    private EntityManagerFactory emf;

    public JPATestDAOFactory(){
        System.out.println("hello!");
        this.emf = Persistence.createEntityManagerFactory("JPATestPU");
        System.out.println(emf.toString());
        this.em = emf.createEntityManager();
    }
    public JPATestDAO createJPATestDAO(){
        return new JPATestDAOImpl(em);
    }

}
