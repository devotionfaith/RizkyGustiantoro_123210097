/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Orenji
 */
public class EditRenterData extends JFrame{

    JFrame window = new JFrame();
    JLabel lName = new JLabel("Name ");
    public JTextField tfName = new JTextField();
    JLabel lContact= new JLabel("Contact ");
    public JTextField tfContact = new JTextField();

    public JButton btnAddPanel = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");

    public EditRenterData() {
        window.setTitle("Renter Data");
        window.setLayout(null);
        window.setSize(550,200);
        //window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        window.add(lName);
        window.add(tfName);
        window.add(lContact);
        window.add(tfContact);
        window.add(btnDelete);
        window.add(btnAddPanel);
        
        //LABEL
        lName.setBounds(5, 30, 120, 20);
        lContact.setBounds(5,60,120,20);

//TEXTFIELD
        tfName.setBounds(110, 35, 120, 20);
        tfContact.setBounds(110, 65, 120, 20);


//BUTTON PANEL
        btnAddPanel.setBounds(350, 95, 120, 30);
        btnDelete.setBounds(350, 35, 120, 30);
    }

    public String getContact() {
        return tfContact.getText();
    }

    public String getName() {
        return tfName.getText();
    }
    
}

