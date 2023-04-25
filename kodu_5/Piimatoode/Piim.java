package kodu_5.Piimatoode;

import java.text.DecimalFormat;

public class Piim extends Piimatoode {
    public Piim(String nimi, Double hind) {
        setHind(hind);
        setNimi(nimi);
    }

    public Double getPrice(int n, Double hind) {
        DecimalFormat df = new DecimalFormat("#.##");
        Double kogus = Double.valueOf(n);
        if (kogus >= 5) {
            hind = hind * 0.9 * kogus;
            String tmp = df.format(hind);
            hind = Double.parseDouble(tmp);
            setSoodustus("10%");
        }
        else {
            hind = hind * kogus;
            String tmp = df.format(hind);
            hind = Double.parseDouble(tmp);
            setSoodustus("0%");
        }
        return hind;
    }
}
