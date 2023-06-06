/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class RenterModel {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/almaul_db";
    static final String USER = "root";
    static final String PASS = "";
    String roomName;
    String harga;
    Connection connection;
    Statement statement;
    
    public RenterModel(String roomName, String harga) {
        this.roomName = roomName;
        this.harga = harga;
        try{
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhsail");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
          
    }
    public void insertData(String name, String contact, String id, String duration){
         try {
            String insert = "INSERT INTO `renter` (`name`, `contact`, `id`, `duration`, `bill`, `status`, `room`) " + 
                        "VALUES ('" + name + "','" + contact + "','" + id + "','" + duration + "','" + harga + "',"+ "'notPaid'"+ ",'" + roomName + "')";
            String update = "UPDATE `rooms` "
                    + "SET "
                    + "`status`='"+name+"'"
                    + " WHERE `name`='" + roomName + "'";
            statement = connection.createStatement();
            statement.executeUpdate(insert);
            statement.executeUpdate(update);
        } catch (Exception e) {
            System.out.println(e.getMessage());  
        }
    }
}
