package datasetHelpers;

public class Tag {

	private String key;
	private String value;
	
	
	public Tag(String tag,String value)
	{
		this.setKey(tag);
		this.setValue(value);
	}


	public String getKey() {
		return key;
	}


	public void setKey(String tag) {
		this.key = tag;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
	
}
