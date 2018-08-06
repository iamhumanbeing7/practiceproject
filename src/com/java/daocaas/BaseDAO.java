package com.java.daocaas;

import java.util.List;

public interface BaseDAO<E, K> {
    public void create(E entity);
    public List<E> retrieveAll();
    public E retrieve(K id);
    public void update(E entity);
    public void delete(K id);
}
