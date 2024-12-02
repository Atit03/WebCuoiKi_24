package vn.locdung.models;

import java.io.Serializable;

public class CategoryModel implements Serializable{

	private static final long serialVersionUID = 1L;
	public int categoryid;
	public String categoryname;
	
	public CategoryModel() {
		super();
	}
	public CategoryModel(int categoryid, String categoryname) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	@Override
	public String toString() {
		return "CategoryModel [categoryid=" + categoryid + ", categoryname=" + categoryname + "]";
	}
	
	
}
