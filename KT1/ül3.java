public class ül3 {
    public static void main(String[] args) {
        System.out.println(eriKaugus(1, 2, 10));
        System.out.println(eriKaugus(3, 2, 1));
        System.out.println(eriKaugus(4, 1, 3));
        System.out.println(eriKaugus(-1, -1, 6));
        System.out.println(eriKaugus(3, 3, 3));
    }

    public static boolean eriKaugus(int a, int b, int c) {
        if(Math.abs(a-b) <= 1 && Math.abs(a-c) >= 2 && Math.abs(b-c) >= 2) {
            return true;
        } else if(Math.abs(a-c) <= 1 && Math.abs(a-b) >= 2 && Math.abs(b-c) >= 2) {
            return true;
        } else if(Math.abs(b-c) <= 1 && Math.abs(a-b) >= 2 && Math.abs(a-c) >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
