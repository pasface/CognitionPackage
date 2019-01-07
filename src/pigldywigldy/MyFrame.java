/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pigldywigldy;

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
        jMenuExit = new javax.swing.JMenuItem();
        jMenuView = new javax.swing.JMenu();
        jMenuStats = new javax.swing.JMenuItem();
        jMenuPrefs = new javax.swing.JMenuItem();
        jMenuHelp = new javax.swing.JMenu();
        jMenuViewHelp = new javax.swing.JMenuItem();
        jMenuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cognition Package");
        setBounds(new java.awt.Rectangle(0, 0, 1940, 1100));
        setMinimumSize(new java.awt.Dimension(1940, 1100));
        setName("Cognition Package"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1940, 1100));
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
        GameLaunch g = new GameLaunch();
        g.setB(true);
        g.launch();
    }//GEN-LAST:event_jMenuNewActionPerformed

    private void jMenuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuAbout;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuExit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenu jMenuHelp;
    private javax.swing.JMenuItem jMenuNew;
    private javax.swing.JMenuItem jMenuPrefs;
    private javax.swing.JMenuItem jMenuSave;
    private javax.swing.JMenuItem jMenuStats;
    private javax.swing.JMenu jMenuView;
    private javax.swing.JMenuItem jMenuViewHelp;
    // End of variables declaration//GEN-END:variables
}
