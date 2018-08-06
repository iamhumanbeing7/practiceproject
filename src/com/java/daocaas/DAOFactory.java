package com.java.daocaas;

import com.java.entity.OffcrProfile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOFactory {
    private EntityManager em;
    private EntityManagerFactory emf;

    public DAOFactory(){
//        System.out.println("test!");
        this.emf = Persistence.createEntityManagerFactory("CAASAAPU");
        System.out.println(emf.toString());
        this.em = emf.createEntityManager();
    }
    public OffcrProfileDAO getOffcrProfileDAO(){
        return new OffcrProfileDAOImpl(em);
    }

}
