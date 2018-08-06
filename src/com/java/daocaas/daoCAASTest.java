package com.java.daocaas;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import com.java.daocaas.*;
import com.java.entity.*;

public class daoCAASTest {
    public static void main(String[] args) throws SQLException {
        DAOFactory caasDAOFactory = new DAOFactory();
        OffcrProfileDAO opDAO = caasDAOFactory.getOffcrProfileDAO();
        OffcrProfile opEntity = opDAO.retrieve("willy_lee@caas.gov.sg");
        System.out.println("OffcrProfile retrieved: " + opEntity.getOffcrId() +"");
        for(Skill aOffcrSkill : opEntity.getSkills()){
            System.out.println("aOffcrSkill: " + aOffcrSkill.getSkillId() + "," + aOffcrSkill.getSkillcategory() + "," + aOffcrSkill.getSkill());
        }
    }
}
