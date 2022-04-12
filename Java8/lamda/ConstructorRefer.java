import java.util.function.BiFunction;

class Box<T, U> {
    private T id;
    private U con;

    public Box(T id, U con) {
        this.id = id;
        this.con = con;
    }

    public void showIt(){
        System.out.println("ID : " + id + ", " + "Contents : " + con);
    }
    
}

class ConstructorRefer {
    public static void main(String[] args) {
        BiFunction<Integer, String, Box<Integer, String>> bf = (a, b) -> new Box<>(a, b);
        // 생성자 참조 버전
        // BiFunction<Integer, String, Box<Integer, String>> bf = Box::new;
        
        Box<Integer, String> b1 = bf.apply(1, "Toy");
        Box<Integer, String> b2 = bf.apply(2, "Robot");
        b1.showIt();
        b2.showIt();
    }
}
