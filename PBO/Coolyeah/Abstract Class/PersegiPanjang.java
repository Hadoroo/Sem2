public class PersegiPanjang extends BangunDatar{
    double sisi;

    public PersegiPanjang (double sisi){
        this.sisi = sisi;
    }

    public double luas(){
        return sisi * sisi;
    }
    
    public double keliling(){
        return sisi*4;
    }
}
