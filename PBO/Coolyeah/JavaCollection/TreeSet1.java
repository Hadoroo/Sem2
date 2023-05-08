package JavaCollection;

import java.util.*;

public class TreeSet1 {
    public static void main(String[] args) {
        TreeSet<String> al = new TreeSet<String>();
        al.add("Adi");
        al.add("Putra");
        al.add("Tari");
        al.add("Syila");
        Iterator<String> itr = al.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
