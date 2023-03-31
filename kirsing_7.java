import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import Soidukid.*;

public class kirsing_7 {
    public static void main(String[] args) {
        System.out.println("\nÜlesanne 1:");
        ül1();
        System.out.println("\nÜlesanne 2:");
        ül2();
        System.out.println("\nÜlesanne 3:");
        ül3();
    }

    static void ül1() {
        System.out.println("Andmed:");
        Auto auto1 = new Auto("ABC 123");
        auto1.setKiirus(30);
        Auto auto2 = new Auto("");
        auto2.setNumber("ABC 234");
        auto2.setKiirus(300);
        auto2.määraHind(auto2.getKiirus());
        Paat paat1 = new Paat("PA-12");
        paat1.setKiirus(9);
        paat1.setSyvis(0.4);
        paat1.määraHind(paat1.getSyvis(), paat1.getKiirus());
        Paat paat2 = new Paat("");
        paat2.setNumber("PA-21");
        paat2.setKiirus(11);
        paat2.setSyvis(0.6);
        paat2.määraHind(paat2.getSyvis(), paat2.getKiirus());
        Lennuk lennuk1 = new Lennuk("L001TK");
        lennuk1.setKorgus(3900);
        lennuk1.setUlatus(1185);
        lennuk1.määraHind(lennuk1.getKorgus(), lennuk1.getUlatus());
        Lennuk lennuk2 = new Lennuk("L-002TK");
        lennuk2.setKorgus(6000);
        lennuk2.setUlatus(5231);
        lennuk2.määraHind(lennuk2.getKorgus(), lennuk2.getUlatus());
        ArrayList<Soiduk> soidukid = new ArrayList<Soiduk>();
        soidukid.add(auto1);
        soidukid.add(auto2);
        soidukid.add(paat1);
        soidukid.add(paat2);
        soidukid.add(lennuk1);
        soidukid.add(lennuk2);
        for (Soiduk s : soidukid) s.Show();
    }

    static void ül2() {
        String[] sõnad = {"Happy", "Quick", "Jump", "Laugh", "Sleep", "Dance", "Smile", "Run", "Sing", "Swim", "Climb", "Sit", "Stand", "Walk", "Play", "Learn", "Read", "Write", "Listen", "Speak"};
        Stream<String> wordStream = Arrays.stream(sõnad);
        Optional<String> lühim = wordStream.min(Comparator.comparingInt(String::length));
        System.out.print("Lühim sõna on: ");
        lühim.ifPresent(System.out::println);
    }

    static void ül3() {
        List<Integer> numbrid = Arrays.asList(50, 120, 75, 200, 95, 150);
        Stream<Integer> väiksemad = numbrid.stream()
            .filter(number -> number < 100)
            .map(number -> number % 10);
        System.out.println("Viimased numbrid: ");
        väiksemad.forEach(System.out::println);

    }
}