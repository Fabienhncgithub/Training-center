/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Planning;
import java.util.ArrayList;

/**
 *
 * @author Fabien
 */
public interface PlanningDao {
    
        
 public  ArrayList<Planning> selectPlanning() throws DaoException;
 
 public ArrayList<Planning> selectPlanningParEmp(String nom) throws DaoException;
 
 public ArrayList<Planning> selectPlanningParProj(int proj) throws DaoException;

    public void insertPlan(Planning planning);
    
}
