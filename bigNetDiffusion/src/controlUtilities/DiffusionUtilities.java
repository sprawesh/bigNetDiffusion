package controlUtilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

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
		System.out.println(obs.size()); 
		return obs;
		
	}
	

}
