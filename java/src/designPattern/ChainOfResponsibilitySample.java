package designPattern;

abstract class Expert {
    private Expert next;
    protected String expertName;
    public final void support(Problem p){
        if (solve(p)) {
           System.out.println(expertName+ "이(가) " + p.getProblemName()  +"을(를) 해결해 버렸네.");
        }else{
            if (next != null) {
                next.support(p);
            }else{
                System.out.println(p.getProblemName() + "은(는) 해결할 넘이 없다.");
            }
        }
    }
    public Expert setNext(Expert next){
        this.next = next;
        return next;
    }
    protected abstract boolean solve(Problem p);
}

class Problem {
    private String problemName;
    public Problem(String name) {
        this.problemName = name;
    }
    public String getProblemName() {
        return problemName;
    }
}

class Fighter extends Expert {
    public Fighter(){
        this.expertName = "격투가";
    }
    @Override
    protected boolean solve(Problem p) {
        return p.getProblemName().contains("깡패");
    }
}

class Hacker extends Expert {
    public Hacker(){
        this.expertName = "해커";        
    }
    @Override
    protected boolean solve(Problem p) {
        return p.getProblemName().contains("컴퓨터");
    }
}

class Casanova extends Expert {
    public Casanova(){
        expertName = "카사노바";
    }
    @Override
    protected boolean solve(Problem p) {
        return p.getProblemName().contains("여자") || p.getProblemName().contains("여성");
    }
}

public class ChainOfResponsibilitySample {
    public static void main(String[] args) {
        Problem[] problems = new Problem[5];
        problems[0] = new Problem("덩치 큰 깡패");
        problems[1] = new Problem("컴퓨터 보안장치");
        problems[2] = new Problem("까칠한 여자");
        problems[3] = new Problem("날렵한 깡패");
        problems[4] = new Problem("폭탄");
        
        Expert fighter = new Fighter();
        Expert hacker = new Hacker();
        Expert casanova = new Casanova();
        
        fighter.setNext(hacker).setNext(casanova);
        
        for (Problem problem : problems) {
            fighter.support(problem);
        }
    }
}
