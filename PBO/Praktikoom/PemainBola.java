import java.util.*;
public class PemainBola {
    public static void main(String[] args) {
        HashMap<Integer, Pemain> timA = new HashMap<Integer, Pemain>();
        HashMap<Integer, Pemain> timB = new HashMap<Integer, Pemain>();

        timA.put(1, new Pemain(168, 50));
        timA.put(2, new Pemain(170, 60));
        timA.put(3, new Pemain(165, 56));
        timA.put(4, new Pemain(168, 55));
        timA.put(5, new Pemain(172, 60));
        timA.put(6, new Pemain(170, 70));
        timA.put(7, new Pemain(169, 66));
        timA.put(8, new Pemain(165, 56));
        timA.put(9, new Pemain(171, 72));
        timA.put(10, new Pemain(166, 56));

        timB.put(1, new Pemain(170, 66));
        timB.put(2, new Pemain(167, 60));
        timB.put(3, new Pemain(165, 59));
        timB.put(4, new Pemain(166, 58));
        timB.put(5, new Pemain(168, 58));
        timB.put(6, new Pemain(175, 71));
        timB.put(7, new Pemain(172, 68));
        timB.put(8, new Pemain(171, 68));
        timB.put(9, new Pemain(168, 65));
        timB.put(10, new Pemain(169, 60));

        System.out.println("Soal 1");
        System.out.println("a. Yang mempunyai tinggi badan sama");
        System.out.println("TIM A\t\tTIM B");
        for (Integer i : timA.keySet()){
            for (Integer j : timB.keySet()) {
                if (timA.get(i).tinggi.equals(timB.get(j).tinggi)){
                    System.out.println(timA.get(i).tinggi + ", " + timA.get(i).berat + "\t\t" + timB.get(j).tinggi + ", " + timB.get(j).berat);
                    
                }
            }
        }

        System.out.println();
        System.out.println("b. Yang mempunyai berat badan sama");
        System.out.println("TIM A\t\tTIM B");
        for (Integer i : timA.keySet()){
            for (Integer j : timB.keySet()) {
                if (timA.get(i).berat.equals(timB.get(j).berat)){
                    System.out.println(timA.get(i).tinggi + ", " + timA.get(i).berat + "\t\t" + timB.get(j).tinggi + ", " + timB.get(j).berat);
                    
                }
            }
        }

        System.out.println();
        System.out.println("c. Rentang nilai dari tinggi badan kedua tim");
        System.out.println("TIM A\t\tTIM B");
        int minA = 1000;
        int maxA = 0;
        int minB = 1000;
        int maxB = 0;
        for (Integer i : timA.keySet()){
            if (timA.get(i).tinggi > maxA){
                maxA = timA.get(i).tinggi;
            }
            if (timA.get(i).tinggi < minA){
                minA = timA.get(i).tinggi;
            }
        }
        for (Integer i : timB.keySet()) {
            if (timB.get(i).tinggi > maxB){
                maxB = timB.get(i).tinggi;
            }
            if (timB.get(i).tinggi < minB){
                minB = timB.get(i).tinggi;
            }
        }
        System.out.println(minA + "-" + maxA + "\t\t" + minB + "-" + maxB);

        System.out.println();
        System.out.println("d. Rentang nilai dari berat badan kedua tim");
        System.out.println("TIM A\t\tTIM B");
        minA = 1000;
        maxA = 0;
        minB = 1000;
        maxB = 0;
        for (Integer i : timA.keySet()){
            if (timA.get(i).berat > maxA){
                maxA = timA.get(i).berat;
            }
            if (timA.get(i).berat < minA){
                minA = timA.get(i).berat;
            }
        }
        for (Integer i : timB.keySet()) {
            if (timB.get(i).berat > maxB){
                maxB = timB.get(i).berat;
            }
            if (timB.get(i).berat < minB){
                minB = timB.get(i).berat;
            }
        }
        System.out.println(minA + "-" + maxA + "\t\t" + minB + "-" + maxB);

        System.out.println();
        System.out.println("e. Tinggi badan pada tim A yang tidak ada pada tim B");
        ArrayList<Pemain> timAKom2 = new ArrayList<>(timA.values());
        ArrayList<Pemain> timBKom2 = new ArrayList<>(timB.values());
        ArrayList<Integer> dataATinggi = new ArrayList<>();
        ArrayList<Integer> dataBTinggi = new ArrayList<>();

        for (Pemain data : timAKom2) {
            dataATinggi.add(data.tinggi);
        }
        for (Pemain data : timBKom2) {
            dataBTinggi.add(data.tinggi);
        }
        ArrayList<Integer> komplemenTinggi = new ArrayList<>(dataATinggi);
        komplemenTinggi.removeAll(dataBTinggi);

        if (komplemenTinggi.size() == 0){
            System.out.println("tidak ada tinggi yang berbeda");
        }else{
            for ( int i : komplemenTinggi) {
                System.out.println(i + " ");
            }
        }
    
        System.out.println();
        System.out.println("f. Berat badan pada tim B yang tidak ada pada tim A");

        ArrayList<Integer> dataAberat = new ArrayList<>();
        ArrayList<Integer> dataBberat = new ArrayList<>();
        for (Pemain data : timAKom2) {
            dataAberat.add(data.berat);
        }
        for (Pemain data : timBKom2) {
            dataBberat.add(data.berat);
        }
        
        ArrayList<Integer> komplemenBerat = new ArrayList<>(dataBberat);
        komplemenBerat.removeAll(dataAberat);

        if (komplemenBerat.size() == 0){
            System.out.println("tidak ada berat yang berbeda");
        }else{
            for ( int i : komplemenBerat) {
                System.out.print(i + " ");
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("Soal 2");
        System.out.println("b. Update data");
        System.out.println("data tim b: ");

        for (Integer i: timB.keySet()){
            if (timB.get(i).tinggi.equals(168)){
                timB.replace(i, new Pemain(168, 66));
            }
        }
        for (Integer i: timB.keySet()){
            System.out.println(i + " " + timB.get(i).tinggi + " " + timB.get(i).berat);
        }
        System.out.println();

        System.out.println("c. data tim a yang memiliki tinggi yang sama dengan tim b");
        HashMap<Integer, Pemain> tinggiSama = new HashMap<Integer, Pemain>();
        for (Integer i : timA.keySet()){
            for (Integer j : timB.keySet()) {
                if (timA.get(i).tinggi.equals(timB.get(j).tinggi)){
                    tinggiSama.put(i, new Pemain(timA.get(i).tinggi, timA.get(i).berat));
                    
                }
            }
        }

        for (Integer i : tinggiSama.keySet()) {
            System.out.println(tinggiSama.get(i).tinggi + ", " + tinggiSama.get(i).berat);
        }
        System.out.println();

        System.out.println("d. data tim a yang memiliki tinggi 168 keatas");
        Iterator<Integer> iterator = tinggiSama.keySet().iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (tinggiSama.get(i).tinggi < 168 && tinggiSama.get(i) != null) {
                iterator.remove();
            }
        }
        for (Integer i : tinggiSama.keySet()) {
            System.out.println(tinggiSama.get(i).tinggi + ", " + tinggiSama.get(i).berat);
        }
    }
}

class Pemain{
    Integer tinggi;
    Integer berat;
    public Pemain(int tinggi, int berat){
        this.tinggi = tinggi;
        this.berat = berat;
    }
}

