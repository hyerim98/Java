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
  * LinkedList   
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
