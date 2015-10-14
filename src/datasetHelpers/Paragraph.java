package datasetHelpers;

import java.util.ArrayList;

public class Paragraph  extends TaggedObject{

	private ArrayList<Sentence> sentences = new ArrayList<>();
	
	
	public Paragraph()
	{
		
	}
	
	public void appendSentence(Sentence s)
	{
		this.sentences.add(s);
	}
	
	
	public ArrayList<Sentence> getAllSentences()
	{
		return this.sentences;
	}
	
}
