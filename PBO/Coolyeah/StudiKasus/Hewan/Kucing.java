package StudiKasus.Hewan;

import StudiKasus.CetakInfoHewan;

public class Kucing extends Hewan implements CetakInfoHewan{
    private String rasKucing;

    public void cetakHewan(){
        System.out.println("Kucing:");
        for (Hewan h : daftarHewan){
            if (h instanceof Kucing){
                System.out.println("Nomor Pelanggan\t= " + h.getNoPelanggan());
                System.out.println("Nama Hewan\t= " + h.getNamaHewan());
                System.out.println("Warna Hewan\t= " + h.getWarnaHewan());
                System.out.println("Tahun Kelahiran\t= " + h.getTahunKelahiran());
                System.out.println("Species Hewan\t= " + h.getSpeciesHewan());
                System.out.println("Ras\t\t= " + h.getRasKucing());
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
    
    public Kucing(){
    }

    public Kucing(String noPelanggan, JenisPerawatan jenisPerawatan, String karyawan,  String namaHewan, String warnaHewan, int tahunKelahiran, String speciesHewan, String rasKucing){
        super(noPelanggan, jenisPerawatan, karyawan, namaHewan, warnaHewan, tahunKelahiran, speciesHewan);
        this.rasKucing = rasKucing;
    }

    public String getRasKucing(){
        return rasKucing;
    }
}
