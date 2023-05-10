import java.text.DecimalFormat;
import java.util.Scanner;

public class Jaket {
    private static boolean member;

    public static void main(String[] args) {
        int jumlah;

        Scanner sc = new Scanner(System.in);

        System.out.println("------------------------------------");
        System.out.println("  Selamat Datang di CV. Labkomdas");
        System.out.println("------------------------------------");
        System.out.println("\t   Rincian Harga");
        System.out.println();
        System.out.println("Bahan A\t\t\t Rp.100.000");
        System.out.println("Bahan B\t\t\t Rp.125.000");
        System.out.println("Bahan C\t\t\t Rp.175.000");
        System.out.println();
        System.out.println("      Beli 9 Dapat 10 Bahan");
        System.out.println("------------------------------------");
        System.out.print("Apakah anda memiliki member?(y/n)");
        String pilihan = sc.nextLine();
        if(pilihan.equalsIgnoreCase("y")){
            setMember(true);;
        }else if (pilihan.equalsIgnoreCase("n")){
            setMember(false);;
        }
        System.out.println(member);
        System.out.print("Silahkan masukkan pesanan anda: ");
        jumlah = sc.nextInt();sc.nextLine();
        kalkulator.pemilihan(jumlah);
        kalkulator.cek();
        kalkulator.hitung();
        kalkulator.print();
    }

    public static boolean isMember() {
        return member;
    }

    public static void setMember(boolean member) {
        Jaket.member = member;
    }
}

final class Harga{
    final private static int hargaA = 100000;
    final private static int hargaB = 125000;
    final private static int hargaC = 175000;
    public static int getHargaA() {
        return hargaA;
    }
    public static int getHargaB() {
        return hargaB;
    }
    public static int getHargaC() {
        return hargaC;
    }
}

class kalkulator{
    static DecimalFormat decimalFormat = new DecimalFormat("###,###.00");
    private static int jumlah;
    private static int jumlahA;
    private static int jumlahB;
    private static int jumlahC;

    private static int jumlahFinalA;
    private static int jumlahFinalB;
    private static int jumlahFinalC;

    private static int hargaA;
    private static int hargaB;
    private static int hargaC;

    private static int hargaDiskonA;
    private static int hargaDiskonB;
    private static int hargaDiskonC;

    private static int hargaFinalA;
    private static int hargaFinalB;
    private static int hargaFinalC;

    private static int hargaTotal;

    static Scanner sc = new Scanner(System.in);

    static void pemilihan(int jumlah){
        setJumlah(jumlah);
        int temp2 = jumlah;
        while (temp2 != 0){
            int temp;
            System.out.println("------------------------------------");
            System.out.print("Berapa Banyak Jaket Dengan Bahan A: ");
            setJumlahA(sc.nextInt());sc.nextLine();
            temp = jumlah;
            temp -= getJumlahA();
            System.out.print("Berapa Banyak Jaket Dengan Bahan B: ");
            setJumlahB(sc.nextInt());sc.nextLine();
            temp -= getJumlahB();
            System.out.print("Berapa Banyak Jaket Dengan Bahan C: ");
            setJumlahC(sc.nextInt());sc.nextLine();
            temp -= getJumlahC();
            System.out.println("------------------------------------");
            if (temp < 0){
                System.out.println("Barang Melebihi Pesanan. Silahkan Input Ulang");
                setJumlahA(0);
                setJumlahB(0);
                setJumlahC(0);
                pemilihan(jumlah);
            }
            if (temp > 0){
                System.out.println("Terdapat Sisa Sebanyak " + temp + " Jaket. Silahkan Ulangi Input Pesanan");
                setJumlahA(0);
                setJumlahB(0);
                setJumlahC(0);
                pemilihan(jumlah);
            }
            temp2 -= getJumlahA() + getJumlahB() + getJumlahC();
        }
    }

    static void cek(){
        System.out.print("Jumlah Jaket\t    :");
        System.out.printf("%15s",jumlah);
        System.out.println();
        System.out.print("Jumlah Jaket Bahan A:");
        System.out.printf("%15s",getJumlahA());
        System.out.println();
        System.out.print("Jumlah Jaket Bahan B:");
        System.out.printf("%15s",getJumlahB());
        System.out.println();
        System.out.print("Jumlah Jaket Bahan C:");
        System.out.printf("%15s",getJumlahC());
        System.out.println();
        System.out.println("------------------------------------");
        System.out.print("Apakah Data di Atas Sudah Benar?(y/n)");
        String pilihan = sc.nextLine();
        if (pilihan.equalsIgnoreCase("n")){
            System.out.print("Apakah Ada Perubahan Jumlah Jaket?(y/n)");
            setJumlahA(0);
            setJumlahB(0);
            setJumlahC(0);
            pilihan = sc.nextLine();
            if (pilihan.equalsIgnoreCase("n")){
                pemilihan(jumlah);
            }else{
                System.out.print("1. Penambahan\n2. Pengurangan\nPilihan anda?(1/2)");
                int pilihan1 = sc.nextInt();sc.nextLine();
                if (pilihan1 == 1){
                    System.out.println("------------------------------------");
                    int tambah = penambahan(jumlah);
                    pemilihan(tambah);
                }else if (pilihan1 == 2){
                    System.out.println("------------------------------------");
                    int kurang = pengurangan(jumlah);
                    pemilihan(kurang);
                }
            }
            cek();
        }
    }

    static int penambahan (int jumlah){
        System.out.print("Silahkan Masukkan Jumlah Jaket: ");
        jumlah = jumlah + sc.nextInt();
        System.out.println("Total Pesanan Jaket: " + jumlah);
        return jumlah;
    }

    static int pengurangan (int jumlah){
        System.out.print("Silahkan Masukkan Jumlah Jaket: ");
        int temp = sc.nextInt();
        if (temp >= jumlah){
            System.out.println("Jaket tidak boleh kurang 0");
            System.out.println("------------------------------------");
            temp = 0;
            return pengurangan(jumlah);
        }
        jumlah = jumlah - temp;
        System.out.println("Total Pesanan Jaket: " + jumlah);
        return jumlah;
    }

    static void hitung(){
        hitungA();
        hitungB();
        hitungC();
        setHargaTotal(getHargaFinalA() + getHargaFinalB() + getHargaFinalC());
    }

    static void hitungA(){
        int gratis = getJumlahA()/10;
        int total = getJumlahA() - gratis;
        setJumlahFinalA(total);
        setHargaA(getJumlahA()*Harga.getHargaA());
        setHargaDiskonA(gratis * Harga.getHargaA());
        setHargaFinalA(total * Harga.getHargaA());
    }

    static void hitungB(){
        int gratis = getJumlahB()/10;
        int total = getJumlahB() - gratis;
        setJumlahFinalB(total);
        setHargaB(getJumlahB()*Harga.getHargaB());
        setHargaDiskonB(gratis * Harga.getHargaB());
        setHargaFinalB(total * Harga.getHargaB());
    }

    static void hitungC(){
        int gratis = getJumlahC()/10;
        int total = getJumlahC() - gratis;
        setJumlahFinalC(total);
        setHargaC(getJumlahC()*Harga.getHargaC());
        setHargaDiskonC(gratis * Harga.getHargaC());
        setHargaFinalC(total * Harga.getHargaC());
    }

    static int hitungDiskon(){
        int diskon = getHargaFinalA() + getHargaFinalB() + getHargaFinalC();
        if (Jaket.isMember() == true){
            diskon = diskon * 10 /100;
            return diskon;
        }else{
            return diskon;
        }
    }

    static void print(){
        int grandTotal;

        System.out.println("------------------------------------");
        System.out.println("Pesanan Jaket\t      " + getJumlah());
        if (getJumlahA() > 0){
            System.out.println("Bahan A\t\t      Rp." + decimalFormat.format(Harga.getHargaA()));
            System.out.printf("x%s\t%17s%s\n", getJumlahA(),"Rp." , decimalFormat.format(getHargaA()));
            System.out.printf("-x%s\t%17s%s\n", getJumlahA()/10,"Rp." , decimalFormat.format(getHargaDiskonA()));
            System.out.printf("x%s\t%17s%s\n", getJumlahFinalA(),"Rp." , decimalFormat.format(getHargaFinalA()));
            System.out.println();
        }
        if (getJumlahB() > 0){
            System.out.println("Bahan B\t\t      Rp." + decimalFormat.format(Harga.getHargaB()));
            System.out.printf("x%s\t%17s%s\n", getJumlahB(),"Rp.", decimalFormat.format(getHargaB()));
            System.out.printf("-x%s\t%17s%s\n", getJumlahB()/10,"Rp." , decimalFormat.format(getHargaDiskonB()));
            System.out.printf("x%s\t%17s%s\n", getJumlahFinalB(),"Rp." , decimalFormat.format(getHargaFinalB()));
            System.out.println();
        }
        if (getJumlahC() > 0){
            System.out.println("Bahan C\t\t      Rp." + decimalFormat.format(Harga.getHargaC()));
            System.out.printf("x%s\t%17s%s\n", getJumlahC(),"Rp.", decimalFormat.format(getHargaC()));
            System.out.printf("-x%s\t%17s%s\n", getJumlahC()/10,"Rp." , decimalFormat.format(getHargaDiskonC()));
            System.out.printf("x%s\t%17s%s\n", getJumlahFinalC(),"Rp." , decimalFormat.format(getHargaFinalC()));
        }
        hitungDiskon();
        System.out.println("------------------------------------");
        System.out.println("Total\t\t      Rp." + decimalFormat.format(getHargaTotal()));
        if (Jaket.isMember() == true){
            System.out.println("Diskon Member 10%     Rp." + decimalFormat.format(hitungDiskon()));
            grandTotal = getHargaTotal() - hitungDiskon();
        }else{
            System.out.println("Diskon Member         Rp.-");
            grandTotal = getHargaTotal();
        }
        System.out.println("Grand Total\t      Rp." + decimalFormat.format(grandTotal));
        System.out.println("------------------------------------");
    }

    public static int getJumlahA() {
        return jumlahA;
    }

    public static void setJumlahA(int jumlahA) {
        kalkulator.jumlahA = jumlahA;
    }

    public static int getJumlahB() {
        return jumlahB;
    }

    public static void setJumlahB(int jumlahB) {
        kalkulator.jumlahB = jumlahB;
    }

    public static int getJumlahC() {
        return jumlahC;
    }

    public static void setJumlahC(int jumlahC) {
        kalkulator.jumlahC = jumlahC;
    }

    public static Scanner getSc() {
        return sc;
    }

    public static void setSc(Scanner sc) {
        kalkulator.sc = sc;
    }

    public static int getHargaA() {
        return hargaA;
    }

    public static void setHargaA(int hargaA) {
        kalkulator.hargaA = hargaA;
    }

    public static int getHargaB() {
        return hargaB;
    }

    public static void setHargaB(int hargaB) {
        kalkulator.hargaB = hargaB;
    }

    public static int getHargaC() {
        return hargaC;
    }

    public static void setHargaC(int hargaC) {
        kalkulator.hargaC = hargaC;
    }

    public static int getJumlah() {
        return jumlah;
    }

    public static void setJumlah(int jumlah) {
        kalkulator.jumlah = jumlah;
    }

    public static int getHargaTotal() {
        return hargaTotal;
    }

    public static void setHargaTotal(int hargaTotal) {
        kalkulator.hargaTotal = hargaTotal;
    }

    public static DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }

    public static void setDecimalFormat(DecimalFormat decimalFormat) {
        kalkulator.decimalFormat = decimalFormat;
    }

    public static int getHargaFinalA() {
        return hargaFinalA;
    }

    public static void setHargaFinalA(int hargaFinalA) {
        kalkulator.hargaFinalA = hargaFinalA;
    }

    public static int getHargaFinalB() {
        return hargaFinalB;
    }

    public static void setHargaFinalB(int hargaFinalB) {
        kalkulator.hargaFinalB = hargaFinalB;
    }

    public static int getHargaFinalC() {
        return hargaFinalC;
    }

    public static void setHargaFinalC(int hargaFinalC) {
        kalkulator.hargaFinalC = hargaFinalC;
    }

    public static int getJumlahFinalA() {
        return jumlahFinalA;
    }

    public static void setJumlahFinalA(int jumlahFinalA) {
        kalkulator.jumlahFinalA = jumlahFinalA;
    }

    public static int getJumlahFinalB() {
        return jumlahFinalB;
    }

    public static void setJumlahFinalB(int jumlahFinalB) {
        kalkulator.jumlahFinalB = jumlahFinalB;
    }

    public static int getJumlahFinalC() {
        return jumlahFinalC;
    }

    public static void setJumlahFinalC(int jumlahFinalC) {
        kalkulator.jumlahFinalC = jumlahFinalC;
    }

    public static int getHargaDiskonA() {
        return hargaDiskonA;
    }

    public static void setHargaDiskonA(int hargaDiskonA) {
        kalkulator.hargaDiskonA = hargaDiskonA;
    }

    public static int getHargaDiskonB() {
        return hargaDiskonB;
    }

    public static void setHargaDiskonB(int hargaDiskonB) {
        kalkulator.hargaDiskonB = hargaDiskonB;
    }

    public static int getHargaDiskonC() {
        return hargaDiskonC;
    }

    public static void setHargaDiskonC(int hargaDiskonC) {
        kalkulator.hargaDiskonC = hargaDiskonC;
    }
}
