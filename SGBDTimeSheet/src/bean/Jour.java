/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;
import java.util.List;

public class Jour {
    private int idJour;
    private Date date;
    private List<Planning> listePlanning;

    public Jour(int idJour, Date date) {
        this.idJour = idJour;
        this.date = date;
    }

    public Jour() {
    }
    

    public int getIdJour() {
        return idJour;
    }

    public void setIdJour(int idJour) {
        this.idJour = idJour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Planning> getListePlanning() {
        return listePlanning;
    }

    public void setListePlanning(List<Planning> listePlanning) {
        this.listePlanning = listePlanning;
    }

    @Override
    public String toString() {
        return (String.valueOf(idJour));
    }
    
    
 
    
    
    
}
