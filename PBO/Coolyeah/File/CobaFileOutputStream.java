package File;
import java.io.*;
import java.util.Scanner;

public class CobaFileOutputStream {
    public static void main(String[] args) {
        String namaFile;
        byte[] bufferData = new byte[1024];
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama File yang akan di buat: ");
        namaFile = sc.nextLine();
        System.out.print("\nMasukkan Data Teks: ");
        try{
            System.in.read(bufferData);
        }catch(IOException e){
            System.err.println("Data Tak Terbaca");
        }
        try{
            FileOutputStream fileOutput = new FileOutputStream(namaFile);
            fileOutput.write(bufferData, 0, bufferData.length);
            fileOutput.close();
        }catch(IOException e){
            System.err.println("Maaf, file gagal dibuat dan ditulis");
            System.exit(1);
        }
        System.out.println("File berhasil dibuka dan diisi");
    }   
}
