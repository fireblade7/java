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
            System.out.println(desc + "�� ���ϴ� ô");
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
            System.out.println("���������̰� "+employee.getDesc() +"�� ��� �־��ٰ� ������.");
        }
    }
}

public class ObserverSample {
    public static void main(String[] args) {
        Watcher watcher = new Watcher();
        Employee pc1 = new Employee("��ȭå���� ��");
        Employee pc2 = new Employee("������ �ڴ� ��");
        Employee pc3 = new Employee("��īġ�� ��");
        //spy�� pc3�� ���� ����.
        //����� ���������� �밡
        Spy spy = new Spy(pc3);
        
        watcher.addObserver(pc1);
        watcher.addObserver(pc2);
        watcher.addObserver(pc3);
        watcher.addObserver(spy);
        
        watcher.action("���� ��.");
        watcher.deleteObserver(pc3);
        watcher.deleteObserver(spy);
        
        watcher.action("���� ��.");
    }
}
