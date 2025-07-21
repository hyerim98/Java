import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIfDemo {
    public static void main(String[] args) {
        List<Integer> ls1 = Arrays.asList(1, -2, 3, -4, 5);
        ls1 = new ArrayList<>();
        
        Predicate<Integer> p = n -> n.intValue() < 0;

        // 0보다 작은 정수 리스트에서 삭제
        ls1.removeIf(p);

        System.out.println(ls1);
    }
}
