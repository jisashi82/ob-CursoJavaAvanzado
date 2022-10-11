package io.codemalone.pattern.iterator;

public class Demo {

	public static void main(String[] args) {
		NameRepository nameRepository = new NameRepository();
		for(Iterator iter = nameRepository.getIterator() ; iter.hasNext();) {
			System.out.println("Name: " + iter.next());
		}
	}

}
