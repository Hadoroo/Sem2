package Tugas;

public class Tugas1 {
    public static void main(String[] args) {
        String kalimat = "Saya belajar bahasa Java. Java adalah salah satu bahasa pemrograman. Belajar Java sangat mudah apabila rajin berlatih. Belajar bahasa JAVA dilakukan seminggu dua kali.";
    
        System.out.println("Jumlah kata 'Java': " + hitungKata(kalimat, "Java"));
        System.out.println("Jumlah kata 'bahasa': " + hitungKata(kalimat, "bahasa"));
        System.out.println("Jumlah kata 'belajar': " + hitungKata(kalimat, "belajar"));
    }

    static int hitungKata(String kalimat, String kata) {
        String[] kataArray = kalimat.split("\\W+"); // Memisahkan kata-kata dengan karakter non-alfanumerik
        int jumlah = 0;
        for (String k : kataArray) {
            if (k.equalsIgnoreCase(kata)) {
                jumlah++;
            }
        }
        return jumlah;
    }
}
