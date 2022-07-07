
class Customer {
    enum Gender {
        MALE, FEMALE
    }

    private String name;
    private Gender gender;

    Customer(String n, String g) {
        this.name = n;
        
        if(g.equals("man")) {
            gender = Gender.MALE;
        }
        else{
            gender = Gender.FEMALE;
        }
    }

    @Override
    public String toString() {
        String gen;

        if(gender == Gender.MALE) {
            gen = "남자";
        }
        else{
            gen = "여자";
        }

        return name + "의 성별은 " + gen + "입니다.";
    }
}

class InnerEnum{
    public static void main(String[] args) {
        Customer cus1 = new Customer("Brown", "man");
        Customer cus2 = new Customer("Susan", "woman");

        System.out.println(cus1);
        System.out.println(cus2);
    }
}