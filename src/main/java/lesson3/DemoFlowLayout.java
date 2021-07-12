/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson3;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author tiennh
 */
public class DemoFlowLayout extends JFrame {
    private JButton[] listBtn;
    public DemoFlowLayout() {
        this.listBtn = new JButton[10];
        
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.RIGHT);
        
        this.getContentPane().setLayout(layout);
        
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton("Button " + i);
            this.listBtn[i] = btn;
            this.getContentPane().add(btn);
        }
    }

    public static void main(String args[]) {
        JFrame frame = new DemoFlowLayout();
        
        frame.setSize(250, 500);
        frame.setVisible(true);
    }
}
