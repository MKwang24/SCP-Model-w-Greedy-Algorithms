package util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class ElementSet implements Comparable{
	//Element e1 = new ElementSet(1,3.0,Arrays.asList(new Integer[]{4,6});
	private int _ID;
	private double _Cost;
	private Collection<Integer> _set;
	private Collection<Integer> _set1;
	
public ElementSet(int id, double cost, Collection<Integer> set){
	_ID = id;
	_Cost = cost;
	_set = new HashSet<Integer>(set);
	_set1 = new TreeSet<Integer>(set);
	
}
@Override
public int compareTo(Object o) {
	if (!(o instanceof ElementSet)) 
		return 1;

	ElementSet es = (ElementSet)o;
	if ( _ID==es._ID)
	return 0;
	else 
		return _ID-es._ID;
}

public boolean containsElement(int id) {
	return this._set.contains(id);
}

public int counterElementsCovered(Set<Integer> elements_to_cover) {
	int count = 0;
	for (int i : elements_to_cover) {
		if (this._set.contains(i)){
			count+=1;
		}
	}
	return count;
}

public boolean equals(Object o) {
	if (!(o instanceof ElementSet)) {
		return false;
	}
	else {
		ElementSet es = (ElementSet)o;
		if (_set.equals(es._set)&&_ID==es._ID&&_Cost==es._Cost) 
			return true;
		else 
			return false;
	}
}
public double getCost() {
	return _Cost;
}

public int getId() {
	return _ID;
}

public double getNumElements() {
	return _set.size();
}

public Iterable<Integer> getElementIterable(){
	return _set;
}
public Collection<Integer> getElement(){
//	TreeSet<Integer> ts = new TreeSet<Integer>();
//	for (int i : _set) {
//		ts.add(i);
//	}
	return (Collection<Integer>)_set;
	//return ts;
}
public String toString() {
	StringBuilder sb = new StringBuilder ();
	sb.append(String.format("Set ID:%4d   Cost:%7.2f   Element IDs: %s",_ID,_Cost,_set1.toString()));

	return sb.toString();
}
	
	
	
	
public static void main(String args[]) {
	ElementSet e1 = new ElementSet(1,3.0,Arrays.asList(new Integer[] {4,8,8,9}));
	ElementSet e2 = new ElementSet(1,3.0,Arrays.asList(new Integer[] {4,8,8,9}));
	ElementSet e3 = new ElementSet(2,3.0,Arrays.asList(new Integer[] {4,8,8,9}));
	ElementSet e4 = new ElementSet(1,2.0,Arrays.asList(new Integer[] {4,8,8,9}));
	ElementSet e5 = new ElementSet(1,3.0,Arrays.asList(new Integer[] {4,8,7,9}));
	ElementSet e6 = new ElementSet(7,3.0,Arrays.asList(new Integer[] {4,8,7,9,10,20}));
	//HashSet hm = new HashSet<Integer>(e1);
	
	//Test toString
	System.out.println(e6);//Set ID:   1   Cost:   3.00   Element IDs: [4, 8, 9]
	
	//Test getElementIterable
	System.out.println(e6.getElementIterable());//[4, 8, 9]
	
	//Test getID()
	System.out.println(e1.getId());//1
	//Test getNumElements()
	System.out.println(e1.getNumElements());//3.0
	// Test getCost()
	System.out.println(e1.getCost());//3.0
	//Test equals()
	System.out.println(e1.equals(e2));
	System.out.println(e1.equals(e3));
	System.out.println(e1.equals(e4));
	System.out.println(e1.equals(e5));
	System.out.println(e1.equals(e6));
	
	//Test compareTo
	System.out.println(e1.compareTo(e2));
	System.out.println(e1.compareTo(e3));
	System.out.println(e1.compareTo(e4));
	System.out.println(e1.compareTo(e5));
	System.out.println(e1.compareTo(e6));
}	
}



//