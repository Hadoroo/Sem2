package StudiKasus.Karyawan;

import java.text.DecimalFormat;

import StudiKasus.CetakInfo;

public class Admin extends Karyawan implements CetakInfo{
    DecimalFormat decimalFormat = new DecimalFormat("###,###.00");

    public void cetak(){
        System.out.println("---------------------------------");
        System.out.println("        Daftar Karyawan:");
        System.out.println("---------------------------------");
        System.out.println("Admin:");
        for (Karyawan k : daftarKaryawan){
            if (k instanceof Admin){
                System.out.println("Nama\t\t= " + k.getNama());
                System.out.println("Alamat\t\t= " + k.getAlamat());
                System.out.println("Telepon\t\t= " + k.getTelepon());
                System.out.println("Jenis Kelamin\t= " + k.getJenisKelamin());
                System.out.println("Kategori\t= " + k.getKategoriKaryawan());
                System.out.println("Gaji\t\t= Rp." + decimalFormat.format(k.getGaji()));
                System.out.println();
            }
        }
        System.out.println("---------------------------------");
    }

    public Admin(){
    }

    public Admin(String nama, String alamat, String telepon, String jenisKelamin, String kategoriKaryawan, int gaji){
        super(nama,alamat,telepon,jenisKelamin,kategoriKaryawan, gaji);
    }
}
