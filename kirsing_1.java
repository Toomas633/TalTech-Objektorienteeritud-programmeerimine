import java.util.Arrays;

public class kirsing_1 {
    public static void main(String[] args){
        ül3(args);
    }
    public static void ül1(String[] args){
        int x=3, y=5, z=8;
        int[] arr={x,y,z};
        Arrays.sort(arr);
        System.out.println("\n Kaks väiksemat numbrit on: " + arr[0] + " " + arr[1]);
    }
    public static void ül2(String[] args){
        int x=25, y=134;
        boolean es, te;
        if(x%7 != 0)es = true;
        else es = false;
        if(y%7 != 0) te = true;
        else te = false;
        if(es==true && te==true)System.out.println("true");
        else System.out.println("false");
    }
    public static void ül3(String[] args){
        int x=3, y=10;
        boolean kaheksa = false;
        for(int i = 0; i<8; i++){
            if (x < 100000){ 
                x=x*y+4;
                kaheksa = true;
            }
            else{
                kaheksa = false;
                break;
            }
        }
        if (kaheksa == true) System.out.print("\nArvutati läbi 8-sa korda.");
        else System.out.print("\nÜletati 100000.");
        System.out.println(" Arv: " + x);
    }
}
