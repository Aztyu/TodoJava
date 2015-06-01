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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Aztyu
 */
public class RegisterFrame extends JFrame implements ActionListener{
    private JPanel panel = new JPanel();
    private boolean username_default;
    private boolean password_default;

    JLabel login = new JLabel("Login");
    JLabel pass = new JLabel("Password");
    JLabel result = new JLabel("");

    private JTextField username = new JTextField("Username");
    private JPasswordField password = new JPasswordField("My password");
    private JCheckBox is_manager = new JCheckBox("Manager ?", false);

    private JButton button = new JButton("Register");

    public RegisterFrame(){
        super();
        username_default = true;
        password_default = true;
        panel.setLayout(null);
        this.setVisible(true);
        this.setSize(640, 400);
        this.setTitle("Hello World");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                ConnectionFrame cf = new ConnectionFrame();
                setVisible(false);
            }
        });
        initComponents();
    }

    public void initComponents(){
        button.setBackground(new Color(200, 200, 200));

        login.setBounds(250, 20, 100, 20);
        username.setBounds(250, 40, 100, 20);
        pass.setBounds(250, 70, 100, 20);
        password.setBounds(250, 90, 100, 20);
        is_manager.setBounds(250, 120, 100, 20);
        button.setBounds(250, 140, 100, 20);
        result.setBounds(250, 160, 100, 20);

        button.addActionListener(this);

        panel.add(result);
        panel.add(login);
        panel.add(username);
        panel.add(pass);
        panel.add(password);
        panel.add(button);
        panel.add(is_manager);
        
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
        
        this.setContentPane(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == button){
            for(Employee emp : DbManager.querySelectEmployee(RequestGenerator.getEmployeeValues())){
                if(username.getText().equals(emp.getLogin())){
                    JOptionPane.showMessageDialog(null, "Pseudo is already used");
                    return;
                }
            }
            for(Manager man : DbManager.querySelectManager(RequestGenerator.getManagerValues())){
                if(username.getText().equals(man.getLogin())){
                    JOptionPane.showMessageDialog(null, "Pseudo is already used");
                    return;
                }
            }
            DbManager.queryUID(RequestGenerator.createUser(username.getText(), String.copyValueOf(password.getPassword()), is_manager.isSelected()));
            String status = (is_manager.isSelected())?"Manager":"Employee";
            JOptionPane.showMessageDialog(null, status + " " + username.getText() + " created");
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
