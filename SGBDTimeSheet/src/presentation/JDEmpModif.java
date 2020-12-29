/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import bean.Employé;
import bean.Ville;
import dao.DaoException;
import dao.DaoFactory;
import dao.EmployeDao;
import dao.JourDao;
import dao.PlanningDao;
import dao.ProjetDao;
import dao.VilleDao;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabien
 */
public class JDEmpModif extends javax.swing.JDialog {

    private DaoFactory factory = DaoFactory.getInstance();
    private PlanningDao daoPlan = factory.getPlanningDao();
    private EmployeDao employeDao = factory.getEmployeDao();
    private ProjetDao projetDao = factory.getProjetDao();
    private JourDao jourDao = factory.getJourDao();
    private VilleDao villeDao = factory.getVilleDao();

    public JDEmpModif(java.awt.Frame parent, String titre, Employé employe) {
        super(parent, titre,true);
        initComponents();
        fillComponents(employe);
        //getRootPane().setDefaultButton(JButtonOk);
        getRootPane().setDefaultButton(Ok);
        setLocation(parent.getX() + parent.getWidth() / 3, parent.getY() + parent.getHeight() / 3);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Ok = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldPrenom = new javax.swing.JTextField();
        jTextFieldAdresse = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jComboBoxVille = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nom");

        jLabel2.setText("Email");

        jLabel3.setText("Prenom");

        jLabel4.setText("Adresse");

        jLabel5.setText("Ville");

        Ok.setText("Ok\n");
        Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkActionPerformed(evt);
            }
        });

        jButtonAnnuler.setText("Annuler\n");
        jButtonAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnnulerActionPerformed(evt);
            }
        });

        jTextFieldNom.setText("\n\n");
        jTextFieldNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNomKeyTyped(evt);
            }
        });

        jTextFieldPrenom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPrenomKeyTyped(evt);
            }
        });

        jTextFieldAdresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAdresseActionPerformed(evt);
            }
        });
        jTextFieldAdresse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAdresseKeyTyped(evt);
            }
        });

        jComboBoxVille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxVilleActionPerformed(evt);
            }
        });

        jLabel6.setText("ID");

        jTextFieldID.setText("\n\n");
        jTextFieldID.setEnabled(false);
        jTextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(Ok)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAnnuler))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6))
                                .addGap(172, 172, 172)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldPrenom)
                                    .addComponent(jTextFieldAdresse)
                                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBoxVille, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldID)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(218, 218, 218)
                                .addComponent(jTextFieldNom, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxVille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ok)
                    .addComponent(jButtonAnnuler))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkActionPerformed
        Employé employe = new Employé();
        employe.setIdEmployé(Integer.parseInt(jTextFieldID.getText()));
        employe.setNom(jTextFieldNom.getText());
        employe.setPrénom(jTextFieldPrenom.getText());
        employe.setAdresse(jTextFieldAdresse.getText());
        employe.setEmail(jTextFieldEmail.getText());
        employe.setVille((Ville) jComboBoxVille.getSelectedItem());

        try {
            employeDao.updateEmploye(employe);
        } catch (DaoException e) {
            JOptionPane.showMessageDialog(null, "Insertion impossible ! ", "Avertissement", JOptionPane.ERROR_MESSAGE);
        }

        this.dispose();

    }//GEN-LAST:event_OkActionPerformed

    private void jButtonAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonAnnulerActionPerformed

    private void jTextFieldAdresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAdresseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAdresseActionPerformed

    private void jComboBoxVilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxVilleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxVilleActionPerformed

    private void jTextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDActionPerformed

    private void jTextFieldNomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomKeyTyped
            char c = evt.getKeyChar();
            if (!Character.isLetter(c)) {
                evt.consume();
        }        

    }//GEN-LAST:event_jTextFieldNomKeyTyped

    private void jTextFieldPrenomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPrenomKeyTyped
                   char c = evt.getKeyChar();
            if (!Character.isLetter(c)) {
                evt.consume();
        }  
    }//GEN-LAST:event_jTextFieldPrenomKeyTyped

    private void jTextFieldAdresseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAdresseKeyTyped
                  char c = evt.getKeyChar();
            if (!Character.isLetter(c)) {
                evt.consume();
        }  
    }//GEN-LAST:event_jTextFieldAdresseKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ok;
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JComboBox jComboBoxVille;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextFieldAdresse;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldPrenom;
    // End of variables declaration//GEN-END:variables

    private void fillComponents(Employé employe) {
        jTextFieldID.setText(String.valueOf((employe.getIdEmployé())));
        jTextFieldNom.setText(employe.getNom());
        jTextFieldPrenom.setText(employe.getPrénom());
        jTextFieldAdresse.setText(employe.getAdresse());
        jTextFieldEmail.setText(employe.getEmail());

        
        int numVille = employe.getVille().getIdVille();
        ArrayList<Ville> ville = villeDao.selectVilles();
        for (int i = 0; i < ville.size(); i++) {
            jComboBoxVille.addItem(ville.get(i));
            if (ville.get(i).getIdVille() == numVille) {
                jComboBoxVille.setSelectedIndex(i);
            }
        }
    }
}
