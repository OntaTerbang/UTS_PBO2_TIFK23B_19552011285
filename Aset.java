/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;

/**
 *
 * @author Fadil
 */
public abstract class Aset {
    protected int id;
    
    public Aset(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public abstract void displayInfo();
}
