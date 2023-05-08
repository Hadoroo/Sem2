// public class Main_Pegawai {
//     public static void main(String[] args) {

//         Pegawai pegawai = new Pegawai("Hadi", 1000);
//         System.out.println("Nama : " + pegawai.getNama());
//         System.out.println("Gaji : "+ pegawai.gaji);
//         Manager manager = new Manager("BBB", "Idah", 3000);
//         System.out.println("Nama : " + manager.getNama());
//         System.out.println("Gaji : "+ manager.gaji);
//         System.out.println("Departemen : "+ manager.departemen);

//         manager.cetakData();

//         Pegawai staf[] = new Pegawai[4];
//         staf[0] = new Pegawai("asd", 123);
//         staf[1] = new Manager("asd", "dfewq", 1234);
//         staf[2] = new Manager("asd", "dfewq", 1234);
//         staf[3] = new Pegawai("asd", 1445);

//         Pegawai staff[] = new Manager[4];
//         staff[0] = new Pegawai("asd", 123);
//         staff[1] = new Manager("asd", "dfewq", 1234);
//         staff[2] = new Manager("asd", "dfewq", 1234);
//         staff[3] = new Pegawai("asd", 1445);
//         for (int i = 0; i < staf.length; i++){
//             staff[i].cetakData();
//         }


//     }
//     public static void hitungPajak(Pegawai peg) {
//         System.out.println(peg instanceof Manager);
//         System.out.println(peg instanceof Pegawai);
//         if (peg instanceof Manager) {
//             System.out.println("Pajak Manager " + (peg.gaji));
//         }
//     }
// }
