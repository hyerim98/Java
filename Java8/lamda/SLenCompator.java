import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SLenCompator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Robot");
        list.add("Lambda");
        list.add("Box");

        // 정렬
        Collections.sort(list, (s1, s2) -> s1.length() - s2.length());    

        for(String s : list)
            System.out.println(s);
    }
}
