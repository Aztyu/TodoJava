/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.entities;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Aztyu
 */
public class Comment {
    private final int id;
    private final String text;
    private final int employee_id;
    private final String employee_name;
    private final int todo_id;
    private Timestamp comment_date;

    public Comment(int id, String text, int employee_id, String employee_name, int todo_id, Timestamp comment_date) {
        this.id = id;
        this.text = text;
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.todo_id = todo_id;
        this.comment_date = comment_date;
    } 

    public String getText() {
        return text;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public Timestamp getComment_date() {
        return comment_date;
    }
    
    
}
