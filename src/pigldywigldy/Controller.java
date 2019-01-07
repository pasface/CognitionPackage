package pigldywigldy;

import java.util.TimerTask;
import java.util.Timer;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nikki
 */
public class Controller {
    private int countSearch = 0, countPeek = 0, total = 0;
    private static final int PEEK = 10, SEARCH = 100, PEEKDURATION = 4000;
    private static final GameGUI gui = new GameGUI();
    private String username;
    
    public void reset(){
        countSearch = 0;
        countPeek = 0;
        total = 0;
        username = null;
        gui.getLblPeek().setText(countPeek+"");
        gui.getLblSearch().setText(countSearch+"");
        gui.getLblTotal().setText(total+"");
        gui.getJlblWelcome().setText("Welcome!");
        gui.getBtnSubmit().setVisible(true);
        gui.getJtfUsername().setText("");
        gui.getJtfUsername().setVisible(true);
        gui.getJlblWarning().setVisible(true);
        gui.getJpMain().setVisible(false);
        gui.getJpUpper().setVisible(true);
        gui.getBtnPeek().setVisible(true);
        gui.getBtnSearch().setVisible(true);
        gui.getJlblWarning().setText(null);
        gui.getJlblIcon().setIcon(new javax.swing.ImageIcon(getClass().getResource("office.jpg")));
        gui.getJlblIcon().setVisible(true);
    }
    
    public void search(){
        total+=SEARCH;
        countSearch+=1;
        gui.getLblTotal().setText(total+"");
        gui.getLblSearch().setText(countSearch+"");
        gui.getBtnPeek().setVisible(false);
        gui.getBtnSearch().setVisible(false);
        gui.getJlblIcon().setIcon(new javax.swing.ImageIcon(getClass().getResource("office3.jpg")));
    }
    
    public void peek(){
        this.total+=PEEK;
        this.countPeek+=1;
        gui.getLblTotal().setText(total+"");
        gui.getLblPeek().setText(countPeek+"");
        gui.getJlblIcon().setIcon(new javax.swing.ImageIcon(getClass().getResource("office2.jpg")));
        peekTimer();
    }
    
    public void startGame(){
        String input_name = gui.getJtfUsername().getText();
        try {
            if (!input_name.isEmpty()){
                String first_letter = input_name.substring(0,1).toUpperCase();
                input_name = first_letter + input_name.substring(1);
                username = input_name;
                gui.getBtnSubmit().setVisible(false);
                gui.getJtfUsername().setVisible(false);
                gui.getJlblWarning().setVisible(false);
                gui.getJpMain().setVisible(true);
                gui.getJpUpper().setVisible(false);
                gui.getJlblIcon().setIcon(new javax.swing.ImageIcon(getClass().getResource("office.jpg")));
            } else {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            gui.getJlblWarning().setText("Please enter your name in the field provided.");
        }
    }
    
    public void peekTimer(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        @Override
        public void run() {
            gui.getJlblIcon().setIcon(new javax.swing.ImageIcon(getClass().getResource("office.jpg")));
            //gui.getJlblIcon().setVisible(true);
        }
        }, PEEKDURATION);
    }

    public void setCountSearch(int countSearch) {
        this.countSearch = countSearch;
    }

    public void setCountPeek(int countPeek) {
        this.countPeek += countPeek;
        System.out.println("Count Peek value: " + this.countPeek);
    }

    public void setTotal(int total) {
        this.total += total;
        System.out.println("Total value: " + this.total);
    }

    public int getCountSearch() {
        return countSearch;
    }

    public int getCountPeek() {
        return countPeek;
    }

    public int getTotal() {
        return total;
    }
    
//    public static void main(String[] args) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GameGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            
//            @Override
//            public void run() {
//                gui.setVisible(true);
//            }
//        });
//    }
    
}
