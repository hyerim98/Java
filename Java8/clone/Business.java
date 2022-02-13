package clone;

public class Business implements Cloneable{
    private String company;
    private String work;

    public Business(String company, String work) {
        this.company = company;
        this.work = work;
    }

    @Override
    public Business clone() {
        // String 클래스는 깊은 복사 안해도 됨
        Business bz = null;

        try{
            bz = (Business) super.clone();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return bz;
    }

    public void showBuinessInfo(){
        System.out.println("회사 : " + company);
        System.out.println("업무 : "  + work);
    }
    
}
