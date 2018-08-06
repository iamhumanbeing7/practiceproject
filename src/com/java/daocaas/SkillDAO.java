package com.java.daocaas;

import com.java.entity.Skill;

import javax.persistence.EntityManager;
import java.util.List;

public class SkillDAO implements BaseDAO<Skill, Integer> {
    private EntityManager em;
    public SkillDAO(EntityManager em){
        this.em = em;
    }

    public void create(Skill entity){
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public List<Skill> retrieveAll(){
        return em.createQuery("SELECT t_sk FROM Skill t_sk",Skill.class).getResultList();
    }

    public Skill retrieve(Integer id){
        return em.find(Skill.class,id);
    }

    public void update(Skill entity){
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public void delete(Integer id){
        em.getTransaction().begin();
        Skill anEntity = retrieve(id);
        em.remove(anEntity);
        em.getTransaction().commit();
    }


}
