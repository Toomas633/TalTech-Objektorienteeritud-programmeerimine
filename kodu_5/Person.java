package kodu_5;

public class Person {
    String eesnimi;
    String perenimi;
    int sünniaasta;

    public Person(String eesnimi, String perenimi, int aasta) {
        setEesnimi(eesnimi);
        setPerenimi(perenimi);
        setSünniaasta(aasta);
    }

    public String getEesnimi() {
        return this.eesnimi;
    }

    public String getPerenimi() {
        return this.perenimi;
    }

    public int getSünniaasta() {
        return this.sünniaasta;
    }

    public void setEesnimi(String eesnimi) {
        this.eesnimi = eesnimi;
    }

    public void setPerenimi(String perenimi) {
        this.perenimi = perenimi;
    }

    public void setSünniaasta(int aasta) {
        this.sünniaasta = aasta;
    }

    public void Show() {
        System.out.println(getEesnimi() + '\t' + getPerenimi() + '\t' +getSünniaasta());
    }
}
