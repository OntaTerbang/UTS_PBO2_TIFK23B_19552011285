/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirproperti;
import com.mycompany.kasirproperti.Apartemen;
import com.mycompany.kasirproperti.Properti;
import com.mycompany.kasirproperti.Rumah;
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
public class PropertiDAO {
    private Connection connection;
    
    public PropertiDAO() {
        connection = DatabaseConnection.getConnection();
    }
    
     public void addProperti(Properti properti) {
        try {
            String query = "INSERT INTO properti (jenis, alamat, harga_sewa, jumlah_kamar, lantai) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, properti.getJenis());
            ps.setString(2, properti.getAlamat());
            ps.setDouble(3, properti.getHargaSewa());
            
            if (properti instanceof Rumah) {
                ps.setInt(4, ((Rumah)properti).getJumlahKamar());
                ps.setNull(5, java.sql.Types.INTEGER);
            } else if (properti instanceof Apartemen) {
                ps.setNull(4, java.sql.Types.INTEGER);
                ps.setInt(5, ((Apartemen)properti).getLantai());
            } else {
                ps.setNull(4, java.sql.Types.INTEGER);
                ps.setNull(5, java.sql.Types.INTEGER);
            }
            
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Properti> getAllProperti() {
        List<Properti> propertiList = new ArrayList<>();
        try {
            String query = "SELECT * FROM properti";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String jenis = rs.getString("jenis");
                String alamat = rs.getString("alamat");
                double hargaSewa = rs.getDouble("harga_sewa");
                
                if (jenis.equalsIgnoreCase("Rumah")) {
                    int jumlahKamar = rs.getInt("jumlah_kamar");
                    propertiList.add(new Rumah(id, alamat, hargaSewa, jumlahKamar));
                } else if (jenis.equalsIgnoreCase("Apartemen")) {
                    int lantai = rs.getInt("lantai");
                    propertiList.add(new Apartemen(id, alamat, hargaSewa, lantai));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return propertiList;
    }
    
    public Properti getPropertiById(int id) {
        Properti properti = null;
        try {
            String query = "SELECT * FROM properti WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String jenis = rs.getString("jenis");
                String alamat = rs.getString("alamat");
                double hargaSewa = rs.getDouble("harga_sewa");
                
                if (jenis.equalsIgnoreCase("Rumah")) {
                    int jumlahKamar = rs.getInt("jumlah_kamar");
                    properti = new Rumah(id, alamat, hargaSewa, jumlahKamar);
                } else if (jenis.equalsIgnoreCase("Apartemen")) {
                    int lantai = rs.getInt("lantai");
                    properti = new Apartemen(id, alamat, hargaSewa, lantai);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return properti;
    }
    public void deleteProperti(int id) {
        try {
            String query = "DELETE FROM properti WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Properti berhasil dihapus.");
            } else {
                System.out.println("Properti dengan ID tersebut tidak ditemukan.");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menghapus properti: " + e.getMessage());
        }
    }
}
