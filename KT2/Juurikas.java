import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Juurikas {
    private String nimi;
    private int hind;
    private int kogus;

    public Juurikas(String nimi, int hind) {
        this.nimi = nimi;
        this.hind = hind;
        this.kogus = 0;
    }

    public void lisa(String nimi, int kogus) {
        if (this.nimi.equals(nimi)) {
            this.kogus += kogus;
        }
    }

    public void eemalda(String nimi, int kogus) {
        if (this.nimi.equals(nimi)) {
            if (this.kogus >= kogus) {
                this.kogus -= kogus;
            } else {
                this.kogus = 0;
            }
        }
    }

    public static void main(String[] args) {
        Juurikas porgand = new Juurikas("porgand", 2);
        Juurikas kartul = new Juurikas("kartul", 1);
        Juurikas sibul = new Juurikas("sibul", 3);
        Juurikas redis = new Juurikas("redis", 2);
        Juurikas tomat = new Juurikas("tomat", 4);

        List<Juurikas> juurviljad = new ArrayList<>();
        juurviljad.add(porgand);
        juurviljad.add(kartul);
        juurviljad.add(sibul);
        juurviljad.add(redis);
        juurviljad.add(tomat);

        porgand.lisa("porgand", 10);
        kartul.lisa("kartul", 5);
        sibul.lisa("sibul", 8);
        redis.lisa("redis", 3);
        tomat.lisa("tomat", 2);

        porgand.eemalda("porgand", 5);
        kartul.eemalda("kartul", 10);
        sibul.eemalda("sibul", 3);
        redis.eemalda("redis", 5);
        tomat.eemalda("tomat", 1);

        Juurikas pikimaNimegaJuurviljaKogus = juurviljad.stream()
                .max(Comparator.comparing(j -> j.nimi.length()))
                .orElse(null);

        if (pikimaNimegaJuurviljaKogus != null) {
            System.out.println("Pikima nimega juurvili on " + pikimaNimegaJuurviljaKogus.nimi
                    + " kogusega " + pikimaNimegaJuurviljaKogus.kogus);
        }
    }
}
