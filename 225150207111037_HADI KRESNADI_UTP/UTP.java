public class UTP {
    public static void main(String[] args) {
        //Silahkan mengubah nama&nomor Pegawai dengan nama & NIM masing-masing
        Pegawai pegawaiPerpus = new Pegawai("Hadi Kresnadi", "225150207111037");
        Perpustakaan perpus = new Perpustakaan(pegawaiPerpus);
        pegawaiPerpus.menambahBuku("Tutorial Java", "Graita", 2);
        pegawaiPerpus.menambahBuku("Tutorial Phyton", "Safir", 2);
        pegawaiPerpus.menambahBuku("Tutorial Javascript", "Bagus", 2);
        pegawaiPerpus.menambahBuku("Tutorial Golang", "Budi", 2);
        pegawaiPerpus.menambahBuku("Tutorial Javascript", "Shinta", 2);
        pegawaiPerpus.menambahPelanggan("Wildan", "1");
        pegawaiPerpus.menambahPelanggan("Machsun", "2");
        pegawaiPerpus.menambahPelanggan("Adin", "3");
        pegawaiPerpus.menambahPelanggan("Machsun", "4");
        perpus.pinjam("Wildan", "Tutorial Java");
        perpus.pinjam("Machsun", "Tutorial Java");
        perpus.pinjam("Adin", "Tutorial Java");
        perpus.pinjam("Adin", "Tutorial Phyton");
        perpus.pinjam("Wildan", "Tutorial Golang");
        perpus.pinjam("Wildan", "Tutorial Javascript");
        perpus.pinjam("Wildan", "Tutorial Phyton");
        perpus.pinjam("Cantika", "Tutorial Golang");
        perpus.pinjam("Machsun", "Sastra Inggris");
        perpus.pinjam("Adin", "Tutorial Phyton");
        perpus.pinjam("Cantika", "Cara cepat belajar Phyton");
        perpus.tampilkanInfoPerpustakaan();    
    }
}

class Buku{
    private String judul;
    private String penulis;
    private int jumlah;

    public Buku (String judul, String penulis, int jumlah){
        this.judul = judul;
        this.penulis = penulis;
        this.jumlah = jumlah;
    }

    public void tampilkanInfoBuku(){
        System.out.println("Judul buku: " + judul);
        System.out.println("Penulis buku: " + penulis);
        System.out.println("Jumlah buku: " + jumlah);
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}

class Pegawai{
    private String nama;
    private String nomorPegawai;

    public Pegawai (String nama, String nomorPegawai){
        this.nama = nama;
        this.nomorPegawai = nomorPegawai;
    }

    public void tampilkanInfoPegawai(){
        System.out.println("Informasi Pegawai di Perpustakaan :");
        System.out.println("Nama pegawai    : " + nama);
        System.out.println("Nomor pegawai   : "+ nomorPegawai);
        System.out.println("====================");
    }

    public void menambahPelanggan(String nama, String nomorPelanggan){
        Perpustakaan.listPelanggan[Perpustakaan.jumPelanggan] = new Pelanggan(nama, nomorPelanggan);
        // System.out.println(Perpustakaan.listPelanggan[Perpustakaan.jumPelanggan].getNama());
        Perpustakaan.jumPelanggan++;
    }

    public void menambahBuku (String judul, String penulis, int jumlah){
        Perpustakaan.listBuku[Perpustakaan.jumBuku] = new Buku(judul, penulis, jumlah);
        Perpustakaan.jumBuku++;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorPegawai() {
        return nomorPegawai;
    }

    public void setNomorPegawai(String nomorPegawai) {
        this.nomorPegawai = nomorPegawai;
    }
}

class Perpustakaan{
    static Buku[] listBuku = new Buku[100];
    public Pegawai pegawaiPerpus;
    public Pelanggan pelanggan;
    static Pelanggan[] listPelanggan = new Pelanggan[20];
    static int jumPelanggan;
    static int jumBuku;

    public Perpustakaan (Pegawai pegawai){
        this.pegawaiPerpus = pegawai;
    }

    public void pinjam (String namaPelanggan, String judulBuku){
        Buku buku = cariBuku(judulBuku);
        Pelanggan pelanggan = cariPelanggan(namaPelanggan);
        if (cariBuku(judulBuku) != null){
            if (cariPelanggan(namaPelanggan) != null){
                if (buku.getJumlah() > 0){
                    pelanggan.tambahBuku(buku);
                    buku.setJumlah(buku.getJumlah()-1);
                }
            }
        }
    }

    public Buku cariBuku(String judulBuku){
        for (Buku buku : listBuku) {
            if (buku != null && judulBuku.equals(buku.getJudul())) {
                return buku;
            }
        }
        return null;
    }

    public Pelanggan cariPelanggan(String namaPelanggan){
        for (Pelanggan pelanggan : listPelanggan){
            if (pelanggan != null && namaPelanggan.equals(pelanggan.getNama())){
                return pelanggan;
            }
        }
        return null;
    }

    public void tampilkanInfoPerpustakaan(){
        pegawaiPerpus.tampilkanInfoPegawai();
        pelanggan.tampilkanInfoPelanggan();
    }
}

class Pelanggan{
    private String nama;
    private String nomorPelanggan;
    private Buku[] BukuPinjaman = new Buku[3];

    public Pelanggan (String nama, String nomorPelanggan){
        this.nama = nama;
        this.nomorPelanggan = nomorPelanggan;
    }

    public void tambahBuku(Buku bukuPinjam){
        
    }

    public void tampilkanInfoPelanggan(){
        System.out.println("Nama pelanggan: " + nama);
        System.out.println("Nomor pelanggan: " + nomorPelanggan);
        System.out.println("Buku pinjaman: ");
        if (BukuPinjaman.length > 0){
            for (int i = 0; i < BukuPinjaman.length; i++){
                System.out.println(BukuPinjaman[i]);
            }
        }else{
            System.out.println("Tidak ada");
        }
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNomorPelanggan() {
        return nomorPelanggan;
    }
    public void setNomorPelanggan(String nomorPelanggan) {
        this.nomorPelanggan = nomorPelanggan;
    }
    public Buku[] getBukuPinjaman() {
        return BukuPinjaman;
    }
    public void setBukuPinjaman(Buku[] bukuPinjaman) {
        BukuPinjaman = bukuPinjaman;
    }
}
