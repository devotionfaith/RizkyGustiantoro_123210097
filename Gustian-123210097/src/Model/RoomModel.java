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

public class RoomModel {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/almaul_db";
    static final String USER = "root";
    static final String PASS = "";
    Connection connection;
    Statement statement;
    
    public RoomModel() {
        try{
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
          
    }
    public int getRoomData(){
        try {
            int Data = 0;
            String query = "SELECT * FROM `rooms`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

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
        public String[][] readRoom(){
        try{
            int Data = 0;
            
            String data[][] = new String[getRoomData()][4];
            
            String show = "SELECT * FROM `rooms`"; 
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(show);
            while (resultSet.next()){
                data[Data][0] = resultSet.getString("name");
                data[Data][1] = resultSet.getString("size");                
                data[Data][2] = resultSet.getString("price");
                data[Data][3] = resultSet.getString("status");
                Data++;
            }
            statement.close();
            return data;
               
        }catch(SQLException e){
            System.out.println("Error : " + e.getMessage());
            return null;
        }
    }
}
