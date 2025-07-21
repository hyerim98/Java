import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReductionParallel {
    public static void main(String[] args) {
        /* Reduction */
        List<String> list = Arrays.asList("Toy", "simple", "Robot");

        BinaryOperator<String> bo = (s1, s2) -> {
            if(s1.length() > s2.length()) {
                return s1;
            }
            else{
                return s2;
            }
        };

        String str = list.stream().reduce("",bo); // "" : 스트림이 빈 경우에 반환
        System.out.println(str);


        /* Parallel : 병렬처리(속도 빠름) */
        String s = list.parallelStream().reduce("", bo); // "Empty Stream" : 해당 글자 수가 가장 많으므로 출력됨
        System.out.println(s);
    }
}
