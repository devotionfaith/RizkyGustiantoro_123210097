/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import Model.RenterModel;
import Model.RoomModel;
import View.LoginPageView;
import View.RenterDataView;
import View.RoomListView;

public class RoomController {
    RoomModel model;
    RoomListView view;
    Object columnName[] = {"name", "size", "price", "status"};
    public RoomController (RoomModel model, RoomListView view){
        this.model = model;
        this.view = view;
        
        if (model.getRoomData()!=0) {
            String dataMovie[][] = model.readRoom();
            view.tabel.setModel((new JTable(dataMovie, columnName)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "No Data");
        }
        
        view.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);

                int baris = view.tabel.getSelectedRow();
                String name = view.tabel.getValueAt(baris, 0).toString();
                String harga = view.tabel.getValueAt(baris, 2).toString();
                String status = view.tabel.getValueAt(baris, 3).toString();
                
                if("empty".equals(status)){
                RenterModel model = new RenterModel(name,harga);
                RenterDataView view = new RenterDataView();
                RenterController controller = new RenterController(model,view);
                }
                else{
                JOptionPane.showMessageDialog(null, "Kamar Sudah Terisi");
                }    
            }

        });
        
        view.bcancel.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginPageView().setVisible(true);
                view.logout();
            }
        
        });
        
        
    }
    
}
