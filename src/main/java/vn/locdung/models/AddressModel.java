package vn.locdung.models;

import java.io.Serializable;

public class AddressModel implements Serializable{

	private static final long serialVersionUID = 1L;
	public int addressid;
	public int userid;
	public String fullname;
	public String address;
	public String phone;
	public AddressModel() {
		super();
	}
	public AddressModel(int addressid, int userid, String fullname, String address, String phone) {
		super();
		this.addressid = addressid;
		this.userid = userid;
		this.fullname = fullname;
		this.address = address;
		this.phone = phone;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	@Override
	public String toString() {
		return "AddressModel [addressid=" + addressid + ", userid=" + userid + ", fullname=" + fullname + ", address="
				+ address + ", phone=" + phone + "]";
	}
	
	
}
