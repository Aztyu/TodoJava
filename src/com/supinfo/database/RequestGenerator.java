/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Aztyu
 */
public class RequestGenerator {
    public static String createUser(String pseudo, String password, boolean isManager){
        if(isManager){
            return "INSERT INTO manager VALUES(null, '"+pseudo+"', '"+password+"')";
        }else{
            return "INSERT INTO employee VALUES(null, '"+pseudo+"', '"+password+"')";
        }
    }

    public static java.sql.PreparedStatement createComment(String comment, int employee_id, int todo_id){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String date_mysql = dateFormat.format(date);
        
        Connection conn = DbManager.createConnection();
        
        try{
            java.sql.PreparedStatement stm = conn.prepareStatement("INSERT INTO comment VALUES(null, ?, ?, ?, ?)");
            stm.setString(1, comment);
            stm.setInt(2, employee_id);
            stm.setInt(3, todo_id);
            stm.setString(4, date_mysql);
            return stm;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    public static java.sql.PreparedStatement createTodo(String text){
        Connection conn = DbManager.createConnection();
        
        try{
            java.sql.PreparedStatement stm = conn.prepareStatement("INSERT INTO todo VALUES(null, ?, FALSE)");
            stm.setString(1, text);
            return stm;
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static String updateUser(int id, String pseudo, String password){
        return "UPDATE user SET user_name='" + pseudo + "', user_password='" + password + "' WHERE user_id = " + id;
    }
    
    public static String updateTodo(int id, boolean is_done){
        String done = (is_done)?"TRUE":"FALSE";
        return "UPDATE todo SET todo_isdone=" + done + " WHERE todo_id = " + id;
    }

    public static String getEmployeeValues(){
        return "SELECT * FROM employee";
    }
    
    public static String getEmployeeValuesByName(String name){
        return "SELECT * FROM employee WHERE employee_login = '" + name + "'";
    }
    
    public static String getManagerValues(){
        return "SELECT * FROM manager";
    }
    
    public static String getManagerValuesByName(String name){
        return "SELECT * FROM manager WHERE manager_login = '" + name + "'";
    }
    
    public static String getTodoValues(){
        return "SELECT * FROM todo";
    }
    
    public static String getTodoValuesByCompletion(boolean done){
        if(done){
            return "SELECT * FROM todo WHERE todo_isdone = 1";
        }else{
            return "SELECT * FROM todo WHERE todo_isdone = 0";
        }
    }
    
    public static String getCommentsByTodoId(int id){
        return "SELECT employee.employee_login, comment.* FROM comment INNER JOIN employee ON employee.employee_id=comment.employee_id WHERE comment.todo_id = " + id + " ORDER BY comment.comment_id";
    }
}
