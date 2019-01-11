package solver;

import java.util.HashMap;
import java.util.TreeSet;

import util.ElementSet;

public class GreedyCostSolver extends GreedySolver{
	public GreedyCostSolver(){
	_name = "Cost";
	this.reset();
	}
	@Override
	public ElementSet nextBestSet() {
		// TODO Auto-generated method stub
		ElementSet nextBestSet = null;
		int currentCover = 0;
		double currentCost;
		HashMap<Double, ElementSet> test_map = new HashMap<Double,ElementSet>();
		for (ElementSet e : _Iter) {
			currentCover = e.counterElementsCovered(set_to_work);
			currentCost = e.getCost();
			
			if (currentCover < 1)
				continue;
			if (!test_map.keySet().contains(currentCost)){
			test_map.put(currentCost,e);
			}
	}
		TreeSet<Double> keys = new TreeSet<Double>(test_map.keySet());
		nextBestSet= test_map.get(keys.first());
		return nextBestSet;
		
		//Another Approach
//		double currentC = 0d;
//		double bestC = Double.POSITIVE_INFINITY;
//		int Covered = 0;
//		ElementSet nextBestSet = null;
//		
//		for (ElementSet e: _Iter){
//			
//			Covered = e.counterElementsCovered(this.set_to_work);
//			
//			if(Covered < 1)
//				continue;
//			
//			currentC = e.getCost();
//			
//			if (currentC < bestC){
//				nextBestSet = e;	
//				bestC = currentC;// repalce the old set with new set and new cost
//	}
//
//}

		
		//return nextBestSet;
		
	}
	
	
	
}