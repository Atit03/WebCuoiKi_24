package vn.locdung.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class ProductModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private int productid;        // Productid
    private int shopid;           // Shopid (Liên kết với bảng Shops)
    private int categoryid;       // Categoryid (Liên kết với bảng Categories)
    private String productname;   // Productname
    private String description;   // Description
    private BigDecimal price;     // Price
    private int stock;            // Stock
    private BigDecimal rating;    // Rating
    private Timestamp createdAt;  // Createdat
    private Timestamp updatedAt;// Updatedat
    private int ratingcount;
    private String image;
    private List<String> images; // Danh sách ảnh phụ
	public ProductModel() {
		super();
	}
	public ProductModel(int productid, int shopid, int categoryid, String productname, String description,
			BigDecimal price, int stock, BigDecimal rating, Timestamp createdAt, Timestamp updatedAt, String image,
			List<String> images) {
		super();
		this.productid = productid;
		this.shopid = shopid;
		this.categoryid = categoryid;
		this.productname = productname;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.rating = rating;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.image = image;
		this.images = images;
	}
	
	public ProductModel(int productid, String productname, BigDecimal price, String image, List<String> images) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.price = price;
		this.image = image;
		this.images = images;
	}
	public ProductModel(int productid, String productname, BigDecimal price, String image) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.price = price;
		this.image = image;
	}
	
	public ProductModel(int productid, String productname, String description, BigDecimal price,
			int ratingcount, String image, List<String> images) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.description = description;
		this.price = price;
		this.ratingcount = ratingcount;
		this.image = image;
		this.images = images;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public BigDecimal getRating() {
		return rating;
	}
	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	
	public int getRatingcount() {
		return ratingcount;
	}
	public void setRatingcount(int ratingcount) {
		this.ratingcount = ratingcount;
	}
	@Override
	public String toString() {
		return "ProductModel [productid=" + productid + ", shopid=" + shopid + ", categoryid=" + categoryid
				+ ", productname=" + productname + ", description=" + description + ", price=" + price + ", stock="
				+ stock + ", rating=" + rating + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", image="
				+ image + ", images=" + images + "]";
	}
    
    

}
