import java.util.stream.IntStream;

public class OpIntStream {
    public static void main(String[] args) {
        
        /* 최종연산 */

        // 합계
        int sum = IntStream.of(1, 3, 5, 7, 9).sum();
        System.out.println("sum : " + sum);

        // 개수
        long count = IntStream.of(1, 3, 5, 7, 9).count();
        System.out.println("count : " + count);

        // 평균
        IntStream.of(1, 3, 5, 7, 9).average().ifPresent(a -> System.out.println("avg : " + a));

        // 최대
        IntStream.of(1, 3, 5, 7, 9).max().ifPresent(mx -> System.out.println("max : " + mx));

        // 최소
        IntStream.of(1, 3, 5, 7, 9).min().ifPresent(mn -> System.out.println("min : " + mn));
    }
}
