
package com.mycompany.kasirproperti;
import com.mycompany.kasirproperti.PenyewaDAO;
import com.mycompany.kasirproperti.PropertiDAO;
import com.mycompany.kasirproperti.TransaksiDAO;
import com.mycompany.kasirproperti.Apartemen;
import com.mycompany.kasirproperti.Penyewa;
import com.mycompany.kasirproperti.Properti;
import com.mycompany.kasirproperti.Rumah;
import com.mycompany.kasirproperti.Transaksi;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Fadil
 */
public class Main {
private static Scanner scanner = new Scanner(System.in);
    private static PropertiDAO propertiDAO = new PropertiDAO();
    private static PenyewaDAO penyewaDAO = new PenyewaDAO();
    private static TransaksiDAO transaksiDAO = new TransaksiDAO();
    
    public static void main(String[] args) {
        boolean running = true;
        
        while (running) {
            System.out.println("\n=== Aplikasi Kasir Properti ===");
            System.out.println("1. Kelola Properti");
            System.out.println("2. Kelola Penyewa");
            System.out.println("3. Kelola Transaksi");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // newline
            
            switch (choice) {
                case 1:
                    kelolaProperti();
                    break;
                case 2:
                    kelolaPenyewa();
                    break;
                case 3:
                    kelolaTransaksi();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        
        System.out.println("Aplikasi selesai. Terima kasih!");
    }
    
    private static void kelolaProperti() {
        boolean back = false;
        
        while (!back) {
            System.out.println("\n=== Kelola Properti ===");
            System.out.println("1. Tambah Properti");
            System.out.println("2. Lihat Daftar Properti");
            System.out.println("3. Kembali");
            System.out.print("Pilih menu: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // newline
            
            switch (choice) {
                case 1:
                    tambahProperti();
                    break;
                case 2:
                    lihatProperti();
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    
    private static void tambahProperti() {
         System.out.println("\n=== Tambah Properti ===");
    System.out.println("1. Rumah");
    System.out.println("2. Apartemen");
    System.out.print("Pilih jenis properti: ");
    int jenis = scanner.nextInt();
    scanner.nextLine(); //newline
    
    System.out.print("Alamat: ");
    String alamat = scanner.nextLine();
    
    System.out.print("Harga Sewa per Bulan: ");
    double hargaSewa = scanner.nextDouble();
    scanner.nextLine(); //newline
    
    Properti properti;
    
    if (jenis == 1) {
        System.out.print("Jumlah Kamar: ");
        int jumlahKamar = scanner.nextInt();
        scanner.nextLine(); //newline
        properti = new Rumah(0, alamat, hargaSewa, jumlahKamar);
    } else if (jenis == 2) {
        System.out.print("Lantai: ");
        int lantai = scanner.nextInt();
        scanner.nextLine(); //newline
        properti = new Apartemen(0, alamat, hargaSewa, lantai);
    } else {
        System.out.println("Jenis tidak valid!");
        return;
    }
        
        propertiDAO.addProperti(properti);
        System.out.println("Properti berhasil ditambahkan!");
    }
    
    private static void lihatProperti() {
        System.out.println("\n=== Daftar Properti ===");
        List<Properti> propertiList = propertiDAO.getAllProperti();
        
        if (propertiList.isEmpty()) {
            System.out.println("Tidak ada properti yang tersedia.");
        } else {
            for (Properti properti : propertiList) {
                properti.displayInfo();
                System.out.println("----------------------");
            }
        }
    }
    
    private static void kelolaPenyewa() {
        boolean back = false;
        
        while (!back) {
            System.out.println("\n=== Kelola Penyewa ===");
            System.out.println("1. Tambah Penyewa");
            System.out.println("2. Lihat Daftar Penyewa");
            System.out.println("3. Hapus Penyewa");
            System.out.println("4. Kembali");
            System.out.print("Pilih menu: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // newline
            
            switch (choice) {
                case 1:
                    tambahPenyewa();
                    break;
                case 2:
                    lihatPenyewa();
                    break;
                case 3:
                    hapusPenyewa();
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    
    private static void tambahPenyewa() {
        while (true) {
        System.out.println("\n=== Tambah Penyewa ===");

        System.out.print("Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Kontak: ");
        String kontak = scanner.nextLine();

        try {
            Penyewa penyewa = new Penyewa(0, nama, kontak);
            penyewaDAO.addPenyewa(penyewa);
            System.out.println("Penyewa berhasil ditambahkan!");
            break;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
    
    private static void lihatPenyewa() {
        System.out.println("\n=== Daftar Penyewa ===");
        List<Penyewa> penyewaList = penyewaDAO.getAllPenyewa();
        
        if (penyewaList.isEmpty()) {
            System.out.println("Tidak ada penyewa yang terdaftar.");
        } else {
            for (Penyewa penyewa : penyewaList) {
                penyewa.displayInfo();
                System.out.println("----------------------");
            }
        }
    }
    
    private static void kelolaTransaksi() {
        boolean back = false;
        
        while (!back) {
            System.out.println("\n=== Kelola Transaksi ===");
            System.out.println("1. Buat Transaksi Sewa");
            System.out.println("2. Lihat Daftar Transaksi");
            System.out.println("3. Hapus Transaksi");
            System.out.println("4. Kembali");
            System.out.print("Pilih menu: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // newline
            
            switch (choice) {
                case 1:
                    buatTransaksi();
                    break;
                case 2:
                    lihatTransaksi();
                    break;
                case 3:
                     hapusTransaksi();
                     break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    
    private static void buatTransaksi() {
        System.out.println("\n=== Buat Transaksi Sewa ===");
        
        // Tampilkan daftar properti
        System.out.println("\nDaftar Properti Tersedia:");
        lihatProperti();
        
        System.out.print("\nPilih ID Properti: ");
        int propertiId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        // Tampilkan daftar penyewa
        System.out.println("\nDaftar Penyewa:");
        lihatPenyewa();
        
        System.out.print("\nPilih ID Penyewa: ");
        int penyewaId = scanner.nextInt();
        scanner.nextLine(); // newline
        
        System.out.print("Durasi Sewa (bulan): ");
        int durasi = scanner.nextInt();
        scanner.nextLine(); // newline
        
        // Dapatkan properti dan penyewa
        Properti properti = propertiDAO.getPropertiById(propertiId);
        Penyewa penyewa = penyewaDAO.getPenyewaById(penyewaId);
        
        if (properti == null || penyewa == null) {
            System.out.println("Properti atau penyewa tidak ditemukan!");
            return;
        }
        
        // Hitung total (harga sewa * durasi + pajak)
        double total = (properti.getHargaSewa() * durasi) + properti.hitungPajak();
        
        // Buat transaksi
        Transaksi transaksi = new Transaksi(0, properti, penyewa, durasi, total);
        transaksiDAO.addTransaksi(transaksi);
        
        System.out.println("\nTransaksi berhasil dibuat!");
        System.out.println("Total Pembayaran: " + total);
        System.out.println("\nDetail Transaksi:");
        transaksi.displayInfo();
    }
    
    private static void lihatTransaksi() {
        System.out.println("\n=== Daftar Transaksi ===");
        List<Transaksi> transaksiList = transaksiDAO.getAllTransaksi();
        
        if (transaksiList.isEmpty()) {
            System.out.println("Tidak ada transaksi yang tercatat.");
        } else {
            for (Transaksi transaksi : transaksiList) {
                transaksi.displayInfo();
                System.out.println("======================");
            }
        }
    }

    private static void hapusPenyewa() {
      System.out.println("\n=== Hapus Penyewa ===");
    lihatPenyewa();

    System.out.print("Masukkan ID penyewa yang ingin dihapus: ");
    int id = scanner.nextInt();
    scanner.nextLine(); // newline

    Penyewa penyewa = penyewaDAO.getPenyewaById(id);
    if (penyewa == null) {
        System.out.println("Penyewa tidak ditemukan.");
        return;
    }

    System.out.print("Yakin ingin menghapus penyewa ini? (y/n): ");
    String confirm = scanner.nextLine();

    if (confirm.equalsIgnoreCase("y")) {
        penyewaDAO.hapusPenyewa(id);
    } else {
        System.out.println("Penghapusan dibatalkan.");
    }
  }

    private static void hapusTransaksi() {
        System.out.println("\n=== Hapus Transaksi ===");
    lihatTransaksi(); 

    System.out.print("Masukkan ID Transaksi yang akan dihapus: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    transaksiDAO.deleteTransaksi(id);
    System.out.println("Transaksi berhasil dihapus.");
    }
}