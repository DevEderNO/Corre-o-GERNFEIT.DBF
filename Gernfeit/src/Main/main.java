/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import View.Home;
import View.Start;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Masterkaos
 */
public class main {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    javax.swing.UIManager um = new javax.swing.UIManager();
                    um.setLookAndFeel(um.getSystemLookAndFeelClassName());

                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                } finally {
                    Home telaPrincipal = new Home();
                    telaPrincipal.setLocationRelativeTo(null);
                    telaPrincipal.setVisible(true);

                }
            }
        });
    }
}
