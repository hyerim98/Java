interface Printable {
    void print(String s);
}

public class Lamda {

    public static void showString(Printable p, String s) {
        p.print(s);
    }

    public static void main(String[] args) {
        showString((s) -> {System.out.println(s);}, "Lambda!!");
    }
}
