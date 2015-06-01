/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.grapicalinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Aztyu
 */
public class ManagerFrame extends MainFrame{
    JButton button_manager = new JButton("Create");
    
    public ManagerFrame(int user_id) {
        super(user_id);
        button_manager.setBounds(490, 10, 120, 30);
        button_manager.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
        
                if(source == button_manager){
                    CreationFrame cf = new CreationFrame(user_id);
                    setVisible(false);
                }
            }
        });
        panel.add(button_manager);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == button){
            ConnectionFrame cf = new ConnectionFrame();
            this.setVisible(false);
        }
    }
}
