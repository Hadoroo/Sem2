package TryCatch;

import java.io.FileOutputStream;

public class TryWithResouces {
    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("D:/coding/FILKOM.txt")){
            String msg = "Selamat Datang di Filkom!";
            byte byteArray[] = msg.getBytes();
            System.out.println(msg.getBytes());
            fileOutputStream.write(byteArray);
            System.out.println("Pesan sudah");
        }catch (Exception exception){
            System.out.println(exception);
        }
    }
}
