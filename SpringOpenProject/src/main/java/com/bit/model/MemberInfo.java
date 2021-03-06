package com.bit.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class MemberInfo {

	private int idx = 0;
	private String userId;
	private String password;
	private String userName;
	private String userPhoto; // DB에 저장할 파일 이름
	private MultipartFile photoFile;
	private Date regDate;

	public MemberInfo() {

	}

	public MemberInfo(String userId, String password, String userName, String userPhoto) {
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.userPhoto = userPhoto;
	}
	
	public MemberInfo(int idx, String userId, String password, String userName, String userPhoto, Date regDate) {
		this.idx = idx;
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.userPhoto = userPhoto;
		this.regDate = regDate;
	}

	public MemberInfo(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date date) {
		this.regDate = date;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public MultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}

	@Override
	public String toString() {
		return "MemberInfo [idx=" + idx + ", userId=" + userId + ", password=" + password + ", userName=" + userName
				+ ", userPhoto=" + userPhoto + ", photoFile=" + photoFile.getOriginalFilename() + ", regDate=" + regDate + "]";
	}

}
