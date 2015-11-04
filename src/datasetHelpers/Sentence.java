package datasetHelpers;

import java.util.ArrayList;

public class Sentence extends TaggedObject{

	private ArrayList<Token> tokens = new ArrayList<>();
	private  edu.upc.freeling.Sentence freelingInformation;
	public Sentence ()
	{
		
	}
	
	
	
	public void appendToken(Token t)
	{
		this.tokens.add(t);
	}
	
	public ArrayList<Token> getAllTokens()
	{
		return this.tokens;
	}
	
	
	public int length(){
		return this.tokens.size();
	}



	public edu.upc.freeling.Sentence getFreelingSentence() {
		return freelingInformation;
	}



	public void setFreelingInformation(edu.upc.freeling.Sentence freelingSentence) {
		this.freelingInformation = freelingSentence;
	}
	
}
