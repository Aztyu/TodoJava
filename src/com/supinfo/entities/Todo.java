/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.entities;

import java.sql.Timestamp;

/**
 *
 * @author Aztyu
 */
public class Todo {
    private final int id;
    private final String text;
    private final boolean is_done;
    private Timestamp todo_date;

    public Todo(int id, String text, boolean is_done, Timestamp todo_date) {
        this.id = id;
        this.text = text;
        this.is_done = is_done;
        this.todo_date = todo_date;
    }

    public String getText() {
        return text;
    }
    
    public int getId() {
        return id;
    }
    
    public Timestamp getTodoDate(){
    	return this.todo_date;
    }
}
