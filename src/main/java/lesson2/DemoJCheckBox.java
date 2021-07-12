/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

/**
 *
 * @author tiennh
 */
public class DemoJCheckBox extends JFrame {
    private JCheckBox ckbC, ckbCs, ckbPhp, ckbJava;
    private ImageIcon checkedIcon, uncheckedIcon;

    public DemoJCheckBox() {
        this.getContentPane().setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.ckbC = new JCheckBox("C/C++");
        this.ckbCs = new JCheckBox("Cs");
        this.ckbPhp = new JCheckBox("Php");
        this.ckbJava = new JCheckBox("Java");
        
        this.checkedIcon = new ImageIcon("src/main/java/lesson2/java.png");
        this.uncheckedIcon = new ImageIcon("src/main/java/lesson2/java_disable.png");
        
        this.ckbJava.setIcon(this.uncheckedIcon);

        this.getContentPane().add(this.ckbC);
        this.getContentPane().add(this.ckbCs);
        this.getContentPane().add(this.ckbPhp);
        this.getContentPane().add(this.ckbJava);
        
        DemoJCheckBox that = this;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isChecked = that.ckbJava.isSelected();
                if (isChecked) {
                    that.ckbJava.setIcon(that.checkedIcon);
                } else {
                    that.ckbJava.setIcon(that.uncheckedIcon);
                }
            }
        };

        this.ckbJava.addActionListener(listener);
    }
    
    public static void main(String[] args) {
        DemoJCheckBox gui = new DemoJCheckBox();
        gui.setSize(400, 400);
        gui.setVisible(true);
    }
}
