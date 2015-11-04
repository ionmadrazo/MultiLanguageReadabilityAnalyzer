package features;

import java.util.ArrayList;

import constants.TagKeys;
import datasetHelpers.Dataset;
import datasetHelpers.Paragraph;
import datasetHelpers.Sentence;
import datasetHelpers.Tag;
import datasetHelpers.TaggedObject;
import datasetHelpers.Text;
import datasetHelpers.Token;

public class CharacterLengthFeature implements Feature{

	@Override
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

	private void processText(Text t) {
		double averageLemmaLength = FeatureHelpers.averageInParagraphs(t.getAllParagraphs(), TagKeys.TAG_LEMMA_CHARLENGTH_AVERAGE);
		t.addTag(new Tag(TagKeys.TAG_LEMMA_CHARLENGTH_AVERAGE, Double.toString(averageLemmaLength)));
	
	}

	private void processParagraph(Paragraph p) {
		double averageLemmaLength = FeatureHelpers.averageInSentences(p.getAllSentences(), TagKeys.TAG_LEMMA_CHARLENGTH_AVERAGE);
		p.addTag(new Tag(TagKeys.TAG_LEMMA_CHARLENGTH_AVERAGE, Double.toString(averageLemmaLength)));
	
	}

	private void processSentence(Sentence s) {
		
		
		double averageLemmaLength = FeatureHelpers.averageInTokens(s.getAllTokens(), TagKeys.TAG_LEMMA_CHARLENGTH_AVERAGE);
		s.addTag(new Tag(TagKeys.TAG_LEMMA_CHARLENGTH_AVERAGE, Double.toString(averageLemmaLength)));
	}

	private void processToken(Token tok) {
		int lemmaLength = tok.getFreelingInformation().getLemma().length();
		tok.addTag(new Tag(TagKeys.TAG_LEMMA_CHARLENGTH_AVERAGE, Integer.toString(lemmaLength)));
		
	}

}
