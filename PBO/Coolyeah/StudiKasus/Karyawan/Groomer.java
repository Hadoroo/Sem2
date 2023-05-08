package StudiKasus.Karyawan;

import StudiKasus.CetakInfo;

public class Groomer extends Karyawan implements CetakInfo{
    private int biayaPerawatan;

    public void cetak(){
        System.out.println("Groomer:");
        for (Karyawan k : daftarKaryawan){
            if (k instanceof Groomer){
                System.out.println("Nama\t\t= " + k.getNama());
                System.out.println("Alamat\t\t= " + k.getAlamat());
                System.out.println("Telepon\t\t= " + k.getTelepon());
                System.out.println("Jenis Kelamin\t= " + k.getJenisKelamin());
                System.out.println("Kategori\t= " + k.getKategoriKaryawan());
                System.out.println("Gaji\t\t= Rp." + decimalFormat.format(k.getGaji()));
                System.out.println("Biaya Perawatan\t= Rp." + decimalFormat.format(((Groomer) k).getBiayaPerawatan()));
                System.out.println();
            }
        }
        System.out.println("---------------------------------");
    }

    public Groomer(){
    } 

    public Groomer(String nama, String alamat, String telepon, String jenisKelamin, String kategoriKaryawan, int gaji, int biayaPerawatan){
        super(nama,alamat,telepon,jenisKelamin,kategoriKaryawan,gaji);
        this.biayaPerawatan = biayaPerawatan;
    }

    public int getBiayaPerawatan(){
        return this.biayaPerawatan;
    }
}
