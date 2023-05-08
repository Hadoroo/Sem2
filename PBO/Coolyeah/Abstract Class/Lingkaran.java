public class Lingkaran extends BangunDatar{
    double diameter;

     public Lingkaran (double diameter){
        this.diameter = diameter;
     }

     public double luas(){
        return Math.PI * diameter/2 * diameter/2;
     }

     public double keliling(){
        return Math.PI * diameter;
     }
}
