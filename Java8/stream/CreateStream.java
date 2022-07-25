import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        /* 스트림 연습 */
         int[] ar = {1, 2, 3, 4, 5};
         int sum = Arrays.stream(ar) // 스트림생성
                    .filter(n -> n % 2 == 1) // 중간 연산(필터 통과)
                    .sum(); // 최종 연산
         System.out.println("sum : " + sum);


         /* 스트림 생성 : String */
        String[] names = {"YOON", "LEE", "PARK"};
        Stream<String> stm = Arrays.stream(names); // 스트림 생성
        stm.forEach(System.out::println); // 최종 연산

        Arrays.stream(names).forEach(System.out::println);


        /* 스트림 생성 : Double */
        double[] ds = {1.1, 2.2, 3.3, 4.4, 5.5};
        Arrays.stream(ds, 1, 4) // 인덱스 1부터 인덱스 4이전까지의 데이터로 스트림 생성
                .forEach(d -> System.out.println(d));


        /* 스트림 생성 : 컬렉션 인스턴스 */
        List<String> list = Arrays.asList("Toy", "Robot", "Box");
        list.stream().forEach(System.out::println);
    }
}
