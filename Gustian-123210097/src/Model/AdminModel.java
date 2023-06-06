/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class AdminModel {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/almaul_db";
    static final String USER = "root";
    static final String PASS = "";
    String id;
    Connection connection;
    Statement statement;
    
    public AdminModel() {
        try{
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
          
    }
     public int getRenterData(){
        try {
            int Data = 0;
            String show = "SELECT * FROM `renter`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(show);

            while(resultSet.next()){
                Data++;
            }
            statement.close();
            return Data;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }
    }
        public String[][] readRenter(){
        try{
            int Data = 0;
            
            String data[][] = new String[getRenterData()][7];
            
            String show = "SELECT * FROM `renter`"; 
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(show);
            while (resultSet.next()){
                data[Data][0] = resultSet.getString("name");
                data[Data][1] = resultSet.getString("id");                
                data[Data][2] = resultSet.getString("contact");
                data[Data][3] = resultSet.getString("duration");
                data[Data][4] = resultSet.getString("bill");
                data[Data][5] = resultSet.getString("status");
                data[Data][6] = resultSet.getString("room");
                Data++;
            }
            statement.close();
            return data;
               
        }catch(SQLException e){
            System.out.println("Error : " + e.getMessage());
            return null;
        }
    }
     public void updateData(String nama,String contact){
        try {
            
            String update = "UPDATE `renter` "
                    + "SET "
                    + "`name`='" + nama + "',"
                    + "`contact`='" + contact + "' WHERE `id`='" + id + "'";
            statement = connection.createStatement();
            statement.executeUpdate(update);
            
            JOptionPane.showMessageDialog(null, "Update Success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(e.getMessage().equals("out")){
                JOptionPane.showMessageDialog(null, "Out of Bound");
            }else{
                JOptionPane.showMessageDialog(null, "Update Failed");
            }     
        }
    }
    
    public void deleteData () {
        try{
            String delete = "DELETE FROM renter WHERE `id` = '"+id+"'";
            statement = connection.createStatement();
            statement.executeUpdate(delete);
            JOptionPane.showMessageDialog(null, "Delete Success");
            
        }catch(SQLException e) {
            System.out.println("Error : " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Delete Failed");
        }
    }
     public void updateStatus(){
       int choice = 0;
       if (choice == JOptionPane.YES_OPTION) {
            try {
            String update = "UPDATE `renter` "
                    + "SET "
                    + "`status`='Paid'"
                    + " WHERE `id`='" + id + "'";
            statement = connection.createStatement();
            statement.executeUpdate(update);
            
            JOptionPane.showMessageDialog(null, "Update Success");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if(e.getMessage().equals("out")){
                JOptionPane.showMessageDialog(null, "Out of Bound");
            }else{
                JOptionPane.showMessageDialog(null, "Update Failed");
            }     
        }
            System.out.println("User confirmed.");
        } else if (choice == JOptionPane.NO_OPTION) {
           
            System.out.println("User cancelled.");
        } else if (choice == JOptionPane.CANCEL_OPTION) {
            
            System.out.println("User cancelled.");
        }
       
    }
}
