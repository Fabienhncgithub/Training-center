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
import java.util.ArrayList;

/**
 *
 * @author Fabien
 */
public class PlanningDaoMysql implements PlanningDao{
    
           private DaoFactory daoFactory;

    public PlanningDaoMysql(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    private static final String SQL_SELECT_TOUS = "SELECT employe.idEmployé, employe.nom,employe.prenom, employe.adresse, employe.email, employe.idVille,ville.idVille, ville.cp, ville.commune, planning.idPlanning, planning.nbHeures, jour.idJour, jour.date, projet.idProjet, projet.nom "
            + "FROM ville JOIN employe ON employe.idVille = ville.idVille "
            + "JOIN planning ON planning.idEmploye = employe.`idEmployé` "
            + "JOIN projet ON projet.idProjet = planning.idProjet "
            + "JOIN jour ON planning.idJour = jour.idJour";
    
    
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

                myList.add(new Planning(resu.getInt(10), resu.getInt(11),
                        new Employé(resu.getInt(1), resu.getString(2), resu.getString(3), resu.getString(4), resu.getString(5),
                        new Ville(resu.getInt(7), resu.getInt(8),resu.getString(9))),
                        new Jour(resu.getInt(12),resu.getDate(13)),
                        new Projet(resu.getInt(14),resu.getString(15))));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            DaoUtil.fermeturesSilencieuses(prepStat, conn);
        }
        return myList;
    }
}
