package random;

import java.util.Random;

public class RandomBetween {

    public static void main(String[] args) {
        int n1 = 1;
        int n2 = 100;

        for(int i = 0; i < 10; i++){
            int num = new Random().nextInt(n2 - n1) + n1;
            System.out.println(num);
        }

        // 계속 다른 난수 생성
        int rand = new Random(System.currentTimeMillis()).nextInt(1000);
        System.out.println(rand);
    }
    
}
