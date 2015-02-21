package base;

import java.util.Date;

public class Post {

		private Date date;
		private String content;
		private User user;
		
		/**
		 * Constructor
		 * @param date
		 * @param content
		 * @param user
		 */
		
		public Post(Date date, String content, User user){
			//TODO
			this.date = date;
			this.content = content;
			this.user = user;
		}
		
		/**
		 * NOT FROM SAUCE: Empty constructor
		 */
		public Post(){
			//TODO
			this.date = new Date();
			this.content = "";
			this.user = new User();
			
			System.out.println("WARNING: Empty constructor");
		}
		
		/**
		 * 
		 * @return the content of the blog
		 */
		
		public String getContent() {
			//TODO
			return this.content;
		}
		
		/**
		 * 
		 * @param content
		 */
		
		public void setContent(String content) {
			//TODO
			this.content = content;
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
			user.toString() + "\n" + 
			date.toString() + "\n" + 
			content;
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
			
			// You can transfer object o to POST
			Post post = (Post) o;
			
			// In what circumstance will you think that post A is equal to post B?
			if (!this.date.equals(post.date)) {return false;}
			if (!this.content.equals(post.content)) {return false;}
			if (!this.user.equals(post.user)) {return false;}
			
			return ans;
		}
		
		/**
		 * 
		 */
		@Override
		public int hashCode() {
			int hashCode = 0;
			//TODO
			//You should give hashCode a unique value?
			//You can use the hashCode of your attributes
			date.hashCode();
			content.hashCode();
			user.hashCode();
			
			return hashCode;
			
		}
		
		/**
		 * Short one Line description.							(1)
		 * <p>
		 * Longer description. If there were any, it would be	[2]
		 * here.
		 * <p>
		 * And even more explanations to follow in consecutive 
		 * paragraphs separated by HTML paragraph breaks.
		 * 
		 * @param	variable Description text text text.		(3)
		 * @return	Description text text text.
		 */
		public int methodName(int a) {
			// method body with a return statement
			return a;
		}
		
		/**
		 * check whether this post contains some keyword
		 * @param keyword
		 * @return
		 */
		
		public boolean contains (String keyword) {
			
			//TODO
			//return true;
			return content.contains(keyword);
		}
}

