package Konto;

public class Säästukonto extends Konto {
    public boolean votaraha(double x) {
        if (getSaldo() - x >= 500) {
            return super.votaraha(x);
        } else {
            return false;
        }
    }
}