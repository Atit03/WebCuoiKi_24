package vn.locdung.models;

import java.io.Serializable;

public class UserModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private int userid;
	private String username;
	private String password;
	private String email;
	private String fullname;
	private String phone;
	private int status;
	private String code;
	private int roleid;
	public UserModel() {
		super();
	}
	
	
	
	public UserModel(String username, String email, String fullname, String password, int status, int roleid,
			String code) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
		this.status = status;
		this.code = code;
		this.roleid = roleid;
	}

	

	public UserModel(int userid, String username, String email, String fullname, String phone) {
		super();
		this.userid = userid;
		this.username = username;
		this.email = email;
		this.fullname = fullname;
		this.phone = phone;
	}



	public UserModel(String username, String email, String fullname, String code) {
		super();
		this.username = username;
		this.email = email;
		this.fullname = fullname;
		this.code = code;
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
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	
	
	

}
