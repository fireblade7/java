package designPattern;

class SingletonCounter {
    private static SingletonCounter singleton = new SingletonCounter();
    private int cnt = 0;
    private SingletonCounter(){
    }
    public static SingletonCounter getInstance(){
        return singleton;
    }
    public int getNextInt(){
        return ++cnt;
    }
}

public class SingletonSample {
    public static void main(String[] args) {
    	SingletonSample t = new SingletonSample();
        t.Amethod();
        t.Bmethod();
    }
    public void Amethod(){
        SingletonCounter sc = SingletonCounter.getInstance();
        System.out.println("Amethod���� ī���� ȣ�� " + sc.getNextInt() );
    }
    public void Bmethod(){
        SingletonCounter sc = SingletonCounter.getInstance();
        System.out.println("Bmethod���� ī���� ȣ�� " + sc.getNextInt() );
    }
}