public class Araba {
    private String marka;
    private String model;
    private String yil;
    private int hiz;

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYil() {
        return yil;
    }

    public void setYil(String yil) {
        this.yil = yil;
    }

    public int getHiz() {
        return hiz;
    }

    public int setHiz(int hiz) {
        this.hiz = hiz;
        return hiz;
    }


    @Override
    public String toString() {
        return "Araba{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", yil='" + yil + '\'' +
                ", hiz=" + hiz +
                '}';
    }

    public int HizArttir(int hizArttirimMiktar){
        return  this.setHiz(this.getHiz()+hizArttirimMiktar);
    }

    public Araba() {
    }

    public Araba(String marka, String model, String yil, int hiz) {
        this.marka = marka;
        this.model = model;
        this.yil = yil;
        this.hiz = hiz;
    }
}
