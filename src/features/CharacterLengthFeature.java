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

public class CharacterLengthFeature extends Feature{

	
	@Override
	public void processText(Text t) {
		double averageLemmaLength = FeatureHelpers.averageInParagraphs(t.getAllParagraphs(), TagKeys.TAG_LEMMA_CHARLENGTH_AVERAGE);
		t.addTag(new Tag(TagKeys.TAG_LEMMA_CHARLENGTH_AVERAGE, Double.toString(averageLemmaLength)));
	
	}
	@Override
	public void processParagraph(Paragraph p) {
		double averageLemmaLength = FeatureHelpers.averageInSentences(p.getAllSentences(), TagKeys.TAG_LEMMA_CHARLENGTH_AVERAGE);
		p.addTag(new Tag(TagKeys.TAG_LEMMA_CHARLENGTH_AVERAGE, Double.toString(averageLemmaLength)));
	
	}
	@Override
	public void processSentence(Sentence s) {
		
		
		double averageLemmaLength = FeatureHelpers.averageInTokens(s.getAllTokens(), TagKeys.TAG_LEMMA_CHARLENGTH_AVERAGE);
		s.addTag(new Tag(TagKeys.TAG_LEMMA_CHARLENGTH_AVERAGE, Double.toString(averageLemmaLength)));
	}
	@Override
	public void processToken(Token tok) {
		int lemmaLength = tok.getFreelingInformation().getLemma().length();
		tok.addTag(new Tag(TagKeys.TAG_LEMMA_CHARLENGTH_AVERAGE, Integer.toString(lemmaLength)));
		
	}

}
