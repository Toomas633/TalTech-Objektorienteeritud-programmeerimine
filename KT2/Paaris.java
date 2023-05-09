import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Paaris {
    public static Map<String,String> paaris(List<String> soned) {
        Map<String, Integer> tulemus = new HashMap<>();
        for (String sone : soned) {
            if (tulemus.containsKey(sone)) {
                tulemus.put(sone, tulemus.get(sone) + 1);
            } else {
                tulemus.put(sone, 1);
            }
        }
        Map<String,String> paarisSoned = new HashMap<>();
        for (Map.Entry<String, Integer> element : tulemus.entrySet()) {
            if (element.getValue() % 2 == 0) {
                String temp = "";
                for (int i = 0; i < element.getValue(); i++) {
                    temp += element.getKey();
                }
                paarisSoned.put(element.getKey(), temp);
            }
        }
        return paarisSoned;
    }

    public static void main(String[] args) {
        String[] paaris = {"ab","c","ab", "x", "x", "x", "x", "r", "r", "r"};
        List<String> soned = Arrays.asList(paaris);
        System.out.println(paaris(soned));
    }
}