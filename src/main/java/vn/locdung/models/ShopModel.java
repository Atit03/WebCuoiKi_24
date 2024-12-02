package vn.locdung.models;

import java.io.Serializable;

public class ShopModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int shopid;
    private int vendorid;
    private String shopname;
    private int productcount;
    private String createdat;
    private String shopimage;
	public ShopModel() {
		super();
	}
	public ShopModel(int shopid, int vendorid, String shopname, int productcount, String createdat, String shopimage) {
		super();
		this.shopid = shopid;
		this.vendorid = vendorid;
		this.shopname = shopname;
		this.productcount = productcount;
		this.createdat = createdat;
		this.shopimage = shopimage;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public int getVendorid() {
		return vendorid;
	}
	public void setVendorid(int vendorid) {
		this.vendorid = vendorid;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public int getProductcount() {
		return productcount;
	}
	public void setProductcount(int productcount) {
		this.productcount = productcount;
	}
	public String getCreatedat() {
		return createdat;
	}
	public void setCreatedat(String createdat) {
		this.createdat = createdat;
	}
	public String getShopimage() {
		return shopimage;
	}
	public void setShopimage(String shopimage) {
		this.shopimage = shopimage;
	}
	@Override
	public String toString() {
		return "ShopModel [shopid=" + shopid + ", vendorid=" + vendorid + ", shopname=" + shopname + ", productcount="
				+ productcount + ", createdat=" + createdat + ", shopimage=" + shopimage + "]";
	}
    

}
