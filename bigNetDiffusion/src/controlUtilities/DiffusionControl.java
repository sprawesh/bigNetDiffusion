package controlUtilities;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class DiffusionControl {
	
	/*
	 * sample sizes = 1,2,3,4,5,10
	 * sampling methods = BFS, Ego sampling, RBFS, Forest Fire, Random Walk, MHRW
	 * Network = largest network possible
	 * select top-5 from 1,2 and 3 percent of sample size
	 * seed = 0.25, 0.5, 0.75 corresponds to different thresholds for seed node selection, e.g. 5 seeding nodes for 1000 is 0.5
	 */
	private static DiffusionUtilities dfu = new DiffusionUtilities();

	public static void main(String[] args) {
		String path = args[0];
		String directed = args[1];
		Double sample = Double.parseDouble(args[2]);
		HashMap<String, Double> obs = dfu.getObservations(path, directed);
		int sampleSize = (int) Math.floor(sample*obs.size()); 
		HashMap<String, Double> sobs = dfu.sortMaps(obs, sampleSize);
		
		Set<Entry<String, Double>> set = sobs.entrySet();
		Iterator<Entry<String, Double>> iterator = set.iterator();
		System.out.println("after sorting : "); 
		while(iterator.hasNext()) {
			Entry<String, Double> entry = (Entry<String, Double>) iterator.next();
			System.out.println(entry.getKey() + "\t" + entry.getValue()); 
		}
		
		System.out.println(set.size()); 
		//sort them
		
	}

}
