/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel a1, a2;
    JTextField b1, b2;
    JButton c1, c2;

    Login() {

        getContentPane().setBackground(Color.WHITE);

        setLayout(null);
        setBounds(450, 250, 350, 240);
        a1 = new JLabel("Username");
        a1.setBounds(70, -5, 100, 100);
        a1.setForeground(Color.gray);
        add(a1);

        a2 = new JLabel("Password");
        a2.setBounds(70, 47, 100, 100);
        a2.setForeground(Color.gray);
        add(a2);

        b1 = new JTextField();
        b1.setBounds(200, 30, 120, 30);
        b1.setForeground(Color.PINK);
        add(b1);

        b2 = new JPasswordField();
        b2.setBounds(200, 80, 120, 30);
        b2.setForeground(Color.PINK);
        add(b2);

        c1 = new JButton("Login");
        c1.setBounds(80, 141, 90, 25);
        c1.setForeground(Color.PINK);
        c1.setBackground(Color.white);
        c1.addActionListener(this);
        add(c1);

        c2 = new JButton("Cancel");
        c2.setBounds(225, 141, 90, 25);
        c2.setForeground(Color.PINK);
        c2.setBackground(Color.white);
        c2.addActionListener(this);
        add(c2);

        ImageIcon pic = new ImageIcon(ClassLoader.getSystemResource("hms/icons/hmsic.png"));
        Image scaledpic = pic.getImage().getScaledInstance(375, 200, Image.SCALE_DEFAULT);
        ImageIcon spic = new ImageIcon(scaledpic);
        JLabel two = new JLabel(spic);
        two.setBounds(0, -30, 375, 250); // location and size with respect to the frame
        add(two);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == c1) {
            String user = b1.getText();
            String pass = b2.getText();

            try {
                Conn c = new Conn();
                String query = "select * from login where username='" + user + "' and password='" + pass + "'";

                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    
                    new Dashboard().setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == c2) {
            System.exit(0);
        }

       
    }

    public static void main(String[] args) {
        new Login();
    }

   
}


