interface Printable {
    void print();
}

class Papers {
    private String str;

    Papers(String str) {
        this.str = str;
    }

    public Printable getPrinter() {
        return new Printable() {

            @Override
            public void print() {
                System.out.println(str);
            }
            
        };
    }
}

public class AnonymousInner {
    public static void main(String[] args) {
        Papers p = new Papers("Hi_Hello");

        Printable prn = p.getPrinter();

        prn.print();
    }
}
