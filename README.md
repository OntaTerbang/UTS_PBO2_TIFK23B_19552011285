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
<p>Inheritance memungkinkan kelas anak mewarisi atribut dan method dari kelas induk. Pada proyek ini:
<ul>
  <li>
    
`Aset` adalah kelas abstrak induk.
</li>
<li>
  
`Properti` mewarisi dari Aset.
</li>
<li>
  
`Rumah` dan `Apartemen` mewarisi dari `Properti`.
</li>
</ul>
  
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
   <li>Menghindari duplikasi kode (reuse).</li>
  <li>Mempermudah ekspansi dan pengelolaan tipe properti baru.</li>
  <li>Meningkatkan struktur dan organisasi kode.</li>
</ul>
</p>

### 2. Encapsulation (Enkapsulasi)
<p>Encapsulation menyembunyikan data dan hanya mengizinkan akses melalui getter dan setter. Pada proyek ini:

<ul>
  <li>
    
Kelas `Penyewa` menyimpan data pribadi (seperti nama dan kontak) secara privat.
</li>
<li>
  
Validasi dilakukan di setter untuk menjaga integritas data.
</li>
</ul>

**Implementasi dalam Aplikasi:**

```java
public class Penyewa {
     private int id;
    private String nama;
    private String kontak;

    public Penyewa(int id, String nama, String kontak) {
        this.id = id;
        setNama(nama);
        setKontak(kontak);
    }

    public Penyewa(int id, String nama, String kontak, boolean skipValidation) {
        this.id = id;
        if (skipValidation) {
            this.nama = nama;
            this.kontak = kontak;
        } else {
            setNama(nama);
            setKontak(kontak);
        }
    }

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
        this.kontak = kontak;
    }

```
**Manfaat:**
<ul>
   <li>Melindungi data sensitif dari akses langsung.</li>
  <li>Memastikan data valid melalui validasi input.</li>
  <li>Mengurangi risiko bug akibat manipulasi langsung terhadap variabel internal.

</li>
</ul>

</p>

### 3. Polymorphism (Polimorfisme)
<p>Polymorphism memungkinkan method yang sama berperilaku berbeda tergantung objeknya. Pada proyek ini:
<ul>
  <li>
    
`hitungPajak()` diimplementasikan secara berbeda di kelas `Rumah` dan `Apartemen`.
</li>
</ul>

  
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
   <li>Mempermudah pengelolaan objek berbeda dalam satu interface umum.</li>
  <li>Memudahkan pengembangan dan integrasi fitur baru.</li>
  <li>Meningkatkan fleksibilitas dan skalabilitas aplikasi.</li>
</ul>
</p>

### 4. Abstract (Abstraksi)
<p>Abstraction menyembunyikan detail implementasi dan hanya menampilkan fungsi penting. Pada proyek ini:
<ul>
  <li>
    
`Aset` mendeklarasikan method abstrak `displayInfo()`.
</li>
<li>
  
Implementasi detail dilakukan di kelas turunannya (`Properti`).
</li>
</ul>

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
  <li>Youtube: <a href="https://youtu.be/QtBo8iv8xhI">Youtube</a></li>
</ul>
