package datasetHelpers;

public class Token extends TaggedObject{

	
	public Token(String wordForm)
	{
		this.addTag(new Tag(constants.TagKeys.TAG_WORDFORM, wordForm));
	}
	
}
