/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Projet;
import java.util.ArrayList;

/**
 *
 * @author Fabien
 */
public interface ProjetDao {
    public  ArrayList<Projet> selectProjets() throws DaoException;
}
