package Lambda_Practice;

public class PojoApartman {

        private String cephe;
        private int katSayisi;
        private int kira;

    //1-parametresiz consructor olusturduk
    public PojoApartman() {

    }
     //2-bol parametreli consructor :
    public PojoApartman(String cephe, int katSayisi, int kira) {
        this.cephe = cephe;
        this.katSayisi = katSayisi;
        this.kira = kira;
    }

    //3-getter ve setterlar :

    public String getCephe() {
        return cephe;
    }

    public void setCephe(String cephe) {
        this.cephe = cephe;
    }

    public int getKatSayisi() {
        return katSayisi;
    }

    public void setKatSayisi(int katSayisi) {
        this.katSayisi = katSayisi;
    }

    public int getKira() {
        return kira;
    }

    public void setKira(int kira) {
        this.kira = kira;
    }

    //4-tostring yapiypriz :
    @Override
    public String toString() {
        return "PojoApartman{" +
                "cephe='" + cephe + '\'' +
                ", katSayisi=" + katSayisi +
                ", kira=" + kira +
                '}';
    }
}
