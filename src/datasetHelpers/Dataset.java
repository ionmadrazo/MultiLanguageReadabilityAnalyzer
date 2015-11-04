package datasetHelpers;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Properties;

import constants.TagKeys;
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
		
		//Load raws
		
		String rawDirectoryPath = directoryPath+"/"+"raw";
		
		File[] directories = new File(rawDirectoryPath).listFiles();
		
		
		for(File directory : directories)
		{
			  if (directory.isDirectory()) {
				  File[] files = directory.listFiles();
				  for(File f : files)
					{
					  Text text = new Text(FileHelpers.fileToString(f.getAbsolutePath()));
					  Tag folderTag = new Tag(TagKeys.TAG_FOLDER, directory.getName());
					  Tag filenameTag = new Tag(TagKeys.TAG_FILENAME, f.getName());
					  text.addTag(folderTag);
					  text.addTag(filenameTag);
					  this.appendText(text);
					}
				  
				  
				  
			  }
		}
		
		
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

	public void setLanguage(String value) {
		Tag languageTag = new Tag(TagKeys.TAG_LANGUAGE, value);
		this.addTag(languageTag);
		
	}
	
	public String getLanguage()
	{
		return this.getTag(TagKeys.TAG_LANGUAGE).getValue();
	}
	
	
	
	
}
