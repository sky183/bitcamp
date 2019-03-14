package com.sb.board.model;

public class BoardVO {
	private int num;
	private String title;
	private String text;
	private String name;
	private int viewcount;
	private String password;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", title=" + title + ", text=" + text + ", name=" + name + ", viewcount="
				+ viewcount + ", password=" + password + "]";
	}
	
	
	
}
