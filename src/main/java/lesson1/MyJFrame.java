/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson1;

import javax.swing.JFrame;

/**
 *
 * @author tiennh
 */
public class MyJFrame extends JFrame {
    public MyJFrame(String title) {
        this.setTitle(title);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
