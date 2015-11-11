package features;

import java.awt.RenderingHints.Key;
import java.util.Hashtable;

import constants.TagKeys;
import datasetHelpers.Dataset;
import datasetHelpers.Paragraph;
import datasetHelpers.Sentence;
import datasetHelpers.Tag;
import datasetHelpers.Text;
import datasetHelpers.Token;

public class POSFeature implements Feature{

	
	private Hashtable<String, Integer> tagCount= new Hashtable<>();
	private int wordCount=0;
	
	@Override
	public void applyFeature(Dataset d, Text t) {
		for(Paragraph paragraph: t.getAllParagraphs())
		{
			for(Sentence sentence: paragraph.getAllSentences())
			{
				for(Token token : sentence.getAllTokens())
				{
					String POSTag=token.getFreelingInformation().getTag();
					
					if(!this.tagCount.containsKey(POSTag))this.tagCount.put(POSTag, 0);
					this.tagCount.put(POSTag, this.tagCount.get(POSTag)+1);					
				}
			}
		}
		
		
		for(String key: this.tagCount.keySet())
		{
			t.addTag(new Tag(TagKeys.TAG_POS_PREFIX+key, Float.toString(this.tagCount.get(key)/this.wordCount)));
		}
		
	}

}
