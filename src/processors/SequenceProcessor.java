package processors;

import java.util.ArrayList;

import datasetHelpers.Dataset;

public class SequenceProcessor implements DatasetProcessor{

	private ArrayList<DatasetProcessor> processors;
	
	public SequenceProcessor() {	
		
		this.processors = new ArrayList<>();
		
	}
	
	public void addProcessor(DatasetProcessor dp)
	{
		this.processors.add(dp);
	}
	
	
	@Override
	public void process(Dataset d) {
		for(DatasetProcessor dp: this.processors)
		{
			dp.process(d);
		}
		
	}

}
