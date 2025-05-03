/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;

/**
 *
 * @author Fadil
 */
public class Penyewa {
    private int id;
    private String nama;
    private String kontak;
    
    public Penyewa(int id, String nama, String kontak) {
        this.id = id;
        this.nama = nama;
        this.kontak = kontak;
    }
    
    // Encapsulation
    public int getId() {
        return id;
    }
    
    public String getNama() {
        return nama;
    }
    
    public String getKontak() {
        return kontak;
    }
    
    public void displayInfo() {
        System.out.println("ID Penyewa: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Kontak: " + kontak);
    }
}
