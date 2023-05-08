package StudiKasus.Hewan;

import StudiKasus.CetakInfoHewan;

public class Anjing extends Hewan implements CetakInfoHewan{
    private String rasAnjing;

    public void cetakHewan(){
        System.out.println("         Daftar Hewan:");
        System.out.println("---------------------------------");
        System.out.println("Anjing:");
        for (Hewan h : daftarHewan){
            if (h instanceof Anjing){
                System.out.println("Nomor Pelanggan\t= " + h.getNoPelanggan());
                System.out.println("Nama Hewan\t= " + h.getNamaHewan());
                System.out.println("Warna Hewan\t= " + h.getWarnaHewan());
                System.out.println("Tahun Kelahiran\t= " + h.getTahunKelahiran());
                System.out.println("Species Hewan\t= " + h.getSpeciesHewan());
                System.out.println("Ras\t\t= " + h.getRasAnjing());
                System.out.println();
                System.out.println("Jenis Perawatan\t= " + h.getPerawatan());
                System.out.println("Perawat\t\t= " + h.getKaryawan());
                System.out.println("Total Harga\t= Rp." + decimalFormat.format(h.getHargaPerawatan()));
                System.out.println();
                System.out.println();
            }
        }
        System.out.println("---------------------------------");
    }

    public Anjing(){
    }

    public Anjing(String noPelanggan, JenisPerawatan jenisPerawatan, String karyawan, String namaHewan, String warnaHewan, int tahunKelahiran, String speciesHewan, String rasAnjing){
        super(noPelanggan, jenisPerawatan, karyawan, namaHewan, warnaHewan, tahunKelahiran, speciesHewan);
        this.rasAnjing = rasAnjing;
    }

    public String getRasAnjing(){
        return rasAnjing;
    }
}
