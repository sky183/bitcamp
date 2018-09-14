package com.codechobo;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

public class UserInfo {
	
	private String name;
	private String user_id;
	private String password;
	private String password2;
	private String email;
	private String reg_num;
	private String zip;
	private String address;
	private String job;
	private String hobby = "";
	private String pr;
	private String hobbys[];
	private String prevUri;
	private String getEmails[];

	public void bindRequestParams(HttpServletRequest request) throws IOException {
		
		request.setCharacterEncoding("utf-8");
		
		name = request.getParameter("name");
		user_id = request.getParameter("user_id");
		password = request.getParameter("password");
		password2 = request.getParameter("password2");
		email = request.getParameter("email");
		reg_num = request.getParameter("reg_num");
		zip = request.getParameter("zip");
		address = request.getParameter("address");
		job = request.getParameter("job");
		hobbys = request.getParameterValues("hobby");
		if (hobbys != null) {
			for (int i = 0; i < hobbys.length; i++) {
				hobby += hobbys[i] + " ";
			}
		}
		pr = request.getParameter("pr");
		prevUri = request.getParameter("prevUri");
		getEmails = email.split("@|\\.");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getReg_num() {
		return reg_num;
	}

	public void setReg_num(String reg_num) {
		this.reg_num = reg_num;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getPr() {
		return pr;
	}

	public void setPr(String pr) {
		this.pr = pr;
	}

	public String[] getHobbys() {
		return hobbys;
	}

	public void setHobbys(String[] hobbys) {
		this.hobbys = hobbys;
	}

	public String getPrevUri() {
		return prevUri;
	}

	public void setPrevUri(String prevUri) {
		this.prevUri = prevUri;
	}

	public String[] getEmails() {
		return getEmails;
	}

	public void setEmails(String[] emails) {
		this.getEmails = emails;
	}
	
	
}
