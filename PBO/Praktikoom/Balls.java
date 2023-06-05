import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Balls{
    public static void main(String[] args) {
        ArrayList<Pemain> timA = new ArrayList<Pemain>();
        ArrayList<Pemain> timB = new ArrayList<Pemain>();

        timA.add(new Pemain(168, 50));
        timA.add(new Pemain(170, 60));
        timA.add(new Pemain(165, 56));
        timA.add(new Pemain(168, 55));
        timA.add(new Pemain(172, 60));
        timA.add(new Pemain(170, 70));
        timA.add(new Pemain(169, 66));
        timA.add(new Pemain(165, 56));
        timA.add(new Pemain(171, 72));
        timA.add(new Pemain(166, 56));

        timB.add(new Pemain(170, 66));
        timB.add(new Pemain(167, 60));
        timB.add(new Pemain(165, 59));
        timB.add(new Pemain(166, 58));
        timB.add(new Pemain(168, 58));
        timB.add(new Pemain(175, 71));
        timB.add(new Pemain(172, 68));
        timB.add(new Pemain(171, 68));
        timB.add(new Pemain(168, 65));
        timB.add(new Pemain(169, 60));

        System.out.println("Soal 1");
        System.out.println("a. Berdasarkan Tinggi Badannya secara Ascending/menaik dan Descending/menurun ");

        Collections.sort(timA, new Comparator<Pemain>() {
            public int compare(Pemain pemain1, Pemain pemain2) {
                return pemain1.tinggi.compareTo(pemain2.tinggi);
            }
        });

        Collections.sort(timB, new Comparator<Pemain>() {
            public int compare(Pemain pemain1, Pemain pemain2) {
                return pemain1.tinggi.compareTo(pemain2.tinggi);
            }
        });

        int sizeA = timA.size();
        int sizeB = timB.size();
        int maxSize = Math.max(sizeA, sizeB);

        System.out.println("-> Berdasarkan Tinggi dari Rendah ke Tinggi");
        System.out.println("Tim A\t\tTim B");

        for (int i = 0; i < maxSize; i++) {
            if (i < sizeA) {
                Pemain pemainA = timA.get(i);
                System.out.print(pemainA.tinggi + ", " + pemainA.berat);
            }
            System.out.print("\t\t");
            if (i < sizeB) {
                Pemain pemainB = timB.get(i);
                System.out.print(pemainB.tinggi + ", " + pemainB.berat);
            }
            System.out.println();
        }
        System.out.println();

        Collections.sort(timA, new Comparator<Pemain>() {
            public int compare(Pemain pemain1, Pemain pemain2) {
                return pemain2.tinggi.compareTo(pemain1.tinggi);
            }
        });
        
        Collections.sort(timB, new Comparator<Pemain>() {
            public int compare(Pemain pemain1, Pemain pemain2) {
                return pemain2.tinggi.compareTo(pemain1.tinggi);
            }
        });

        System.out.println("-> Berdasarkan Tinggi dari Tinggi ke Rendah");
        System.out.println("Tim A\t\tTim B");

        for (int i = 0; i < maxSize; i++) {
            if (i < sizeA) {
                Pemain pemainA = timA.get(i);
                System.out.print(pemainA.tinggi + ", " + pemainA.berat);
            }
            System.out.print("\t\t");
            if (i < sizeB) {
                Pemain pemainB = timB.get(i);
                System.out.print(pemainB.tinggi + ", " + pemainB.berat);
            }
            System.out.println();
        }
        System.out.println();
        ///////////////////////////////////////////////////////////////

        System.out.println("b. Berdasarkan Berat Badannya secara Ascending/menaik dan Descending/menurun ");

        Collections.sort(timA, new Comparator<Pemain>() {
            public int compare(Pemain pemain1, Pemain pemain2) {
                return pemain1.berat.compareTo(pemain2.berat);
            }
        });

        Collections.sort(timB, new Comparator<Pemain>() {
            public int compare(Pemain pemain1, Pemain pemain2) {
                return pemain1.berat.compareTo(pemain2.berat);
            }
        });

        System.out.println("-> Berdasarkan Berat dari Rendah ke Tinggi");
        System.out.println("Tim A\t\tTim B");

        for (int i = 0; i < maxSize; i++) {
            if (i < sizeA) {
                Pemain pemainA = timA.get(i);
                System.out.print(pemainA.tinggi + ", " + pemainA.berat);
            }
            System.out.print("\t\t");
            if (i < sizeB) {
                Pemain pemainB = timB.get(i);
                System.out.print(pemainB.tinggi + ", " + pemainB.berat);
            }
            System.out.println();
        }
        System.out.println();

        Collections.sort(timA, new Comparator<Pemain>() {
            public int compare(Pemain pemain1, Pemain pemain2) {
                return pemain2.berat.compareTo(pemain1.berat);
            }
        });

        Collections.sort(timB, new Comparator<Pemain>() {
            public int compare(Pemain pemain1, Pemain pemain2) {
                return pemain2.berat.compareTo(pemain1.berat);
            }
        });

        System.out.println("-> Berdasarkan Berat dari Rendah ke Tinggi");
        System.out.println("Tim A\t\tTim B");

        for (int i = 0; i < maxSize; i++) {
            if (i < sizeA) {
                Pemain pemainA = timA.get(i);
                System.out.print(pemainA.tinggi + ", " + pemainA.berat);
            }
            System.out.print("\t\t");
            if (i < sizeB) {
                Pemain pemainB = timB.get(i);
                System.out.print(pemainB.tinggi + ", " + pemainB.berat);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("c. Cari nilai maksimum dan minimum Tinggi Badan dan Berat Badan untuk pemain dari masing-masing tim. ");
        Pemain maxA = new Pemain(0, 0);
        Pemain minA = new Pemain(1000, 1000);
        Pemain maxB = new Pemain(0, 0);
        Pemain minB = new Pemain(1000, 1000);

        for(Pemain a: timA){
            if (maxA.tinggi < a.tinggi){
                maxA = new Pemain (a.tinggi, a.berat);
            }
            if (minA.tinggi > a.tinggi){
                minA = new Pemain (a.tinggi, a.berat);
            }
        }

        for(Pemain b: timB){
            if (maxB.tinggi < b.tinggi){
                maxB = new Pemain (b.tinggi, b.berat);
            }
            if (minB.tinggi > b.tinggi){
                minB = new Pemain (b.tinggi, b.berat);
            }
        }

        System.out.println("-> Tinggi Maksimum");
        System.out.println("Tim A\t\tTim B");
        System.out.println(maxA.tinggi + ", " + maxA.berat + "\t\t" + maxB.tinggi + ", " + maxB.berat);
        System.out.println();
        System.out.println("-> Tinggi Minimum");
        System.out.println("Tim A\t\tTim B");
        System.out.println(minA.tinggi + ", " + minA.berat + "\t\t" + minB.tinggi + ", " + minB.berat);
        System.out.println();

        for(Pemain a: timA){
            if (maxA.berat < a.berat){
                maxA = new Pemain (a.tinggi, a.berat);
            }
            if (minA.berat > a.berat){
                minA = new Pemain (a.tinggi, a.berat);
            }
        }

        for(Pemain b: timB){
            if (maxB.berat < b.berat){
                maxB = new Pemain (b.tinggi, b.berat);
            }
            if (minB.berat > b.berat){
                minB = new Pemain (b.tinggi, b.berat);
            }
        }

        System.out.println("-> Berat Maksimum");
        System.out.println("Tim A\t\tTim B");
        System.out.println(maxA.tinggi + ", " + maxA.berat + "\t\t" + maxB.tinggi + ", " + maxB.berat);
        System.out.println();
        System.out.println("-> Tinggi Minimum");
        System.out.println("Tim A\t\tTim B");
        System.out.println(minA.tinggi + ", " + minA.berat + "\t\t" + minB.tinggi + ", " + minB.berat);
        System.out.println();

        System.out.println("d. Copy seluruh anggota Tim B ke Tim C yang baru dibentuk");

        ArrayList<Pemain> timC = new ArrayList<Pemain>();
        timC.addAll(timB);
        for (Pemain c: timC){
            System.out.println(c.tinggi + ", " + c.berat);
        }
        System.out.println();

        /////////////////////////////////////////////////////////////////////
        Collections.sort(timA, new Comparator<Pemain>() {
            public int compare(Pemain pemain1, Pemain pemain2) {
                return pemain1.berat.compareTo(pemain2.berat);
            }
        });

        Collections.sort(timB, new Comparator<Pemain>() {
            public int compare(Pemain pemain1, Pemain pemain2) {
                return pemain1.berat.compareTo(pemain2.berat);
            }
        });

        System.out.println("Soal 2");
        System.out.println("b. Dari data tim B, dicari jumlah pemain yang mempunyai tinggi badan 168 cm dan 160 cm. ");
        for (Pemain b: timB){
            if (b.tinggi == 168 || b.tinggi == 160){
                System.out.println(b.tinggi + ", "  + b.berat);
            }
        }
        System.out.println(cariTinggi(timB, 168) + cariTinggi(timB, 160) + " orang");
        System.out.println();

        System.out.println("c. Dari data tim A, dicari jumlah pemain yang mempunyai berat badan 56 kg dan 53 kg. ");
        
        for (Pemain a: timA){
            if (a.berat == 56 || a.berat == 53){
                System.out.println(a.tinggi + ", " + a.berat);
            }
        }
        System.out.println(cariBerat(timA, 53) + cariBerat(timA, 56) + " orang");
        System.out.println();

        System.out.println("d. Ingin diketahui apakah pemain di Tim A ada yang mempunyai tinggi badan atau berat badan yang sama dengan pemain di Tim B?");
        System.out.println("Tim A\t\tTim B");
        
        for(Pemain a: timA){
            for(Pemain b: timB){
                if (a.tinggi.equals(b.tinggi)){
                    System.out.println("\033[4m" + a.tinggi + "\033[0m" + ", " + a.berat + "\t\t" + "\033[4m" + b.tinggi + "\033[0m" + ", " + b.berat);
                }
                if (a.berat.equals(b.berat)){
                    System.out.println(a.tinggi + ", " + "\033[4m" + a.berat + "\033[0m" + "\t\t" + b.tinggi + ", " + "\033[4m" + b.berat  + "\033[0m");
                }
            }
        }
    }

    static int cariTinggi(ArrayList<Pemain> data, int key) {
        Collections.sort(data, Comparator.comparingInt(Pemain::getTinggi));
        int firstIndex = Collections.binarySearch(data, new Pemain(key, -1), Comparator.comparingInt(p -> p.tinggi));
        int lastIndex = firstIndex;
        if (firstIndex >= 0) {
            while (firstIndex > 0 && data.get(firstIndex - 1).tinggi == key) {
                firstIndex--;
            }
            while (lastIndex < data.size() - 1 && data.get(lastIndex + 1).tinggi == key) {
                lastIndex++;
            }
    
            int count = lastIndex - firstIndex + 1;
            return count;
        } else {
            return 0;
        }
    }

    static int cariBerat(ArrayList<Pemain> data, int key) {
        Collections.sort(data, Comparator.comparingInt(Pemain::getBerat));
        int firstIndex = Collections.binarySearch(data, new Pemain(-1, key), Comparator.comparingInt(p -> p.berat));
        int lastIndex = firstIndex;
        if (firstIndex >= 0) {
            while (firstIndex > 0 && data.get(firstIndex - 1).berat == key) {
                firstIndex--;
            }
            while (lastIndex < data.size() - 1 && data.get(lastIndex + 1).berat == key) {
                lastIndex++;
            }
    
            int count = lastIndex - firstIndex + 1;
            return count;
        } else {
           return 0;
        }
    }
    
}

class Pemain {
    Integer berat;
    Integer tinggi;

    public Pemain(Integer tinggi, Integer berat){
        this.tinggi = tinggi;
        this.berat = berat;
    }

    public Integer getBerat() {
        return berat;
    }

    public Integer getTinggi() {
        return tinggi;
    }
}