package datasetHelpers;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Properties;

import ioHelpers.FileHelpers;

public class Dataset extends TaggedObject{
private ArrayList<Text> texts;
private String log;
	
	public Dataset() {
		
		texts = new ArrayList<>();
		this.log = "";
	}
	
	public void appendText(Text t)
	{
		this.texts.add(t);
	}
	
	
	public ArrayList<Text> getAllTexts()
	{
		return this.texts;
	}
	
	
	
	public void log(String message)
	{
		this.log+=message+"\n";
	}
	
	public void loadFromDirectory(String directoryPath) throws IOException
	{
		this.loadLogFile(directoryPath);
	}
	
	public void saveToDirectory(String directoryPath)
	{
		this.saveLogFile(directoryPath);
	}
	
	
	private void loadLogFile(String directoryPath) throws IOException
	{
		String logFile = directoryPath+"/"+"log.txt";
		
		if((new File(logFile)).exists())
		{
			this.log= FileHelpers.fileToString(logFile);
		}
	}
	
	private void saveLogFile(String directoryPath)
	{
		String logFile = directoryPath+"/"+"log.txt";	
		
		FileHelpers.StringToFile(logFile, this.log);
	}
	
	
	
}
