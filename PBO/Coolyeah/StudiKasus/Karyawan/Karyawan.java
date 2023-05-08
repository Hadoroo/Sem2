package StudiKasus.Karyawan;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Karyawan{
    DecimalFormat decimalFormat = new DecimalFormat("###,###.00");
    private String nama;
    private String alamat;
    private String telepon;
    private String jenisKelamin;
    private String kategoriKaryawan;
    private int gaji;

    public static ArrayList <Karyawan> daftarKaryawan = new ArrayList<Karyawan>();

    public Karyawan(){
    }
    
    public Karyawan(String nama, String alamat, String telepon, String jenisKelamin, String kategoriKaryawan, int gaji){
        this.nama = nama;
        this.alamat = alamat;
        this.telepon = telepon;
        this.jenisKelamin = jenisKelamin;
        this.kategoriKaryawan = kategoriKaryawan;
        this.gaji = gaji;
    }                              

    public String getNama(){
        return nama;
    }

    public String getAlamat(){
        return alamat;
    }

    public String getTelepon(){
        return telepon;
    }

    public String getJenisKelamin(){
        return jenisKelamin;
    }

    public String getKategoriKaryawan(){
        return kategoriKaryawan;
    }

    public int getGaji(){
        return gaji;
    }
}
