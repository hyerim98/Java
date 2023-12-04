import java.util.ArrayList;
import java.util.List;

class ToyPriceInfo {
    private String model;
    private int price;
    
    public ToyPriceInfo(String m, int p) {
        model = m;
        price = p;
    }

    public int getPrice() {
        return price;
    }

    public String getModel() {
        return model;
    }
}


public class StreamFilterMapping {
    public static void main(String[] args) {
        List<ToyPriceInfo> ls = new ArrayList<>();
        ls.add(new ToyPriceInfo("GUN_LR_45", 200));
        ls.add(new ToyPriceInfo("TEDDY_BEAR_S_014", 350));
        ls.add(new ToyPriceInfo("CAR_TRANSFORM_VER_7719", 550));
                  
        ls.stream()
            .filter(toy -> toy.getModel().length() > 10)
            .map(ToyPriceInfo::getModel)  // .map(m -> m.getModel())
            .forEach(System.out::println);
                       
    }
}
