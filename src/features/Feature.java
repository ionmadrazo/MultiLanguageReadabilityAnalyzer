package features;

import datasetHelpers.Dataset;
import datasetHelpers.Paragraph;
import datasetHelpers.Sentence;
import datasetHelpers.Text;
import datasetHelpers.Token;

public class Feature {
	
	
	public void applyFeature(Dataset d, Text t) {

		for(Paragraph p : t.getAllParagraphs())
		{
			for(Sentence s: p.getAllSentences())
			{
				for(Token tok : s.getAllTokens()){
					processToken(tok);
				}
				processSentence(s);
			}
			processParagraph(p);
		}
		processText(t);
	}
	
	public void processParagraph(Paragraph p)
	{
		// TODO Auto-generated method stub
		
	}

	public void processSentence(Sentence s)
	{
		// TODO Auto-generated method stub
		
	}

	public void processToken(Token tok)
	{
		// TODO Auto-generated method stub
		
	}

	public void processText(Text t) {
	
	
	}
}
