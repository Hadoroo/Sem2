// import java.util.Scanner;
// import java.text.DecimalFormat;

// public class perpus2 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner (System.in);
//         int jumlahKategori;
//         String kategori;
//         int jumlahBuku;
//         int totalBuku = 0;
        
//         System.out.print("Silahkan input jumlah kategori buku yang ingin diinput: ");
//         jumlahKategori = sc.nextInt();
//         int [] totalKategori = new int[jumlahKategori];
//         String[] namaKategori = new String[jumlahKategori];
//         System.out.println("Silahkan input nama kategori beserta jumlah bukunya (contoh: Filsafat 2): ");
//         for (int i = 0; i < jumlahKategori; i++){
//             System.out.print(i+1 +". ");
//             kategori = sc.next();
//             namaKategori[i] = kategori;
//             jumlahBuku = sc.nextInt(); sc.nextLine();
//             totalKategori[i] = jumlahBuku;
//             totalBuku += jumlahBuku;
//             // System.out.println(TambahBuku.totalBuku);
//         }
        
//         TambahBuku[][] Buku = new TambahBuku[jumlahKategori][totalBuku];

//         for (int i = 0; i < jumlahKategori; i++){
//             System.out.println("Kategori " + namaKategori[i] + ": ");
//             for (int j = 0; j < totalKategori[i]; j++){
//                 TambahBuku buku = new TambahBuku();
//                 buku.tambahBuku();
//                 Buku[i][j] = buku;
//                 System.out.println();
//             }
//         }

//         for (int i = 0; i < jumlahKategori; i++){
//             System.out.println("Kategori " + namaKategori[i] + ": ");
//             for (int j = 0; j < totalKategori[i]; j++){
//                 Buku[i][j].print();
//             }
//         }
//     }
// }
// class TambahBuku{
//     public String judul;
//     public String penulis;
//     public String[] pisahPenulis;
//     public String sinopsis;
//     public double harga;
//     public double royalty;
//     DecimalFormat df = new DecimalFormat("###,###.00");

//     public TambahBuku(){

//     }

//     public void tambahBuku(){
//         Scanner sc = new Scanner (System.in);
//             System.out.print("Silahkan input judul buku: ");
//             this.judul = sc.nextLine();
//             System.out.print("Silahkan input nama penulis: ");
//             this.penulis = sc.nextLine();
//             this.pisahPenulis = this.penulis.split(", ");
//             System.out.print("Silahkan input sinopsis: ");   
//             this.sinopsis = sc.nextLine();
//             System.out.print("Silahkan input harga: ");
//             this.harga = sc.nextDouble(); sc.nextLine();
//             System.out.print("Silahkan input total penjualan: ");
//             String input = sc.nextLine();
//             System.out.println("Apakah anda ingin mengganti presentase royalti? y/n (default 10%)");
//             String pilih = sc.nextLine();
//             if (pilih.equalsIgnoreCase("y")){
//                 this.royalty = sc.nextDouble();
//             }else if (pilih.equalsIgnoreCase("n")){
//                 System.out.println("Royalti akan menjadi default yaitu 10%");
//             }
//             String[] penjuDanPese = input.split(" ");
//             double penjualan = Double.parseDouble(penjuDanPese[0]);
//             if (penjuDanPese.length > 1){
//                 double persentase = Double.parseDouble(penjuDanPese[1]);
//                 hitungRoyalty(penjualan,persentase);
//             } else {
//                 hitungRoyalty(penjualan);
//             }
//     }


//     public String perbaikiSinopsis(String sinopsis){
//         String[] kalimat = sinopsis.split("(?<=[.!?])\\s");
//         sinopsis = "";
//         for (int i = 0; i < kalimat.length; i++) {
//             sinopsis += Character.toUpperCase(kalimat[i].charAt(0)) + kalimat[i].substring(1) + " ";
//             System.out.println((kalimat[i].charAt(0)));
//         }
//         return sinopsis;        
//     }

//     public void hitungRoyalty(double penjualan){
//             this.royalty = this.harga * penjualan / 10;
//     }

//     public void hitungRoyalty(double penjualan, double persentase){
//         if (persentase>1) persentase = persentase/100;
//             this.royalty = this.harga * penjualan / persentase;
//     }

//     public void print(){
//         System.out.println("Judul: " + this.judul);
//         System.out.println("Penulis: ");
//         for(int i = 0; i < this.pisahPenulis.length; i++){
//             System.out.println(i+1+". "+this.pisahPenulis[i]);
//         }
//         System.out.println("Sinopsis: "+perbaikiSinopsis(this.sinopsis));
//         System.out.println("Royalti: Rp."+ df.format(royalty));                 
//     }
// }