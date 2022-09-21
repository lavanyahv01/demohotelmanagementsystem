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
public class AddRooms extends JFrame implements ActionListener {

    JLabel lroomnr, lavailability, lcleaningstatus, lprice, lbedtype, heading;
    JTextField troomnr, tprice;
    JButton addroom, cancel;
    JComboBox tavailability, tcleaningstatus, tbedtype;

    AddRooms() {
        setLayout(null);

        heading = new JLabel("Add Rooms");
        heading.setBounds(70, -15, 150, 100);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        lroomnr = new JLabel("Room Number");
        lroomnr.setBounds(70, 30, 100, 100);
        lroomnr.setFont(new Font("Arial", Font.PLAIN, 13));
        lroomnr.setForeground(Color.BLACK);
        add(lroomnr);

        lavailability = new JLabel("Availability");
        lavailability.setBounds(70, 80, 100, 100);
        lavailability.setFont(new Font("Arial", Font.PLAIN, 13));
        lavailability.setForeground(Color.BLACK);
        add(lavailability);

        lcleaningstatus = new JLabel("Cleaning Status");
        lcleaningstatus.setBounds(70, 130, 100, 100);
        lcleaningstatus.setFont(new Font("Arial", Font.PLAIN, 13));
        lcleaningstatus.setForeground(Color.BLACK);
        add(lcleaningstatus);

        lprice = new JLabel("Price");
        lprice.setBounds(70, 180, 100, 100);
        lprice.setFont(new Font("Arial", Font.PLAIN, 13));
        lprice.setForeground(Color.BLACK);
        add(lprice);

        lbedtype = new JLabel("Bed Type");
        lbedtype.setBounds(70, 230, 100, 100);
        lbedtype.setFont(new Font("Arial", Font.PLAIN, 13));
        lbedtype.setForeground(Color.BLACK);
        add(lbedtype);

        troomnr = new JTextField();
        troomnr.setBounds(180, 65, 120, 30);
        troomnr.setFont(new Font("Arial", Font.PLAIN, 13));
        troomnr.setForeground(Color.BLACK);
        add(troomnr);

        tprice = new JTextField();
        tprice.setBounds(180, 215, 120, 30);
        tprice.setFont(new Font("Arial", Font.PLAIN, 13));
        tprice.setForeground(Color.BLACK);
        add(tprice);

        String str[] = {"Single Bed", "Double Bed"};
        tbedtype = new JComboBox(str);
        tbedtype.setBounds(180, 265, 120, 30);
        tbedtype.setFont(new Font("Arial", Font.PLAIN, 13));
        tbedtype.setForeground(Color.BLACK);
        add(tbedtype);

        String avoption[] = {"Available", "Occupied"};
        tavailability = new JComboBox(avoption);
        tavailability.setBounds(180, 114, 120, 30);
        tavailability.setFont(new Font("Arial", Font.PLAIN, 13));
        tavailability.setForeground(Color.BLACK);
        add(tavailability);

        String csoption[] = {"Cleaned", "Dirty"};
        tcleaningstatus = new JComboBox(csoption);
        tcleaningstatus.setBounds(180, 165, 120, 30);
        tcleaningstatus.setFont(new Font("Arial", Font.PLAIN, 13));
        tcleaningstatus.setForeground(Color.BLACK);
        add(tcleaningstatus);

        ImageIcon aepic = new ImageIcon(ClassLoader.getSystemResource("hms/icons/aepic.jpg"));
        Image scaledpic1 = aepic.getImage().getScaledInstance(650, 360, Image.SCALE_DEFAULT);
        ImageIcon spic1 = new ImageIcon(scaledpic1);
        JLabel aepics = new JLabel(spic1);
        aepics.setBounds(150, 80, 1000, 550); // location and size with respect to the frame
        add(aepics);

        addroom = new JButton("Add");
        addroom.setBounds(50, 350, 120, 40);
        addroom.setForeground(Color.WHITE);
        addroom.setBackground(Color.darkGray);
        addroom.setFont(new Font("Arial", Font.BOLD, 15));
        addroom.addActionListener(this);
        add(addroom);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 120, 40);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.darkGray);
        cancel.setFont(new Font("Arial", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);
        setBounds(200, 300, 800, 550);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addroom) {
            String roomnr = troomnr.getText();
            String price = tprice.getText();

            String availability = (String) tavailability.getSelectedItem();
            String status = (String) tcleaningstatus.getSelectedItem();
            String type = (String) tbedtype.getSelectedItem();

            try {
                Conn conn = new Conn();
                String query1 = "insert into room values('" + roomnr + "', '" + availability + "', '" + status + "', '" + price + "', '" + type + "', )";

                conn.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null, "Room added successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new AddRooms();
    }
}
