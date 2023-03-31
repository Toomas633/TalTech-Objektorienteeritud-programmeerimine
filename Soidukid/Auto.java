package Soidukid;

public class Auto extends Soiduk{
    public Auto(String number) {
        setNumber(number);
    }

    public Auto(){
        setHind(0);
    }
    
    public void Show(){
        System.out.println("Number: " + getNumber() + "\t\tKiirus: " + getKiirus() + "\tHind: " + getHind());
    }

    public void määraHind(int kiirus) {
        if (kiirus < 50) setHind(400);
        else setHind(1000);;
    }
}