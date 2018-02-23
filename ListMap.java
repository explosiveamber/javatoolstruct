

import java.awt.Graphics;
import java.awt.List;
import java.util.Map;
import java.util.TreeMap;

public class ListMap extends List {

	TreeMap internalMap;
	int cols;
	int rows;
	
	public ListMap(int rows, int cols) {
		
		this.rows = rows;
		this.cols = cols;
		this.internalMap = new TreeMap();
		
	}
	
	
	public boolean add(Object k, Object v) {
		if(k == null || v == null) return false;
		put(k, v);
		addFromInternalMap();
		return true;
	}
	
	public boolean put(Object k, Object v) throws ListMapNotAccessibleException {
		
		
		try {
			if(true) {
				
			internalMap.put(k, v);
			
			} 
			else {
				
				throw new ListMapNotAccessibleException("Internal map not correctly initialized");
			}
		}
		catch(ListMapNotAccessibleException e) {
			
		   e.printStackTrace();
		}
		
		return true;
		
	}
	
	
	public void addFromInternalMap() {
		
		
		Map.Entry entry = internalMap.pollLastEntry();
		StringBuilder toAwtList = new StringBuilder();
		toAwtList.append(entry.getKey());
		toAwtList.append(entry.getValue());
		super.add(new String(toAwtList));
		
		
	}
	
	class ListMapNotAccessibleException extends RuntimeException {
		
		public ListMapNotAccessibleException(String mess) {
			
			super(mess);
		}
	}
}
