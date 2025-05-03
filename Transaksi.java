/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;
import java.time.LocalDate;
/**
 *
 * @author Fadil
 */
public class Transaksi {
    private int id;
    private Properti properti;
    private Penyewa penyewa;
    private int durasi; // dalam bulan
    private double total;
    private LocalDate tanggalTransaksi;
    
    public Transaksi(int id, Properti properti, Penyewa penyewa, int durasi, double total) {
        this.id = id;
        this.properti = properti;
        this.penyewa = penyewa;
        this.durasi = durasi;
        this.total = total;
        this.tanggalTransaksi = LocalDate.now();
    }
    
    // Encapsulation
    public int getId() {
        return id;
    }
    
    public Properti getProperti() {
        return properti;
    }
    
    public Penyewa getPenyewa() {
        return penyewa;
    }
    
    public int getDurasi() {
        return durasi;
    }
    
    public double getTotal() {
        return total;
    }
    
    public LocalDate getTanggalTransaksi() {
        return tanggalTransaksi;
    }
    
    public void displayInfo() {
        System.out.println("ID Transaksi: " + id);
        System.out.println("Tanggal: " + tanggalTransaksi);
        System.out.println("Durasi (bulan): " + durasi);
        System.out.println("Total: " + total);
        System.out.println("\nDetail Properti:");
        properti.displayInfo();
        System.out.println("\nDetail Penyewa:");
        penyewa.displayInfo();
    }
}
