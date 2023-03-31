import Soidukid.*;

public class kirsing_6 {
    public static void main(String[] args) {
        Auto auto1 = new Auto("ABC 123");
        auto1.setKiirus(30);
        auto1.Show();
        Auto auto2 = new Auto("");
        auto2.setNumber("ABC 234");
        auto2.setKiirus(300);
        auto2.määraHind(auto2.getKiirus());
        auto2.Show();
        Paat paat1 = new Paat("PA-12");
        paat1.setKiirus(9);
        paat1.setSyvis(0.4);
        paat1.määraHind(paat1.getSyvis(), paat1.getKiirus());
        paat1.Show();
        Paat paat2 = new Paat("");
        paat2.setNumber("PA-21");
        paat2.setKiirus(11);
        paat2.setSyvis(0.6);
        paat2.määraHind(paat2.getSyvis(), paat2.getKiirus());
        paat2.Show();
        int[] kiirused = {auto1.getHind(), auto2.getHind(), paat1.getHind(), paat2.getHind()};
    }
}