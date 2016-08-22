package processors;

import java.util.ArrayList;

import datasetHelpers.Dataset;
import datasetHelpers.Text;
import features.Feature;

public abstract class FeatureProcessor implements DatasetProcessor{

	private ArrayList<Feature> featureList;
	public FeatureProcessor()
	{
		this.featureList= new ArrayList<>();
		
	}
	
	
	public void addFeature(Feature f)
	{	
		if(!this.featureList.contains(f)) this.featureList.add(f);		
	}
	
	public void addFeatures(ArrayList<Feature> featuresToAdd)
	{
		for(Feature f: featuresToAdd)
		{
			this.addFeature(f);
		}
	}
	
	public void process(Dataset d)
	{
		
		for(Feature f : this.featureList)
		{
			for(Text t : d.getAllTexts())
			{
				f.applyFeature(d, t);
			}
		}
		
	}
	
}
