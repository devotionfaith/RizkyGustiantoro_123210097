/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.AdminModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminPageView extends JFrame{ 
    JFrame window = new JFrame("Renter Data");
    Object columnName [];
    
    public String data[][] = new String [100][4];
    public DefaultTableModel tableModel = new DefaultTableModel(columnName,0);
    public JTable tabel = new JTable(tableModel);
    public JScrollPane scrollPane = new JScrollPane(tabel);
    
    public JButton blogout = new JButton("Logout");

    public AdminPageView() {
        window.setLayout(null);
        window.setSize(550,600);
       
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(scrollPane);
        window.add(blogout);
        scrollPane.setBounds(20, 35, 500, 300);
        blogout.setBounds(20, 350, 100,50);
        
        showData();
        window.setVisible(true);
    }
    
    private void showData(){
    AdminModel model = new AdminModel(); 
     String[][] data = model.readRenter();
    
     Object[] columnName = {"Name", "ID", "Contact", "Duration", "Bill", "Status", "Room"};
    tableModel.setRowCount(0);
    for (String[] rowData : data) {
        tableModel.addRow(rowData);
    }
    }
    public void logout(){
    this.dispose();
    LoginPageView login = new LoginPageView();
    }
    
}
