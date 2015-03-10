package base;

import java.util.Date;

public class FriendsPost extends Post{

	private User friend;
	
	//TODO
	public FriendsPost(Date date, String content, User user){
		//FriendsPost(date,content,user);
		super(date, content);
		this.friend = user;
	}
	
	/**
	 * Output this object in string format
	 * @return String
	 * 
	 */
	
	@Override
	public String toString() {
		//TODO
		return this.friend.toString() + "\n" + 
				this.getDate().toString() + "\n" + 
				this.getContent();				
	}
	
	/**
	 * Check whether this object equals object o
	 * @param object o
	 * @return Boolean
	 * 
	 */
	
	@Override
	public boolean equals(Object o) {
		
		// Should it be equal compared to itself?
		if (o == this) {return true;}
		
		// What if if object is null?
		if (o == null) {return false;}
		
		// Are they the same class?
		// You can get the class of object o
		if (o.getClass() != getClass()) {return false;};
		
		// You can transfer object o to POST
		FriendsPost Fpost = (FriendsPost) o;
		
		// In what circumstance will you think that post A is equal to post B?
		if (!this.friend.equals(Fpost.friend)) {return false;}
		if (!this.getDate().equals(Fpost.getDate())) {return false;}
		if (!this.getContent().equals(Fpost.getContent())) {return false;}		
		
		return true;
	}
	
	/**
	 * 
	 */
	@Override
	public int hashCode() {
		//TODO
		//You should give hashCode a unique value?
		//You can use the hashCode of your attributes
		return friend.hashCode() + this.getDate().hashCode() + this.getContent().hashCode();
	}
}
