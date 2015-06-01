/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.entities;

/**
 *
 * @author Aztyu
 */
public class Todo {
    private final int id;
    private final String text;
    private final boolean is_done;

    public Todo(int id, String text, boolean is_done) {
        this.id = id;
        this.text = text;
        this.is_done = is_done;
    }

    public String getText() {
        return text;
    }
    
    public int getId() {
        return id;
    }
}
