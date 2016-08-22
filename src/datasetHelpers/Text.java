package datasetHelpers;

import java.util.ArrayList;
import java.util.HashSet;

public class Text extends TaggedObject
{

	private ArrayList<Paragraph> paragraphs = new ArrayList<>();
	private String rawText;

	public Text(String rawText)
	{
		this.rawText = rawText;
	}

	public void appendParagraph(Paragraph p)
	{
		this.paragraphs.add(p);
	}

	public ArrayList<Paragraph> getAllParagraphs()
	{
		return this.paragraphs;
	}

	public String getRawText()
	{
		return rawText;
	}

	public String getCSV(HashSet<String> allTags)
	{
		String result = "";
		for (String key : allTags)
		{
			
			result += " " + this.getTag(key).getValue();
		}
		result +=  " " + this.getTag(constants.TagKeys.TAG_READABILITY).getValue();
		return result.trim().replace(" ", ",");
	}
}
