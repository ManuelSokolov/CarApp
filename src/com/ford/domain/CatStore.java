package com.ford.domain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class CatStore {
	
	private static HashMap<String,Store> stores = new HashMap<>();
	
	public CatStore() {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(new File("config.properties")));
			String s = p.getProperty("stores");
			String[] storesS = s.split(",");
			for(String a : storesS) {
				stores.put(a,new Store(a));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Store getStore(String location) {
		return stores.get(location);
	}
	
	public void addStore(Store st) {
		stores.put(st.getLocation(),st);
	}
	
	public void removeStore(Store st) {
		stores.remove(st.getLocation());
		
	}
	
	
	

}
