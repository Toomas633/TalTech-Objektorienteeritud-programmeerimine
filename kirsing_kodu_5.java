import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

import kodu_5.Person;
import kodu_5.Arve.Arve;
import kodu_5.Piimatoode.Juust;
import kodu_5.Piimatoode.Kohupiim;
import kodu_5.Piimatoode.Piim;
import kodu_5.Piimatoode.Piimatoode;

public class kirsing_kodu_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nÜlesanne 1");
        Person[] persons = setup(); //Tekita 8 inimesega testkonteiner
        String perenimi = perenimi(scanner); //Saa perekonnanimi kasutajalt
        int count = 0;
        for (Person person : persons) { //Käib kõik perenimed läbi ja kontrollib neid sisendiga
            if (person.getPerenimi().equalsIgnoreCase(perenimi)) {
                System.out.println("Eesnimi: " + person.getEesnimi() + '\t'+ "Sünniaasta: " + person.getSünniaasta());
                count = count + 1;
            }
        }
        if (count < 1) { //Kui ühtegi sellise perenimega inimest ei leita
            System.out.println("Sellise perekonnanimega inimest ei leitud");
        }
        scanner.close();
        System.out.println("\nÜlesanne 2:");
        ül2();
    }

    static String perenimi(Scanner scanner) { //Saa sisend kasutajalt
        String sisend = "";
        boolean õige = false;
        while (!õige) {
            System.out.print("Sisesta perekonnanimi: ");
            sisend = scanner.nextLine();
            if (sisend.matches("[a-zA-Z]+")) { //Sisend tohib sisaldada ainult tähti
                õige = true;
            } else { // Kui sisend sisaldab mingit muud sümbolit peale tähtede küsi uuesti
                System.out.println("Perekonnanimi tohib sisaldada ainult tähi.");
            }
        }
        return sisend;
    }

    static Person[] setup() { //Tekita 8 inimest ja lisa nad arraysse
        Person[] persons = {
            new Person("John", "Doe", 1980),
            new Person("Jane", "Doe", 1985),
            new Person("Bob", "Smith", 1975),
            new Person("Alice", "Jones", 1990),
            new Person("Mike", "Johnson", 1982),
            new Person("Sarah", "Lee", 1995),
            new Person("David", "Brown", 1988),
            new Person("Emily", "Davis", 1979)
        };
        return persons;
    }

    static void ül2() {
        Arve arve1 = new Arve("Uku", 1); //Tekitab arved
        Arve arve2 = new Arve("Jaan", arve1.järgmine());
        Arve arve3 = new Arve("Marju", arve2.järgmine());
        Piimatoode[] tooted1 = tooted(); //Tekita ostjate ostukorvid
        Piimatoode[] tooted2 = tooted(); 
        Piimatoode[] tooted3 = tooted();
        arve1 = koostaArve(arve1, tooted1); //Tekita ostukorvi arve 
        arve1.maksa(tooted1); //Printi tšekid
        arve2 = koostaArve(arve2, tooted2);
        arve2.maksa(tooted2);
        arve3 = koostaArve(arve3, tooted3);
        arve3.maksa(tooted3);
    }

    static Arve koostaArve(Arve arve, Piimatoode[] tooted) {
        DecimalFormat df = new DecimalFormat("#.##"); //Ümarda 2e komakohani
        Random random = new Random(System.currentTimeMillis());
        Double summa = 0.0;
        int piim = 0, juust = 0, kohupiim = 0;
        for (int i = 0; i < 3; i++) {
            for (Piimatoode toode : tooted) {
                int kogus = random.nextInt(3); //Anna toodetele ostukorvis kogus
                toode.setKogus(kogus);
                if (toode instanceof Piim) piim = piim + kogus; //Loe kokku kõik piimad, juustud ja kohupiimad
                if (toode instanceof Juust) juust = juust + kogus;
                if (toode instanceof Kohupiim) kohupiim = kohupiim + kogus;
            }
            for (Piimatoode toode : tooted) { 
                if (toode instanceof Piim) { //Kui toode on piim arvuta hinnad
                    Piim toodePiim = (Piim) toode;
                    Double hind = toodePiim.getPrice(piim, toode.getHind());
                    toode.setHind(hind);
                    summa = summa + hind;
                }
                if (toode instanceof Juust) {
                    Juust toodeJuust = (Juust) toode;
                    Double hind = toodeJuust.getPrice(juust, toode.getHind());
                    toode.setHind(hind);
                    summa = summa + hind;
                }
                if (toode instanceof Kohupiim) {
                    Kohupiim toodeKohupiim = (Kohupiim) toode;
                    Double hind = toodeKohupiim.getPrice(kohupiim, toode.getHind());
                    toode.setHind(hind);
                    summa = summa + hind;
                }
            }
        }
        String tmp = df.format(summa);
        summa = Double.parseDouble(tmp); //Ümarda 2e komakohani
        arve.setSumma(summa);
        return arve;
    }

    static Piimatoode[] tooted() {
        Piimatoode[] tooted = { //Tooted mida väiketootja müüb
            new Juust("Kõvajuust", 11.45),
            new Juust("Sulajuust", 9.97),
            new Juust("Hiirejuust", 14.60),
            new Piim("2.5% Piim" , 0.99),
            new Piim("Rasvane piim", 1.79),
            new Kohupiim("Kohupiim", 5.45),
            new Kohupiim("Rosina kohupiim", 5.45),
            new Kohupiim("Lahja kohupiim", 5.95)
        };
        return tooted;
    }
}
