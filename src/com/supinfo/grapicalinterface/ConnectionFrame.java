/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.grapicalinterface;

import com.supinfo.database.DbManager;
import com.supinfo.database.RequestGenerator;
import com.supinfo.entities.Employee;
import com.supinfo.entities.Manager;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JTextField;

/**
 *
 * @author Aztyu
 */
public class ConnectionFrame extends JFrame implements ActionListener {
    private boolean username_default;
    private boolean password_default;
    
    private JPanel panel = new JPanel();

    JLabel login = new JLabel("Login");
    JLabel pass = new JLabel("Password");
    JLabel result = new JLabel("");

    private JTextField username = new JTextField("Username");
    private JPasswordField password = new JPasswordField("My password");

    private JButton button = new JButton("Login");
    private JButton button1 = new JButton("Register");

    public ConnectionFrame(){
        super();
        username_default = true;
        password_default = true;
        panel.setLayout(null);
        this.setVisible(true);
        this.setSize(640, 400);
        this.setTitle("Todo - Login");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents();
    }

    public void initComponents(){
        button.setBackground(new Color(200, 200, 200));
        result.setHorizontalAlignment(JLabel.CENTER);

        login.setBounds(250, 20, 100, 20);
        username.setBounds(250, 40, 100, 20);
        pass.setBounds(250, 70, 100, 20);
        password.setBounds(250, 90, 100, 20);
        button.setBounds(250, 120, 100, 20);
        result.setBounds(230, 140, 140, 20);
        button1.setBounds(250, 320, 100, 20);

        button.addActionListener(this);
        button1.addActionListener(this);

        username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(username_default){
                    username.setText("");
                    username_default = false;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        
        password.addKeyListener(new myKeyListener());
        
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(password_default){
                    password.setText("");
                    password_default = false;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        
        panel.add(result);
        panel.add(login);
        panel.add(username);
        panel.add(pass);
        panel.add(password);
        panel.add(button);
        panel.add(button1);

        this.setContentPane(panel);
        BufferedImage img = null;
        try {
            //System.
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
            for(Manager man : DbManager.querySelectManager(RequestGenerator.getManagerValuesByName(username.getText()))){
                if(String.copyValueOf(password.getPassword()).equals(man.getPassword())){
                        result.setText("Connecting Manager...");
                        button.setBackground(Color.GREEN);
                        ManagerFrame mf = new ManagerFrame(man.getId());
                        this.setVisible(false);
                        return;
                }
            }
            for(Employee emp : DbManager.querySelectEmployee(RequestGenerator.getEmployeeValuesByName(username.getText()))){
                if(String.copyValueOf(password.getPassword()).equals(emp.getPassword())){
                        result.setText("Connecting Employee...");
                        button.setBackground(Color.GREEN);
                        MainFrame mf = new MainFrame(emp.getId());
                        this.setVisible(false);
                        return;
                }
            }
            
            result.setText("Wrong credentials");
            button.setBackground(Color.RED);
            password.setText("");
        }else if(source == button1){
            RegisterFrame f = new RegisterFrame();
            this.setVisible(false);
        }
    }
    
    public class myKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                button.doClick();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } 
    }
}
