package designPattern;

import java.util.HashMap;
import java.util.Map;
class PersonFactory {
    private static Map<String, Person> map = new HashMap<String, Person>();
    public synchronized static Person getPerson(String name){
        if (!map.containsKey(name)) {
            Person tmp = new Person(name);
            map.put(name, tmp);
        }
        return map.get(name);
    }
}

class Person {
    private final String name;
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

public class FlyweightSample {
    public static void main(String[] args) {
        Person p1 = PersonFactory.getPerson("È«±æµ¿");
        Person p2 = PersonFactory.getPerson("±è¸»ÀÚ");
        Person p3 = PersonFactory.getPerson("È«±æµ¿");
        
        System.out.println(p1 == p2);
        System.out.println(p1 == p3);
    }
}
