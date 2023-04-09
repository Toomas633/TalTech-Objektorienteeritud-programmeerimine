import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class kirsing_kodu_4 {
    public static void main(String[] args) {
        List<String> text = new ArrayList<String>(); //Loo teksti jaoks List et seda edasi anda töötlemiseks
        text = words(text); //Leia kõik sõnad tekstist ja loe tekst sisse Listi
        vocals(text); //Leia täishäälikute leidumise sagedus
        rt(text); //Leia kõik r-i või t-ga algavad sõnad
        rtsagedus(text); //Leia r-i ja t-ga algavate sõnade sagedus ja väljasta 5 enim leiduvat
    };

    static List<String> words(List<String> text) {
        Set<String> words = new LinkedHashSet<String>();
        try { // Ava fail ja lisa kõik sõnad words set-i
            File file = new File("kodu_4.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext() == true) { //Võta kõik sõnad järjest sisse, eemalda kirjavahemärgind ning lisa set-i
                String s = scanner.next().toLowerCase().replace(",", "").replace(".", "").replace(" ", "").replace(";","").replace("!","").replace("?", "");
                words.add(s);
                text.add(s);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        System.out.println("\n\nwords:\n" + words); //Prindi words set
        return text; //tagasta sõnade set
    }

    static void vocals(List<String> words) {
        Map<Character, Integer> vocals =new HashMap<Character, Integer>();
        Character[] täishäälikud = {'a','e','i','o','u'};
        for (String word:words) for (char x:word.toCharArray()) { //Otsi igast sõnast set-is words tähti
            if (contains(täishäälikud, x)) { //Kontrolii kas on täishäälik
                if(!vocals.containsKey(x)) vocals.put(x, 1); //Kui hashmapis ei leidu liiget siis see lisatakse
                else vocals.put(x, vocals.get(x)+1); //Kui leidub hashmapis otsitakse leidumiste arv ja suurendatakse seda 1e korra
            }
        }
        Comparator<Character> valueComparator = new Comparator<Character>() { //järjesta täishäälikud leidumise järgi
            public int compare(Character k1, Character k2) {
                int compare = vocals.get(k2).compareTo(vocals.get(k1));
                return compare != 0 ? compare : 1;
            }
        };
        Map<Character, Integer> järjestatud = new TreeMap<>(valueComparator); //Pane comparatorist saadud tulemus uute map-i
        järjestatud.putAll(vocals); //Lisa järjestatud tagasi vocals mapi
        System.out.println("\n\nvocals:\n" + järjestatud); //Prindi täishäälikud järjestatult
    }

    static void rt(List<String> words) {
        List<String> rt = new ArrayList<String>();
        for (String word:words) if ((word.startsWith("r") || word.startsWith("t")) && !rt.contains(word)) {
            rt.add(word); //Kui sõna algab tähega r või t ning seda ei ole juba Listis lisatakse see
        }
        Collections.sort(rt); //Sorteeri tähestiku järgi
        System.out.println("\n\nr ja t algusega sõnad:\n" + rt);
    }

    static void rtsagedus(List<String> words) {
        Map<String, Integer> rtsõnad = new HashMap<String, Integer>();
        for (String x:words) if (x.startsWith("r") || x.startsWith("t")){ //Kui sõna algab r-i või t-ga
            if(!rtsõnad.containsKey(x)) rtsõnad.put(x, 1); //Kui hashmapis ei leidu liiget siis see lisatakse
            else rtsõnad.put(x, rtsõnad.get(x)+1); //Kui leidub hashmapis otsitakse leidumiste arv ja suurendatakse seda 1e korra
        }
        TreeMap<Integer, String> sorteeritud = new TreeMap<>(Collections.reverseOrder()); //Sorteeri sõnade leidumine jättes alles ainult 5 suuremat
        for (Map.Entry<String, Integer> entry : rtsõnad.entrySet()) {
            sorteeritud.put(entry.getValue(), entry.getKey());
            if (sorteeritud.size() > 5) {
                sorteeritud.remove(sorteeritud.lastKey());
            }
        }
        System.out.println("\n\n5 sagedasemat sõna:\n" + sorteeritud); //Prindi 5 sagedasemat sõna
    }

    static boolean contains(Character[] array, char character) { //Kas array sisaldab otsitavat, kui jah tagastatakse true
        for (int i = 0; i < array.length; i++) if (array[i] == character) return true;
        return false;
    }
}
