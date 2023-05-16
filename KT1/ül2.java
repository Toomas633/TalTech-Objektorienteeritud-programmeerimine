import java.util.HashMap;

public class ül2 {
    public static void main(String[] args) {
        String[] sonad = {"auto", "tee", "takso", "auto", "auto", "takso"};
        HashMap<String,Boolean> tulemus = esinemisteArvVäiksem(sonad);
        System.out.println(tulemus);
    }

    public static HashMap<String,Boolean> esinemisteArvVäiksem(String[] sonad) {
        HashMap<String,Integer> sõnadeEsinemised = new HashMap<>();
        for (String sõna : sonad) {
            if (sõnadeEsinemised.containsKey(sõna)) {
                sõnadeEsinemised.put(sõna, sõnadeEsinemised.get(sõna) + 1);
            } else {
                sõnadeEsinemised.put(sõna, 1);
            }
        }
        HashMap<String,Boolean> tulemus = new HashMap<>();
        for (String sõna : sõnadeEsinemised.keySet()) {
            int esinemisteArv = sõnadeEsinemised.get(sõna);
            boolean väärtus = esinemisteArv <= 2;
            tulemus.put(sõna, väärtus);
        }
        return tulemus;
    }
    
}
