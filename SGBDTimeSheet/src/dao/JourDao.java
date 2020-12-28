/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Jour;
import java.util.ArrayList;

/**
 *
 * @author Fabien
 */
public interface JourDao {
      public  ArrayList<Jour> selectJours() throws DaoException;
}
