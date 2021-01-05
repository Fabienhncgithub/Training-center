/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;

public class Employé {

    private int idEmployé;
    private String nom;
    private String prénom;
    private String adresse;
    private String email;
    private List<Planning> listePlanning;
    private Ville ville;

    public Employé(int idEmployé, String nom, String prénom, String adresse, String email, Ville ville) {
        this.idEmployé = idEmployé;
        this.nom = nom;
        this.prénom = prénom;
        this.adresse = adresse;
        this.email = email;
        this.ville = ville;
    }

    public Employé(int idEmployé, String nom) {
        this.idEmployé = idEmployé;
        this.nom = nom;
    }

    public Employé() {
    }
    
    

    public int getIdEmployé() {
        return idEmployé;
    }
    
    
    

    public void setIdEmployé(int idEmployé) {
        this.idEmployé = idEmployé;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrénom() {
        return prénom;
    }

    public void setPrénom(String prénom) {
        this.prénom = prénom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return nom;
    }

 

    
   

    
}
