import java.io.File;
import java.util.Scanner;

public class fileSizeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nama file: ");
        String nama = sc.nextLine();
        var file = new File(nama);
        double size = file.length();

        String Size = "";
        if (size < 1024*1024){
            Size = String.valueOf(size/1024 + " KB");
        }else{
            Size = String.valueOf(size/(1024*1024) + " MB");
        }

        System.out.println("Nama file: " + nama + "\n" + "Size file: " + Size);
    }
}
