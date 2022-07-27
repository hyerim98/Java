import java.util.stream.Stream;

public class StreamConcat {
    public static void main(String[] args) {

        /* 스트림 생성 */
        Stream.of(2, 3, 4).forEach(System.out::println);

        Stream<String> s1 = Stream.of("Cake", "Milk");
        Stream<String> s2 = Stream.of("Lemon", "Jelly");
        /* concat : 스트림 연결 */
        Stream.concat(s1, s2).forEach(System.out::println);
    }
}
