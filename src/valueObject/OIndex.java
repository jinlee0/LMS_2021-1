package valueObject;

import model.MIndex;

public class OIndex {
	private String id;
	private String name;
	private String fileName;

	public OIndex() {

	}

	public OIndex(String id, String name, String fileName) {
		this.id = id;
		this.name = name;
		this.fileName = fileName;
	}

	public void set(MIndex mIndex) {
		this.id = mIndex.getId();
		this.name = mIndex.getName();
		this.fileName = mIndex.getFileName();
		
	}
	
	public OIndex getInstance() {
		return new OIndex();
	}
	
	
	@Override
	public String toString() {
		return this.id + " " + this.name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	

	

}
