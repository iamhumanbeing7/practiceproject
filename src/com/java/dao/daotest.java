package com.java.dao;

//import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class daotest {
    public static void main(String[] args) throws SQLException {
        JPATestDAOFactory jpaTestDAOFactory = new JPATestDAOFactory();
        JPATestDAO testDAO = jpaTestDAOFactory.createJPATestDAO();
        TblJpatestEntity jpatestEntity = new TblJpatestEntity();
        int ranNum = new Random().nextInt(1000);
        jpatestEntity.setName("Test");
        jpatestEntity.setRamount(ranNum);
        jpatestEntity.setRdate(LocalDate.now());
        testDAO.addJPATest(jpatestEntity);
        List<TblJpatestEntity> jpatestEntityResultList = testDAO.queryJPATest();
        int i=0;
        for(TblJpatestEntity result : jpatestEntityResultList){
            System.out.println("DAO retrieve: " + result.getId() + "," + result.getName() + "," + result.getRamount() + "," + result.getRdate());
        }
    }
//    public void JDBCTester() throws SQLException{
//        Connection con = null;
//        Statement stmt = null;
//        try {
//            String connString="jdbc:oracle:thin:@sscda:1521:ORADBDEV";
//            OracleDataSource ods = new OracleDataSource();
//            ods.setURL(connString);
//            ods.setUser("scott");
//            ods.setPassword("tiger");
//            con = DriverManager.getConnection(
//                    "jdbc:myDriver:myDatabase",
//                    "APPTESTDBA",
//                    "Passw0rd1");
//            stmt = con.createStatement();
//            stmt.execute("INSERT INTO \"APPTESTDBA\".\"TBL_JPATEST\" (ID, NAME, RDATE, RAMOUNT) VALUES ('1', 'Test Manual Insert', TO_DATE('2018-07-18 14:32:00', 'YYYY-MM-DD HH24:MI:SS'), '200')\n");
//        } catch (SQLException sqlexception){
//
//        } finally {
//            if(stmt != null) stmt.close();
//            if(con != null) con.close();
//        }
//    }
}
