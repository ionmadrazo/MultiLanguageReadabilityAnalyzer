package datasetHelpers;

import java.util.ArrayList;

public class Text  extends TaggedObject{

	private ArrayList<Paragraph> paragraphs = new ArrayList<>();
	
	
	public Text()
	{
		
	}
	
	public void appendParagraph(Paragraph p)
	{
		this.paragraphs.add(p);
	}
	
	
	public ArrayList<Paragraph> getAllParagraphs()
	{
		return this.paragraphs;
	}
	
}
