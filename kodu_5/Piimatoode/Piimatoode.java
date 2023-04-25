package kodu_5.Piimatoode;

public abstract class Piimatoode {
    String nimi;
    Double hind;
    int kogus;
    String soodustus;

    public void setHind(Double hind) {
        this.hind = hind;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public Double getHind() {
        return this.hind;
    }

    public String getNimi() {
        return this.nimi;
    }

    public void setKogus(int kogus) {
        this.kogus = kogus;
    }

    public int getKogus() {
        return this.kogus;
    }

    public void setSoodustus(String soodustus) {
        this.soodustus = soodustus;
    }

    public String getSoodustus() {
        return this.soodustus;
    }
}
