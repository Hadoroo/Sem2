package StudiKasus.Hewan;

import java.text.DecimalFormat;
import java.util.ArrayList;

import StudiKasus.Karyawan.DokterHewan;
import StudiKasus.Karyawan.Groomer;
import StudiKasus.Karyawan.Karyawan;

public class Hewan {
    DecimalFormat decimalFormat = new DecimalFormat("###,###.00");
    private String noPelanggan;
    private String namaHewan;
    private String warnaHewan;
    private int tahunKelahiran;
    private String speciesHewan;
    private JenisPerawatan jenisPerawatan;
    private String karyawan;
    public static ArrayList <Hewan> daftarHewan = new ArrayList<Hewan>();

    public int getHargaPerawatan(){
        int perawatan = 0;
        for (Karyawan k : Karyawan.daftarKaryawan){
            if (k.getNama().equalsIgnoreCase(getKaryawan())){
                if (k.getKategoriKaryawan().equalsIgnoreCase("Groomer")){
                    perawatan = ((Groomer) k).getBiayaPerawatan();
                }else if (k.getKategoriKaryawan().equalsIgnoreCase("Dokter Hewan")){
                    perawatan = ((DokterHewan) k).getBiayaPeriksa();
                }
            }
        }
        switch (jenisPerawatan){
            case SUNTIK_VAKSIN: return 100000 + perawatan;
            case SUNTIK_ANTI_KUTU: return 150000 + perawatan;
            case SUNTIK_SCABIES: return 200000 + perawatan;
            case SUNTIK_ANTI_JAMUR_KULIT: return 250000 + perawatan;
            case PEMERIKSAAN_RAWAT_INAP: return 1000000 + perawatan;
            case PEMERIKSAAN_RAWAT_JALAN: return 500000 + perawatan;
            case GROOMING: return 100000 + perawatan;
            default : return 0;
        }
    }

    public String getPerawatan(){
        switch (jenisPerawatan){
            case SUNTIK_VAKSIN: return "Suntik Vaksin";
            case SUNTIK_ANTI_KUTU: return "Suntik Anti Kutu";
            case SUNTIK_SCABIES: return "Suntik Scabies";
            case SUNTIK_ANTI_JAMUR_KULIT: return "Suntik Anti Jamur Kulit";
            case PEMERIKSAAN_RAWAT_INAP: return "Pemeriksaan Rawat Inap";
            case PEMERIKSAAN_RAWAT_JALAN: return "Pemeriksaan Rawat Jalan";
            case GROOMING: return "Grooming";
            default : return "";
        }
    }

    public Hewan(){
    }

    public Hewan(String noPelanggan, JenisPerawatan jenisPerawatan, String karyawan,String namaHewan, String warnaHewan, int tahunKelahiran, String speciesHewan){
        this.noPelanggan = noPelanggan;
        this.jenisPerawatan = jenisPerawatan;
        this.karyawan = karyawan;
        this.namaHewan = namaHewan;
        this.warnaHewan = warnaHewan;
        this.tahunKelahiran = tahunKelahiran;
        this.speciesHewan = speciesHewan;
    }
    
    public String getNoPelanggan(){
        return noPelanggan;
    }

    public String getKaryawan(){
        return karyawan;
    }

    public String getNamaHewan(){
        return namaHewan;
    }

    public String getWarnaHewan(){
        return warnaHewan;
    }
    
    public int getTahunKelahiran(){
        return tahunKelahiran;
    }

    public String getSpeciesHewan(){
        return speciesHewan;
    }

    public String getRasAnjing() {
        return speciesHewan;
    }

    public String getRasKelinci() {
        return speciesHewan;
    }

    public String getRasKucing() {
        return speciesHewan;
    }
}
