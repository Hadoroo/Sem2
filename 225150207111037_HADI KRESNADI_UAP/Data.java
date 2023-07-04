import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    public static Scanner in = new Scanner(System.in);
    public static ArrayList<Tanaman> tanamans = new ArrayList<Tanaman>();
    public static ArrayList<Integer> lokasi = new ArrayList<Integer>();

    public static void mulai(){
        System.out.print("Masa tanam (bulan) : ");
        int bulan  = in.nextInt(); in.nextLine();
        int hari = bulan * 30;
        System.out.println();

        int jumTanaman = 3;
        for (int i = 0; i < jumTanaman ; i++){
            menanam();
        }

        for (int i = 0; i < hari; i++){
            for (Tanaman t : tanamans){
                if(t.status() != "Mati"){
                    if (t instanceof Tomat){
                        Tomat tomat = (Tomat) t;
                        tomat.berkembang();
                    }else if (t instanceof Stroberi){
                        Stroberi stroberi = (Stroberi) t;
                        stroberi.berkembang();
                    }else if (t instanceof Persik){
                        Persik persik = (Persik) t;
                        persik.berkembang();
                    }
                }else if (t.status() == "Mati"){
                    lokasi.add(tanamans.indexOf(t));
                }

                if (i%90 == 0){
                    if (t instanceof Tomat){
                        Tomat tomat = (Tomat) t;
                        tomat.treatment();
                    }else if (t instanceof Stroberi){
                        Stroberi stroberi = (Stroberi) t;
                        stroberi.treatment();
                    }else if (t instanceof Persik){
                        Persik persik = (Persik) t;
                        persik.treatment();
                    }
                }
            }
        }
    }

    public static void menanam(){
        System.out.println("Mau menanam apa ?\n1. Tomat\n2. Stroberi\n3. Persik");
            int pilihan = in.nextInt(); in.nextLine();

            if (pilihan == 1){
                tanamans.add(new Tomat());
                System.out.println("Tomat berhasil ditanam.");
            }else if (pilihan == 2){
                tanamans.add(new Stroberi());
                System.out.println("Stroberi berhasil ditanam.");
            }else if (pilihan == 3){
                tanamans.add(new Persik());
                System.out.println("Persik berhasil ditanam.");
            }
    }

    public static void info(){
        int angka = 1;
        System.out.println("------HASIL MENANAM------");
        for (Tanaman t : tanamans){
            System.out.println("Tanaman buah ke-" + angka);
            System.out.println(t.toString());
            angka++;
            System.out.println();
        }

    }
}
