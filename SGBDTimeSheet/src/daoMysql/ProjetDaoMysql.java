/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMysql;

import bean.Projet;
import dao.DaoException;
import dao.DaoFactory;
import dao.DaoUtil;
import dao.ProjetDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fabien
 */
public class ProjetDaoMysql implements ProjetDao{
    
       private  DaoFactory daoFactory;

    public ProjetDaoMysql(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    
    private static final String SQL_SELECT_TOUS = "SELECT projet.idProjet, projet.nom FROM projet ORDER BY 1";
    
    


    @Override
    public ArrayList<Projet> selectProjets() throws DaoException {
               Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;

        ArrayList<Projet> myList = new ArrayList();

        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[]) null);
            resu = prepStat.executeQuery();
            while (resu.next()) {

                myList.add(new Projet(resu.getInt(1), resu.getString(2)));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
        return myList;
    }
    
    
}
