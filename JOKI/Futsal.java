import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class AnggotaTim {
    private int tinggiBadan;
    int beratBadan;

    public AnggotaTim(int tinggiBadan, int beratBadan) {
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
    }

    public int getTinggiBadan() {
        return tinggiBadan;
    }

    public int getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(int i) {
    }
}

class Tim {
    private List<AnggotaTim> anggota;

    public Tim() {
        anggota = new ArrayList<>();
    }

    public void tambahAnggota(AnggotaTim anggotaBaru) {
        anggota.add(anggotaBaru);
    }

    public List<AnggotaTim> getAnggota() {
        return anggota;
    }

    public int jumlahAnggota() {
        return anggota.size();
    }

    public int rataRataTinggiBadan() {
        int totalTinggiBadan = 0;
        for (AnggotaTim anggotaTim : anggota) {
            totalTinggiBadan += anggotaTim.getTinggiBadan();
        }
        return totalTinggiBadan / anggota.size();
    }

    public int rataRataBeratBadan() {
        int totalBeratBadan = 0;
        for (AnggotaTim anggotaTim : anggota) {
            totalBeratBadan += anggotaTim.getBeratBadan();
        }
        return totalBeratBadan / anggota.size();
    }

    public boolean containsTinggiBadan(int tinggiBadan) {
        for (AnggotaTim anggotaTim : anggota) {
            if (anggotaTim.getTinggiBadan() == tinggiBadan) {
                return true;
            }
        }
        return false;
    }

    public boolean containsBeratBadan(int beratBadan) {
        for (AnggotaTim anggotaTim : anggota) {
            if (anggotaTim.getBeratBadan() == beratBadan) {
                return true;
            }
        }
        return false;
    }

    public int getMinTinggiBadan() {
        int minTinggiBadan = Integer.MAX_VALUE;
        for (AnggotaTim anggotaTim : anggota) {
            if (anggotaTim.getTinggiBadan() < minTinggiBadan) {
                minTinggiBadan = anggotaTim.getTinggiBadan();
            }
        }
        return minTinggiBadan;
    }

    public int getMaxTinggiBadan() {
        int maxTinggiBadan = Integer.MIN_VALUE;
        for (AnggotaTim anggotaTim : anggota) {
            if (anggotaTim.getTinggiBadan() > maxTinggiBadan) {
                maxTinggiBadan = anggotaTim.getTinggiBadan();
            }
        }
        return maxTinggiBadan;
    }

    public int getMinBeratBadan() {
        int minBeratBadan = Integer.MAX_VALUE;
        for (AnggotaTim anggotaTim : anggota) {
            if (anggotaTim.getBeratBadan() < minBeratBadan) {
                minBeratBadan = anggotaTim.getBeratBadan();
            }
        }
        return minBeratBadan;
    }

    public int getMaxBeratBadan() {
        int maxBeratBadan = Integer.MIN_VALUE;
        for (AnggotaTim anggotaTim : anggota) {
            if (anggotaTim.getBeratBadan() > maxBeratBadan) {
                maxBeratBadan = anggotaTim.getBeratBadan();
            }
        }
        return maxBeratBadan;
    }
}

public class Futsal {
    public static void main(String[] args) {
        // Membuat objek Tim A
        Tim timA = new Tim();

        // Menambahkan anggota ke Tim A
        timA.tambahAnggota(new AnggotaTim(168, 50));
        timA.tambahAnggota(new AnggotaTim(170, 60));
        timA.tambahAnggota(new AnggotaTim(165, 56));
        timA.tambahAnggota(new AnggotaTim(168, 55));
        timA.tambahAnggota(new AnggotaTim(172, 60));
        timA.tambahAnggota(new AnggotaTim(170, 70));
        timA.tambahAnggota(new AnggotaTim(169, 66));
        timA.tambahAnggota(new AnggotaTim(165, 56));
        timA.tambahAnggota(new AnggotaTim(171, 72));
        timA.tambahAnggota(new AnggotaTim(166, 56));

        // Membuat objek Tim B
        Tim timB = new Tim();

        // Menambahkan anggota ke Tim B
        timB.tambahAnggota(new AnggotaTim(170, 66));
        timB.tambahAnggota(new AnggotaTim(167, 60));
        timB.tambahAnggota(new AnggotaTim(165, 59));
        timB.tambahAnggota(new AnggotaTim(166, 58));
        timB.tambahAnggota(new AnggotaTim(168, 58));
        timB.tambahAnggota(new AnggotaTim(175, 71));
        timB.tambahAnggota(new AnggotaTim(172, 68));
        timB.tambahAnggota(new AnggotaTim(171, 68));
        timB.tambahAnggota(new AnggotaTim(168, 65));
        timB.tambahAnggota(new AnggotaTim(169, 60));

        // Soal 1a: Mencari anggota yang mempunyai tinggi badan sama
        System.out.println("SOAL 1");
        System.out.println();
        System.out.println("a. Anggota yang mempunyai tinggi badan sama:");
        System.out.println("Tinggi Badan        TIM A           TIM B");
        for (AnggotaTim anggotaTimA : timA.getAnggota()) {
            for (AnggotaTim anggotaTimB : timB.getAnggota()) {
                if (anggotaTimA.getTinggiBadan() == anggotaTimB.getTinggiBadan()) {
                    System.out.println("    "+ anggotaTimA.getTinggiBadan() + "              " + anggotaTimA.getBeratBadan() + "              " + anggotaTimB.getBeratBadan());
                }
            }
        }


        // Soal 1b: Mencari anggota yang mempunyai berat badan sama
        System.out.println();
        System.out.println("b. Anggota yang mempunyai berat badan sama:");
        System.out.println("Berat Badan        TIM A           TIM B");
        for (AnggotaTim anggotaTimA : timA.getAnggota()) {
            for (AnggotaTim anggotaTimB : timB.getAnggota()) {
                if (anggotaTimA.getBeratBadan() == anggotaTimB.getBeratBadan()) {
                    System.out.println("    " + anggotaTimA.getBeratBadan() + "              " + anggotaTimA.getTinggiBadan() + "              " + anggotaTimB.getTinggiBadan());
                }
            }
        }

        // Soal 1c: Rentang nilai tinggi badan kedua tim
        int minTinggiBadan = Math.min(timA.getMinTinggiBadan(), timB.getMinTinggiBadan());
        int maxTinggiBadan = Math.max(timA.getMaxTinggiBadan(), timB.getMaxTinggiBadan());
        System.out.println();
        System.out.print("c. Rentang nilai tinggi badan kedua tim : ");
        System.out.println(minTinggiBadan + " - " + maxTinggiBadan);

        // Soal 1d: Rentang nilai berat badan kedua tim
        int minBeratBadan = Math.min(timA.getMinBeratBadan(), timB.getMinBeratBadan());
        int maxBeratBadan = Math.max(timA.getMaxBeratBadan(), timB.getMaxBeratBadan());
        System.out.println();
        System.out.println("d. Rentang nilai berat badan kedua tim : " + minBeratBadan + " - " + maxBeratBadan);

        // Soal 1e: Tinggi badan pada tim A yang tidak ada pada tim B
        System.out.println();
        System.out.println("e. Tinggi badan pada tim A yang tidak ada pada tim B:");
        for (AnggotaTim anggotaTimA : timA.getAnggota()) {
            if (!timB.containsTinggiBadan(anggotaTimA.getTinggiBadan())) {
                System.out.println("Tinggi Badan: " + anggotaTimA.getTinggiBadan() + ", Berat Badan: " + anggotaTimA.getBeratBadan());
            }
        }

        // Soal 1f: Berat badan pada tim B yang tidak ada pada tim A
        System.out.println();
        System.out.println("f. Berat badan pada tim B yang tidak ada pada tim A:");
        System.out.println("Berat Badan        Tinggi Badan");

        for (AnggotaTim anggotaTimB : timB.getAnggota()) {
            if (!timA.containsBeratBadan(anggotaTimB.getBeratBadan())) {
                System.out.println("    " + anggotaTimB.getBeratBadan() + "                  " + anggotaTimB.getTinggiBadan());
            }
        }

        
        // Soal 2: Implementasi Map untuk menyimpan data tim A dan tim B
        System.out.println();
        System.out.println("SOAL 2");
        Map<String, Tim> timMap = new HashMap<>();
        timMap.put("Tim A", timA);
        timMap.put("Tim B", timB);

        // Update data Map untuk tim B dengan perubahan berat badan
        timB.getAnggota().get(0).beratBadan = 66;

        // Implementasi Map untuk menyimpan data tinggi badan dan berat badan dari tim A yang tinggi badannya sama dengan tim B
        Map<Integer, Integer> tinggiBeratMap = new HashMap<>();
        for (AnggotaTim anggotaTimA : timA.getAnggota()) {
            for (AnggotaTim anggotaTimB : timB.getAnggota()) {
                if (anggotaTimA.getTinggiBadan() == anggotaTimB.getTinggiBadan()) {
                    tinggiBeratMap.put(anggotaTimA.getTinggiBadan(), anggotaTimA.getBeratBadan());
                }
            }
        }

        // Update data Map sesuai kondisi terakhir
        Map<Integer, Integer> updatedTinggiBeratMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : tinggiBeratMap.entrySet()) {
            if (entry.getKey() >= 168) {
                updatedTinggiBeratMap.put(entry.getKey(), entry.getValue());
            }
        }

        // Update data tim B
        for (AnggotaTim anggotaTimB : timB.getAnggota()) {
            if (anggotaTimB.getTinggiBadan() == 168) {
                anggotaTimB.setBeratBadan(66);
            }
        }


        // Menampilkan data tinggi badan dan berat badan dari tim A yang tinggi badannya sama dengan tim B
        System.out.println("\nc. Data tinggi badan dan berat badan dari tim A yang tinggi badannya sama dengan tim B (setelah perubahan):");
        System.out.println("Tinggi Badan        Berat Badan");
        for (Map.Entry<Integer, Integer> entry : updatedTinggiBeratMap.entrySet()) {
            System.out.println("    " + entry.getKey() + "                 " + entry.getValue());
        }

        
        System.out.println("\nd. Data tim B yang memiliki tinggi 168 keatas");
        System.out.println("Tinggi Badan        Berat Badan");
        for (AnggotaTim anggotaTimA : timA.getAnggota()){
            if (anggotaTimA.getTinggiBadan() >= 168 && anggotaTimA.getTinggiBadan() != 0){
                System.out.println("    " + anggotaTimA.getTinggiBadan() + "                 "  + anggotaTimA.getBeratBadan());
            }
        }
        
    }
}
