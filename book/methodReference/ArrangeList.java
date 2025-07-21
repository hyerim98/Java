import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

// 인스턴스 메소드 참조(인스턴스가 존재하는 상황에서 참조)
class JustSort {
    public void sort(List<?> lst) {
        Collections.reverse(lst);
    }
}

public class ArrangeList {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 3, 5, 7, 9);
        ls = new ArrayList<>(ls);
        
        System.out.println(ls);

        // Consumer<T>    void accept(T t)
        Consumer<List<Integer>> c1 = l -> Collections.reverse(l);
        c1.accept(ls);

        // static 메소드 참조
        Consumer<List<Integer>> c2 = Collections :: reverse; // ClassName::staticMethodName
        c2.accept(ls);

        // 인스턴스 메소드의 참조(인스턴스가 존재하는 상황에서 참조)
        JustSort js = new JustSort();
        Consumer<List<Integer>> c3 = js :: sort; // ReferenceName::instanceMethodName
        c3.accept(ls);

        System.out.println(ls);
    }
}
