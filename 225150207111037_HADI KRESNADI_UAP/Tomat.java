public class Tomat extends Tanaman implements Perawatan{
    public Tomat(){
       this.setMasaHidup(100);
       this.setBerbuah(100);
       this.setPerkembangan(0.25);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + "Buah yang Dihasilkan: " + getBuah() + " buah Tomat" + "\n"
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