package features;

import java.util.ArrayList;

import datasetHelpers.Paragraph;
import datasetHelpers.Sentence;
import datasetHelpers.TaggedObject;
import datasetHelpers.Token;

public class FeatureHelpers {

	public static double averageInTokens(ArrayList<Token> list, String tagKey)
	{
		double average = 0;
		
		for(TaggedObject to: list)
		{
			average+=Double.parseDouble(to.getTag(tagKey).getValue());
		}
		average/= list.size();
		
		return average;
		
	}
	
	public static double averageInSentences(ArrayList<Sentence> list, String tagKey)
	{
		double average = 0;
		
		for(TaggedObject to: list)
		{
			average+=Double.parseDouble(to.getTag(tagKey).getValue());
		}
		average/= list.size();
		
		return average;
		
	}
	
	public static double averageInParagraphs(ArrayList<Paragraph> list, String tagKey)
	{
		double average = 0;
		
		for(TaggedObject to: list)
		{
			average+=Double.parseDouble(to.getTag(tagKey).getValue());
		}
		average/= list.size();
		
		return average;
		
	}
	
	
	
	
}
