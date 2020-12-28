/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import bean.Employé;
import bean.Planning;
import java.util.ArrayList;

/**
 *
 * @author Fabien
 */
public class TableModelEmploye extends javax.swing.table.AbstractTableModel {

    private String[] columnNames = {"Nom", "Prenom", "Adresse", "Email", "Ville","Code postal"};
    private ArrayList<Employé> myList;

    public TableModelEmploye(ArrayList myList) {
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
        Employé myPlan = myList.get(row);
        switch (col) {
            case 0:
                return myPlan.getNom();
            case 1:
                return myPlan.getPrénom();
            case 2:
                return myPlan.getAdresse();
            case 3:
                return myPlan.getEmail();
            case 4:
                return myPlan.getVille().getCommune();
            case 5:
                return myPlan.getVille().getCp();
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
            case 5:
                return String.class;
        }
        return null;
    }
    
    
        public ArrayList<Employé> getMyList() {
        return myList;
    }

    public void setMyList(ArrayList<Employé> myList) {
        this.myList = myList;
        this.fireTableDataChanged();
    }
    
    
}
