import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ül1 {
    public static void main(String[] args) {
        String[] sisend = {"bba", "bcccb", "cAc", "McMc",""};
        String[] sobivadSoned = poleAM(sisend);
        System.out.println(Arrays.toString(sobivadSoned));
    }

    static String[] poleAM(String[] sisend) {
        List<String> sobivadSoned = new ArrayList<String>();
        for (String sona : sisend) {
            if (!sona.toLowerCase().contains("a") && !sona.toLowerCase().contains("m")) {
                sobivadSoned.add(sona);
            }
        }
        String[] sobivadSonedArray = new String[sobivadSoned.size()];
        sobivadSoned.toArray(sobivadSonedArray);
        return sobivadSonedArray;
    }
}
