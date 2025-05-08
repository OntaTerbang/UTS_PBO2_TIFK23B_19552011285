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
        setNama(nama);
        setKontak(kontak);
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

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong.");
        }
        this.nama = nama;
    }

    public void setKontak(String kontak) {
        if (kontak == null || kontak.trim().isEmpty()) {
            throw new IllegalArgumentException("Kontak tidak boleh kosong.");
        }
        if (!kontak.matches("\\d+")) {
            throw new IllegalArgumentException("Kontak hanya boleh angka.");
        }
        if (kontak.length() < 10 || kontak.length() > 13) {
            throw new IllegalArgumentException("Kontak harus terdiri dari 10-13 digit.");
        }
        this.kontak = kontak;
    }

    public void displayInfo() {
        System.out.println("ID Penyewa: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Kontak: " + kontak);
    }
}
