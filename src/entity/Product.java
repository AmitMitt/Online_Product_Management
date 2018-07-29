package entity;

public class Product {

	int id;
	String name,warranty,wType,coverage,exclusion;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product() {
		super();
	}

	public Product(int id,String name, String warranty, String wType, String coverage,
			String exclusion) {
		super();
		this.name = name;
		this.warranty = warranty;
		this.wType = wType;
		this.coverage = coverage;
		this.exclusion = exclusion;
		this.id = id;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public String getwType() {
		return wType;
	}

	public void setwType(String wType) {
		this.wType = wType;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

	public String getExclusion() {
		return exclusion;
	}

	public void setExclusion(String exclusion) {
		this.exclusion = exclusion;
	}
	
	
	
}
