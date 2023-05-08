package Enum;

public class Cofee {
    private Size size;
    public Cofee (Size size){
        this.size = size;
    }

    public double getPrice(){
        switch (size){
            case SMALL: return 20.0;
            case MEDIUM: return 30.0;
            case LAGRE: return 40.0;
            default: return 0;
        }
    }
}
