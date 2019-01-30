/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.core;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import se.core.GameLaunch;
/**
 *
 * @author Pas
 */
public class MyFrame extends javax.swing.JFrame {

    /**
     * Creates new form MyFrame
     */
    public MyFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuNew = new javax.swing.JMenuItem();
        jMenuSave = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuExit = new javax.swing.JMenuItem();
        jMenuView = new javax.swing.JMenu();
        jMenuStats = new javax.swing.JMenuItem();
        jMenuPrefs = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuViewHelp = new javax.swing.JMenuItem();
        jMenuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cognition Package");
        setBounds(new java.awt.Rectangle(0, 0, 1920, 1080));
        setMinimumSize(new java.awt.Dimension(1940, 1100));
        setName("Cognition Package"); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMenuFile.setText("File");

        jMenuNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuNew.setText("New");
        jMenuNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNewActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuNew);

        jMenuSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuSave.setText("Save");
        jMenuFile.add(jMenuSave);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuItem1);

        jMenuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuExit.setText("Exit");
        jMenuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuExitActionPerformed(evt);
            }
        });
        jMenuFile.add(jMenuExit);

        jMenuBar1.add(jMenuFile);

        jMenuView.setText("View");

        jMenuStats.setText("Statistics");
        jMenuView.add(jMenuStats);

        jMenuPrefs.setText("Preferences");
        jMenuView.add(jMenuPrefs);

        jMenuBar1.add(jMenuView);

        jMenuHelp.setText("Help");

        jMenuViewHelp.setText("View Help");
        jMenuHelp.add(jMenuViewHelp);

        jMenuAbout.setText("About");
        jMenuHelp.add(jMenuAbout);

        jMenuBar1.add(jMenuHelp);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNewActionPerformed
        try {
            GameLaunch g = new GameLaunch();
            g.setBool(true);
            g.launch();
        } catch (JAXBException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println("IO e");
        } catch (Exception ex) {
            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuNewActionPerformed

    private void jMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuExitActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuAbout;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuExit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuNew;
    private javax.swing.JMenuItem jMenuPrefs;
    private javax.swing.JMenuItem jMenuSave;
    private javax.swing.JMenuItem jMenuStats;
    private javax.swing.JMenu jMenuView;
    private javax.swing.JMenuItem jMenuViewHelp;
    // End of variables declaration//GEN-END:variables
}
