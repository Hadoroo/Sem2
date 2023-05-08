import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class Swalayan {
    static Scanner sc = new Scanner (System.in);
    static ArrayList <Akun> daftarAkun = new ArrayList<Akun>();
    static ArrayList <Handphone> daftarHp = new ArrayList<Handphone>();
    static DecimalFormat decimalFormat = new DecimalFormat("###,###.00");
    
    static void ui(){
        System.out.println("Selamat datang di Tiny Swalayan. Silahkan pilih menu berikut");
        System.out.println("1. Pembelian\n2. Akun\n9. Keluar");
        System.out.print("Pilihan anda: ");
        int pilihan = sc.nextInt();sc.nextLine();
        switch (pilihan){
            case 1:
                Handphone.beliHp();
                ui();
                break;
            case 2:
                akun();
                ui();
                break;
            case 9:
                System.out.println("Terima kasih sudah berbelanja di Tiny Swalayan");
                System.exit(0);
                break;
            default:
                System.out.println("Tolong berikan input yang valid!");
                ui();
        }
    }
    static void akun(){
        System.out.println("1. Daftar Akun\n2. Cek Akun\n3. Top Up\n4. Tarik Saldo\n0. Kembali");
        System.out.print("Pilihan anda: ");
        int pilihan = sc.nextInt();sc.nextLine();
        switch (pilihan){
            case 1:
                Akun.inputAkun();
                break;
            case 2:
                Akun.cekAkun();
                break;
            case 3:
                Akun.topUp();
                break;
            case 4:
                Akun.tarikSaldo();
                break;
            case 0:
                ui();
                break;
            default:
            System.out.println("Tolong berikan input yang valid!");
                akun();

        }
    }
    
    public static void main(String[] args) {
        Akun akun = new Akun("Hadi","Silver",50000,"000000");
        Handphone hp1 = new Handphone("Aibon 25 Pro Min", 10000000);
        Handphone hp2 = new Handphone("Samsul S3 Ultra", 5000000);
        Handphone hp3 = new Handphone("Opera Pixel 7 Noob", 7000000);
        Handphone hp4 = new Handphone("Pocong X4 Noob", 900000);
        daftarHp.add(hp1);
        daftarHp.add(hp2);
        daftarHp.add(hp3);
        daftarHp.add(hp4);
        daftarAkun.add(akun);
        ui();
    }
}
class Akun{
    static Scanner sc = new Scanner (System.in);
    private String nama;
    public String noPelanggan;
    public String jenisRekening;
    public int min = 10000000;
    public int max = 99999999;
    public int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
    public String noTemp;
    public double saldo;
    public String pin;
    public static boolean blokir;
    public static String tempNoPelanggan;

    public Akun(){

    }
    
    public Akun(String nama, String jenisRekening, double saldo, String pin){
        this.nama = nama;
        this.saldo = saldo;
        this.pin = pin;
        this.jenisRekening = jenisRekening;
        noTemp = String.valueOf(random_int);
        switch (jenisRekening){
            case "Silver":
                this.noPelanggan = "38"+this.noTemp;
                break;
            case "Gold":
                this.noPelanggan = "56"+this.noTemp;
                break;
            case "Platinum":
                this.noPelanggan = "74"+this.noTemp;
                break;
        }  
    }

    static void inputAkun(){
        System.out.print("Silahkan masukkan nama anda: ");
        String nama = sc.nextLine();
        System.out.print("Silahkan masukkan jenis rekening (Silver, Gold, Platinum): ");
        String jenisRekening = sc.nextLine();
        System.out.print("Silahkan masukkan deposit pertama anda (minimal Rp.50.000): ");
        double saldo = sc.nextDouble();sc.nextLine();
        System.out.print("Silahkan masukkan pin anda (isi dengan 6 digit angka): ");
        String pin = sc.nextLine();
        System.out.println();
        Akun akun = new Akun(nama,jenisRekening,saldo,pin);
        Swalayan.daftarAkun.add(akun);
    }

    static void cekAkun(){
        System.out.print("Silahkan masukkan nama anda: ");
        String cekNama = sc.nextLine();
        for (Akun element : Swalayan.daftarAkun){
            if (element.nama.contains(cekNama)){
                boolean Validate = false;
                String cekPin;
                int i = 0;
                do{
                System.out.print("Silahkan masukkan pin anda: ");
                cekPin = sc.nextLine();
                    if (element.pin.contains(cekPin)){
                        Validate = true;
                    }else if (i == 2){
                        System.out.println("Akun anda terblokir");
                        Swalayan.daftarAkun.remove(element);
                        System.out.println();
                        Swalayan.ui();
                        break;
                    }else if (!element.pin.contains(cekPin) && i < 2){
                        System.out.println("Maaf, pin salah. Silahkan coba lagi.");
                    }
                    i++;
                } while (!Validate && i < 3);
                System.out.println("Nama: " + element.nama);
                System.out.println("Nomor Pelanggan: " + element.noPelanggan);
                System.out.println("Saldo: Rp." + Swalayan.decimalFormat.format(element.saldo));
                System.out.println("Apakah anda mau mengganti nama? (y/n)");
                String pilih = sc.nextLine();
                    if (pilih.equalsIgnoreCase("y")){
                        element.setNama();
                        System.out.println("Nama anda telah terganti menjadi: "+element.nama);
                    }else if (pilih.equalsIgnoreCase("n")){
                        break;
                    }
                    System.out.println();
                }
            }
        }

    public void setNama(){
        System.out.print("Silahkan masukkan nama anda: ");
        this.nama = sc.nextLine();
    }

    static void topUp(){
        System.out.print("Silahkan masukkan nomor pelanggan anda: ");
        String cekNoPelanggan = sc.nextLine();
        tempNoPelanggan = cekNoPelanggan;
        for (Akun element : Swalayan.daftarAkun){
            if (element.noPelanggan.contains(cekNoPelanggan)){
                boolean Validate = false;
                String cekPin;
                int i = 0;
                do{
                System.out.print("Silahkan masukkan pin anda: ");
                cekPin = sc.nextLine();
                    if (element.pin.contains(cekPin)){
                        Validate = true;
                    }else if (i == 2){
                        System.out.println("Akun anda terblokir");
                        Swalayan.daftarAkun.remove(element);
                        System.out.println();
                        Swalayan.ui();
                        break;
                    }else if (!element.pin.contains(cekPin) && i < 2){
                        System.out.println("Maaf, pin salah. Silahkan coba lagi.");
                    }
                    i++;
                } while (!Validate && i < 3);
            }else{
                System.out.println("Akun tidak ditemukan, silahkan cek terlebih dahulu nomor pelanggan");
                cekAkun();
                Swalayan.ui();   
                System.out.println();
            }
        }
        for (Akun element : Swalayan.daftarAkun){
            if (element.noPelanggan.contains(tempNoPelanggan)){
                System.out.print("Silahkan masukkan nominal top up: ");
                double topUp = sc.nextDouble();sc.nextLine();
                element.saldo += topUp;
                System.out.println("Saldo anda sekarang adalah: Rp."+ Swalayan.decimalFormat.format(element.saldo));
            }
        }
    }

    static void isiSaldo(Akun akun){
        System.out.print("Silahkan masukkan nominal top up: ");
        double topUp = sc.nextDouble();sc.nextLine();
        akun.saldo += topUp;
        System.out.println("Saldo anda sekarang adalah: Rp."+ Swalayan.decimalFormat.format(akun.saldo));
    }
            
    static void tarikSaldo(){
        System.out.print("Silahkan masukkan nomor pelanggan anda: ");
        String cekNoPelanggan = sc.nextLine();
        tempNoPelanggan = cekNoPelanggan;
        for (Akun element : Swalayan.daftarAkun){
            if (element.noPelanggan.contains(cekNoPelanggan)){
                boolean Validate = false;
                String cekPin;
                int i = 0;
                do{
                System.out.print("Silahkan masukkan pin anda: ");
                cekPin = sc.nextLine();
                    if (element.pin.contains(cekPin)){
                        Validate = true;
                    }else if (i == 2){
                        System.out.println("Akun anda terblokir");
                        Swalayan.daftarAkun.remove(element);
                        System.out.println();
                        Swalayan.ui();
                        break;
                    }else if (!element.pin.contains(cekPin) && i < 2){
                        System.out.println("Maaf, pin salah. Silahkan coba lagi.");
                    }
                    i++;
                } while (!Validate && i < 3);
            }else{
                System.out.println("Akun tidak ditemukan, silahkan cek terlebih dahulu nomor pelanggan");
                cekAkun();
                Swalayan.ui();   
                System.out.println();
            }
        }
        for (Akun element : Swalayan.daftarAkun){
            if (element.noPelanggan.contains(tempNoPelanggan)){
                double tarik;
                boolean inputValid = false;
                do {
                        System.out.print("Silahkan masukkan nominal penarikan: ");
                        tarik = sc.nextDouble(); sc.nextLine();
                    if (element.saldo > tarik && element.saldo - tarik >= 10000) {
                            inputValid = true;
                    } else {
                            System.out.println("Maaf, saldo anda tidak cukup. Silahkan coba lagi.");
                    }
                } while (!inputValid);
    
                    // melakukan penarikan setelah input nominal valid
                    element.saldo -= tarik;
                    System.out.println("Saldo anda sekarang adalah: Rp." + Swalayan.decimalFormat.format(element.saldo));
                    System.out.println();
            }
        }
    }
}

class Handphone{
    static Scanner sc = new Scanner(System.in);
    public String nama;
    public double harga;
    public double saldo;
    public int diskon;

    public Handphone(){

    }
    
    public Handphone(String nama, double harga){
        this.nama = nama;
        this.harga = harga;
    }

    static void beliHp(){
        System.out.print("Silahkan masukkan nomor pelanggan anda: ");
        String cekNoPelanggan = sc.nextLine();
        Akun.tempNoPelanggan = cekNoPelanggan;
        for (Akun element : Swalayan.daftarAkun){
            if (element.noPelanggan.contains(cekNoPelanggan)){
                boolean Validate = false;
                String cekPin;
                int i = 0;
                do{
                System.out.print("Silahkan masukkan pin anda: ");
                cekPin = sc.nextLine();
                    if (element.pin.contains(cekPin)){
                        Validate = true;
                    }else if (i == 2){
                        System.out.println("Akun anda terblokir");
                        Swalayan.daftarAkun.remove(element);
                        System.out.println();
                        Swalayan.ui();
                        break;
                    }else if (!element.pin.contains(cekPin) && i < 2){
                        System.out.println("Maaf, pin salah. Silahkan coba lagi.");
                    }
                    i++;
                } while (!Validate && i < 3);
            }else{
                System.out.println("Akun tidak ditemukan, silahkan cek terlebih dahulu nomor pelanggan");
                Akun.cekAkun();
                Swalayan.ui();   
                System.out.println();
            }
        }
        Handphone.print();
        System.out.print("Silahkan masukkan pilihan anda: ");
        int pilihan = sc.nextInt();sc.nextLine();
        double tempHarga;
        switch (pilihan){
            case 1:
                for (Handphone hp : Swalayan.daftarHp){ 
                    if (hp.nama.contains("Aibon 25 Pro Min")){
                        tempHarga = hp.harga; 
                        for (Akun akun : Swalayan.daftarAkun){
                            if (akun.noPelanggan.contains(Akun.tempNoPelanggan)){
                                if (tempHarga > 1000000){
                                    if (akun.saldo > tempHarga && akun.saldo - tempHarga > 10000 && akun.jenisRekening.equalsIgnoreCase("silver")){
                                        double cashBack = tempHarga*5/100;
                                        akun.saldo = akun.saldo - tempHarga + cashBack;
                                        System.out.println("Selamat anda mendapatkan cash back sebesar: Rp." + Swalayan.decimalFormat.format(cashBack));
                                        System.out.println("Saldo anda sekarang: Rp." + Swalayan.decimalFormat.format(akun.saldo));
                                        System.out.println();
                                    }else if (akun.saldo > tempHarga && akun.saldo - tempHarga > 10000 && akun.jenisRekening.equalsIgnoreCase("gold")){
                                        double cashBack = tempHarga*7/100;
                                        akun.saldo = akun.saldo - tempHarga + cashBack;
                                        System.out.println("Selamat anda mendapatkan cash back sebesar: Rp." + Swalayan.decimalFormat.format(cashBack));
                                        System.out.println("Saldo anda sekarang: Rp." + Swalayan.decimalFormat.format(akun.saldo));
                                        System.out.println();
                                    }else if (akun.saldo > tempHarga && akun.saldo - tempHarga > 10000 && akun.jenisRekening.equalsIgnoreCase("platinum")){
                                        double cashBack = tempHarga*10/100;
                                        akun.saldo = akun.saldo - tempHarga + cashBack;
                                        System.out.println("Selamat anda mendapatkan cash back sebesar: Rp." + Swalayan.decimalFormat.format(cashBack));
                                        System.out.println("Saldo anda sekarang: Rp." + Swalayan.decimalFormat.format(akun.saldo));
                                        System.out.println();
                                    }else if (akun.saldo - tempHarga < 10000 ){
                                        System.out.println("Maaf, saldo anda tidak cukup silahkan top up terlebih dahulu");
                                        System.out.println();
                                        Akun.isiSaldo(akun);
                                        beliHp();
                                    }
                                }else if (tempHarga < 1000000){
                                    if (akun.saldo > tempHarga && akun.saldo - tempHarga > 10000 && akun.jenisRekening.equalsIgnoreCase("silver")){
                                        akun.saldo = akun.saldo - tempHarga;
                                        System.out.println("Saldo anda sekarang: Rp." + Swalayan.decimalFormat.format(akun.saldo));
                                        System.out.println();
                                    }else if (akun.saldo - tempHarga < 10000 ){
                                        System.out.println("Maaf, saldo anda tidak cukup silahkan top up terlebih dahulu");
                                        System.out.println();
                                        Akun.isiSaldo(akun);
                                        beliHp();
                                    }
                                }
                            }
                        }
                    }
                }
            case 2:
                for (Handphone hp : Swalayan.daftarHp){ 
                    if (hp.nama.contains("Samsul S3 Ultra")){
                        tempHarga = hp.harga; 
                        for (Akun akun : Swalayan.daftarAkun){
                            if (akun.noPelanggan.contains(Akun.tempNoPelanggan)){
                                if (tempHarga > 1000000){
                                    if (akun.saldo > tempHarga && akun.saldo - tempHarga > 10000 && akun.jenisRekening.equalsIgnoreCase("silver")){
                                        double cashBack = tempHarga*5/100;
                                        akun.saldo = akun.saldo - tempHarga + cashBack;
                                        System.out.println("Selamat anda mendapatkan cash back sebesar: Rp." + Swalayan.decimalFormat.format(cashBack));
                                        System.out.println("Saldo anda sekarang: Rp." + Swalayan.decimalFormat.format(akun.saldo));
                                        System.out.println();
                                    }else if (akun.saldo > tempHarga && akun.saldo - tempHarga > 10000 && akun.jenisRekening.equalsIgnoreCase("gold")){
                                        double cashBack = tempHarga*7/100;
                                        akun.saldo = akun.saldo - tempHarga + cashBack;
                                        System.out.println("Selamat anda mendapatkan cash back sebesar: Rp." + Swalayan.decimalFormat.format(cashBack));
                                        System.out.println("Saldo anda sekarang: Rp." + Swalayan.decimalFormat.format(akun.saldo));
                                        System.out.println();
                                    }else if (akun.saldo > tempHarga && akun.saldo - tempHarga > 10000 && akun.jenisRekening.equalsIgnoreCase("platinum")){
                                        double cashBack = tempHarga*10/100;
                                        akun.saldo = akun.saldo - tempHarga + cashBack;
                                        System.out.println("Selamat anda mendapatkan cash back sebesar: Rp." + Swalayan.decimalFormat.format(cashBack));
                                        System.out.println("Saldo anda sekarang: Rp." + Swalayan.decimalFormat.format(akun.saldo));
                                        System.out.println();
                                    }else if (akun.saldo - tempHarga < 10000 ){
                                        System.out.println("Maaf, saldo anda tidak cukup silahkan top up terlebih dahulu");
                                        System.out.println();
                                        Akun.isiSaldo(akun);
                                        beliHp();
                                    }
                                }else if (tempHarga < 1000000){
                                    if (akun.saldo > tempHarga && akun.saldo - tempHarga > 10000 && akun.jenisRekening.equalsIgnoreCase("silver")){
                                        akun.saldo = akun.saldo - tempHarga;
                                        System.out.println("Saldo anda sekarang: Rp." + Swalayan.decimalFormat.format(akun.saldo));
                                        System.out.println();
                                    }else if (akun.saldo - tempHarga < 10000 ){
                                        System.out.println("Maaf, saldo anda tidak cukup silahkan top up terlebih dahulu");
                                        System.out.println();
                                        Akun.isiSaldo(akun);
                                        beliHp();
                                    }
                                }
                            }
                        }
                    }
                }
            case 3:
                for (Handphone hp : Swalayan.daftarHp){ 
                    if (hp.nama.contains("Opera Pixel 7 Noob")){
                        tempHarga = hp.harga; 
                        for (Akun akun : Swalayan.daftarAkun){
                            if (akun.noPelanggan.contains(Akun.tempNoPelanggan)){
                                if (tempHarga > 1000000){
                                    if (akun.saldo > tempHarga && akun.saldo - tempHarga > 10000 && akun.jenisRekening.equalsIgnoreCase("silver")){
                                        double cashBack = tempHarga*5/100;
                                        akun.saldo = akun.saldo - tempHarga + cashBack;
                                        System.out.println("Selamat anda mendapatkan cash back sebesar: Rp." + Swalayan.decimalFormat.format(cashBack));
                                        System.out.println("Saldo anda sekarang: Rp." + Swalayan.decimalFormat.format(akun.saldo));
                                        System.out.println();
                                    }else if (akun.saldo > tempHarga && akun.saldo - tempHarga > 10000 && akun.jenisRekening.equalsIgnoreCase("gold")){
                                        double cashBack = tempHarga*7/100;
                                        akun.saldo = akun.saldo - tempHarga + cashBack;
                                        System.out.println("Selamat anda mendapatkan cash back sebesar: Rp." + Swalayan.decimalFormat.format(cashBack));
                                        System.out.println("Saldo anda sekarang: Rp." + Swalayan.decimalFormat.format(akun.saldo));
                                        System.out.println();
                                    }else if (akun.saldo > tempHarga && akun.saldo - tempHarga > 10000 && akun.jenisRekening.equalsIgnoreCase("platinum")){
                                        double cashBack = tempHarga*10/100;
                                        akun.saldo = akun.saldo - tempHarga + cashBack;
                                        System.out.println("Selamat anda mendapatkan cash back sebesar: Rp." + Swalayan.decimalFormat.format(cashBack));
                                        System.out.println("Saldo anda sekarang: Rp." + Swalayan.decimalFormat.format(akun.saldo));
                                        System.out.println();
                                    }else if (akun.saldo - tempHarga < 10000 ){
                                        System.out.println("Maaf, saldo anda tidak cukup silahkan top up terlebih dahulu");
                                        System.out.println();
                                        Akun.isiSaldo(akun);
                                        beliHp();
                                    }
                                }else if (tempHarga < 1000000){
                                    if (akun.saldo > tempHarga && akun.saldo - tempHarga > 10000 && akun.jenisRekening.equalsIgnoreCase("silver")){
                                        akun.saldo = akun.saldo - tempHarga;
                                        System.out.println("Saldo anda sekarang: Rp." + Swalayan.decimalFormat.format(akun.saldo));
                                        System.out.println();
                                    }else if (akun.saldo - tempHarga < 10000 ){
                                        System.out.println("Maaf, saldo anda tidak cukup silahkan top up terlebih dahulu");
                                        System.out.println();
                                        Akun.isiSaldo(akun);
                                        beliHp();
                                    }
                                }
                            }
                        }
                    }
                }
            case 4:
                for (Handphone hp : Swalayan.daftarHp){ 
                    if (hp.nama.contains("Pocong X4 Noob")){
                        tempHarga = hp.harga; 
                        for (Akun akun : Swalayan.daftarAkun){
                            if (akun.noPelanggan.contains(Akun.tempNoPelanggan)){
                                if (tempHarga > 1000000){
                                    if (akun.saldo > tempHarga && akun.saldo - tempHarga > 10000 && akun.jenisRekening.equalsIgnoreCase("silver")){
                                        double cashBack = tempHarga*5/100;
                                        akun.saldo = akun.saldo - tempHarga + cashBack;
                                        System.out.println("Selamat anda mendapatkan cash back sebesar: Rp." + Swalayan.decimalFormat.format(cashBack));
                                        System.out.println("Saldo anda sekarang: Rp." + Swalayan.decimalFormat.format(akun.saldo));
                                        System.out.println();
                                    }else if (akun.saldo > tempHarga && akun.saldo - tempHarga > 10000 && akun.jenisRekening.equalsIgnoreCase("gold")){
                                        double cashBack = tempHarga*7/100;
                                        akun.saldo = akun.saldo - tempHarga + cashBack;
                                        System.out.println("Selamat anda mendapatkan cash back sebesar: Rp." + Swalayan.decimalFormat.format(cashBack));
                                        System.out.println("Saldo anda sekarang: Rp." + Swalayan.decimalFormat.format(akun.saldo));
                                        System.out.println();
                                    }else if (akun.saldo > tempHarga && akun.saldo - tempHarga > 10000 && akun.jenisRekening.equalsIgnoreCase("platinum")){
                                        double cashBack = tempHarga*10/100;
                                        akun.saldo = akun.saldo - tempHarga + cashBack;
                                        System.out.println("Selamat anda mendapatkan cash back sebesar: Rp." + Swalayan.decimalFormat.format(cashBack));
                                        System.out.println("Saldo anda sekarang: Rp." + Swalayan.decimalFormat.format(akun.saldo));
                                        System.out.println();
                                    }else if (akun.saldo - tempHarga < 10000 ){
                                        System.out.println("Maaf, saldo anda tidak cukup silahkan top up terlebih dahulu");
                                        System.out.println();
                                        Akun.isiSaldo(akun);
                                        beliHp();
                                    }
                                }else if (tempHarga < 1000000){
                                    if (akun.saldo > tempHarga && akun.saldo - tempHarga > 10000 && akun.jenisRekening.equalsIgnoreCase("silver")){
                                        akun.saldo = akun.saldo - tempHarga;
                                        System.out.println("Saldo anda sekarang: Rp." + Swalayan.decimalFormat.format(akun.saldo));
                                        System.out.println();
                                    }else if (akun.saldo - tempHarga < 10000 ){
                                        System.out.println("Maaf, saldo anda tidak cukup silahkan top up terlebih dahulu");
                                        System.out.println();
                                        Akun.isiSaldo(akun);
                                        beliHp();
                                    }
                                }
                            }
                        }
                    }
                }
            default:

        }
    }

    static void print(){
        int i =1;
        for (Handphone element : Swalayan.daftarHp){
            System.out.print(i + ". " + element.nama);
            System.out.printf("%s%s", "Harga: Rp.", Swalayan.decimalFormat.format(element.harga));
            System.out.println();
            i++;
        }
    }
}
