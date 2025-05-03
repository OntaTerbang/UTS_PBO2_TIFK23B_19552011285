/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;

/**
 *
 * @author Fadil
 */
public class Apartemen extends Properti {
    private int lantai;
    
    public Apartemen(int id, String alamat, double hargaSewa, int lantai) {
        super(id, "Apartemen", alamat, hargaSewa);
        this.lantai = lantai;
    }
    
    public int getLantai() {
        return lantai;
    }
    
    // Implementasi polymorphism
    @Override
    public double hitungPajak() {
        return hargaSewa * 0.15; // Pajak 15% dari harga sewa
    }
    
    @Override
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Jenis: " + jenis);
        System.out.println("Alamat: " + alamat);
        System.out.println("Harga Sewa: " + hargaSewa);
        System.out.println("Lantai: " + lantai);
        System.out.println("Pajak: " + hitungPajak());
    }
}