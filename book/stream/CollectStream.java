import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CollectStream {
    public static void main(String[] args) {
        
        // collect : 스트림에서 조건에 맞는 데이터를 거른 후 컬렉션 인스턴스에 저장
        String[] words = {"Hello", "Box", "Robot", "Toy"};
        Stream<String> ss = Arrays.stream(words);

        List<String> list1 = ss.filter(s -> s.length() < 5) // 필터링
                                .collect(() -> new ArrayList<>(), // 데이터를 저장할 저장소를 생성
                                            (c, s) -> c.add(s), // 컬렉션 인스턴스에 스트림의 데이터 저장
                                            (lst1, lst2) -> lst1.addAll(lst2)); // 순차 스트림에서는 의미없는 람다식
                                    
        System.out.println(list1);
        System.out.println(list1.getClass().getName());

        // 병렬 스트림
        List<String> list2 = ss.parallel()
                                .filter(s -> s.length() < 5) // 필터링
                                .collect(() -> new ArrayList<>(), // 데이터를 저장할 저장소를 생성
                                            (c, s) -> c.add(s), // 컬렉션 인스턴스에 스트림의 데이터 저장
                                            (lst1, lst2) -> lst1.addAll(lst2)); // 저장소에 담긴 데이터들을 하나로 묶는 과정
    }
}
