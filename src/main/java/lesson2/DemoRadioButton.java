/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author tiennh
 */
public class DemoRadioButton extends JFrame {
    private JRadioButton rdoCat, rdoDog;
    private ImageIcon iconCat, iconDog;
    
    public DemoRadioButton() {
        this.getContentPane().setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.rdoCat = new JRadioButton("Cat");
        this.rdoDog = new JRadioButton("Dog");
        
        this.iconCat = new ImageIcon("src/main/java/lesson2/cat.png");
        this.iconDog = new ImageIcon("src/main/java/lesson2/dog.png");

        ButtonGroup gr = new ButtonGroup();
        gr.add(rdoCat);
        gr.add(rdoDog);
        
        this.rdoCat.setSelected(true);
        this.rdoCat.setIcon(this.iconCat);
        
        this.getContentPane().add(this.rdoCat);
        this.getContentPane().add(this.rdoDog);
        this.addAction();
    }
    
    private void addAction() {
        DemoRadioButton that = this;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String clickedBtn = e.getActionCommand();
                if (clickedBtn.equals("Cat")) {
                    that.rdoCat.setIcon(that.iconCat);
                    that.rdoDog.setIcon(null);
                } else {
                    that.rdoDog.setIcon(that.iconDog);
                    that.rdoCat.setIcon(null);
                }
            }
        };

        this.rdoCat.addActionListener(listener);
        this.rdoDog.addActionListener(listener);
    }

    public static void main(String[] args) {
        DemoRadioButton gui = new DemoRadioButton();
        gui.setSize(400, 400);
        gui.setVisible(true);
    }
}
