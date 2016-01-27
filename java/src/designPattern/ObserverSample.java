package designPattern;

import java.util.Observable;
import java.util.Observer;
class Watcher extends Observable {
    public void action(String string) {
        System.out.println("======="+string+"========");
        setChanged();
        notifyObservers(string);
    }
}

class Employee implements Observer {
    private String desc;
    public Employee(String desc) {
        this.desc = desc;
    }
    public void update(Observable o, Object arg) {
        if (o instanceof Watcher) {
            System.out.println(desc + "이 일하는 척");
        }
    }
    public String getDesc() {
        return desc;
    }
}

class Spy implements Observer {
    private Employee employee;
    public Spy(Employee employee) {
        this.employee = employee;
    }
    public void update(Observable o, Object arg) {
        if (o instanceof Watcher) {
            System.out.println("고자질쟁이가 "+employee.getDesc() +"이 놀고 있었다고 고자질.");
        }
    }
}

public class ObserverSample {
    public static void main(String[] args) {
        Watcher watcher = new Watcher();
        Employee pc1 = new Employee("만화책보는 놈");
        Employee pc2 = new Employee("퍼질러 자는 놈");
        Employee pc3 = new Employee("포카치는 놈");
        //spy는 pc3을 보고 있음.
        //요놈은 꼰질르기의 대가
        Spy spy = new Spy(pc3);
        
        watcher.addObserver(pc1);
        watcher.addObserver(pc2);
        watcher.addObserver(pc3);
        watcher.addObserver(spy);
        
        watcher.action("사장 뜸.");
        watcher.deleteObserver(pc3);
        watcher.deleteObserver(spy);
        
        watcher.action("사장 뜸.");
    }
}
