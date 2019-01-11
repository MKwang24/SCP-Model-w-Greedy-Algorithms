package solver;

import java.util.HashMap;
import java.util.TreeSet;

import util.ElementSet;

public class ChvatalSolver extends GreedySolver{

	public ChvatalSolver(){
		_name = "Chvatal";
		this.reset();
	}
	@Override
	public ElementSet nextBestSet() {
		// TODO Auto-generated method stub
ElementSet nextBestSet = null;
int Covered = 0;
		HashMap<Double, ElementSet> test_map = new HashMap<Double,ElementSet>();
		for (ElementSet e : _Iter) {
			Covered = e.counterElementsCovered(set_to_work);
			
			if (Covered < 1)
				continue;
			test_map.put(e.getCost()/Covered, e);
	}
		TreeSet<Double> keys = new TreeSet<Double>(test_map.keySet());
		nextBestSet= test_map.get(keys.first());
	return nextBestSet;	
	}

}		
