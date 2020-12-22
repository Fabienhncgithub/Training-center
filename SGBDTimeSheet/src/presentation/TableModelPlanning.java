/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import bean.Planning;
import java.util.ArrayList;

/**
 *
 * @author Fabien
 */
public class TableModelPlanning extends javax.swing.table.AbstractTableModel {

    private String[] columnNames = {"Projet", "Heure", "Date","Employé","Ville"};
    private ArrayList<Planning> myList;

    public TableModelPlanning(ArrayList myList) {
        this.myList = myList;
    }

    @Override
    public int getRowCount() {
        return myList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        Planning myPlan = myList.get(row);
        switch (col) {
            case 0:
                return myPlan.getProjet().getNomProjet();
            case 1:
             return myPlan.getNbHeures();
            case 2:
             return myPlan.getJour().getDate();
            case 3:
             return myPlan.getEmployé().getNom();
            case 4:
                  return myPlan.getEmployé().getVille().getCommune();
        }
        return null;
    }

    @Override
    public Class getColumnClass(int c) {

        switch (c) {

            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
        }
        return null;
    }
}
