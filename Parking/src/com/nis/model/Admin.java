package com.nis.model;

public class Admin {
private int adminid;
private String adminname;
private String password;
private String picture;
public int getAdminid() {
	return adminid;
}
public String getAdminname() {
	return adminname;
}
public String getPassword() {
	return password;
}
public String getPicture() {
	return picture;
}
public void setAdminid(int adminid) {
	this.adminid = adminid;
}
public void setAdminname(String adminname) {
	this.adminname = adminname;
}
public void setPassword(String password) {
	this.password = password;
}
public void setPicture(String picture) {
	this.picture = picture;
}

}
