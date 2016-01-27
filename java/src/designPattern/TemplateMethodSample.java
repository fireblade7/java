package designPattern;

abstract class Worker {
    protected abstract void doit();
    public final void work(){
        System.out.println("출근");
        doit();
        System.out.println("퇴근");
    }
}

class Designer extends Worker {
    @Override
    protected void doit() {
        System.out.println("열심히 디자인");
    }
}

class Gamer extends Worker {
    @Override
    protected void doit(){
        System.out.println("열심히 껨질");
    }
}

public class TemplateMethodSample {
    public static void main(String[] args) {
        Worker designer = new Designer();
        designer.work();
        Worker gamer = new Gamer();
        gamer.work();
    }
}
