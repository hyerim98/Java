import java.util.Optional;

class Friend {
    private String name;
    private Optional<Company> comp;

    public Friend(String name, Optional<Company> comp) {
        this.name = name;
        this.comp = comp;
    }

    public String getName() {
        return name;
    }

    public Optional<Company> getComp() {
        return comp;
    }
}

class Company {
    private String cName;
    private Optional<ContInfo> ci;

    public Company(String cName, Optional<ContInfo> ci) {
        this.cName = cName;
        this.ci = ci;
    }

    public String getcName() {
        return cName;
    }

    public Optional<ContInfo> getCi() {
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

public class FlatMapElseOptional {
    public static void showCompAddr(Optional<Friend> op) {
        String addr = op.flatMap(Friend::getComp).flatMap(Company::getCi).map(ContInfo::getAdrs).orElse("There is no phone number");
        System.out.println(addr);
    }

    public static void main(String[] args) {
        Optional<ContInfo> ci = Optional.of(new ContInfo(null, "South Korea"));
        Optional<Company> cp = Optional.of(new Company("cName", ci));
        Optional<Friend> fr = Optional.of(new Friend("ccccc", cp));

        showCompAddr(fr);
    }
}
