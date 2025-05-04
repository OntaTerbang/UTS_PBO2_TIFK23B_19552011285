# UTS Pemrograman Berorientasi Obyek 2
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: <a href="https://github.com/Muhammad-Ikhwan-Fathulloh">Muhammad Ikhwan Fathulloh</a></li>
</ul>

## Profil
<ul>
  <li>Nama: Fadillah Fajri</li>
  <li>NIM: 19552011285</li>
  <li>Studi Kasus: : 5</li>
</ul>

##  Kasir Properti
<p>Aplikasi Kasir Properti adalah solusi digital untuk mengelola transaksi penyewaan properti secara efisien. Sistem ini dirancang khusus untuk agen properti atau pemilik yang ingin menyederhanakan proses sewa-menyewa, mulai dari pendataan aset, pencatatan penyewa, hingga pembuatan laporan transaksi. Dengan antarmuka yang intuitif, aplikasi ini membantu pengguna menghemat waktu dan mengurangi kesalahan manual dalam pengelolaan properti.</p>

## Penjelasan Studi Kasus Kasir Properti
<p>Studi kasus ini berfokus pada pengembangan sistem kasir untuk penyewaan properti dengan menerapkan prinsip-prinsip Object-Oriented Programming (OOP). Aplikasi mencakup fitur:

  1. Manajemen Properti: Pendataan properti (rumah/apartemen) dengan detail spesifik seperti alamat, harga sewa, dan karakteristik unik (jumlah kamar/lantai).
  2. Manajemen Penyewa: Penyimpanan informasi penyewa beserta kontak dan riwayat transaksi.
  3. Transaksi Sewa: Pembuatan kontrak sewa, perhitungan otomatis (harga sewa + pajak), dan pelacakan pembayaran.

Dibangun dengan menerapkan  **Inheritance**, **Polymorphism**, **Encapsulation**, dan **Abstraction** pada sistem aplikasi ini, sistem ini mengintegrasikan database MySQL untuk penyimpanan data yang andal.</p>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance (Pewarisan)
<p>Membuat hierarki kelas di mana kelas anak mewarisi atribut/method dari kelas parent.
  
**Implementasi dalam Aplikasi:**

```java
// Kelas Abstrak Induk (Aset)
public abstract class Aset {
    protected int id;  // Atribut umum untuk semua aset
    public abstract void displayInfo();  // Metode abstrak
}

// Kelas Induk Properti (mewarisi Aset)
public abstract class Properti extends Aset {
    protected String alamat;
    protected double hargaSewa;
    // Metode umum untuk semua properti
}

// Kelas Anak (Rumah dan Apartemen)
public class Rumah extends Properti {
    private int jumlahKamar;  // Atribut spesifik Rumah
    // Implementasi metode
}

public class Apartemen extends Properti {
    private int lantai;  // Atribut spesifik Apartemen
    // Implementasi metode
}
```
**Manfaat:**
<ul>
   <li>Efisiensi Kode: Hindari duplikasi kode untuk atribut umum.</li>
  <li>Organisasi Logis: Relasi "is-a" jelas (Rumah adalah Properti, Properti adalah Aset).</li>
</ul>
</p>

### 2. Encapsulation (Enkapsulasi)
<p>Membungkus data dan method terkait dalam satu unit (kelas), dan membatasi akses langsung ke data.

**Implementasi dalam Aplikasi:**

```java
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
```
**Manfaat:**
<ul>
   <li>Kesalahan dicegah: Developer tidak bisa mengubah nama sembarangan tanpa validasi.</li>
  <li>Konsistensi data: Nilai id, nama, dan kontak tetap valid sejak objek dibuat.</li>
</ul>

</p>

### 3. Polymorphism (Polimorfisme)
<p>Kemampuan objek untuk merespon method yang sama dengan cara berbeda.
  
**Implementasi dalam Aplikasi:**
```java
// Metode polymorphic di kelas Properti
public abstract double hitungPajak();

// Override di kelas Rumah
@Override
public double hitungPajak() {
    return hargaSewa * 0.1;  // Pajak 10% untuk Rumah
}

// Override di kelas Apartemen
@Override
public double hitungPajak() {
    return hargaSewa * 0.15;  // Pajak 15% untuk Apartemen
}
```
**Manfaat:**
<ul>
   <li>Fleksibilitas: Logika spesifik tiap jenis properti terpisah.</li>
  <li>Kemudahan Ekstensi: Tambah jenis properti baru tanpa ubah kode utama.</li>
</ul>
</p>

### 4. Abstract (Abstraksi)
<p>Menyembunyikan detail kompleks dan hanya menampilkan fungsionalitas esensial.

**Implementasi dalam Aplikasi:**
```java
public abstract class Aset {
    public abstract void displayInfo(); // Wajib diimplementasikan
}

// Di kelas Properti
@Override
public void displayInfo() {
    System.out.println("Alamat: " + alamat);
    System.out.println("Harga: " + hargaSewa);
}
```
**Manfaat:**
<ul>
   <li>Sederhanakan Kompleksitas: Pengguna cukup tahu "tampilkan info", bukan cara menampilkannya.</li>
  <li>Fleksibilitas: Implementasi bisa berubah tanpa pengaruhi kode pemanggil.</li>
</ul>
</p>

## Demo Proyek
<ul>
  <li>Youtube: <a href="">belom bikin hehe</a></li>
</ul>
