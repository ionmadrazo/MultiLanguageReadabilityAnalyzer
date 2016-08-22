package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
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
		/*FileOutputStream fileOut =
		         new FileOutputStream("dataset.ser");
		         ObjectOutputStream out = new ObjectOutputStream(fileOut);
		         out.writeObject(dataset);
		         out.close();
		         fileOut.close();
		         
		         
		         FileInputStream fileIn = new FileInputStream("dataset.ser");
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         dataset = (Dataset) in.readObject();
		         in.close();
		         fileIn.close();        
		 */        
		
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
