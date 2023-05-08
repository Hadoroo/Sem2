package RecordClass;

public class runRecord {
    public static void main(String[] args) {
        Record r = new Record(4, 5);
        System.out.println(r.toString());
        System.out.println(r.panjang());
        System.out.println(r.lebar());
    }
}
