/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author bunny
 */
public class AddDriver extends JFrame implements ActionListener {

    JLabel lname, lage, lcarcompany, lgender, lcarmodel, llocation, lavailable;
    JTextField tname, tage, tcarcompany, tcarmodel, tlocation;
    JButton tadd, tcan;
    JComboBox tavailability, tgender;

    AddDriver() {
        setLayout(null);

        lname = new JLabel("Name");
        lname.setBounds(70, 30, 100, 100);
        lname.setFont(new Font("Arial", Font.BOLD, 13));
        lname.setForeground(Color.BLACK);
        add(lname);

        lage = new JLabel("Age");
        lage.setBounds(70, 75, 100, 100);
        lage.setFont(new Font("Arial", Font.BOLD, 13));
        lage.setForeground(Color.BLACK);
        add(lage);

        lgender = new JLabel("Gender");
        lgender.setBounds(70, 120, 100, 100);
        lgender.setFont(new Font("Arial", Font.BOLD, 13));
        lgender.setForeground(Color.BLACK);
        add(lgender);

        lcarcompany = new JLabel("Car Company");
        lcarcompany.setBounds(70, 165, 100, 100);
        lcarcompany.setFont(new Font("Arial", Font.BOLD, 13));
        lcarcompany.setForeground(Color.BLACK);
        add(lcarcompany);

        lcarmodel = new JLabel("Car Model");
        lcarmodel.setBounds(70, 210, 100, 100);
        lcarmodel.setFont(new Font("Arial", Font.BOLD, 13));
        lcarmodel.setForeground(Color.BLACK);
        add(lcarmodel);

        lavailable = new JLabel("Availability");
        lavailable.setBounds(70, 255, 100, 100);
        lavailable.setFont(new Font("Arial", Font.BOLD, 13));
        lavailable.setForeground(Color.BLACK);
        add(lavailable);

        llocation = new JLabel("Location");
        llocation.setBounds(70, 300, 100, 100);
        llocation.setFont(new Font("Arial", Font.BOLD, 13));
        llocation.setForeground(Color.BLACK);
        add(llocation);

        tname = new JTextField();
        tname.setBounds(180, 65, 120, 30);
        tname.setFont(new Font("Arial", Font.BOLD, 13));
        tname.setForeground(Color.BLACK);
        add(tname);

        tage = new JTextField();
        tage.setBounds(180, 110, 120, 30);
        tage.setFont(new Font("Arial", Font.BOLD, 13));
        tage.setForeground(Color.BLACK);
        add(tage);

        String genoption[] = {"Male", "Female", "Prefer not to say", "Other"};
        tgender = new JComboBox(genoption);
        tgender.setBounds(180, 155, 120, 30);
        tgender.setFont(new Font("Arial", Font.PLAIN, 13));
        tgender.setForeground(Color.BLACK);
        add(tgender);

        tcarcompany = new JTextField();
        tcarcompany.setBounds(180, 200, 120, 30);
        tcarcompany.setFont(new Font("Arial", Font.BOLD, 13));
        tcarcompany.setForeground(Color.BLACK);
        add(tcarcompany);

        tcarmodel = new JTextField();
        tcarmodel.setBounds(180, 248, 120, 30);
        tcarmodel.setFont(new Font("Arial", Font.BOLD, 13));
        tcarmodel.setForeground(Color.BLACK);
        add(tcarmodel);

        String avoption[] = {"Available", "Occupied"};
        tavailability = new JComboBox(avoption);
        tavailability.setBounds(180, 290, 120, 30);
        tavailability.setFont(new Font("Arial", Font.PLAIN, 13));
        tavailability.setForeground(Color.BLACK);
        add(tavailability);

        tlocation = new JTextField();
        tlocation.setBounds(180, 330, 120, 30);
        tlocation.setFont(new Font("Arial", Font.BOLD, 13));
        tlocation.setForeground(Color.BLACK);
        add(tlocation);

        ImageIcon aepic = new ImageIcon(ClassLoader.getSystemResource("hms/icons/aepic.jpg"));
        Image scaledpic1 = aepic.getImage().getScaledInstance(650, 360, Image.SCALE_DEFAULT);
        ImageIcon spic1 = new ImageIcon(scaledpic1);
        JLabel aepics = new JLabel(spic1);
        aepics.setBounds(150, 80, 1000, 550); // location and size with respect to the frame
        add(aepics);

        tadd = new JButton("Add Driver");
        tadd.setBounds(170, 445, 120, 40);
        tadd.setForeground(Color.WHITE);
        tadd.setBackground(Color.darkGray);
        tadd.setFont(new Font("Arial", Font.BOLD, 15));
        tadd.addActionListener(this);
        add(tadd);

        tcan = new JButton("Cancel");
        tcan.setBounds(170, 445, 120, 40);
        tcan.setForeground(Color.WHITE);
        tcan.setBackground(Color.darkGray);
        tcan.setFont(new Font("Arial", Font.BOLD, 15));
        tcan.addActionListener(this);
        add(tcan);

        getContentPane().setBackground(Color.WHITE);
        setBounds(150, 150, 1000, 550);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == tadd) {
            String name = tname.getText();
            String age = tage.getText();
            String carcompany = tcarcompany.getText();
            String carmodel = tcarmodel.getText();
            String location = tlocation.getText();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name should not be empty");
            }

            String gender = (String) tgender.getSelectedItem();
            String availability = (String) tavailability.getSelectedItem();

            try {
                Conn conn = new Conn();
                String query = "insert into driver values('" + name + "', '" + age + "', '" + gender + "', '" + carcompany + "', '" + carmodel + "', '" + availability + "', '" + location + "' )";

                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Driver added successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
