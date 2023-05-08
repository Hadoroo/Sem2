public class Persegi extends BangunDatar {
    double sisi;

    public Persegi (double sisi){
        this.sisi = sisi;
    }

    public double luas(){
        return sisi * sisi;
    }
    
    public double keliling(){
        return sisi*4;
    }
}
