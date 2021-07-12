/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author tiennh
 */
public class DemoDialog extends JFrame {
    private JButton btnMessage, btnConfirm, btnInput, btnFile;
    private JFileChooser fChooser;

    public DemoDialog() {
        this.getContentPane().setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.btnFile = new JButton("File");
        this.btnMessage = new JButton("Message");
        this.btnConfirm = new JButton("Confirm");
        this.btnInput = new JButton("Input");
        
        this.fChooser = new JFileChooser();

        DemoDialog that = this;
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cmd = e.getActionCommand();
                if (cmd.equals("Message")) {
                    JOptionPane.showMessageDialog(that, "Message Dialog");
                } else if (cmd.equals("Confirm")) {
                    JOptionPane.showConfirmDialog(that, "Bạn có người yêu chưa", "Confirm", JOptionPane.YES_NO_OPTION);
                } else if (cmd.equals("Input")) {
                    String name = JOptionPane.showInputDialog(that, "Vui lòng nhập tên");
                    JOptionPane.showMessageDialog(that, "Tên đã nhập: " + name);
                } else {
                    int returnValue = that.fChooser.showOpenDialog(that);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File f = that.fChooser.getSelectedFile();
                        JOptionPane.showMessageDialog(that, "Tên file: " + f.getName());
                    }
                }
            }
            
        };
        
        this.btnMessage.addActionListener(listener);
        this.btnConfirm.addActionListener(listener);
        this.btnInput.addActionListener(listener);
        this.btnFile.addActionListener(listener);
        
        this.getContentPane().add(this.btnMessage);
        this.getContentPane().add(this.btnConfirm);
        this.getContentPane().add(this.btnInput);
        this.getContentPane().add(this.btnFile);
    }
    
    public static void main(String[] args) {
        DemoDialog gui = new DemoDialog();
        gui.setSize(400, 400);
        gui.setVisible(true);
    }
}
