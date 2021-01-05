/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMysql;

import bean.Jour;
import dao.DaoException;
import dao.DaoFactory;
import dao.DaoUtil;
import dao.JourDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author Fabien
 */
public class JourDaoMysql implements JourDao {

    private DaoFactory daoFactory;

    public JourDaoMysql(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    private static final String SQL_SELECT_TOUS = "SELECT jour.idJour, jour.date FROM jour ";

    private static final String SQL_INSERT_JOUR = "INSERT INTO jour (date) VALUE (?) ";

    private static final String SQL_RECUP_JOUR = " SELECT jour.idJour, jour.date FROM jour where jour.idJour = ? ";

    @Override
    public ArrayList<Jour> selectJours() throws DaoException {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;

        ArrayList<Jour> myList = new ArrayList();

        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[]) null);
            resu = prepStat.executeQuery();
            while (resu.next()) {
                myList.add(new Jour(resu.getInt(1), resu.getDate(2)));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
        return myList;
    }

    @Override
    public Jour creatJour(Date date) {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;

        Jour j = null;

        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[]) null);
            resu = prepStat.executeQuery();
            while (resu.next()) {
                if (date.toString().equals(resu.getDate("date").toString())) {
                    j = new Jour(resu.getInt("idJour"), resu.getDate("date"));
                }

            }
            if (j == null) {
                conn = daoFactory.getConnection();
                prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_INSERT_JOUR, true, new java.sql.Date(date.getTime()));
                prepStat.executeUpdate();
                resu = prepStat.getGeneratedKeys();
                resu.next();
                int idJour = resu.getInt(1);

                prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_RECUP_JOUR, false, idJour);
                resu = prepStat.executeQuery();

                if (resu.next()) {
                    j = new Jour(resu.getInt(1), resu.getDate(2));
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
        return j;
    }

}
