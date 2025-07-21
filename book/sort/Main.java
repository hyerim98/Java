package sort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person[] arr = new Person[3];
        arr[0] = new Person("혜리미", 25);
        arr[1] = new Person("체리나무", 52);
        arr[2] = new Person("혜영", 23);

        // Person 클래스에 구현되어 있는 comapreTo 메소드 기준에 따라 정렬됨
        Arrays.sort(arr);

        for(Person p : arr){
            System.out.println(p);
        }

    }
}
