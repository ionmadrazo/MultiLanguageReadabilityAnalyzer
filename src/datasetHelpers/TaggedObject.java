package datasetHelpers;

import java.util.ArrayList;
import java.util.Hashtable;

public class TaggedObject {

	private Hashtable<String, Tag> tags = new Hashtable<>();	
	
	
	public boolean hasTag(String tagKey)
	{
		return tags.containsKey(tagKey);
	}
	
	
	public Tag getTag(String tagKey)
	{
		return this.tags.get(tagKey);
	}
	
	public void addTag(Tag newTag)
	{
		this.tags.put(newTag.getKey(), newTag);
	}
	
	public void removeTag(String tagKey)
	{
		this.tags.remove(tagKey);
	}
	
	public int numberOfTags()
	{
		return this.getAllTags().size();
	}
	
	
	public ArrayList<Tag> getAllTags()
	{
		
		ArrayList<Tag> allTags = new ArrayList<>();
		
		for( Tag t : this.tags.values())
		{
			allTags.add(t);
		}
		
		return allTags;
	}
	
	
	
}
