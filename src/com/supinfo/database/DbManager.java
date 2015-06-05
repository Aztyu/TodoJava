/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.database;

import com.supinfo.entities.Comment;
import com.supinfo.entities.Employee;
import com.supinfo.entities.Manager;
import com.supinfo.entities.Todo;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aztyu
 */
public class DbManager {
    private static Connection conn = null;
    private static Statement stm = null;
    private static ResultSet rslt = null;
    
    public static void openConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "root");
        } catch (ClassNotFoundException ex) {
            System.out.println("No class found");
        } catch (SQLException ex) {
            System.out.println("Open connection error : " + ex.getMessage());
        }
    }
    
    public static Connection createConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjava", "root", "root");
            return conn;
        } catch (ClassNotFoundException ex) {
            System.out.println("No class found");
            return null;
        } catch (SQLException ex) {
            System.out.println("Open connection error : " + ex.getMessage());
            return null;
        }
    }
    
    public static List<Todo> querySelectTodo(String query){
        List<Todo> todo_list = new ArrayList<>();
        
        try {
            openConnection();
            stm = conn.createStatement();
            rslt = stm.executeQuery(query);
            
            while(rslt.next()){
                todo_list.add(new Todo(rslt.getInt("todo_id"), rslt.getString("todo_text"), rslt.getBoolean("todo_isdone"), rslt.getTimestamp("todo_date")));
            }
            
            conn.close();
            return todo_list;
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static List<Comment> querySelectComment(String query){
        List<Comment> comment_list = new ArrayList<>();
        
        try {
            openConnection();
            stm = conn.createStatement();
            rslt = stm.executeQuery(query);
            
            while(rslt.next()){
                comment_list.add(new Comment(rslt.getInt("comment_id"), rslt.getString("comment_text"), rslt.getInt("employee_id"), rslt.getString("employee_login"), rslt.getInt("todo_id"), rslt.getTimestamp("comment_date")));
            }
            
            conn.close();
            return comment_list;
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static List<Employee> querySelectEmployee(String query){
        List<Employee> employee_list = new ArrayList<>();
        
        try {
            openConnection();
            stm = conn.createStatement();
            rslt = stm.executeQuery(query);
            
            while(rslt.next()){
                employee_list.add(new Employee(rslt.getInt("employee_id"), rslt.getString("employee_login"), rslt.getString("employee_passwd")));
            }
            
            conn.close();
            return employee_list;
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static List<Manager> querySelectManager(String query){
        List<Manager> manager_list = new ArrayList<>();
        
        try {
            openConnection();
            stm = conn.createStatement();
            rslt = stm.executeQuery(query);
            
            while(rslt.next()){
                manager_list.add(new Manager(rslt.getInt("manager_id"), rslt.getString("manager_login"), rslt.getString("manager_passwd")));
            }
            
            conn.close();
            return manager_list;
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void queryUID(String query){
        try {
            openConnection();
            stm = conn.createStatement();
            stm.execute(query);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void createPrepared(PreparedStatement pstm){
        try {
            pstm.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
