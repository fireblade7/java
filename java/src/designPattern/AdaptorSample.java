package designPattern;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class AdaptorSample {
	public static void goodMethod(Enumeration<String> enu) {
		while (enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("¿Ã¿∫∞·");
		list.add("Kevin parker");
		list.add("David Blaine");
		Enumeration<String> ite = new IteratorToEnumeration(list.iterator());
		AdaptorSample.goodMethod(ite);
	}
}

class IteratorToEnumeration implements Enumeration<String>{
    private Iterator<String> iter;
    
    public IteratorToEnumeration(Iterator<String> iter) {
        this.iter = iter;
    }
    
    public boolean hasMoreElements() {
        return iter.hasNext();
    }
    
    public String nextElement() {
        return iter.next();
    }
}