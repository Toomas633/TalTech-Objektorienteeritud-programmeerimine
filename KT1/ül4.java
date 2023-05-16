import java.util.ArrayList;

public class ül4 {
    public static void main(String[] args) {
        ArrayList<String> soned = new ArrayList<String>();
        soned.add("abe6");
        soned.add("bcdff");
        soned.add("d");
        
        ArrayList<String> tulemus = lisaTärn(soned);
        
        System.out.println("Sisendmassiiv: " + soned);
        System.out.println("Tulemusmassiiv: " + tulemus);
    }

    public static ArrayList<String> lisaTärn(ArrayList<String> soned) {
        ArrayList<String> tulemus = new ArrayList<String>();
        for (String sõna : soned) {
            if (sõna.length() >= 3) {
                String uusSõna = sõna.substring(0, 2) + "*" + sõna.substring(2);
                tulemus.add(uusSõna);
            } else if (sõna.length() == 2) {
                tulemus.add(sõna + "*");
            }
        }
        return tulemus;
    }
}
