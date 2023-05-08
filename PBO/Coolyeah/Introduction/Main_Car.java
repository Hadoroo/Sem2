public class Main_Car {
    public static void main(String[] args) {

        Car bugatti = new Car("Gold", 999, 9000);
        bugatti.drive();
        System.out.println("Color : " + bugatti.getColor());
        System.out.println("Speed : " + bugatti.getSpeed());
        System.out.println("Power : " + bugatti.getPower());
        Car ferrari = new Car("Brown", 0, 9867);
        ferrari.stop();
        System.out.println("Color : " + ferrari.getColor());
        System.out.println("Speed : " + ferrari.getSpeed());
        System.out.println("Power : " + ferrari.getPower());
    }
}