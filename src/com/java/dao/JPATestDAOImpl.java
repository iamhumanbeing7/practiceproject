package com.java.dao;

import javax.persistence.EntityManager;
import java.util.List;

public class JPATestDAOImpl implements JPATestDAO{
    private EntityManager em;
    public JPATestDAOImpl(EntityManager em){
        this.em = em;
    }
    @Override
    public void addJPATest(TblJpatestEntity JPATestEntity){
        em.getTransaction().begin();
        em.persist(JPATestEntity);
        em.getTransaction().commit();
    }

    @Override
    public TblJpatestEntity getJPATest(int id){
        return queryJPATest().get(id);
    }

    @Override
    public List<TblJpatestEntity> queryJPATest(){
        return em.createNativeQuery("select * from TBL_JPATEST order by id", TblJpatestEntity.class).getResultList();
    }

    @Override
    public void deleteJPATest(int id){
        em.getTransaction().begin();
        em.remove(getJPATest(id));
        em.getTransaction().commit();
    }

    @Override
    public void updateJPATest(TblJpatestEntity JPATestEntity){
        em.getTransaction().begin();
        em.merge(JPATestEntity);
        em.getTransaction().commit();
    }
}
