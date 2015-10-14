package datasetHelpers;

import java.util.ArrayList;

public class Dataset extends TaggedObject{
private ArrayList<Text> texts = new ArrayList<>();
	
	
	public Dataset() {
		
	}
	
	public void appendText(Text t)
	{
		this.texts.add(t);
	}
	
	
	public ArrayList<Text> getAllTexts()
	{
		return this.texts;
	}
}
