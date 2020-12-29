/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMysql;

import bean.Employé;
import bean.Ville;
import dao.DaoException;
import dao.DaoFactory;
import dao.DaoUtil;
import dao.EmployeDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fabien
 */
public class EmployeDaoMysql implements EmployeDao {

    private DaoFactory daoFactory;

    public EmployeDaoMysql(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    private static final String SQL_SELECT_TOUS = "SELECT employe.idEmployé, employe.nom,employe.prenom, employe.adresse, employe.email, employe.idVille,ville.idVille, ville.cp, ville.commune from ville join employe where employe.idVille = ville.idVille order by 1";

    private static final String SQL_INSERT = "INSERT into employe ( nom,prenom,adresse ,email,idVille) values (?, ?, ?, ?,?)";

    private static final String SQL_DELETE = "delete from employe where idEmployé = ?";

    private static final String SQL_UPDATE = "Update employe set nom = ?, prenom = ?, adresse = ?, email = ?, idVille = ? where idEmployé = ?";

    public ArrayList selectEmployes() throws DaoException {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;

        ArrayList<Employé> myList = new ArrayList();

        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[]) null);
            resu = prepStat.executeQuery();
            while (resu.next()) {

                myList.add(new Employé(resu.getInt(1), resu.getString(2), resu.getString(3), resu.getString(4), resu.getString(5),
                        new Ville(resu.getInt(6), resu.getInt(7), resu.getString(8))));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
        return myList;
    }

    @Override
    public void insertEmp(Employé employe) {
        System.out.println(employe);
        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            conn = daoFactory.getConnection();

            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_INSERT, false, employe.getNom(), employe.getPrénom(), employe.getAdresse(), employe.getEmail(), employe.getVille().getIdVille());

            prepStat.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }

    }

    @Override
    public void deleteEmploye(int idEmployé) throws DaoException {
        {
            System.out.println(idEmployé);
            Connection conn = null;
            PreparedStatement prepStat = null;

            try {
                /* Récupération d'une connexion depuis la Factory */
                conn = daoFactory.getConnection();
                prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_DELETE, false, idEmployé);
                prepStat.executeUpdate();
            } catch (SQLException e) {
                throw new DaoException(e);
            } finally {
                DaoUtil.fermeturesSilencieuses(prepStat, conn);
            }

        }
    }

    @Override
    public void updateEmploye(Employé employe) {

        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            conn = daoFactory.getConnection();

            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_UPDATE, false,
            employe.getNom(),
            employe.getPrénom(),
            employe.getAdresse(),
            employe.getEmail(),
            employe.getVille().getIdVille(),
            employe.getIdEmployé());
                prepStat.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
    }

}
