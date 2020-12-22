/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {

    private static final String FICHIER_PROPERTIES = "dao/config.properties";
    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE = "motdepasse";
    private static final String PROPERT_PLAN_DAO = "planningdao";
    private static final String PROPERT_EMP_DAO = "employedao";
        private static final String PROPERT_PRO_DAO = "projetdao";

    private String url;
    private String driver;
    private String username;
    private String password;
    private String planDao;
    private String empDao;
    private String proDao;

    /* Pattern Singleton */
    private static DaoFactory uniqueInstance = new DaoFactory();

    public static DaoFactory getInstance() {
        return uniqueInstance;
    }

    private DaoFactory() throws DaoConfigurationException {
        Properties properties = new Properties();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);

        if (fichierProperties == null) {
            throw new DaoConfigurationException("Le fichier properties " + FICHIER_PROPERTIES + " est introuvable.");
        }

        try {
            properties.load(fichierProperties);
            url = properties.getProperty(PROPERTY_URL);
            driver = properties.getProperty(PROPERTY_DRIVER);
            username = properties.getProperty(PROPERTY_NOM_UTILISATEUR);
            password = properties.getProperty(PROPERTY_MOT_DE_PASSE);
            planDao = properties.getProperty(PROPERT_PLAN_DAO);
             empDao = properties.getProperty(PROPERT_EMP_DAO);
             proDao = properties.getProperty(PROPERT_PRO_DAO);

        } catch (IOException e) {
            throw new DaoConfigurationException("Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e);
        }

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new DaoConfigurationException("Le driver est introuvable", e);
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public PlanningDao getPlanningDao() {
        try {
            Class planDaoClass = Class.forName(planDao);
            Constructor[] constr = planDaoClass.getConstructors();
            return (PlanningDao)constr[0].newInstance(this);
        } catch (Exception e) {
            throw new DaoConfigurationException("problème d'injection avec la classe appareils", e);
        }
    }
    
    
      public EmployeDao getEmployeDao() {
        try {
            Class empDaoClass = Class.forName(empDao);
            Constructor[] constr = empDaoClass.getConstructors();
            return (EmployeDao)constr[0].newInstance(this);
        } catch (Exception e) {
            throw new DaoConfigurationException("problème d'injection avec la classe employé", e);
        }
    }
      
      
         public ProjetDao getProjetDao() {
        try {
            Class proDaoClass = Class.forName(proDao);
            Constructor[] constr = proDaoClass.getConstructors();
            return (ProjetDao)constr[0].newInstance(this);
        } catch (Exception e) {
            throw new DaoConfigurationException("problème d'injection avec la classe employé", e);
        }
    }

}
