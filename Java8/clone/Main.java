package clone;

public class Main {
    public static void main(String[] args) {
        Business bz1 = new Business("태광산업", "무역");
        Business bz2 = new Business("미디어로그", "소프트웨어 개발");
        Business bz3 = bz1.clone();

        bz1.showBuinessInfo();
        bz2.showBuinessInfo();
        bz3.showBuinessInfo();

        PersonalInfo info1 = new PersonalInfo("최혜영", 23, bz1);
        PersonalInfo info2 = new PersonalInfo("최혜림", 25, bz2);
        PersonalInfo info3 = info2.clone();

        info1.showPersonalInfo();
        info2.showPersonalInfo();
        info3.showPersonalInfo();
        
    }
}
