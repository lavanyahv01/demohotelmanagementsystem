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
public class Addemployee extends JFrame implements ActionListener {

    JLabel lname, lage, ljob, lgender, lsalary, lphone, lemail, lidnr;
    JTextField tname, tage, tsalary, tphone, temail, tidnr;
    JRadioButton tmale, tfemale, tother, tprefernottosay;
    JButton submit;
    JComboBox tjob;

    Addemployee() {
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

        ljob = new JLabel("Job");
        ljob.setBounds(70, 165, 100, 100);
        ljob.setFont(new Font("Arial", Font.BOLD, 13));
        ljob.setForeground(Color.BLACK);
        add(ljob);

        lsalary = new JLabel("Salary");
        lsalary.setBounds(70, 210, 100, 100);
        lsalary.setFont(new Font("Arial", Font.BOLD, 13));
        lsalary.setForeground(Color.BLACK);
        add(lsalary);

        lphone = new JLabel("Phone");
        lphone.setBounds(70, 255, 100, 100);
        lphone.setFont(new Font("Arial", Font.BOLD, 13));
        lphone.setForeground(Color.BLACK);
        add(lphone);

        lemail = new JLabel("Email");
        lemail.setBounds(70, 300, 100, 100);
        lemail.setFont(new Font("Arial", Font.BOLD, 13));
        lemail.setForeground(Color.BLACK);
        add(lemail);

        lidnr = new JLabel("Personal identification number");
        lidnr.setBounds(70, 345, 200, 100);
        lidnr.setFont(new Font("Arial", Font.BOLD, 13));
        lidnr.setForeground(Color.BLACK);
        add(lidnr);

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

        tmale = new JRadioButton("Male");
        tmale.setBounds(180, 155, 70, 25);
        tmale.setFont(new Font("Arial", Font.BOLD, 13));
        tmale.setForeground(Color.BLACK);
        add(tmale);

        tfemale = new JRadioButton("Female");
        tfemale.setBounds(260, 155, 80, 25);
        tfemale.setFont(new Font("Arial", Font.BOLD, 13));
        tfemale.setForeground(Color.BLACK);
        add(tfemale);

        

        tother = new JRadioButton("Other");
        tother.setBounds(470, 155, 120, 25);
        tother.setFont(new Font("Arial", Font.BOLD, 13));
        tother.setForeground(Color.BLACK);
        add(tother);

        tprefernottosay = new JRadioButton("Prefer not to say");
        tprefernottosay.setBounds(600, 155, 130, 25);
        tprefernottosay.setFont(new Font("Arial", Font.BOLD, 13));
        tprefernottosay.setForeground(Color.BLACK);
        add(tprefernottosay);

        ButtonGroup bg = new ButtonGroup();
        bg.add(tmale);
        bg.add(tfemale);
        
        bg.add(tother);
        bg.add(tprefernottosay);

        tsalary = new JTextField();
        tsalary.setBounds(180, 248, 120, 30);
        tsalary.setFont(new Font("Arial", Font.BOLD, 13));
        tsalary.setForeground(Color.BLACK);
        add(tsalary);

        tphone = new JTextField();
        tphone.setBounds(180, 290, 120, 30);
        tphone.setFont(new Font("Arial", Font.BOLD, 13));
        tphone.setForeground(Color.BLACK);
        add(tphone);

        temail = new JTextField();
        temail.setBounds(180, 330, 120, 30);
        temail.setFont(new Font("Arial", Font.BOLD, 13));
        temail.setForeground(Color.BLACK);
        add(temail);

        tidnr = new JTextField();
        tidnr.setBounds(300, 380, 120, 30);
        tidnr.setFont(new Font("Arial", Font.BOLD, 13));
        tidnr.setForeground(Color.BLACK);
        add(tidnr);

        String str[] = {"Housekeeping", "Kitchen staff", "Room service", "Porters", "Waiter/Waitress", "Manager", "Accountant", "Front desk clerks"};
        tjob = new JComboBox(str);
        tjob.setBounds(180, 200, 120, 30);
        tjob.setFont(new Font("Arial", Font.BOLD, 13));
        tjob.setForeground(Color.BLACK);
        add(tjob);

        ImageIcon aepic = new ImageIcon(ClassLoader.getSystemResource("hms/icons/aepic.jpg"));
        Image scaledpic1 = aepic.getImage().getScaledInstance(650, 360, Image.SCALE_DEFAULT);
        ImageIcon spic1 = new ImageIcon(scaledpic1);
        JLabel aepics = new JLabel(spic1);
        aepics.setBounds(150, 80, 1000, 550); // location and size with respect to the frame
        add(aepics);

        submit = new JButton("Submit");
        submit.setBounds(170, 445, 120, 40);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.darkGray);
        submit.setFont(new Font("Arial", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.WHITE);
        setBounds(150, 150, 1000, 550);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String name = tname.getText();
        String age = tage.getText();
        String salary = tsalary.getText();
        String phone = tphone.getText();
        String email = temail.getText();
        String idnr = tidnr.getText();

        String gender = null;
        
        if(name.isEmpty()){JOptionPane.showMessageDialog(null, "Name should not be empty");}
        
        if (tmale.isSelected()) {
            gender = "Male";
        } else if (tfemale.isSelected()) {
            gender = "Female";
         
        } else if (tother.isSelected()) {
            gender = "Gender Queer";
        } else if (tprefernottosay.isSelected()) {
            gender = "Prefer not to say";
        }
        String job = (String) tjob.getSelectedItem();

        try {
            Conn conn = new Conn();
            String query = "insert into employee values('" + name + "', '" + age + "', '" + gender + "', '" + job + "', '" + salary + "', '" + phone + "', '" + email + "', '" + idnr + "' )";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Employee added successfully");
            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public static void main(String[] args) {
        new Addemployee();
    }
}
