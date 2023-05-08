package Interface;

public class PrintAll implements Interface3{
    public String printStr1(String x){
        return "Cetak String 1: " + x;
    }
    public String printStr2(String x){
        return "Cetak String 2: " + x;
    }
    public String printInt1(int x){
        return "Cetak String 1: " + x;
    }
    public String printInt2(int x){
        return "Cetak String 2: " + x;
    }
    public void print(){
        System.out.println("Semua sudah tercetak");
    }
}
