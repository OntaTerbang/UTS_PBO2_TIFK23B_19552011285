/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;
import com.mycompany.kasirproperti.Transaksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Fadil
 */
public class TransaksiDAO {
    private Connection connection;
    private PropertiDAO propertiDAO;
    private PenyewaDAO penyewaDAO;
    
    public TransaksiDAO() {
        connection = DatabaseConnection.getConnection();
        propertiDAO = new PropertiDAO();
        penyewaDAO = new PenyewaDAO();
    }
    
    public void addTransaksi(Transaksi transaksi) {
        try {
            String query = "INSERT INTO transaksi (properti_id, penyewa_id, durasi, total) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, transaksi.getProperti().getId());
            ps.setInt(2, transaksi.getPenyewa().getId());
            ps.setInt(3, transaksi.getDurasi());
            ps.setDouble(4, transaksi.getTotal());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Transaksi> getAllTransaksi() {
        List<Transaksi> transaksiList = new ArrayList<>();
        try {
            String query = "SELECT * FROM transaksi";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int propertiId = rs.getInt("properti_id");
                int penyewaId = rs.getInt("penyewa_id");
                int durasi = rs.getInt("durasi");
                double total = rs.getDouble("total");
                LocalDate tanggal = rs.getDate("tanggal").toLocalDate();

                Transaksi transaksi = new Transaksi(
                    id, 
                    propertiDAO.getPropertiById(propertiId), 
                    penyewaDAO.getPenyewaById(penyewaId), 
                    durasi, 
                    total
                );
                transaksiList.add(transaksi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaksiList;
    }
     public void deleteTransaksi(int id) {
        try {
        String query = "DELETE FROM transaksi WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        int rowsAffected = ps.executeUpdate();
        
        if (rowsAffected == 0) {
            System.out.println("Transaksi dengan ID tersebut tidak ditemukan.");
        }
    } catch (SQLException e) {
        System.out.println("Gagal menghapus transaksi: " + e.getMessage());
        }
    }
}
