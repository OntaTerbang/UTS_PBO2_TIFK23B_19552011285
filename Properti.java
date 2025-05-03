/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;

/**
 *
 * @author Fadil
 */
public abstract class Properti extends Aset {
    protected String jenis;
    protected String alamat;
    protected double hargaSewa;
    
    public Properti(int id, String jenis, String alamat, double hargaSewa) {
        super(id);
        this.jenis = jenis;
        this.alamat = alamat;
        this.hargaSewa = hargaSewa;
    }
    
    public String getJenis() {
        return jenis;
    }
    
    public String getAlamat() {
        return alamat;
    }
    
    public double getHargaSewa() {
        return hargaSewa;
    }
    
    // Polymorphism
    public abstract double hitungPajak();
    
    @Override
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Jenis: " + jenis);
        System.out.println("Alamat: " + alamat);
        System.out.println("Harga Sewa: " + hargaSewa);
    }
}