package Interface;

public class Run {
    public static void main(String[] args) {
    PrintAll print = new PrintAll();
    Interface1.start();
    System.out.println(print.printStr1("Halo!"));
    System.out.println(print.printStr2("Hadi"));
    System.out.println(print.printInt1(1));
    System.out.println(print.printInt2(5));
    print.print();
    print.msg();
    }   
}
