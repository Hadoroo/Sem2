public class Car {

    private String color;
    private int speed;
    private int power;
    public Car (String color, int speed, int power){
    this.color = color;
    this.speed = speed;
    this.power = power;
    }

    public void drive(){
        System.out.println("drive");
        System.out.println("drive power " + this.power);
    }
    public void turnRight(){
        System.out.println("turnRight");
    }
    public void turnLeft(){
        System.out.println("turnLeft");
    }
    public void stop(){
        System.out.println("stop");
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void setPower(int power){
        this.power = power;
    }
    public String getColor(){
        return color;
    }
    public int getSpeed(){
        return speed;
    }
    public int getPower(){
        return power;
    }
}
