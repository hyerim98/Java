import java.util.Arrays;
import java.util.List;

public class FilterAndMap {
    public static void main(String[] args) {
        /* filter : 내부적으로 스트림의 데이터를 하나씩 인자로 전달하면서 test를 호출한다 */
        int[] ar = {1, 2, 3, 4, 5};
         int sum = Arrays.stream(ar) // 스트림생성
                    .filter(n -> n % 2 == 1) // 중간 연산(필터 통과)
                    .sum(); // 최종 연산
         System.out.println("sum : " + sum);


         /* map : 맵핑을 진행하면 스트림의 데이터 형이 달라진다 */
         List<String> list = Arrays.asList("Toy", "Robot", "Simple");
         list.stream().map(s -> s.length()).forEach(System.out::println);
    }
}
