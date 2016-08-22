package nlp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TermFreqsByTag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static Hashtable<String, Hashtable<String, Integer>> categoryTohashtable;
	private static Hashtable<String, List<Map.Entry<String, Integer>>> categoryToSortedList;
	
	public static void addTerm(String term, String categoryLabel)
	{
		
		if(categoryTohashtable==null) categoryTohashtable = new Hashtable<>();		
		if(!categoryTohashtable.containsKey(categoryLabel)) categoryTohashtable.put(categoryLabel, new Hashtable<String, Integer>());
		if(!categoryTohashtable.get(categoryLabel).containsKey(term)) categoryTohashtable.get(categoryLabel).put(term, 0);
		
		categoryTohashtable.get(categoryLabel).put(term,categoryTohashtable.get(categoryLabel).get(term)+1);	
		
		categoryToSortedList.put(categoryLabel, null);
	}
	
	public static int getFrequencyOfTerm(String term, String categoryLabel)
	{
		if(categoryTohashtable.get(categoryLabel).contains(term)) return categoryTohashtable.get(categoryLabel).get(term);
		return 0;
	
	}
	
	
	private void createSortedListIfDoesNotExist(String categoryLabel){
		
		List<Map.Entry<String, Integer>> result = new ArrayList(categoryTohashtable.get(categoryLabel).entrySet());
	    Collections.sort(result, new Comparator<Map.Entry<String, Integer>>(){
	        public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
	        	if(o2.getValue()>o1.getValue()) return 1;
	        	if(o2.getValue()<o1.getValue()) return -1;
	            return 0;
	    }});
		
	    categoryToSortedList.put(categoryLabel, result);
		
	}
	
	public List<Map.Entry<String, Integer>> getTopN(String categoryLabel,int n)
	{
		createSortedListIfDoesNotExist(categoryLabel);
		return categoryToSortedList.get(categoryLabel).subList(0, n);
	}
	
	
	
	
	/*List<Map.Entry<String, Double>> result = new ArrayList(hashtagToreadability.entrySet());
    Collections.sort(result, new Comparator<Map.Entry<String, Double>>(){
        public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
        	if(o2.getValue()>o1.getValue()) return 1;
        	if(o2.getValue()<o1.getValue()) return -1;
            return 0;
    }});
	*/
}
