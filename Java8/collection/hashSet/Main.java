package hashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Person> hSet = new HashSet<>();

        hSet.add(new Person("혜림", 25));
        hSet.add(new Person("혜영", 23));
        hSet.add(new Person("뿌엥", 25));
        hSet.add(new Person("혜림", 25));

        System.out.println(hSet.size());

        Iterator<Person> itr = hSet.iterator();
        System.out.println(itr.next());
    }
}
