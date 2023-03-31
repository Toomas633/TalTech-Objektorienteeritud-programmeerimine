package Soidukid;

public class Lennuk extends Soiduk {
    private int maxKorgus, lennuUlatus;

    public int getKorgus() {
        return this.maxKorgus;
    }

    public void setKorgus(int kõrgus) {
        this.maxKorgus = kõrgus;
    }

    public int getUlatus() {
        return this.lennuUlatus;
    }

    public void setUlatus(int ulatus) {
        this.lennuUlatus = ulatus;
    }

    public Lennuk(String number) {
        setNumber(number);
    }

    public Lennuk(){
        setHind(0);
    }

    public void Show(){
        System.out.println("Number: " + getNumber() + "\t\t\t\tHind: " + getHind());
    }

    public void määraHind(int maxKorgus, int lennuUlatus) {
        // Kõrgus m ja lennu ulatus km
        if (maxKorgus < 50000) setHind(1000);
        else if (lennuUlatus < 4000) setHind(3000);
        else setHind(150000);
    }
}

