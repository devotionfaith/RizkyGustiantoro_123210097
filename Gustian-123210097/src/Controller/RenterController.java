/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.RenterModel;
import View.RenterDataView;


public class RenterController {
    RenterModel model;
    RenterDataView view;
    
    public RenterController (RenterModel model, RenterDataView view){
        this.model = model;
        this.view = view;
        
         view.btnAddPanel.addActionListener(new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String nama = view.getName();
                String id = view.getId();
                String contact = view.getContact();
                String durasi = view.getRentTime();
                model.insertData(nama, id, contact, durasi);
            }
           
        });
    }
}
