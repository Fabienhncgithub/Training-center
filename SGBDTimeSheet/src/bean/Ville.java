package bean;

import java.util.List;

public class Ville {
    private int idVille;
    private int cp;
    private String commune;
    List<Employé>listeEmploye;

    public Ville(int idVille, int cp, String commune) {
        this.idVille = idVille;
        this.cp = cp;
        this.commune = commune;
    }

    public Ville(int cp, String commune) {
        this.cp = cp;
        this.commune = commune;
    }
    
    
    

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public List<Employé> getListeEmploye() {
        return listeEmploye;
    }

    public void setListeEmploye(List<Employé> listeEmploye) {
        this.listeEmploye = listeEmploye;
    }
    
    
    
    
        @Override
    public String toString() {
        return commune;
    }
    
    

}
