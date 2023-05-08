package StudiKasus;

import StudiKasus.Karyawan.*;

import java.util.List;
import java.util.Scanner;

import StudiKasus.Hewan.*;

public class PetShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Karyawan groomerAdit = new Groomer("Adit","Malang","0801234167","Laki-laki","Groomer",9023459,60000);
        Karyawan dokterApriliano = new DokterHewan("Apriliano","Solo","0808123123","Laki-laki","Dokter Hewan",999999,100000);
        Karyawan dokterGustav = new DokterHewan("Gustav","Nganjuk","08081345438","Laki-laki","Dokter Hewan",9999999,150000);
        Karyawan adminFarel = new Admin("Farel","Rembang","080864768796854","Laki-laki","Admin",9999999);
        Karyawan groomerHadi = new Groomer("Hadi","Jakarta","08084567567","Laki-laki","Groomer",9099999,200000);
        Hewan anjingJaved = new Anjing("001", JenisPerawatan.SUNTIK_VAKSIN,"Apriliano","Raju","Hitam",1998,"Anjing","Buldog");
        Hewan anjingUjang = new Anjing("002", JenisPerawatan.GROOMING, "Hadi", "Sukarjo","Abu-abu",1968,"Anjing","Herder");
        Hewan kucingErvan = new Kucing("003", JenisPerawatan.SUNTIK_ANTI_JAMUR_KULIT,"Gustav","Budi","Orange",1945,"Kucing","Persia");
        Hewan kucingBayu = new Kucing("004", JenisPerawatan.PEMERIKSAAN_RAWAT_JALAN,"Apriliano", "Ayu","Coklat",3000,"Kucing","Anggora");
        Hewan kelinciSalma = new Kelinci("005", JenisPerawatan.SUNTIK_SCABIES,"Gustav", "Sukimin","Putih",2030,"Kelinci","Polandia");

        Karyawan.daftarKaryawan.add(dokterGustav);
        Karyawan.daftarKaryawan.add(dokterApriliano);
        Karyawan.daftarKaryawan.add(adminFarel);
        Karyawan.daftarKaryawan.add(groomerHadi);
        Karyawan.daftarKaryawan.add(groomerAdit);
        Hewan.daftarHewan.add(kelinciSalma);
        Hewan.daftarHewan.add(anjingUjang);
        Hewan.daftarHewan.add(anjingJaved);
        Hewan.daftarHewan.add(kucingErvan);
        Hewan.daftarHewan.add(kucingBayu);   

        DokterHewan dh = new DokterHewan();
        Admin admin = new Admin();
        Groomer groomer = new Groomer();
        admin.cetak();
        dh.cetak();
        groomer.cetak();

        Anjing anjing = new Anjing();
        Kelinci kelinci = new Kelinci();
        Kucing kucing = new Kucing();
        anjing.cetakHewan();
        kucing.cetakHewan();
        kelinci.cetakHewan();

        JenisPerawatan[] perawatan = JenisPerawatan.values();
		String[] enumList = new String[5];
        try {
            for(int i=0; i< perawatan.length; i++){
                enumList[i] = (String.valueOf(perawatan[i]));
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println();
            System.out.println("Tidak dapat menambah Jenis perawatan lagi pada output");
            System.out.println("Berikut adalah Jenis Perawatan");
            System.out.println("Jenis Perawatan:");
            for (int i = 0; i < enumList.length; i++){
                System.out.println(enumList[i]);
            }
        }

    }
}
