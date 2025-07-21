import java.util.Optional;

class Friend {
    private String name;
    private Company comp;

    public Friend(String name, Company comp) {
        this.name = name;
        this.comp = comp;
    }

    public String getName() {
        return name;
    }

    public Company getComp() {
        return comp;
    }
}

class Company {
    private String cName;
    private ContInfo ci;

    public Company(String cName, ContInfo ci) {
        this.cName = cName;
        this.ci = ci;
    }

    public String getcName() {
        return cName;
    }

    public ContInfo getCi() {
        return ci;
    }
}

class ContInfo {
    private String phone;
    private String adrs;

    public ContInfo(String phone, String adrs) {
        this.phone = phone;
        this.adrs = adrs;
    }

    public String getPhone() {
        return phone;
    }

    public String getAdrs() {
        return adrs;
    }
}

public class MapElseOptional {

    public static void showCompAddr(Optional<Friend> op) {

        String addr = op.map(Friend::getComp).map(Company::getCi).map(ContInfo::getAdrs).orElse("There id no phone number");
    
        System.out.println(addr);
    } 

    public static void main(String[] args) {
        
        ContInfo ci = new ContInfo(null, "Korea");
        Company cp = new Company("cName", ci);
        Friend fr = new Friend("aaa", cp);

        showCompAddr(Optional.of(fr));
        
    }
}
