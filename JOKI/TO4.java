public class TO4 {
    public static void main(String[] args) {
        Kue kue[] = new Kue[20];
        kue[0] = new KuePesanan ("Brownis",(int)(((Math.random()*(10-1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[1] = new KuePesanan("Bolu",(int)(((Math.random()*(10-1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[2] = new KuePesanan("Kue Sus",(int)(((Math.random()*(10-1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[3] = new KuePesanan("Kue Pisang",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[4] = new KuePesanan("Piscok",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[5] = new KuePesanan("Risol Mayo",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[6] = new KuePesanan("Rainbow Cake",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[7] = new KuePesanan("Oreo Cake",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[8] = new KuePesanan("Tiramissu Cake",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[9] = new KuePesanan("Kue Apem",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[10] = new KueJadi("Kue Binka",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[11] = new KueJadi("Bika Ambon",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[12] = new KueJadi("Bolu Kukus",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[13] = new KueJadi("Kue Cubit",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[14] = new KueJadi("Dadar Gulung",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[15] = new KueJadi("Kue Lumpur",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[16] = new KueJadi("Kue Pukis",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[17] = new KueJadi("Kue Pancong",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[18] = new KueJadi("Kue Putu",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));
        kue[19] = new KueJadi("Klepon",(int)(((Math.random()*(10 - 1)) +1) *1000),(int) (((Math.random() * (20 - 1)) +1) *0.5));

        for(Kue jajan : kue){
            System.out.println(jajan.toString());
        }
        double totalSemua=0;
        for(Kue jajan : kue){
            totalSemua += jajan.hitungHarga();
        }
        double totalHargaPesanan=0;
        for(int i = 0; i < 5; i++){
            totalHargaPesanan += kue[i].hitungHarga();
        }
        double totalBeratPesanan=0;
        for(int i = 0; i < 5; i++){
            totalBeratPesanan += kue[i].Berat();
        }
        double totalHargaJadi=0;
        for(int i = 3; i < 5; i++){
            totalHargaJadi += kue[i].hitungHarga();
        }
        double totalJumlahJadi=0;
        for(int i = 3; i < 5; i++){
            totalJumlahJadi += kue[i].Jumlah();
        }
        System.out.println("----------------------------------");
        System.out.println();
        System.out.println("Total Harga Kue\t\t:"+totalSemua);
        System.out.println("Total Harga Kue Pesanan\t:"+totalHargaPesanan);
        System.out.println("Total Berat Kue Pesanan\t:"+totalBeratPesanan);
        System.out.println("Total Harga Kue Jadi\t:"+totalHargaJadi);
        System.out.println("Total Jumlah Kue Jadi\t:"+totalJumlahJadi);
        double maks = 0;
        for(int i = 0; i < 5; i++){
            maks = Math.max(maks, kue[i].hitungHarga());
        }
        for(int i = 0; i < 5; i++){
            if (maks == kue[i].hitungHarga()){
                System.out.println("Kue Termahal\t\t"+kue[i].getNama());
            }
        }

            
            
        }
}

abstract class Kue{
    private String nama;
    private double harga;

    public Kue (String nama, double harga){
        this.nama = nama;
        this.harga = harga;
    }
    
    abstract public double hitungHarga();
    abstract public double Berat();
    abstract public double Jumlah();

    @Override
    public String toString(){
        return String.format("\n---------- "+getNama()+" ----------"+"\nHarga\t\t:"+getHarga());
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
}

class KuePesanan extends Kue{
    private double berat;

    public double Berat(){
        return getBerat();
    }

    public double Jumlah(){
        return 0;
    }

    public KuePesanan(String nama, double harga, double berat){
        super(nama, harga);
        this.berat = berat;
    }

    public double hitungHarga(){
        return getHarga() * getBerat();
    }

    public double getBerat() {
        return berat;
    }
    public void setBerat(double berat) {
        this.berat = berat;
    }
}

class KueJadi extends Kue{
    private double jumlah;

    public double Berat(){
        return 0;
    }

    public double Jumlah(){
        return getJumlah();
    }

    public KueJadi(String nama, double harga, double jumlah){
        super(nama, harga);
        this.jumlah = jumlah;
    }

    public double hitungHarga(){
        return getHarga() * getJumlah() * 2;
    }
    public double getJumlah() {
        return jumlah;
    }
    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }
    
}


