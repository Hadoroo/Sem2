// import java.util.Scanner;
// import java.text.DecimalFormat;

// public class Perpus {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Silahkan input berapa banyak jumlah kategori yang ingin diinput: ");
//         int jumlah = sc.nextInt();
//         Buku Buku[] = new Buku[jumlah];
//         for(int i = 0; i < jumlah; i++){           
//             Buku buku = new Buku();
//             buku.tambahBuku();
//             Buku[i] = buku;
//         }
//         for(int j = 0; j < jumlah; j++){
//             Buku[j].print();
//         } 
//         sc.close();
//     }
// }

// class Buku{
//     public String kategori;
//     public int jumlah;
//     public String[] judul;
//     public String[] penulis;
//     public String[][] isiPenulis;
//     public String[] sinopsis;
//     public double[] harga;
//     public double[] royalti;
//     DecimalFormat df = new DecimalFormat("###,###.00");

//     public static Scanner sc = new Scanner(System.in);

//     public void tambahBuku(){
//         System.out.print("Silahkan input jenis kategori: ");
//         this.kategori = sc.next();
//         System.out.print("Silahkan input jumlah buku yang mau diinput: ");
//         this.jumlah = sc.nextInt(); sc.nextLine();
//         this.judul = new String[this.jumlah];
//         this.isiPenulis = new  String[this.jumlah][];
//         this.penulis = new String[this.jumlah];
//         this.sinopsis = new String[this.jumlah];
//         this.harga = new double[this.jumlah];
//         this.royalti = new double[this.jumlah];
//         for(int i = 0; i < this.jumlah; i++){
//             System.out.print("Silahkan input judul buku: ");
//             this.judul[i] = sc.nextLine();
//             System.out.print("Silahkan input nama penulis: ");
//             this.penulis[i] = sc.nextLine();
//             this.isiPenulis[i] = this.penulis[i].split(", ");     
//             System.out.print("Silahkan input sinopsis: ");   
//             this.sinopsis[i] = sc.nextLine();
//             System.out.print("Silahkan input harga: ");
//             this.harga[i] = sc.nextDouble(); sc.nextLine();
//             System.out.print("Silahkan input penjualan dan persentase (presentase default di 10%, isi presentase dengan angka saja): ");
//             String input = sc.nextLine();
//             // System.out.print("Apakah anda ingin mengganti presentase royalti? y/n (default 10%)");
//             // String pilih = sc.nextLine();
//             // if (pilih.equalsIgnoreCase("y")){
                
//             // }else if (pilih.equalsIgnoreCase("n")){
//             //     break;
//             // }else{
//             //     pilih = sc.nextLine();
//             // }
//             System.out.print("Apakah anda ingin mengganti presentase royalti? y/n (default 10%)");
            
//             String[] penjuDanPese = input.split(" ");
//             double penjualan = Double.parseDouble(penjuDanPese[0]);
//             if (penjuDanPese.length > 1){
//                 double persentase = Double.parseDouble(penjuDanPese[1]);
//                 hitungRoyalti(penjualan,persentase);
//             } else {
//                 hitungRoyalti(penjualan);
//             }
//         }
//     }            

//     public String perbaikiSinopsis(String sinopsis){
//         String[] kalimat = sinopsis.split("(?<=[.!?])\\s");
//         sinopsis = "";
//         for (int i = 0; i < kalimat.length; i++) {
//             sinopsis += Character.toUpperCase(kalimat[i].charAt(0)) + kalimat[i].substring(1) + " ";
//         }
//         return sinopsis;        
//     }

//     public void hitungRoyalti(double penjualan){
//         for (int i = 0; i < this.harga.length; i++) {
//             this.royalti[i] = this.harga[i] * penjualan / 10;
//         }
//     }

//     public void hitungRoyalti(double penjualan, double persentase){
//         if (persentase>1) persentase = persentase/100;
//         for (int i = 0; i < this.harga.length; i++) {
//             this.royalti[i] = this.harga[i] * penjualan / persentase;
//         }
//     }

//     public void print(){
//         System.out.println("Kategori: " + this.kategori);
//         for(int i = 0; i < this.judul.length; i++){
//             System.out.println("Judul: " + this.judul[i]);
//             System.out.println("Penulis: ");
//             for(int j = 0; j < this.isiPenulis[i].length; j++){
//                 System.out.println(this.isiPenulis[i][j] + " ");
//             }
//             System.out.println("Sinopsis: ");
//             System.out.println(perbaikiSinopsis(this.sinopsis[i]));
//             System.out.println("Royalti: ");
//             System.out.println("Rp." + df.format(royalti[i]));             
//         }       
//     }
// }