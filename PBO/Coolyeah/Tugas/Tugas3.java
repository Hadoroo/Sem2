package Tugas;
import java.util.Calendar;

public class Tugas3 {
    public static void main(String[] args) {
        Calendar tanggalPertama = Calendar.getInstance();
        tanggalPertama.set(2023, Calendar.MAY, 23, 10, 0, 0);

        Calendar tanggalKedua = Calendar.getInstance();
        tanggalKedua.set(2023, Calendar.JUNE, 1, 12, 0, 0);

        long selisihMiliDetik = tanggalKedua.getTimeInMillis() - tanggalPertama.getTimeInMillis();
        long selisihMenit = selisihMiliDetik / (60 * 1000);
        long selisihJam = selisihMiliDetik / (60 * 60 * 1000);
        long selisihHari = selisihMiliDetik / (24 * 60 * 60 * 1000);

        long sisaJam = selisihJam - (selisihHari*24);
        long sisaMenit = selisihMenit - (selisihJam*60);

        System.out.print("Selisih waktu : ");
        System.out.print(selisihHari+ " hari ");
        System.out.print(sisaJam + " jam ");
        System.out.println(sisaMenit + " menit ");
    }
}
