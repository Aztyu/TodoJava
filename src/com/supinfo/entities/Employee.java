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
public class Employee {
    private final int id;
    private final String login;
    private final String password;

    public Employee(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }
    
    public String getLogin(){
        return login;
                
    }
}
