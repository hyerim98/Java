package clone;

public class PersonalInfo implements Cloneable{
    private String name;
    private int age;
    private Business bz;

    public PersonalInfo(String name, int age, Business bz) {
        this.name = name;
        this.age = age;
        this.bz = bz;
    }

    @Override
    public PersonalInfo clone(){

        // String, int는 깊은 복사 안해도 됨
        // Object 클래스는 깊은 복사 필요

        PersonalInfo info = null;

        try{
            info = (PersonalInfo) super.clone();
            info.bz = (Business) this.bz.clone();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return info;
    }

    public void showPersonalInfo(){
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        bz.showBuinessInfo();
    }
}
