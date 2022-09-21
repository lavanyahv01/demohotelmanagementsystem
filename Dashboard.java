/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

/**
 *
 * @author bunny
 */
public class Dashboard extends JFrame implements ActionListener{

    Dashboard() {
        setBounds(200, 15, 1550, 1000);

        setLayout(null);
        ImageIcon pic1 = new ImageIcon(ClassLoader.getSystemResource("hms/icons/htm2.jpg"));
        Image scaledpic = pic1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon spic = new ImageIcon(scaledpic);
        JLabel two = new JLabel(spic);
        two.setBounds(0, 0, 1550, 1000);
        add(two);

        JLabel welcome = new JLabel("Welcome to Celine Towers !");
        welcome.setBounds(125, 100, 500, 60);
        welcome.setForeground(Color.BLACK);
        welcome.setFont(new Font("serif", Font.BOLD, 35));
        two.add(welcome);
        
        JMenuBar menu1 = new JMenuBar();
        menu1.setForeground(Color.CYAN);
        menu1.setBackground(Color.LIGHT_GRAY);
        menu1.setBounds(0,0,1550,30);
        two.add(menu1);
        
        JMenu hm = new JMenu("Hotel Management");
        hm.setForeground(Color.BLACK);
        menu1.add(hm);
        
        JMenuItem rec = new JMenu("Reception");
        rec.setForeground(Color.BLACK);
        hm.add(rec);
        
         JMenu admin = new JMenu("Admin");
        hm.setForeground(Color.BLACK);
        menu1.add(admin);
        
        JMenuItem employees = new JMenuItem("Add Employee");
       
        employees.addActionListener(this);
        admin.add(employees);
        

        JMenuItem room = new JMenuItem("Add Room");
        
        room.addActionListener(this);
        admin.add(room);
        
        JMenuItem drivers = new JMenuItem ("Add Drivers");
        drivers.setForeground(Color.BLACK);
        drivers.addActionListener(this);
        admin.add(drivers);
        
        
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {if (ae.getActionCommand().equals("Add Employee")){
    new Addemployee();
    }
    else if (ae.getActionCommand().equals("Add Room")){
    new AddRooms();
    }else if (ae.getActionCommand().equals("Add Drivers")){
    new AddDriver();
    }
    }

    public static void main(String args[]) {
        Dashboard dashboard = new Dashboard();
    }
}
