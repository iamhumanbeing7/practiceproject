package com.java.dao;
import java.util.List;

public interface JPATestDAO {
    public void addJPATest(TblJpatestEntity JPATestEntity);
    public TblJpatestEntity getJPATest(int id);
    public void deleteJPATest(int id);
    public void updateJPATest(TblJpatestEntity JPATestEntity);
    public List<TblJpatestEntity> queryJPATest();
}
