package model;

import java.util.Arrays;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import util.ElementSet;

public class SCPModel {
	private SortedSet<ElementSet> _Sortes;
//	private TreeSet<Integer> _elements;
	
public SCPModel() {
	_Sortes = new TreeSet<ElementSet>();
//	_elements = new TreeSet<Integer>();
}
public void addSetToCover(int id, double cost, Collection<Integer> elements) {
	ElementSet es =  new ElementSet(id,cost,elements);
//	_elements.addAll(es.getElement());
	_Sortes.add(es);
}
public SortedSet<Integer> getElementsCopy(){
	TreeSet<Integer> ts = new TreeSet<Integer>();
	for (ElementSet es:_Sortes) {
		Iterable<Integer> _Iter = es.getElementIterable();
		for (int i : _Iter) {
			ts.add(i);
		}
	}
	return ts;
//	return _elements;
}
public Iterable<ElementSet> getElementSetIterable(){
	return (Iterable<ElementSet>)_Sortes;
}
public Collection<ElementSet> getElementSet(){
	return _Sortes;
}
public int getNumElements() {
	return this.getElementsCopy().size();
}
public int getNumElemsentSets() {
	return _Sortes.size();
}

public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("\nWeighted SCP model:\n");
	sb.append("---------------------\n");
	sb.append("Number of elements (n): "+this.getNumElements()+"\n");
	sb.append("Number of sets (m): "+this.getNumElemsentSets()+"\n"+"\n");
	sb.append("Set details:\n");
	sb.append("----------------------------------------------------------"+"\n");
	for (ElementSet es: _Sortes) {
		sb.append(es+"\n");
	}
	//sb.append("\s");
	return sb.toString();
}




public static void main(String[] args) {
	SCPModel model = new SCPModel();
	model.addSetToCover(6, 2.0, Arrays.asList(new Integer[] {4,8}));
	model.addSetToCover(5, 2.0, Arrays.asList(new Integer[] {2,6,100}));
	model.addSetToCover(4, 5.0, Arrays.asList(new Integer[] {2,4,6,8,100}));
	model.addSetToCover(3, 2.0, Arrays.asList(new Integer[] {5,7,9}));
	model.addSetToCover(2, 2.0, Arrays.asList(new Integer[] {1,5,9}));
	model.addSetToCover(1, 3.0, Arrays.asList(new Integer[] {1,3,5,7,9}));
	System.out.println(model.getElementsCopy());
	System.out.println(model.getElementSetIterable());
	System.out.println(model);
}





}
