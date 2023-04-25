package kodu_5.Arve;
import kodu_5.Piimatoode.*;

public class Arve {
    String nimi;
    int arvenumber;
    int järgmine;
    Double summa;
    
    public Arve(String nimi, int arvenumber) {
        this.nimi = nimi;
        this.arvenumber = arvenumber;
        this.järgmine = leiaJärgmine(arvenumber);
    }

    private static int leiaJärgmine(int arvenumber) {
        int number = arvenumber + 1;
        return number;
    }

    public int järgmine() {
        return this.järgmine;
    }

    public void setSumma(Double summa) {
        this.summa = summa;
    }

    public void setKlinet(String nimi) {
        this.nimi = nimi;
    }

    public String klient() {
        return this.nimi;
    }

    public Double leiaKoguSumma() {
        return this.summa;
    }

    public int leiaArveNr() {
        return this.arvenumber;
    }

    public void maksa(Piimatoode[] tooted) {
        System.out.println("\nArve nr: " + leiaArveNr() + "\t\t\tTellija: " + klient() + "\nTooted:\t\tKogus:\tSoodustus:\tHind:");
        for (Piimatoode toode : tooted) {
            if (toode.getKogus() != 0) {
                System.out.println(toode.getNimi() + "\t\t" + toode.getKogus() + '\t' + toode.getSoodustus() + '\t' + toode.getHind());
            }
        }
        System.out.println("\t\t\t\tKokku: " + summa);
    }
}