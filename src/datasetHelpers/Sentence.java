package datasetHelpers;

import java.util.ArrayList;

public class Sentence extends TaggedObject{

	private ArrayList<Token> tokens = new ArrayList<>();
	
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
	
}
