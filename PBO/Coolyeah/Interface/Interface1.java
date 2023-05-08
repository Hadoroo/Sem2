package Interface;

public interface Interface1 {
    public String printStr1 (String x);
    public String printStr2 (String x);
    default void msg(){
        System.out.println("default method");
    }
    static void start(){
        System.out.println("Mulai pencetakan");
    }
}
