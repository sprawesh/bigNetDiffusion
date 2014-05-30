package controlUtilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DiffusionUtilities {
	
	public HashMap<String, Double> getObservations(String path, String directed) {
		
		HashMap<String, Double> obs = new HashMap<String, Double>();
		try {
			boolean dr = Boolean.parseBoolean(directed);
			if(!dr) {
				BufferedReader br = new BufferedReader(new FileReader(path));
				String header = br.readLine();
				
				String data = br.readLine();
				while(data != null) {
					String[] ob = data.split(",");
					obs.put(ob[0], Double.parseDouble(ob[1]));					
					data = br.readLine();
				}
			}			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obs;		
	}
	
	public HashMap<String, Double> sortMaps(HashMap<String, Double> entries, int sampleSize) {
		
		List<Entry<String, Double>> list = new LinkedList<Entry<String, Double>>(entries.entrySet()); 
		
		Collections.sort(list, new Comparator<Entry<String, Double>>() {			

			@Override
			public int compare(Entry<String, Double> value1,
					Entry<String, Double> value2) {				
				return value2.getValue().compareTo(value1.getValue()); 
			}
			
		});
		
		HashMap<String, Double> sortedMap = new LinkedHashMap<String, Double>();		
		
		for(int i = 0; i < sampleSize; i++) {
			Entry<String, Double> entry = list.get(i);
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
		
	}
	

}
