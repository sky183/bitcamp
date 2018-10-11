package guest.model;

//테이블의 컬럼과 메칭되는 데이터 관리 기능 
public class Message {
	private int id;
	private String guestName;
	private String password;

	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
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

	public boolean hasPassword() {
		return password != null && !password.isEmpty();
	}

	public boolean matchPassword(String pwd) {
		return password != null && password.equals(pwd);
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", guestName=" + guestName + ", password=" + password + ", message=" + message
				+ "]";
	}
}
