/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMysql;

import bean.Ville;
import dao.DaoException;
import dao.DaoFactory;
import dao.DaoUtil;
import dao.VilleDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fabien
 */
public class VilleDaoMysql implements VilleDao{
    
    
           private  DaoFactory daoFactory;

    public VilleDaoMysql(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    
    private static final String SQL_SELECT_TOUS = "SELECT ville.idVille, ville.cp,ville.commune FROM ville ORDER BY 1";

    @Override
    public ArrayList<Ville> selectVilles() throws DaoException {
                Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;

        ArrayList<Ville> myList = new ArrayList();

        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[]) null);
            resu = prepStat.executeQuery();
            while (resu.next()) {

                myList.add(new Ville(resu.getInt(1), resu.getInt(2),resu.getString(3)));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
        return myList;
    }

    
}
