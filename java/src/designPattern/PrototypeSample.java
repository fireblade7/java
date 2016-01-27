package designPattern;

import java.util.Date;
class Complex implements Cloneable{
    private String complexInfo;
    private Date date;
    public Complex(String complexInfo) {
        this.complexInfo = complexInfo;
    }
    public String getComplexInfo() {
        return complexInfo;
    }
    public void setDate(Date date){
        this.date = new Date(date.getTime());
    }
    public Date getDate() {
        return date;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        Complex tmp = (Complex) super.clone();
        return tmp;
    }
}

public class PrototypeSample {
    public static void main(String[] args) {
        Complex com = new Complex("매우 복잡한 정보");
        try {
            Complex cloned1 = (Complex)com.clone();
            cloned1.setDate(new Date(2008,0,1));
            Complex cloned2 = (Complex)com.clone();
            cloned2.setDate(new Date(2008,2,1));
            
            System.out.println(cloned1.getDate());
            System.out.println(cloned2.getDate());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
