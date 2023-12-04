import java.util.stream.IntStream;

public class MatchStream {
    public static void main(String[] args) {
        
        // allMatch
        boolean b = IntStream.of(1, 2, 3, 4, 5)
                                .allMatch(n -> n % 2 == 0);
        System.out.println("전체 짝수인가? " + b);

        // anyMatch
        b = IntStream.of(1, 2, 3, 4, 5)
                        .anyMatch(n -> n % 2 == 0);
        System.out.println("짝수가 존재하는가? " + b);

        // noneMatch
        b = IntStream.of(1, 2, 3, 4, 5)
                        .noneMatch(n -> n  % 2 == 0);
        System.out.println("짝수가 존재하지 않는가? " + b);
    }
}
