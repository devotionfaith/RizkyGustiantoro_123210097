/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.RoomModel;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class RoomListView extends JFrame { 
    JFrame window = new JFrame("Room Data");
    Object columnName[] = {"name", "size", "price", "status"};
    
    public String data[][] = new String [100][4];
    public DefaultTableModel tableModel = new DefaultTableModel(columnName,0);
    public JTable tabel = new JTable(tableModel);
    public JScrollPane scrollPane = new JScrollPane(tabel);
    
    public JButton bcancel = new JButton("Logout");
    public JButton bread = new JButton("Read Data");

    public RoomListView(){
        window.setLayout(null);
        window.setSize(550,600);
       
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        window.add(bread);
        window.add(scrollPane);
        window.add(bcancel);
        scrollPane.setBounds(20, 35, 500, 300);
        bcancel.setBounds(20, 350, 100,50);
        bread.setBounds(150, 350, 100,50);
        
        window.setVisible(true);
        showData();
        
    }
    
    private void showData(){
    RoomModel model = new RoomModel();
    String[][] data = model.readRoom();
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
