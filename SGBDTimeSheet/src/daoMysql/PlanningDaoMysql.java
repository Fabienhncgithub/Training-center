/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daoMysql;

import bean.Planning;
import dao.PlanningDao;
import bean.Employé;
import bean.Jour;
import bean.Projet;
import bean.Ville;
import dao.DaoException;
import dao.DaoFactory;
import dao.DaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Fabien
 */
public class PlanningDaoMysql implements PlanningDao {

    private DaoFactory daoFactory;

    public PlanningDaoMysql(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    private static final String SQL_SELECT_TOUS = "SELECT employe.idEmployé, employe.nom,employe.prenom, employe.adresse, employe.email, employe.idVille,ville.idVille, ville.cp, ville.commune, planning.idPlanning, planning.nbHeures, jour.idJour, jour.date, projet.idProjet, projet.nom "
            + "FROM ville JOIN employe ON employe.idVille = ville.idVille "
            + "JOIN planning ON planning.idEmploye = employe.`idEmployé` "
            + "JOIN projet ON projet.idProjet = planning.idProjet "
            + "JOIN jour ON planning.idJour = jour.idJour order by 1";

    private static final String SQL_SELECT_PAR_EMP = " SELECT employe.idEmployé, employe.nom,employe.prenom, employe.adresse, employe.email, employe.idVille,ville.idVille, ville.cp, ville.commune, planning.idPlanning, planning.nbHeures, jour.idJour, jour.date, projet.idProjet, projet.nom "
            + " FROM ville JOIN employe ON employe.idVille = ville.idVille "
            + " JOIN planning ON planning.idEmploye = employe.`idEmployé` "
            + " JOIN projet ON projet.idProjet = planning.idProjet "
            + " JOIN jour ON planning.idJour = jour.idJour and employe.nom LIKE ? order by 1 ";

    private static final String SQL_SELECT_PAR_PRO = "SELECT employe.idEmployé, employe.nom,employe.prenom, employe.adresse, employe.email, employe.idVille,ville.idVille, ville.cp, ville.commune, planning.idPlanning, planning.nbHeures, jour.idJour, jour.date, projet.idProjet, projet.nom "
            + " FROM ville JOIN employe ON employe.idVille = ville.idVille "
            + " JOIN planning ON planning.idEmploye = employe.`idEmployé` "
            + " JOIN projet ON projet.idProjet = planning.idProjet "
            + " JOIN jour ON planning.idJour = jour.idJour and projet.`idProjet` = ? order by 1";

    private static final String SQL_INSERT = "INSERT into planning ( idEmploye,idProjet, idJour,nbHeures) values (?, ?, ?, ?)";

    private static final String SQL_DELETE = "delete from planning where idPlanning = ?";

    private static final String SQL_UPDATE = "Update planning set idEmploye = ?, idProjet = ?, idJour = ?, nbHeures = ? WHERE idPlanning = ?";

    private static final String SQL_DATE = "SELECT employe.idEmployé, employe.nom,employe.prenom, employe.adresse, employe.email, employe.idVille,ville.idVille, ville.cp, ville.commune, planning.idPlanning, planning.nbHeures, jour.idJour, jour.date, projet.idProjet, projet.nom FROM ville JOIN employe ON employe.idVille = ville.idVille JOIN planning ON planning.idEmploye = employe.`idEmployé` JOIN projet ON projet.idProjet = planning.idProjet JOIN jour ON planning.idJour = jour.idJour WHERE jour.date >= ? AND jour.date <= ? ";

    private static final String SQL_VERIF = "SELECT employe.idEmployé, employe.nom,employe.prenom, employe.adresse, employe.email, employe.idVille,ville.idVille, ville.cp, ville.commune, planning.idPlanning, planning.nbHeures, jour.idJour, jour.date, projet.idProjet, projet.nom FROM ville JOIN employe ON employe.idVille = ville.idVille JOIN planning ON planning.idEmploye = employe.`idEmployé` JOIN projet ON projet.idProjet = planning.idProjet JOIN jour ON planning.idJour = jour.idJour WHERE planning.nbHeures<=10 GROUP BY 1";
    
    
    @Override
    public ArrayList<Planning> selectPlanning() throws DaoException {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;

        ArrayList<Planning> myList = new ArrayList();

        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[]) null);
            resu = prepStat.executeQuery();
            while (resu.next()) {

                myList.add(new Planning(resu.getString(10), resu.getInt(11),
                        new Employé(resu.getInt(1), resu.getString(2), resu.getString(3), resu.getString(4), resu.getString(5),
                                new Ville(resu.getInt(7), resu.getInt(8), resu.getString(9))),
                        new Jour(resu.getInt(12), resu.getDate(13)),
                        new Projet(resu.getInt(14), resu.getString(15))));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
        return myList;
    }

    @Override
    public ArrayList<Planning> selectPlanningParEmp(String nom) throws DaoException {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;

        ArrayList<Planning> myList = new ArrayList();

        try {
            conn = daoFactory.getConnection();

            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_PAR_EMP, false, (Object[]) null);
            prepStat.setString(1, "%" + nom + "%");
            resu = prepStat.executeQuery();
            while (resu.next()) {

                myList.add(new Planning(resu.getString(10), resu.getInt(11),
                        new Employé(resu.getInt(1), resu.getString(2), resu.getString(3), resu.getString(4), resu.getString(5),
                                new Ville(resu.getInt(7), resu.getInt(8), resu.getString(9))),
                        new Jour(resu.getInt(12), resu.getDate(13)),
                        new Projet(resu.getInt(14), resu.getString(15))));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
        return myList;
    }

    @Override
    public ArrayList<Planning> selectPlanningParProj(int pro) throws DaoException {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;

        ArrayList<Planning> myList = new ArrayList();

        try {
            conn = daoFactory.getConnection();
            if (pro == -1) {
                prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_TOUS, false, (Object[]) null);
            } else {
                prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_SELECT_PAR_PRO, false, pro);
            }
            resu = prepStat.executeQuery();
            while (resu.next()) {

                myList.add(new Planning(resu.getString(10), resu.getInt(11),
                        new Employé(resu.getInt(1), resu.getString(2), resu.getString(3), resu.getString(4), resu.getString(5),
                                new Ville(resu.getInt(7), resu.getInt(8), resu.getString(9))),
                        new Jour(resu.getInt(12), resu.getDate(13)),
                        new Projet(resu.getInt(14), resu.getString(15))));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
        return myList;
    }

    @Override
    public void insertPlan(Planning planning) {
        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            conn = daoFactory.getConnection();

            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_INSERT, false, planning.getEmployé().getIdEmployé(), planning.getProjet().getIdProjet(), planning.getJour().getIdJour(), planning.getNbHeures());

            prepStat.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }

    }

    @Override
    public void deletePlanning(String ident) {
        System.out.println(ident);
        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            conn = daoFactory.getConnection();

            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_DELETE, false, ident);
            prepStat.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
    }

    @Override
    public void updatePlanning(Planning planning) throws DaoException {
        {
            Connection conn = null;
            PreparedStatement prepStat = null;

            try {
                /* Récupération d'une connexion depuis la Factory */
                conn = daoFactory.getConnection();

                prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_UPDATE, false,
                        planning.getEmployé().getIdEmployé(),
                        planning.getProjet().getIdProjet(),
                        planning.getJour().getIdJour(),
                        planning.getNbHeures(),
                        planning.getIdPlanning());
                prepStat.executeUpdate();
            } catch (SQLException e) {
                throw new DaoException(e);
            } finally {
                DaoUtil.fermeturesSilencieuses(prepStat, conn);
            }
        }

    }

    @Override
    public ArrayList<Planning> selectPlanningDate(Date dateMin, Date dateMax) {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resu = null;

        ArrayList<Planning> myList = new ArrayList();

        try {
            conn = daoFactory.getConnection();
            prepStat = DaoUtil.initialisationRequetePreparee(conn, SQL_DATE, false, (Object[]) null);
            prepStat.setDate(1, new java.sql.Date(dateMin.getTime()));
            prepStat.setDate(2, new java.sql.Date(dateMax.getTime()));
            resu = prepStat.executeQuery();
            while (resu.next()) {

                myList.add(new Planning(resu.getString(10), resu.getInt(11),
                        new Employé(resu.getInt(1), resu.getString(2), resu.getString(3), resu.getString(4), resu.getString(5),
                                new Ville(resu.getInt(7), resu.getInt(8), resu.getString(9))),
                        new Jour(resu.getInt(12), resu.getDate(13)),
                        new Projet(resu.getInt(14), resu.getString(15))));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
        return myList;

    }
}
