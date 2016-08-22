package datasetHelpers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

public class TaggedObject implements java.io.Serializable
{

	private Hashtable<String, Tag> tags = new Hashtable<>();

	public boolean hasTag(String tagKey)
	{
		return tags.containsKey(tagKey);
	}

	public Tag getTag(String tagKey)
	{

		if (!tags.containsKey(tagKey))
		{
			return new Tag(tagKey, "0");
		}

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

	public HashSet<Tag> getAllTags()
	{

		HashSet<Tag> allTags = new HashSet<>();

		for (Tag t : this.tags.values())
		{
			allTags.add(t);
		}

		return allTags;
	}

	public HashSet<String> getAllKeys()
	{
		HashSet<String> allKeys = new HashSet<>();
		for (Tag t : this.getAllTags())
		{
			allKeys.add(t.getKey());
		}

		return allKeys;
	}

}
