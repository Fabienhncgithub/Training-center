/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;

public class Projet {
    private int idProjet;
    private String nomProjet;
    private List<Planning> listePlanning;

    public Projet(int idProjet, String nomProjet) {
        this.idProjet = idProjet;
        this.nomProjet = nomProjet;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public List<Planning> getListePlanning() {
        return listePlanning;
    }

    public void setListePlanning(List<Planning> listePlanning) {
        this.listePlanning = listePlanning;
    }

    @Override
    public String toString() {
        return nomProjet;
    }
    
    
    
}




