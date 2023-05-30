package Tugas;

public class Tugas2 {
    static double hasil;
    public static void main(String[] args) {
        soalA(3, 4);
        soalB(2, 5);
    }

    static void soalA(double x, double y) {
        for (int i = 1; i <= 10; i++) {
            hasil += Math.log10(i);
        }
        System.out.println(hasil + Math.sin(y) + Math.cos(x));
    }

    static void soalB(double x, double y) {
        x = Math.pow(x, 5);
        y = Math.pow(y, 3);
        hasil = Math.sqrt(x*(1/y));
        System.out.println(hasil);
    }
}
