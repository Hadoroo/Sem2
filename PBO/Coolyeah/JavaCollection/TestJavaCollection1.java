package JavaCollection;

import java.sql.ShardingKeyBuilder;
import java.util.ArrayList;
import java.util.Iterator;

public class TestJavaCollection1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Adi");
        list.add("Putra");
        list.add("Tari");
        list.add("Syila");

        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("Adi");
        list1.add("Putra");
        list1.removeAll(list);

        list.removeAll(list1);
        
        Iterator itr = list.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
