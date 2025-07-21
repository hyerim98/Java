import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamSort {
    public static void main(String[] args) {
        
        /* Sorted : 스트림 정렬 */
        Stream.of("Box", "Rabbit", "Apple")
                .sorted((s1, s2) -> s1.length() - s2.length()) // int compare(T o1, T o2)
                .forEach(System.out::println);


        IntStream.of(5, 9, 3, 7)
                    .sorted()
                    .forEach(System.out::println);
    }
}
