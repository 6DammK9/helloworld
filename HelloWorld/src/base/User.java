package base;

import java.math.MathContext;

public class User {
	
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
	
	/**
	 * Check whether this object equals object o
	 * @param object o
	 * @return Boolean
	 * 
	 */
	
	@Override
	public boolean equals(Object o) {
		
		boolean ans = true;
		// Should it be equal compared to itself?
		if (o == this) {return true;}
		
		// What if if object is null?
		if (o == null) {return false;}
		
		// Are they the same class?
		// You can get the class of object o
		o.getClass();
		
		// You can transfer object o to User
		User user = (User) o;
		
		// In what circumstance will you think that User A is equal to User B?
		if (this.userId != user.userId) {return false;}
		if (!this.userName.equals(user.userName)) {return false;}
		if (!this.userEmail.equals(user.userEmail)) {return false;}
		
		return ans;
	}
	
	/**
	 * 
	 */
	@Override
	public int hashCode() {
		int hashCode = 17;
		//TODO
		//You should give hashCode a unique value?
		//You can use the hashCode of your attributes
		
		return (hashCode+userId) + userName.hashCode() + userEmail.hashCode();
	}
}
