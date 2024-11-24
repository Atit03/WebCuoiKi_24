package vn.locdung.models;

import java.io.Serializable;

public class UserModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private int userid;
	private String username;
	private String password;
	private String email;
	private String phone;
	private int roleid;
	private boolean isactive;
	public UserModel() {
		super();
	}
	public UserModel(int userid, String username, String password, String email, String phone, int roleid,
			boolean isactive) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.roleid = roleid;
		this.isactive = isactive;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	@Override
	public String toString() {
		return "UserModel [userid=" + userid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", roleid=" + roleid + ", isactive=" + isactive + "]";
	}
	

}
