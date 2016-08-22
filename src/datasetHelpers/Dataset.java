package datasetHelpers;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;

import constants.TagKeys;
import ioHelpers.FileHelpers;

public class Dataset
{
	private ArrayList<Text> texts;
	private String log;

	public Dataset()
	{

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
		this.log += message + "\n";
	}

	public void loadFromDirectory(String directoryPath) throws IOException
	{
		this.loadLogFile(directoryPath);

		// Load raws

		String rawDirectoryPath = directoryPath + "/" + "raw";

		File[] directories = new File(rawDirectoryPath).listFiles();

		for (File directory : directories)
		{
			if (directory.isDirectory())
			{
				File[] files = directory.listFiles();
				for (File f : files)
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
		String logFile = directoryPath + "/" + "log.txt";

		if ((new File(logFile)).exists())
		{
			this.log = FileHelpers.fileToString(logFile);
		}
	}

	private void saveLogFile(String directoryPath)
	{
		String logFile = directoryPath + "/" + "log.txt";

		FileHelpers.StringToFile(logFile, this.log);
	}

	public String getArff()
	{
		String result = "";

		result += "@RELATION " + constants.TagKeys.TAG_READABILITY + "\n";

		HashSet<String> allTags = this.getAllUsedTags();
		allTags.remove(constants.TagKeys.TAG_READABILITY);
		for (String key : allTags)
		{
			result += "@ATTRIBUTE  " + key + " NUMERIC\n";

		}
		result += "@ATTRIBUTE class ";
		result += "{";

		String possibleClassValues = "";
		for (String value : this.getAllValuesForKey(constants.TagKeys.TAG_READABILITY))
		{
			possibleClassValues += " " + value;
		}
		result += possibleClassValues.trim().replace(" ", ",");

		result += "}\n";
		result += "\n";

		result += "@DATA\n";

		for (Text t : this.getAllTexts())
		{
			result+=t.getCSV(allTags)+"\n";
		}

		return result;
	}

	public HashSet<String> getAllUsedTags()
	{
		HashSet<String> result = new HashSet<>();

		for (Text t : this.getAllTexts())
		{
			result.addAll(t.getAllKeys());
		}

		return result;
	}

	public HashSet<String> getAllValuesForKey(String key)
	{
		HashSet<String> result = new HashSet<>();

		for (Text t : this.getAllTexts())
		{
			result.add(t.getTag(key).getValue());
		}

		return result;
	}

}
