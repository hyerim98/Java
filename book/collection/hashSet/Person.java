package hashSet;


import java.util.Objects;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "(" + age + "세)";
    }

    // hashcode 오버라이딩
    @Override
    public int hashCode() {
        // hash 메소드는 하나 이상의 인자를 조합하여 하나의 해쉬 값을 만들어 반환
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        String n = ((Person)obj).name;
        int a = ((Person)obj).age;

        if(name.equals(n) && age == a){
            return true;
        }

        return false;
    }
}
