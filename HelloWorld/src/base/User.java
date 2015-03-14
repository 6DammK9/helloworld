package base;

import java.io.Serializable;

public class User implements Comparable<User>, Serializable {
	
	/**
	 * Don't know what it means; generated in auto
	 */
	private static final long serialVersionUID = 1111407784922779501L;
	private int userId;
	private String userName;
	private String userEmail; 
	
	public User(int id, String name, String email) {
		// TODO
		// User user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		
		this.userId = id;
		this.userName = name;
		this.userEmail = email;
	}
	
	/**
	 * NOT FROM SAUCE: Empty constructor
	 */
	public User(){
		this.userId = 0;
		this.userName = "";
		this.userEmail = "";
		
		//System.out.println("WARNING: Empty constructor");
	}
	
	/**
	 * Output this object in string format
	 * @return String
	 * 
	 */
	
	@Override
	public String toString() {
		//TODO
		return 
		"User [" + 
		"userID=" + userId +
		", userName=" + userName +
		", userEmail=" + userEmail +
		"]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + userId;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public int compareTo(User u) {
		// TODO Auto-generated method stub
		if (this.userId > u.userId) {return 1;}
			else if (this.userId < u.userId) {return -1;}
			else return 0;
	}
	
	public String getUserName() {
		return this.userName;
	}
}
