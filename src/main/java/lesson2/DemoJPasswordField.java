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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author tiennh
 */
public class DemoJPasswordField extends JFrame {
    private JPasswordField pwd;
    private ImageIcon on, off;
    private JButton btnToggle;
    private boolean showPwd;

    public DemoJPasswordField() {
        this.showPwd = false;
        this.getContentPane().setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pwd = new JPasswordField();
        this.btnToggle = new JButton();
        this.on = new ImageIcon("src/main/java/lesson2/visibility_true.png");
        this.off = new ImageIcon("src/main/java/lesson2/visibility_false.png");
        
        this.btnToggle.setIcon(this.off);

        this.pwd.setEchoChar('^');
        this.pwd.setColumns(10);
        this.getContentPane().add(this.pwd);
        this.getContentPane().add(this.btnToggle);
        
        DemoJPasswordField that = this;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                that.showPwd = !that.showPwd;
                if (that.showPwd) {
                    that.btnToggle.setIcon(that.on);
                    that.pwd.setEchoChar((char)0);
                } else {
                    that.btnToggle.setIcon(that.off);
                    that.pwd.setEchoChar('^');
                }
            }
        };

        this.btnToggle.addActionListener(listener);
    }
    
    public static void main(String[] args) {
        DemoJPasswordField gui = new DemoJPasswordField();
        gui.setSize(400, 400);
        gui.setVisible(true);
    }
}
