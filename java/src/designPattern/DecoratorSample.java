package designPattern;

class Decorator {
    public String getMerong(){
        return "merong";
    }
}

class ChildDecorator extends Decorator{
    private Decorator decorator;
    public ChildDecorator(Decorator decorator){
        this.decorator = decorator;
    }
    @Override
    public String getMerong(){
        return "@" + decorator.getMerong() + "@";
    }
}

public class DecoratorSample {
    public static void main(String[] args) {
        Decorator decorator = new Decorator();
        System.out.println(decorator.getMerong());
        Decorator child = new ChildDecorator(decorator);
        System.out.println(child.getMerong());
        Decorator child2 = new ChildDecorator(child);
        System.out.println(child2.getMerong());
    }
}
