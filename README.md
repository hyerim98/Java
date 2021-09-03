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




 
