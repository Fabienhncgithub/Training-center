/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

public class Planning {
    private String idPlanning;
    private int nbHeures;
    private Employé employé;
    private Jour jour;
    private Projet projet;

    public Planning(String idPlanning, int nbHeures, Employé employé, Jour jour, Projet projet) {
        this.idPlanning = idPlanning;
        this.nbHeures = nbHeures;
        this.employé = employé;
        this.jour = jour;
        this.projet = projet;
    }

    public Planning() {
    }

    public String getIdPlanning() {
        return idPlanning;
    }

    public void setIdPlanning(String idPlanning) {
        this.idPlanning = idPlanning;
    }

    public int getNbHeures() {
        return nbHeures;
    }

    public void setNbHeures(int nbHeures) {
        this.nbHeures = nbHeures;
    }

    public Employé getEmployé() {
        return employé;
    }

    public void setEmployé(Employé employé) {
        this.employé = employé;
    }

    public Jour getJour() {
        return jour;
    }

    public void setJour(Jour jour) {
        this.jour = jour;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
    
    
    
}

