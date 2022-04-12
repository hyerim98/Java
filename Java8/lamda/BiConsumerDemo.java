import java.util.function.BiConsumer;

class Box<T>{
    private T ob;

    public void set(T o){
        ob = o;
    }

    public T get(){
        return ob;
    }

}

public class BiConsumerDemo {
    public static void main(String[] args) {
        BiConsumer< Box<Integer>, Integer> conv1 = (b, i) -> b.set(i);
        BiConsumer<Box<Double>, Double> conv2 = (b, d) -> b.set(d);

        Box<Integer> box1 = new Box<>();
        conv1.accept(box1, 3);
        System.out.println(box1.get());

        Box<Double> box2 = new Box<>();
        conv2.accept(box2, 3.5);
        System.out.println(box2.get());
       
    }
}
