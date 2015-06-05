/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.grapicalinterface;

import com.supinfo.custominterface.TodoPanel;
import com.supinfo.database.DbManager;
import com.supinfo.database.RequestGenerator;
import com.supinfo.entities.Todo;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author Aztyu
 */
public class MainFrame extends JFrame implements ActionListener{
    protected int user_id;
    protected JPanel panel = new JPanel();
    protected JButton button = new JButton("Deconnexion");
    
    protected JPanel pan1 = new JPanel();
    protected JPanel pan2 = new JPanel();
    
    private JTabbedPane tabPan = new JTabbedPane();
    
    public MainFrame(int user_id){
        super();
        this.user_id = user_id;
        panel.setLayout(null);
        this.setVisible(true);
        this.setSize(640, 400);
        this.setTitle("Todo - View");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        getContentPane().add(panel);
        initComponents();
    }
    
    private void initComponents(){
        button.setBounds(10, 10, 120, 30);
        button.addActionListener(this);
        tabPan.setBounds(10, 50, 620, 310);
        
        createPages();
        
        panel.add(button);
        panel.add(tabPan);
        
        BufferedImage img = null;
        try {
            //System.
            img = ImageIO.read(new File("Ressources//todo.png"));
            this.setIconImage(img);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createPages(){
        int i = 1;
        for(Todo to : DbManager.querySelectTodo(RequestGenerator.getTodoValuesByCompletion(false))){
            JPanel todo_pan = new JPanel();
            todo_pan.setLayout(new FlowLayout());
            
            todo_pan.add(new TodoPanel(to.getId(), to.getText(), user_id, to.getTodoDate()));
            
            JScrollPane scroll = new JScrollPane(todo_pan, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            tabPan.addTab("Todo" + i, scroll);
            i++;
        }
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
