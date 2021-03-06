# Java  

## Comparable & Comparator   
* Comparable : 정의한 class의 인스턴스의 필드 중 특정 필드를 기준으로 정렬하기 위한 인스턴스의 비교 기준을 정의하는 인터페이스   
```
class Person implements Comparable{
	private String name;
	private int height;
	
	public Person(String name, int height) {
		this.name = name;
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name + " " + height;
	}

        // Person을 height를 기준으로 내림차순 정렬
	@Override
	public int compareTo(Object o) {
		Person p = (Person)o;
		return p.height - this.height;
	}
}
```   
* Comparator : 자바에서 제공하는 기본 class(String 등)를 대상으로 정렬 기준을 바꿔야하는 상황에서 사용하는 인터페이스(정의한 class에도 사용가능)    
```
class HeightOrderComparator implements Comparator<Person>{
// Person 클래스를 height를 기준으로 오름차순 정렬
	@Override
	public int compare(Person o1, Person o2) {
		return o1.getHeight() - o2.getHeight();
	}
	
}
```

## 컬렉션 프레임워크   
### List   
  * 특징
    * 인스턴스의 저장 순서를 유지한다   
    * 동일한 인스턴스의 중복 저장을 허용한다   
    * Iterator(반복자)뿐만아니라 ListIterator(양방향 반복자)도 사용 가능하다   
  * ArrayList   
    * 장점 : 저장된 인스턴스의 참조가 빠르다      
    * 단점   
        * 저장 공간을 늘리는 과정에서 시간이 비교적 많이 소요된다   
        * 인스턴스의 삭제 과정에서 많은 연산이 필요하여 느릴 수 있다   
  * LinkedList(List, Deque, Queue)      
    * 장점   
        * 저장 공간을 늘리는 과정이 간단하다   
        * 저장된 인스턴스의 삭제 과정이 단순하다   
    * 단점 : 저장된 인스턴스의 참조 과정이 배열에 비해 복잡하여 느릴 수 있다   

### Set   
  * 특징
     * 저장 순서가 유지되지 않는다   
     * 데이터의 중복 저장을 허용하지 않는다   
  * HashSet   
    * 중복 저장의 원리는 hashCode, equals(참조 값 비교) 메소드에 있다    
    * class의 인스턴스들은 새로운 객체를 생성할 때마다 참조값이 달라지므로 중복 저장이 된다.   
    * 그러므로 2개의 메소드를 적절하게 오버라이딩을 하여 class의 인스턴스 데이터도 중복되면 저장이 되지 않도록 해야한다
    ```
    // Person class에는 name, age 필드가 존재
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    
    @Override
    public boolean equals(Object obj) {
        Person comp = (Person)obj;
        
        if(comp.name.equals(name) && (comp.age == age))
            return true;
        else
            return false;
    }
    ```   
   * TreeSet
     * 정렬된 상태가 유지되면서 인스턴스가 저장된다(default : 오름차순)   
     * 정의한 class의 인스턴스의 필드 중 특정 필드를 기준으로 정렬하고 싶다면 인스턴스의 비교 기준을 정의하는 Comparable 인터페이스를 구현해야한다 
     * 자바에서 제공하는 기본 class(String 등)를 대상으로 정렬 기준을 바꿔야하는 상황에서는 Comparator를 구현하는 것이 좋다   
     ```
     class IntegerComparator implements Comparator<Integer> {
       public int compare(Integer n1, Integer n2) {
           return n2.intValue() - n1.intValue();
       }
     }

     class ComparatorIntegerDemo {
         public static void main(String[] args) {
             TreeSet<Integer> tr = new TreeSet<>(new IntegerComparator());
             tr.add(30);
             tr.add(10);    
             tr.add(20);        
             System.out.println(tr);	
         }
     }
     ```   
     
 ### Queue & Deque & Stack 
 * Queue   
 ```
 class LinkedListQueue {
    public static void main(String[] args) {
        Queue<String> que = new LinkedList<>(); 

        // 데이터 저장       
        que.offer("Box");
        que.offer("Toy");
        que.offer("Robot");

        // 무엇이 다음에 나올지 확인
        System.out.println("next: " + que.peek());

        // 첫 번째, 두 번째 인스턴스 꺼내기
        System.out.println(que.poll());
        System.out.println(que.poll());

        // 무엇이 다음에 나올지 확인
        System.out.println("next: " + que.peek());

        // 마지막 인스턴스 꺼내기
        System.out.println(que.poll());
    }
} 
 ```
 * Deque   
 ```
 class ArrayDequeCollection {
    public static void main(String[] args) {
        Deque<String> deq = new ArrayDeque<>(); 

        // 앞으로 넣고       
        deq.offerFirst("1.Box");
        deq.offerFirst("2.Toy");
        deq.offerFirst("3.Robot");

        // 앞에서 꺼내기
        System.out.println(deq.pollFirst());
        System.out.println(deq.pollFirst());
        System.out.println(deq.pollFirst());  
    }
}
 ```   
 * Stack
 ```
 interface DIStack<E> {
    public boolean push(E item);
    public E pop();
}

class DCStack<E> implements DIStack<E> {
    private Deque<E> deq;

    public DCStack(Deque<E> d) {
        deq = d;
    }

    public boolean push(E item) {
        return deq.offerFirst(item);
    }
    
    public E pop() {
        return deq.pollFirst();
    }
}


class DefinedStack {
    public static void main(String[] args) {
        // 배열 기반의 스택 생성
        DIStack<String> stk = new DCStack<>(new ArrayDeque<String>()); 
        // 리스트 기반의 스택 생성
        DIStack<String> stk = new DCStack<>(new LinkedList<String>());

        // PUSH 연산
        stk.push("1.Box");
        stk.push("2.Toy");
        stk.push("3.Robot");

        // POP 연산
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());  
    }
}
 ```   
 
 ### Map   
 * HashMap
 * TreeMap : 정렬 상태를 유지한다(정렬 기준 : key)   

## 네스티드 클래스와 람다      
### 멤버 클래스   
```
interface Printable {
    void print();   
}

class Papers {
    private String con;

    public Papers(String s) {
        con = s;
    }

    public Printable getPrinter() {
        return new Printer();
    }

    private class Printer implements Printable {
        public void print() {
            System.out.println(con);
        }
    }
}

class UseMemberInner {
    public static void main(String[] args) {
        Papers p = new Papers("서류 내용: 행복합니다.");
        Printable prn = p.getPrinter();
        prn.print();
    }
}
```  

### 로컬 클래스
```
interface Printable {
    void print();   
}

class Papers {
    private String con;
    public Papers(String s) { con = s; }

    public Printable getPrinter() {
        class Printer implements Printable {
            public void print() { System.out.println(con); }
        }
        
        return new Printer();
    }
}

class UseLocalInner {
    public static void main(String[] args) {
        Papers p = new Papers("서류 내용: 행복합니다.");
        Printable prn = p.getPrinter();
        prn.print();
    }
}
```   

## 익명 클래스   
```
class AnonymousComparator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("ROBOT");
        list.add("APPLE");
        list.add("BOX");
        
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };

        Collections.sort(list, cmp);
        System.out.println(list);
    }
}
```   
## 람다   
```
interface Printable {
    void print(String s);
}

class Lambda3 {
    public static void main(String[] args) {
    
    	// 익명 클래스
    	Printable prn = new Printable() {
            public void print(String s) {
                System.out.println(s);
            }
        };
	
	// 람다
        Printable prn = (s) -> { System.out.println(s); };
        prn.print("What is Lambda?");
}
```   
### 람다 매개변수 전달
```
interface Printable {
    void print(String s);
}

public static void ShowString(Printable p, String s) {
      p.print(s);
}

public static void main(String[] args) {
      ShowString((s) -> { System.out.println(s); }, "What is Lambda?");
}
```   
## 정의되어 있는 함수형 인터페이스   
### Predicate   
전달된 인자를 판단하여 T/F를 반환해야 하는 상황일 때 사용   
```
public static <T> void show(Predicate<T> p, List<T> list) {
	for(T n : list) {
		if(p.test(n)) {
			System.out.print(n + " ");
		}
	}
	System.out.println();
}

public static void main(String[] args) {
	List<Integer> lst1 = Arrays.asList(1,3,8,10,11);
	show(n -> n%2 != 0, lst1); // 홀수만 출력
		
	List<Double> lst2 = Arrays.asList(-1.2, 3.5, -2.4, 9.5);
	show(n -> n > 0.0, lst2); // 0보다 큰 수만 출력

}
```   
### Supplier   
단순히 무엇인가를 반환해야 할 때 사용   
```
class SupplierDemo {
    public static List<Integer> makeIntList(Supplier<Integer> s, int n) {
        List<Integer> list = new ArrayList<>();    
        for(int i = 0; i < n; i++)
            list.add(s.get());
        return list;
    }
    
    public static void main(String[] args) {
        Supplier<Integer> spr = () -> {
            Random rand = new Random();
            return rand.nextInt(50);
        };

        List<Integer> list = makeIntList(spr, 5);
        System.out.println(list);

        list = makeIntList(spr, 10);
        System.out.println(list);
    }
}
```   
### Consumer   
전달된 인자를 가지고 어떤 결과를 보여야 할 때 사용   
```
class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> c = s -> System.out.println(s);
        
        c.accept("Pineapple");    // 출력이라는 결과를 보임
        c.accept("Strawberry");
    }
}
```   
### Fuction   
전달 인자와 반환 값이 모두 존재할 때 사용   
```
class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> f = s -> s.length();

        System.out.println(f.apply("Robot"));
        System.out.println(f.apply("System"));
    }
}
```   

## Optional  
* if문 대체
```
public void ifPresent(Consumer<? super T> consumer)
```
```
class StringOptional2 {
    public static void main(String[] args) {
        Optional<String> os1 = Optional.of(new String("Toy1")); // NULL값 허용 안됨
        Optional<String> os2 = Optional.ofNullable(new String("Toy2")); // NULL값 허용됨

        // 람다식 버전 : 내용물이 os1에 존재한다면, 인자가 전달되면서 accept 메소드가 호출된다.
        os1.ifPresent(s -> System.out.println(s));

        // 메소드 참조 버전
        os2.ifPresent(System.out::println);
    }
}
```   

* if~else문 대체   
1. map은 Optional로 감싸서 값을 반환한다   
```
class OptionalOrElse {
    public static void main(String[] args) {
        Optional<String> os1 = Optional.empty();
        Optional<String> os2 = Optional.of("So Basic");

        String s1 = os1.map(s -> s.toString()) // 인스턴스가 존재한다면
                       .orElse("Empty"); // 인스턴스가 존재하지 않다면

        String s2 = os2.map(s -> s.toString())
                       .orElse("Empty");

        System.out.println(s1);
        System.out.println(s2);
    }
}
```   
2. flatMap은 Optional 인스턴스를 클래스의 멤버로 두는 경우에 사용   
```
class ContInfo {
    Optional<String> phone;   // null 일 수 있음
    Optional<String> adrs;    // null 일 수 있음

    public ContInfo(Optional<String> ph, Optional<String> ad) {
        phone = ph;
        adrs = ad;
    }
    public Optional<String> getPhone() { return phone; }
    public Optional<String> getAdrs() { return adrs; }
}

class FlatMapElseOptional {
    public static void main(String[] args) {
        Optional<ContInfo> ci = Optional.of(
            new ContInfo(Optional.ofNullable(null), Optional.of("Republic of Korea"))
        );
        
        String phone = ci.flatMap(c -> c.getPhone())
                         .orElse("There is no phone number.");

        String addr = ci.flatMap(c -> c.getAdrs())
                        .orElse("There is no address.");
          
        System.out.println(phone);
        System.out.println(addr);
    }
}
```   

## 스트림(Stream)
```
class MyFirstStream2 {
    public static void main(String[] args) {
    	// 배열 스트림
        int[] ar = {1, 2, 3, 4, 5};

        int sum = Arrays.stream(ar) // 스트림 생성
                        .filter(n -> n%2 == 1) // 중간 연산
                        .sum(); // 최종 연산

        System.out.println(sum);
	
	// 컬렉션 스트림
	List<String> list = Arrays.asList("Toy", "Robot", "Box");
        
        list.stream() // 스트림 생성
          .map(s -> s.length()) // 중간 연산(String형 스트림 -> Integer형 스트림으로 변환하는 연산작업)
          .forEach(n -> System.out.print(n + "\t")); // 최종 연산
        
	// Reduction
        BinaryOperator<String> lc = 
            (s1, s2) -> { 
               if(s1.length() > s2.length())
                   return s1;
               else 
                   return s2;                   
            };
        
        String str = list.stream()
                      .reduce("", lc); // 스트림이 빈 경우 빈 문자열 반환
      
        System.out.println(str); // Robot
    }
}
```   
## 스트림2   
* flatMap
```
class GradeAverage2 {
    public static void main(String[] args) {
        ReportCard[] cards = {
            new ReportCard(70, 80, 90),
            new ReportCard(90, 80, 70),
            new ReportCard(80, 80, 80)
        };       

        Arrays.stream(cards) // ReportCard 인스턴스로 이루어진 스트림 생성
           .flatMapToInt(r -> IntStream.of(r.getKor(), r.getEng(), r.getMath())) // flatMap을 이용하여 학생들의 국,영,수 점수로 이루어진 스트림 생성
           .average() // 최종 연산
           .ifPresent(avg -> System.out.println("avg. " + avg));        
     }
}
```   
* 중간 연산   
```
// 정렬 Stream<T> sorted(Comparator<? super T> comparator)
IntStream.of(3, 9, 4, 2)
            .sorted()
            .forEach(d -> System.out.print(d + "\t"));
	    
	 
// 루핑 (최종연산인 forEach의 중간연산 버전 : forEach - 반환형이 void, peek - 반환형이 void가 아니다)
IntStream.of(5, 3, 1)
            .peek(d -> System.out.print(d + "\t"))
            .sum(); 
```   
* 최종 연산   
```
class OpIntStream {
    public static void main(String[] args) {
        // 합
        int sum = IntStream.of(1, 3, 5, 7, 9)
                          .sum();
        System.out.println("sum = " + sum);

        // 개수
        long cnt = IntStream.of(1, 3, 5, 7, 9)
                          .count();
        System.out.println("count = " + cnt);

        // 평균
        IntStream.of(1, 3, 5, 7, 9)
                .average()
                .ifPresent(av -> System.out.println("avg = " + av));

        // 최소
        IntStream.of(1, 3, 5, 7, 9)
                .min()
                .ifPresent(mn -> System.out.println("min = " + mn));

        // 최대
        IntStream.of(1, 3, 5, 7, 9)
                .max()
                .ifPresent(mx -> System.out.println("max = " + mx));
		
		
	// MatrchStream	
	boolean b = IntStream.of(1, 2, 3, 4, 5)
                          .allMatch(n -> n%2 == 0);
        System.out.println("모두 짝수이다. " + b);

        b = IntStream.of(1, 2, 3, 4, 5)
                    .anyMatch(n -> n%2 == 0);
        System.out.println("짝수가 하나는 있다. " + b);

        b = IntStream.of(1, 2, 3, 4, 5)
                    .noneMatch(n -> n%2 == 0);
        System.out.println("짝수가 하나도 없다. " + b);
	
	
	// collect
	String[] words = {"Hello", "Box", "Robot", "Toy"};
        Stream<String> ss = Arrays.stream(words);
        
        List<String> ls = ss.filter(s -> s.length() < 5)
                          .collect(
                              () -> new ArrayList<>(), // 데이터를 저장할 저장소를 생성
                              (c, s) -> c.add(s), // c - 컬렉션 인스턴스, s - 스트림을 이루는 데이터들
                              (lst1, lst2) -> lst1.addAll(lst2)); // 순차 스트림이라면 의미가 없는 람다식(병렬 스트림이라면 저장소에 담긴 데이터들을 하나로 묶는 과정)
    
        System.out.println(ls);
 
    }
}
```   

## I/O 스트림   
* 바이트 스트림   
```
// 입력 스트림
InputStream in = new FileInputStream("경로");
// 출력 스트림
OutputStream out = new FileOutputStream("경로");
```   
* 바이트 필터 스트림(자바 프로그램 - 필터 스트림 - 바이트 스트림 - 파일) (기본 자료형 데이터를 저장하는 필터)   
```
// 입력 필터 스트림
DataInputStream in = 
                 new DataInputStream(new FileInputStream("data.dat"));
		 
// 출력 필터 스트림
DataOutputStream out = 
                 new DataOutputStream(new FileOutputStream("data.dat"));
```
* 바이트 버퍼 필터 스트림(자바 프로그램 - 필터 스트림 - 바이트 스트림 - 파일) (버퍼가 꽉 차야 전송됨)   
```
// 입력 버퍼 필터 스트림  
BufferedInputStream in = 
                   new BufferedInputStream(new FileInputStream(src));
		   
// 출력 버퍼 필터 스트림
BufferedOutputStream out = 
                   new BufferedOutputStream(new FileOutputStream(dst));
```
* 문자 스트림   
```
// 문자 입력 스트림
Reader in = new FileReader("경로");
// 문자 출력 스트림
Writer out = new FileWriter("data.txt")
```   
* 문자 버퍼 필터 스트림   
```
// 입력 문자 버퍼 필터 스트림
BufferedReader br = new BufferedReader(new FileReader("String.txt"));
// 출력 문자 버퍼 필터 스트림
BufferedWriter bw = new BufferedWriter(new FileWriter("String.txt"));
```
* 객체 스트림   
```
// 입력 객체 스트림
ObjectInputStream oi = 
                new ObjectInputStream(new FileInputStream("Object.bin"));
		
// 출력 객체 스트림
ObjectOutputStream oo = 
                new ObjectOutputStream(new FileOutputStream("Object.bin"));
```   

## 쓰레드와 동기화   
```
class Counter { 
    int count = 0; 

    public void increment() {
        synchronized(this) { // 하나의 쓰레드만 접근 가능하도록 동기화 설정
            count++;
        }
    }

    public void decrement() {
        synchronized(this) { // 하나의 쓰레드만 접근 가능하도록 동기화 설정
            count--;
        }
    }

    public int getCount() { return count; }
}

class MutualAccess {
    public static Counter cnt = new Counter();

    public static void main(String[] args) throws InterruptedException {        
        Runnable task1 = () -> {
            for(int i = 0; i<1000; i++)
                cnt.increment();
        };

        Runnable task2 = () -> {
            for(int i = 0; i<1000; i++)
                cnt.decrement();
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        
        t1.start(); // 쓰레드 시작
        t2.start();
    
        t1.join(); // main 쓰레드가 t1의 쓰레드가 종료될때까지 기다린다
        t2.join(); // main 쓰레드가 t2의 쓰레드가 종료될때까지 기다린다
     
        System.out.println(cnt.getCount());
    }
}
```




 
