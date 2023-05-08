package StudiKasus.Karyawan;

import StudiKasus.CetakInfo;

public class DokterHewan extends Karyawan implements CetakInfo{
    private int biayaPeriksa;

    public void cetak(){
        System.out.println("Dokter Hewan:");
        for (Karyawan k : daftarKaryawan){
            if (k instanceof DokterHewan){
                System.out.println("Nama\t\t= " + k.getNama());
                System.out.println("Alamat\t\t= " + k.getAlamat());
                System.out.println("Telepon\t\t= " + k.getTelepon());
                System.out.println("Jenis Kelamin\t= " + k.getJenisKelamin());
                System.out.println("Kategori\t= " + k.getKategoriKaryawan());
                System.out.println("Gaji\t\t= Rp." + decimalFormat.format(k.getGaji()));
                System.out.println("Biaya Perawatan\t= Rp." + decimalFormat.format(((DokterHewan) k).getBiayaPeriksa()));
                System.out.println();
            }
        }
        System.out.println("---------------------------------");
    }

    public DokterHewan(){
    }

    public DokterHewan(String nama, String alamat, String telepon, String jenisKelamin, String kategoriKaryawan, int gaji, int biayaPeriksa){
        super(nama,alamat,telepon,jenisKelamin,kategoriKaryawan,gaji);
        this.biayaPeriksa = biayaPeriksa;
    }

    public int getBiayaPeriksa(){
        return biayaPeriksa;
    }
}
