import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Iterator;
 
public class Main {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("a", "10");
		map.put("b", "30");
		map.put("c", "50");
		map.put("d", "40");
		map.put("e", "20");
        ArrayList<String> array = new ArrayList<String>();
		System.out.println(map);
 
		Map sortedMap = sortByValue(map);
        Iterator it = sortedMap.entrySet().iterator();
        while (it.hasNext()) {
        	Map.Entry pair = (Map.Entry)it.next();
        	array.add((String) pair.getValue());
        	//it.remove(); // avoids a ConcurrentModificationException
    	}
		System.out.println(sortedMap);
		System.out.println(array);
	}
 
	public static Map sortByValue(Map unsortedMap) {
		Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
		sortedMap.putAll(unsortedMap);
		return sortedMap;
	}
 
}
 
class ValueComparator implements Comparator {
 
	Map map;
 
	public ValueComparator(Map map) {
		this.map = map;
	}
 
	public int compare(Object keyA, Object keyB) {
		Comparable valueA = (Comparable) map.get(keyA);
		Comparable valueB = (Comparable) map.get(keyB);
		return valueB.compareTo(valueA);
	}
}