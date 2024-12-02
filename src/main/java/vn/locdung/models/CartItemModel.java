package vn.locdung.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItemModel implements Serializable{
	private static final long serialVersionUID = 1L;
	public int productid;
	public String productname;
	public int quantity;
	public BigDecimal price;
	
	public CartItemModel(int productid, String productname, int quantity, BigDecimal price) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.quantity = quantity;
		this.price = price;
	}

	public CartItemModel() {
		super();
	}
	
	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartItemModel [productid=" + productid + ", productname=" + productname + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
	
	
}
