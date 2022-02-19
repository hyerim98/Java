public class Main {
    
    public static void main(String[] args) {
        System.out.println("--------------------Question 1-----------------------");
        DBox<String, Integer> box1 = new DBox<>();
        box1.set("Apple", 25);

        DBox<String, Integer> box2 = new DBox<>();
        box2.set("Orange", 33);

        DDBox<DBox<String, Integer>, DBox<String, Integer>> ddbox = new DDBox<>();
        ddbox.set(box1, box2);
        System.out.println(ddbox);


        System.out.println("--------------------Question 2-----------------------");
        DBox<String, Integer> box3 = new DBox<>();
        box3.set("Watermelon", 23);

        DBox<String, Integer> box4 = new DBox<>();
        box4.set("Kiwi", 30);

        DBox<DBox<String, Integer>, DBox<String, Integer>> dBox = new DBox<>();
        dBox.set(box3, box4);

        System.out.println(dBox);



        System.out.println("--------------------Question 3-----------------------");
        Box<Integer> b1 = new Box<>();
        b1.set(99);

        Box<Integer> b2 = new Box<>();
        b2.set(55);

        System.out.println(b1.get() + " & " + b2.get());

        swapBox(b1, b2);

        System.out.println(b1.get() + " & " + b2.get());
    }

    // Question3
    public static <T extends Number> void swapBox(Box<T> b1, Box<T> b2){
        T tmp = b1.get();
        b1.set(b2.get());
        b2.set(tmp);
    }
}
