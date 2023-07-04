public class Stroberi extends Tanaman implements Perawatan{
    public Stroberi(){
       this.setMasaHidup(60);
       this.setBerbuah(150);
       this.setPerkembangan(0.35);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + "Buah yang Dihasilkan: " + getBuah() + " buah Stroberi" + "\n"
        + "Status Tanaman: " + status();
    }

    @Override
    public void treatment() {
        this.setPerkembangan(getPerkembangan() + 0.05);
    }

    @Override
    public void berkembang() {
        if (this.getProsesBerbuah() >= this.getBerbuah()){
            this.setBuah(getBuah() + 1);
            this.setProsesBerbuah(this.getProsesBerbuah() - this.getBerbuah());
        }else{
            if (getProsesBerbuah()==0) {
                this.setProsesBerbuah(this.getBerbuah() * this.getPerkembangan());
            }
            this.setProsesBerbuah(this.getProsesBerbuah() + this.getBerbuah() * this.getPerkembangan());
        }

        this.setLamaHidup(getLamaHidup() + 1);
    }
}