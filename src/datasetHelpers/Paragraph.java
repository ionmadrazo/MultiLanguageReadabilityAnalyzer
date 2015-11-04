package datasetHelpers;

import java.util.ArrayList;

public class Paragraph  extends TaggedObject{

	private ArrayList<Sentence> sentences = new ArrayList<>();
	private String rawText;
	
	public Paragraph(String rawText)
	{
		this.rawText= rawText;
	}
	
	public void appendSentence(Sentence s)
	{
		this.sentences.add(s);
	}
	
	
	public ArrayList<Sentence> getAllSentences()
	{
		return this.sentences;
	}
	
	public String getRawText() {
		return rawText;
	}
}
