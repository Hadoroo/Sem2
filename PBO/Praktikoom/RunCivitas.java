
import java.text.DecimalFormat;

public class RunCivitas {
    public static void main(String[] args) {
        Dosen d1 = new Dosen("123", "Indirati", "Jalan A", "TIF", "FILKOM", "1000000");
        Dosen d2 = new Dosen("124","Randy","Jalan B", "TIF","FILKOM", "2000000");
        Dosen d3 = new Dosen("125","Ujang","Jalan C", "TIF","FILKOM", "3000000");
        d1.tampilkanData();
        d2.tampilkanData();
        d3.tampilkanData();

        KRS krsKel = new KRS();
        MataKuliah m1 = new MataKuliah("CIF62002","SISOP",10,d1);
        MataKuliah m2 = new MataKuliah("CIF62004","ASD",4,d1);
        MataKuliah m3 = new MataKuliah("CIF62006","STP",3,d2);
        MataKuliah m4 = new MataKuliah("CIF62003","PBO",12,d2);
        krsKel.tambahMatkul(m1);
        krsKel.tambahMatkul(m2);
        krsKel.tambahMatkul(m3);
        krsKel.tambahMatkul(m4);

        Mahasiswa mhs1 = new Mahasiswa("225150207111037", "Hadi Kresnadi", "Jalan A", "TIF", "Ilmu Komputer", "9500000");
        Mahasiswa mhs2 = new Mahasiswa("225150208111038", "Ujang Supardi", "Jalan B", "TIF", "Ilmu Komputer", "8500000");
        mhs1.tampilkanData();  
        mhs2.tampilkanData();
        
        krsKel.setMahasiswa(mhs1);      
        // krsKel.tampilKRS();
    }
}

abstract class CivitasAkademik{
    private String nama;
    private String alamat;
    private String prodi;
    private String fakultas;

    public CivitasAkademik(){

    }

    public CivitasAkademik(String nama, String alamat, String prodi, String fakultas){
        this.nama = nama;
        this.alamat = alamat;
        this.prodi = prodi;
        this.fakultas = fakultas;
    }

    public void tampilkanData(){
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
}

class Mahasiswa extends CivitasAkademik{
    private String nim;
    private String ukt;
    DecimalFormat df = new DecimalFormat("Rp ###,###.00");

    public Mahasiswa(String nim, String nama, String alamat, String prodi, String fakultas, String ukt){
        super(nama, alamat, prodi, fakultas);
        this.nim = nim;
        this.ukt = ukt;
    }

    public void tampilkanData(){
        System.out.println("Nama: " + getNama());
        System.out.println("Prodi: " + getProdi());
        System.out.println("Fakultas: " + getFakultas());
        System.out.println("Alamat: " + getAlamat());
        System.out.println("NIM: " + nim);
        System.out.println("UKT: " + df.format(Integer.parseInt(ukt)));
        System.out.println();
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getUkt() {
        return ukt;
    }

    public void setUkt(String ukt) {
        this.ukt = ukt;
    }
}

class KRS{
    private Mahasiswa mhs;
    private MataKuliah[] matkul = new MataKuliah[12];
    private int sks;
    private int jumlahMatkul;
    DecimalFormat df = new DecimalFormat("Rp ###,###.00");

    public KRS(){

    }

    public KRS(Mahasiswa mhs, MataKuliah[] matkul){
        this.mhs = mhs;
    }

    public void tambahMatkul(MataKuliah newMatkul){
        sks += newMatkul.getSks();
        if (sks <= 24){
            matkul[jumlahMatkul] = newMatkul;
            jumlahMatkul++;
        }
    }

    public void tampilKRS(){
        System.out.println("Nama: " + mhs.getNama());
        System.out.println("Prodi: " + mhs.getProdi());
        System.out.println("Fakultas: " + mhs.getFakultas());
        System.out.println("Alamat: " + mhs.getAlamat());
        System.out.println("NIDN: " + mhs.getNim());
        System.out.println("Gaji: " + df.format(Integer.parseInt(mhs.getUkt())));
        System.out.println();
        for (int i = 0; i < jumlahMatkul; i++) {
            System.out.println("Nama Mata Kuliah: " + matkul[i].getNamaMatkul());
            System.out.println("Kode Mata Kuliah: " + matkul[i].getKodeMatkul());
            System.out.println("Dosen Pengampu: " + matkul[i].getDsn().getNama());
            System.out.println("Jumlah SKS: " + matkul[i].getSks());
            System.out.println();
        }
        if(sks > 24){
            System.out.println();
            System.out.println("Tidak bisa menambahkan mata kuliah baru karena SKS sudah lebih dari 24");
        }
    }

    public Mahasiswa getMhs(){
        return mhs;
    }

    public void setMahasiswa(Mahasiswa mhs) {
        this.mhs = mhs;
    }

    public MataKuliah[] getMatkul(){
        return matkul;
    }

    public void setMatkul(MataKuliah[] matkul){
        this.matkul = matkul;
    }

}

class Dosen extends CivitasAkademik{
    private String nidn;
    private String gaji;
    DecimalFormat df = new DecimalFormat("Rp ###,###.00");

    public Dosen(String nidn, String nama, String alamat, String prodi, String fakultas, String gaji) {
        super (nama, alamat, prodi, fakultas);
        this.nidn = nidn;
        this.gaji = gaji;
    }

    public void tampilkanData(){
        System.out.println("Nama: " + getNama());
        System.out.println("Prodi: " + getProdi());
        System.out.println("Fakultas: " + getFakultas());
        System.out.println("Alamat: " + getAlamat());
        System.out.println("NIDN: " + nidn);
        System.out.println("Gaji: " + df.format(Integer.parseInt(gaji)));
        System.out.println();
    }

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

}

class MataKuliah{
    private String kodeMatkul;
    private String namaMatkul;
    private int sks;
    private Dosen dsn;

    public MataKuliah(String kodeMatkul, String namaMatkul, int sks, Dosen dsn){
        this.kodeMatkul = kodeMatkul;
        this.namaMatkul = namaMatkul;
        this.sks = sks;
        this.dsn = dsn;
    }

    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public void setKodeMatkul(String kodeMatkul) {
        this.kodeMatkul = kodeMatkul;
    }

    public String getNamaMatkul() {
        return namaMatkul;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.namaMatkul = namaMatkul;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }

    public Dosen getDsn() {
        return dsn;
    }

    public void setDsn(Dosen dsn) {
        this.dsn = dsn;
    }
}