/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author tiennh
 */
public class DemoGridLayout extends JFrame {
    public DemoGridLayout() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        GridLayout layout = new GridLayout(3, 5);
        this.getContentPane().setLayout(layout);
        
        for (int i = 0; i < 9; i++) {
            JButton btn = new JButton(i + 1 + "");
            this.getContentPane().add(btn);
        }

        JButton btnCong = new JButton("+");
        JButton btnTru = new JButton("-");
        JButton btnNhan = new JButton("*");
        JButton btnChia = new JButton("/");
        JButton btnTinh = new JButton("=");
        JButton btnClear = new JButton("C");

        this.getContentPane().add(btnCong);
        this.getContentPane().add(btnTru);
        this.getContentPane().add(btnNhan);
        this.getContentPane().add(btnChia);
        this.getContentPane().add(btnTinh);
        this.getContentPane().add(btnClear);
    }

    public static void main(String args[]) {
        JFrame frame = new DemoGridLayout();
        
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
