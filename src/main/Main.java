package main;

import java.io.IOException;

import datasetHelpers.Dataset;
import datasetHelpers.Tag;
import datasetHelpers.Text;
import features.CharacterLengthFeature;
import processors.FeatureProcessor;
import processors.SequenceProcessor;
import textProcessors.FreelingProcessor;
import textProcessors.ParagraphSplitterProcessor;

public class Main {
	public static final String datasetFolder = "datasets/testDataset";
	public static void main(String[] args) throws IOException {
		
		Dataset dataset = new Dataset();
		dataset.loadFromDirectory(datasetFolder);
		dataset.setLanguage("en");
		
		SequenceProcessor sequenceProcessor = new SequenceProcessor();
		sequenceProcessor.addProcessor(new ParagraphSplitterProcessor());
		sequenceProcessor.addProcessor(new FreelingProcessor());
		
		FeatureProcessor featureProcessor = new FeatureProcessor();
		featureProcessor.addFeature(new CharacterLengthFeature());
		
		sequenceProcessor.addProcessor(featureProcessor);	
		
		sequenceProcessor.process(dataset);
		
		
		for(Text t : dataset.getAllTexts())
		{
			for(Tag tag: t.getAllTags())
			{
				System.out.println(tag.getKey()+","+tag.getValue());
			}
			
			System.out.println("Paragraphs: "+t.getAllParagraphs().size());
			//System.out.println("Average lemma length:" +);
		}
		
		
	}

}
