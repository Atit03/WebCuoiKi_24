package vn.locdung.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItemModel implements Serializable{
	private static final long serialVersionUID = 1L;
	public int cartitemid;
	public int productid;
	public String productname;
	public String image;
	public int quantity;
	public BigDecimal price;
	
	

	public CartItemModel(int productid, String productname, String image, int quantity, BigDecimal price) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.image = image;
		this.quantity = quantity;
		this.price = price;
	}
	

	public CartItemModel(int cartitemid, int productid, String productname, String image, int quantity,
			BigDecimal price) {
		super();
		this.cartitemid = cartitemid;
		this.productid = productid;
		this.productname = productname;
		this.image = image;
		this.quantity = quantity;
		this.price = price;
	}


	public CartItemModel() {
		super();
	}
	
	public int getCartitemid() {
		return cartitemid;
	}


	public void setCartitemid(int cartitemid) {
		this.cartitemid = cartitemid;
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
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	@Override
	public String toString() {
		return "CartItemModel [cartitemid=" + cartitemid + ", productid=" + productid + ", productname=" + productname
				+ ", image=" + image + ", quantity=" + quantity + ", price=" + price + "]";
	}

	
	
	
	
}
