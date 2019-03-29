package day7_28March_111245;

import java.util.*;


public class PrintTreeSet implements Comparator<String> {

	public PrintTreeSet() {
		// TODO Auto-generated constructor stub
	}

	//print treeSet 
	//sort set by length of strings
	//use comparator to compare treeSet elements
	
	public static void main(String[] args) {
		Set<String> names = new TreeSet<>(new LengthComparator());
		names.add("Parth");
		names.add("Xavier");
		names.add("Jason");
		names.add("Falco");
		names.add("Ozar");
		names.add("Luis");
		names.add("Sundas");
		System.out.println(names);
		
		
		/*
		int max = 0;
		String temp = "";
		
		
		
		Iterator <String> it = names.iterator();
		
		while(it.hasNext()){
			
			int element = it.next().length();
			int element2 = it.next().length();
			
			String temp2;
			if(){
				
				max = it.next().length();
				temp = it.next();
				it.next() 
				
				it.next() = temp;
				
			}
		}
		*/
		

	}



}

class LengthComparator implements Comparator<String>{
	

	//since internally treeset sorts the data by natural ordering by implementing Comparator
	//and overriding compare() we are overriding compare() so the sorting can be done by String length
	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		
		if(o1.length() > o2.length() ) return 1;
		
		else if (o1.length() == o2.length() ) return 0;
		
		else  return -1;
	}
	
}
