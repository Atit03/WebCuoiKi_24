package vn.locdung.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderModel implements Serializable{

	private static final long serialVersionUID = 1L;
	public int orderid;
	public String fullname;
	public String address;
	public String phone;
	public BigDecimal total;
	public String paymentmethod;
	public OrderModel() {
		super();
	}
	public OrderModel(int orderid, String fullname, String address, String phone, BigDecimal total,
			String paymentmethod) {
		super();
		this.orderid = orderid;
		this.fullname = fullname;
		this.address = address;
		this.phone = phone;
		this.total = total;
		this.paymentmethod = paymentmethod;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	@Override
	public String toString() {
		return "OrderModel [orderid=" + orderid + ", fullname=" + fullname + ", address=" + address + ", phone=" + phone
				+ ", total=" + total + ", paymentmethod=" + paymentmethod + "]";
	}
	
	
}
