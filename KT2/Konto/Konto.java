package Konto;

public class Konto {
    private double saldo;
    
    public Konto() {
        saldo = 0;
    }
    
    public void hoiusta(double x) {
        saldo += x;
    }
    
    public boolean votaraha(double x) {
        if (saldo - x >= 0) {
            saldo -= x;
            return true;
        } else {
            return false;
        }
    }
    
    public double getSaldo() {
        return saldo;
    }
}