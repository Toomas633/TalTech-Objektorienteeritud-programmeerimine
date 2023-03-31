import java.util.Random;
import java.util.Scanner;

// tikkude arv = N
// tikkude võtmise lubatud arv = M

public class kirsing_kodu_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // alusta uut mängu
        System.out.println("\n\nAlustan mängu!");
        newGame(in);
        // Küsi kasutajalt mängu lõppetes soovi
        System.out.println("Mäng läbi, kas alustame uut?");
        System.out.println("[1] Uus mäng");
        System.out.println("[2] Välju");
        while(true){
            int valik = sisend(in);
            if (valik == 1) {
                System.out.println("\n\nAlustan uut mängu!");
                main(args);
            } 
            else if (valik == 2) {
                System.out.println("Nägemist!");
                break;
            } 
            else System.out.println("Sisesta number valikust!");
        }
        in.close();
    }

    static void newGame(Scanner in) {
        // küsi mängu parameetreid
        System.out.print("Sisesta soovitud tikkude arv (N): ");
        int lubatud = 0;
        int tikud = sisend(in);
        while(true){
            System.out.print("Tikkude võtmise lubatud arv (M): ");
            lubatud = sisend(in);
            // kontrollib et lubatud võtmiste arv vastab valemile
            if (1 < lubatud && lubatud < tikud) {
                break;
            }
            else System.out.println("Tikkude võtmise maksimaalne arv peab olema 1 < lubatud && lubatud <" + tikud);
        }
        System.out.println("Mäng algab, edu!");
        // mängu põhiosa kuni keegi võidab
        while(true){
            // inimese kord
            System.out.println("\nTikke on laual: " + tikud);
            System.out.println("Kasutaja kord.");
            tikud = makeHumanMove(tikud, lubatud, in);
            // kui tikkude arv peale inimese käiku on 0, tagasta et kasutaja on võitnud
            if (tikud == 0) {
                System.out.println("Mängija võitis, palju õnne!");
                break;
            }
            // arvuti kord
            System.out.println("\nTikke on laual: " + tikud);
            System.out.println("Arvuti kord.");
            tikud = makeComputerMove(tikud, lubatud, in);
            // kui tikkude arv peale arvuti käiku on 0, tagasta et arvuti võitis
            if (tikud == 0) {
                System.out.println("Arvuti võitis, edu järgmiseks korraks!");
                break;
            }
        }
    }

    static int makeComputerMove(int tikud, int lubatud, Scanner in) {
        Random rand = new Random();
        int randomNum = 0;
        // kui tikke on vähem või võrdselt käigu lubatud suurusega, eemalda kõik tikud
        if (tikud <= lubatud) {
            return 0;
        }
        // tee suvaline käik
        while(true){
            // genereeri suvaline number
            int max = lubatud, min = 1;
            randomNum = rand.nextInt((max - min) + 1) + 1;
            // kontrolli et on piisavalt tikke, kui ei genereeri uus number
            if(randomNum <= tikud) return tikud - randomNum;
        }
    }

    static int makeHumanMove(int tikud, int lubatud, Scanner in) {
        while(true){
            System.out.print("Mitut tikku soovid eemaldada?(suurim:" + lubatud + "): ");
            int valik = sisend(in);
            // kontrolli valiku vahemikku
            if (tikud < valik) System.out.println("Laual pole piisavalt tikke!");
            else if (1 <= valik && valik <= lubatud) {
                return tikud - valik;
            }
            else System.out.println("Vale arv!");
        }
    }

    static int sisend(Scanner in) {
        while (true) {
            try {
                // saa sisend ja tagasta
                return in.nextInt();
            } 
            catch (Exception e) {
                // kui sisend ei ole number saada error ja küsi sisendit uuesti
                System.out.print("Sisend võib olla ainult number! Sisesta uuesti:");
                //puhasta sisendi väli
                in.nextLine();
            }
        }
    }
}