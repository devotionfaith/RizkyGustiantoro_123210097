package View;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import Controller.LoginController;
import Model.UserModel;
import View.LoginPageView;

/**
 *
 * @author OWNER
 */
public class ViewResponsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserModel model = new UserModel();
        LoginPageView view = new LoginPageView();
        LoginController controller = new LoginController(model,view);
    }   
}
