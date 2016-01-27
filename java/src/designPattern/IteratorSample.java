package designPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorSample implements Iterable<String> {
	private List<String> list = new ArrayList<String>();

	public void add(String name) {
		list.add(name);
	}

	public Iterator<String> iterator() {
		return new Iterator<String>() {
			int seq = 0;

			public boolean hasNext() {
				return seq < list.size();
			}

			public String next() {
				return list.get(seq++);
			}

			public void remove() {
			}
		};
	}

	public static void main(String[] arg){
		IteratorSample sample = new IteratorSample();
		sample.add("ÀÌÀº°á");
		sample.add("Kevin parker");
		sample.add("David Blaine");
  
		Iterator<String> iterator = sample.iterator();
		while (iterator.hasNext()) {
		  String element = iterator.next();
		  System.out.println(element);
		}
	}
}
