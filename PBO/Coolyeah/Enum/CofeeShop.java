package Enum;

public class CofeeShop {
    public static void main(String[] args) {
        Cofee c = new Cofee(Size.SMALL);
        System.out.println(c.getPrice());
    }
}
