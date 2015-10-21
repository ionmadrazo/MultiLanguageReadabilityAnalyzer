package datasetHelpers;

import java.util.ArrayList;

public class Text  extends TaggedObject{

	private ArrayList<Paragraph> paragraphs = new ArrayList<>();
	private String rawText;
	
	public Text(String rawText)
	{
		this.rawText= rawText;
	}
	
	public void appendParagraph(Paragraph p)
	{
		this.paragraphs.add(p);
	}
	
	
	public ArrayList<Paragraph> getAllParagraphs()
	{
		return this.paragraphs;
	}

	public String getRawText() {
		return rawText;
	}

	
	
}
