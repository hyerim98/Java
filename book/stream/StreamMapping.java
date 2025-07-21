import java.util.Arrays;
import java.util.List;

class TestBox<T> {
    private T ob;

    public TestBox(T ob) {
        this.ob = ob;
    }

    public T get(){
        return ob;
    }
    
}

public class StreamMapping {
    public static void main(String[] args) {
        List<TestBox<String>> ls = Arrays.asList(new TestBox<>("Robot"), new TestBox<>("Simple"));

        // String -> String 맵핑
        ls.stream()
        .map(box -> box.get())
        .forEach(System.out::println);

        System.out.println();

        // String -> Integer 맵핑
        ls.stream()
        .map(box -> box.get().length())
        .forEach(System.out::println);
        
    }
}
