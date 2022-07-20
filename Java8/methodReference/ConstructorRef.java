import java.util.function.BiFunction;


class Box<T, U> {

    private T id;
    private U con;

    public Box(T i, U c) {
        id = i;
        con = c;
    }

    public void showIt() {
        System.out.println("ID : " + id + ", " + "Contents: " + con);
    }
}

public class ConstructorRef {
    public static void main(String[] args) {
        BiFunction<Integer, String, Box<Integer, String>> bf = Box::new; // 생성자 참조

        Box<Integer, String> box1 = bf.apply(1, "Toy");
        Box<Integer, String> box2 = bf.apply(2, "Robot");

        box1.showIt();
        box2.showIt();
    }
}
