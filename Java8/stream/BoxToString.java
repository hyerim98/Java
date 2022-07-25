import java.util.Arrays;
import java.util.List;

class ABox<T> {
    private T ob;

    public ABox(T ob) {
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }
}

public class BoxToString {
    public static void main(String[] args) {
        List<ABox<String>> list = Arrays.asList(new ABox<>("Robot"), new ABox<>("Simple")); 
        // String 맵핑
        list.stream().map(ABox::getOb).forEach(System.out::println);

        // Integer 맵핑
        list.stream().map(ABox::getOb).map(s -> s.length()).forEach(System.out::println);
    }
}
