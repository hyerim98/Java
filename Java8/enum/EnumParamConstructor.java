enum Person {
    MAN(29), WOMAN(25);

    int age;

    Person(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "나이 : " + age;
    }
}

public class EnumParamConstructor {
    public static void main(String[] args) {
        System.out.println(Person.MAN);
        System.out.println(Person.WOMAN);
    }
}
