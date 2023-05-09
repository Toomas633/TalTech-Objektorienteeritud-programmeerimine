import Konto.*;

public class Küsimus1 {
    public static void main(String[] args) {
        Konto konto1 = new Konto();
        Säästukonto konto2 = new Säästukonto();
        
        konto1.hoiusta(1000);
        konto1.votaraha(500);
        System.out.println("Konto 1 saldo: " + konto1.getSaldo());
        
        konto2.hoiusta(1000);
        konto2.votaraha(1100);
        System.out.println("Konto 2 saldo: " + konto2.getSaldo());
        
        konto2.votaraha(500);
        System.out.println("Konto 2 saldo: " + konto2.getSaldo());
    }
}
