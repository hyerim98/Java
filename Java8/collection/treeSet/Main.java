package treeSet;

import java.util.Comparator;
import java.util.TreeSet;

// TreeSet은 정렬된 상태가 유지되면서 인스턴스가 저장된다.

class IntegerComparator implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
       return o2.intValue() - o1.intValue();
    }

}

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> tr = new TreeSet<>(new IntegerComparator());
        tr.add(30);
        tr.add(10);
        tr.add(20);
        System.out.println(tr);
    }
}
