package com.bit.model;


public class Message {
	private int message_Id;
	private String guest_Name;
	private String password;
	private String message;

	
	
	public boolean matchPassword(String pw) {		
		return password.equals(pw);
	}
	
	public boolean hasPassword() {
		return password != null && !password.isEmpty();
	}

	public int getMessage_Id() {
		return message_Id;
	}

	public void setMessage_Id(int message_Id) {
		this.message_Id = message_Id;
	}

	public String getGuest_Name() {
		return guest_Name;
	}

	public void setGuest_Name(String guest_Name) {
		this.guest_Name = guest_Name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [message_Id=" + message_Id + ", guest_Name=" + guest_Name + ", password=" + password
				+ ", message=" + message + "]";
	}
	
	
	
	
	
	
	
	

}
