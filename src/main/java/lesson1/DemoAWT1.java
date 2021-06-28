/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson1;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tiennh
 */
public class DemoAWT1 extends Frame implements ActionListener {
    Button btnOngVang, btnOngDo, btnExit;
    Label lbl;

    public DemoAWT1(String title) {
        this.setTitle(title);
        this.setLayout(new FlowLayout());
        this.btnOngVang = new Button("Button ong vàng");
        this.btnOngDo = new Button("Button ong đỏ");
        this.btnExit = new Button("Exit");
        this.lbl = new Label("Hello Poly");
        
//        this.btnExit.
        this.btnOngVang.addActionListener(this);
        this.btnOngDo.addActionListener(this);
        this.btnExit.addActionListener(this);
        
        this.add(this.btnOngVang);
        this.add(this.btnOngDo);
        this.add(this.btnExit);
        this.add(this.lbl);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        System.out.println(cmd);
        if (cmd.equals("Button ong vàng")) {
            this.lbl.setText("Hello ong vàng!");
            this.setBackground(Color.yellow);
        } else if (cmd.equals("Button ong đỏ"))  {
            this.lbl.setText("Hello ong đỏ!");
            this.setBackground(Color.RED);
        } else {
            System.exit(0);
        }
    }
}
