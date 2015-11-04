package textProcessors;

import datasetHelpers.Dataset;
import datasetHelpers.Paragraph;
import datasetHelpers.Text;
import processors.DatasetProcessor;

public class ParagraphSplitterProcessor implements DatasetProcessor{

	@Override
	public void process(Dataset d) {
		
		for(Text t : d.getAllTexts())
		{
			String rawText = t.getRawText();
			
			String[] lines = rawText.split("\n");
			
			String currentParagraph ="";
			for(int i =0; i<lines.length;i++)
			{
				
				
				
				if(lines[i].trim().isEmpty())
				{
					Paragraph paragraph = new Paragraph(currentParagraph);
					t.appendParagraph(paragraph);
					
					currentParagraph="";
				}
				else
				{
					currentParagraph+=" "+lines[i].trim();
				}
				
				
				
				
			}
			Paragraph paragraph = new Paragraph(currentParagraph);
			t.appendParagraph(paragraph);
			
		}
		
	}

}
