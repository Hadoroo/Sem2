import java.util.*;

public class Setring {
    public static void main(String[] args) {
        String kalimat = "Saya belajar bahasa Java. Bahasa Java mempunyai kelas berupa String. Belajar String Java itu mudah. String Java juga sering diimplementasikan";
        String batas = ". ";
        StringTokenizer strToken = new StringTokenizer(kalimat, batas);
        Map<String, Integer> list = new LinkedHashMap<>();
        while(strToken.hasMoreTokens()){
            String token = strToken.nextToken().toLowerCase();
            if(!list.containsKey(token)){
                list.put(token, 1);
            }
            else{
                int frekuensi = list.get(token);
                list.put(token, ++frekuensi);
            }
        }
        System.out.println("-----------------------------------------");
        System.out.println("\tToken\t    |\t  Frekuensi");
        System.out.println("-----------------------------------------");
        for (Map.Entry<String, Integer> entry : list.entrySet()) {
            String token = entry.getKey();
            int frekuensi = entry.getValue(); 
            System.out.printf("%-2s%-18s%-10s%-10d%s\n","|", token,"|", frekuensi, "|");
        }
        System.out.println("-----------------------------------------");
    }
}



