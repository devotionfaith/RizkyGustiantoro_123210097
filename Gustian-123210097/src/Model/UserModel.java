/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Controller.AdminController;
import Controller.RoomController;
import View.AdminPageView;
import View.RoomListView;

public class UserModel {
     static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/almaul_db";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection connection;
    Statement statement;
    
    public UserModel() {
        try{
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    public void loginUser(String username, String password){
           try {
            String login = "SELECT * FROM `accounts` WHERE `username` = '" +username+"' AND `password` = '" +password+ "' AND `role` = 'renter'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(login);
            
            if(resultSet.next()){
                RoomModel model = new RoomModel();
                RoomListView view = new RoomListView();
                RoomController controller = new RoomController(model,view);
            }
            else{
             statement.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
              try {
            String login = "SELECT * FROM `accounts` WHERE `username` = '" +username+"' AND `password` = '" +password+ "' AND `role` = 'admin'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(login);

            if(resultSet.next()){
                AdminModel model = new AdminModel();
                AdminPageView view = new AdminPageView();
                AdminController controller = new AdminController(model,view);
            }
            else{
             statement.close();
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    
    }
}
