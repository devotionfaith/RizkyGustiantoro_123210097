/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.UserModel;
import View.LoginPageView;


public class LoginController {
    UserModel model;
    LoginPageView view;
    
    public LoginController (UserModel model, LoginPageView view){
        this.model = model;
        this.view = view;
    
        view.blogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               String username = view.GetUsername();
               String password = view.GetPassword();
               model.loginUser(username,password);
               view.logout();
            }
        });
        
    
    }
    
    
}
