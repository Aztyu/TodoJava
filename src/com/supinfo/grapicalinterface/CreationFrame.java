/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.grapicalinterface;

import com.supinfo.database.DbManager;
import com.supinfo.database.RequestGenerator;
import com.supinfo.utilities.ProjectUtils;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Aztyu
 */
public class CreationFrame extends JFrame implements ActionListener{
    private boolean username_default;
    private boolean password_default;
    private int user_id;
    
    private JPanel panel = new JPanel();
    JScrollPane scroll_pane = new JScrollPane();
    private JButton button = new JButton("Show preview");
    private JButton button_create = new JButton("Create todo");
    
    JTextArea text = new JTextArea(16,58);
    JLabel text_apercu = new JLabel();

    public CreationFrame(int user_id){
        super();
        panel.setLayout(new FlowLayout());
        this.user_id = user_id;
        this.setVisible(true);
        this.setSize(640, 400);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Todo - Creation");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                ManagerFrame mf = new ManagerFrame(user_id);
                setVisible(false);
            }
        });
        this.setResizable(false);
        initComponents();
        this.setContentPane(scroll_pane);
        this.setLocationRelativeTo(null);
    }
    
    public void initComponents(){
        button.setPreferredSize(new Dimension(280, 30));
        button_create.setPreferredSize(new Dimension(280, 30));
        JScrollPane scroll = new JScrollPane(text);
        Dimension d = scroll.getPreferredSize();
        d.width = 500;
        scroll.setPreferredSize(d);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        text.setPreferredSize(new Dimension(560, 160));
        text.setMaximumSize(new Dimension(560, 1000));
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
       
        button.addActionListener(this);
        button_create.addActionListener(this);
        
        panel.add(scroll);
        panel.add(button);
        panel.add(button_create);
        panel.add(text_apercu);
        
        panel.setPreferredSize(new Dimension(600, 460));
        scroll_pane = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("Ressources//todo.png"));
            this.setIconImage(img);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == button){
            String test = text.getText();
            text_apercu.setText(ProjectUtils.textToHtml(test));
            System.out.println("text : " + ProjectUtils.textToHtml(test));
        }else if(source == button_create){
            DbManager.createPrepared(RequestGenerator.createTodo(ProjectUtils.textToHtml(text.getText())));
        }
    }
}
