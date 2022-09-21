/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author lavan
 */
public class Hms extends JFrame implements ActionListener {

    Hms() {

        setBounds(500, 250, 900, 450); // location and size with respect to screen

        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("hms/icons/hotel.jpg"));
        JLabel l1 = new JLabel(il);
        l1.setBounds(500, 450, 900, 450); // location and size with respect to the frame
        add(l1);

        JLabel l2 = new JLabel("Hotel Management System");
        l2.setBounds(225, 350, 500, 60);
        l1.add(l2);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("serif", Font.BOLD, 35));

        JButton l3 = new JButton("Next ");
        l3.setBackground(Color.white);
        l3.setForeground(Color.PINK);
        l3.setFont(new Font("serif", Font.BOLD, 20));
        l3.setBounds(750, 350, 80, 30);
        l3.addActionListener(this);
        l1.add(l3);

        setVisible(true);

        while (true) {
            l2.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            l2.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        Hms hms = new Hms();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Login();
        this.setVisible(false);
    }
}
