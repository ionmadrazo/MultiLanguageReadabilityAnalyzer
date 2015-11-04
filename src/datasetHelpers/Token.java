package datasetHelpers;

import edu.upc.freeling.Word;

public class Token extends TaggedObject{

	private Word freelingInformation;
	public Token()
	{
		
	}
	public Word getFreelingInformation() {
		return freelingInformation;
	}
	public void setFreelingInformation(Word freelingInformation) {
		this.freelingInformation = freelingInformation;
	}
	
	
}
