# Java   

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
 
