package File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class cobaFileReader {
    public static void main(String[] args) {
        String namaFile;
        int jumlah = 0;
        byte[] bufferData = new byte[1024];
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama file: ");
        namaFile = sc.nextLine();
        FileReader fileInput = null;
        try{
            fileInput = new FileReader(namaFile);
        }catch(IOException e){
            System.out.println("Maaf, file tidak dapat dibuka");
            System.exit(1);
        }
        BufferedReader streamInput = new BufferedReader(fileInput);
        try{
            while(true){
                String  baris = streamInput.readLine();
                if (baris == null){
                    break;
                }
                System.out.println(baris);
            }
        }catch(IOException e){
            System.err.println("Maaf, Gagap membaca data");
            System.exit(1);
        }
        try{
            fileInput.close();
        }catch(IOException e){
            System.err.println("Maaf, ada kesalahan sewaktu menutup file");
            System.exit(1);
        }
    }
}
