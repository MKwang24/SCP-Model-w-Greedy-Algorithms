package solver;

import java.util.HashMap;
import java.util.TreeSet;

import util.ElementSet;

public class GreedyCoverageSolver extends GreedySolver{

	public  GreedyCoverageSolver(){
		_name = "Coverage";
		this.reset();
	}

	@Override
	public ElementSet nextBestSet() {
		// TODO Auto-generated method stub
		ElementSet nextBestSet = null;
		int currentCover = 0;
		HashMap<Integer, ElementSet> test_map = new HashMap<Integer,ElementSet>();
		for (ElementSet e : _Iter) {
			currentCover = e.counterElementsCovered(set_to_work);
			
			if (currentCover < 1)
				continue;
			if (!test_map.keySet().contains(currentCover)){
			test_map.put(currentCover,e);
			}
	}
		TreeSet<Integer> keys = new TreeSet<Integer>(test_map.keySet());
		nextBestSet= test_map.get(keys.last());
		return nextBestSet;
		
		//Another approach
//		int currentCover = 0;
//		int bestCover = 0;
//		ElementSet nextBestSet = null;
//		
//		for (ElementSet e: _Iter){
//			
//			currentCover = e.counterElementsCovered(this.set_to_work);
//			
//			
//			if (bestCover < currentCover){
//				nextBestSet = e;	
//				bestCover = currentCover;// repalce the old set with new set and new cost
//	}
//
//}
//
//		return nextBestSet;
		
	}
	}


