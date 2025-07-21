import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class ReportCard {
    private int kor;
    private int eng;
    private int math;

    public ReportCard(int k, int e, int m) {
        kor = k;
        eng = e;
        math = m;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }
}

public class GradeAverage {

    public static void main(String[] args) {
        ReportCard[] cards = {
            new ReportCard(90, 80, 70),
            new ReportCard(50, 40, 30),
            new ReportCard(100, 100, 95)
        };
    
        Stream<ReportCard> ls = Arrays.stream(cards);
    
        // map = 1 : 1 매핑
        // flatMap = 1 : N 매핑
        IntStream iStream = ls.flatMapToInt(c -> IntStream.of(c.getKor(), c.getEng(), c.getMath()));
        double avg = iStream.average().getAsDouble();
        
        System.out.println("avg : " + avg);


        Arrays.stream(cards).flatMapToInt(c -> IntStream.of(c.getKor(), c.getEng(), c.getMath())).average()
                .ifPresent(a -> System.out.println("avg. " + a));

        
        /* Match */
        boolean b = Arrays.stream(cards).mapToDouble(c -> (c.getEng() + c.getKor() + c.getMath()) / 3.0)
                                            .anyMatch(n -> n > 90);
        System.out.println("평균 90점이상이 존재합니까? " + b);
    }
    
}
