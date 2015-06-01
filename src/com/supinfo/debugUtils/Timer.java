/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.debugUtils;

/**
 *
 * @author Aztyu
 */
public class Timer {
    private final long start_time;
    private long last_time;

    public Timer() {
        this.start_time = System.currentTimeMillis();
        this.last_time = this.start_time;
    }
    
    public long sinceStart(){
        long current_time = System.currentTimeMillis();
        last_time = current_time;
        return current_time - start_time;
    }
    
    public long sinceLast(){
        long system = System.currentTimeMillis();
        long time = system - last_time;
        last_time = system;
        return time;
    }
}
