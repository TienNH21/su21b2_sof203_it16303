/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author tiennh
 */
public class DemoBorderlayout extends JFrame {
    public DemoBorderlayout() {
        BorderLayout layout = new BorderLayout();
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(layout);
        JButton btn1 = new JButton("Button Center");
        JButton btn2 = new JButton("Button PAGE_START");
        JButton btn3 = new JButton("Button LINE_START");
        JButton btn4 = new JButton("Button PAGE_END");
        JButton btn5 = new JButton("Button LINE_END");

        this.getContentPane().add(btn1, BorderLayout.CENTER);
        this.getContentPane().add(btn2, BorderLayout.PAGE_START);
        this.getContentPane().add(btn3, BorderLayout.LINE_START);
        this.getContentPane().add(btn4, BorderLayout.PAGE_END);
        this.getContentPane().add(btn5, BorderLayout.LINE_END);
    }

    public static void main(String args[]) {
        JFrame frame = new DemoBorderlayout();
        
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
