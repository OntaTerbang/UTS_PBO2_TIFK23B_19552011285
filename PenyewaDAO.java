/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;
import com.mycompany.kasirproperti.Penyewa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Fadil
 */
public class PenyewaDAO {
  private Connection connection;
    
    public PenyewaDAO() {
        connection = DatabaseConnection.getConnection();
    }
    
    public void addPenyewa(Penyewa penyewa) {
        try {
            String query = "INSERT INTO penyewa (nama, kontak) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, penyewa.getNama());
            ps.setString(2, penyewa.getKontak());
            ps.executeUpdate();
        } catch (SQLException e) {
           System.out.println("Gagal menambahkan penyewa ke database: " + e.getMessage()); 
        }
    }
    
    public List<Penyewa> getAllPenyewa() {
        List<Penyewa> penyewaList = new ArrayList<>();
        try {
            String query = "SELECT * FROM penyewa";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String kontak = rs.getString("kontak");
                penyewaList.add(new Penyewa(id, nama, kontak, true)); // skip validasi
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return penyewaList;
    }
    
    public Penyewa getPenyewaById(int id) {
        Penyewa penyewa = null;
        try {
            String query = "SELECT * FROM penyewa WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String nama = rs.getString("nama");
                String kontak = rs.getString("kontak");
                penyewa = new Penyewa(id, nama, kontak, true); // skip validasi
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return penyewa;
    }
    
    public void hapusPenyewa(int id) {
        try {
            String query = "DELETE FROM penyewa WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Penyewa berhasil dihapus.");
            } else {
                System.out.println("Penyewa tidak ditemukan.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menghapus penyewa: " + e.getMessage());
        }
    }
}
