package base;

import java.util.Date;

public class FriendsPost extends Post{

	/**
	 * Don't know what it means; generated in auto
	 */
	private static final long serialVersionUID = 8517203547543118002L;
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FriendsPost other = (FriendsPost) obj;
		if (friend == null) {
			if (other.friend != null)
				return false;
		} else if (!friend.equals(other.friend))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((friend == null) ? 0 : friend.hashCode());
		return result;
	}
}
