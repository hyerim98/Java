package equals;

public class Main {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(2, 3, 4, 1);
        Rectangle r2 = new Rectangle(2, 3, 4, 1);
        Rectangle r3 = new Rectangle(2, 4, 5, 2);

        if(r1.equals(r2)){
            System.out.println("같은 사각형");
        }
        else{
            System.out.println("다른 사각형");
        }

        if(r1.equals(r3)){
            System.out.println("같은 사각형");
        }
        else{
            System.out.println("다른 사각형");
        }
    }
}