/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;

/**
 *
 * @author Fadil
 */
public class Rumah extends Properti {
    private int jumlahKamar;
    
    public Rumah(int id, String alamat, double hargaSewa, int jumlahKamar) {
        super(id, "Rumah", alamat, hargaSewa);
        this.jumlahKamar = jumlahKamar;
    }
    
    public int getJumlahKamar() {
        return jumlahKamar;
    }
    
    // Implementasi polymorphism
    @Override
    public double hitungPajak() {
        return hargaSewa * 0.1; // Pajak 10% dari harga sewa
    }
    
    @Override
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Jenis: " + jenis);
        System.out.println("Alamat: " + alamat);
        System.out.println("Harga Sewa: " + hargaSewa);
        System.out.println("Jumlah Kamar: " + jumlahKamar);
        System.out.println("Pajak: " + hitungPajak());
    }
}
