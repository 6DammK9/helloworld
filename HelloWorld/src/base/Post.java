package base;

import java.util.Calendar;
import java.util.Date;

public class Post implements Comparable<Post> {

		private Date date;
		private String content;
		
		/**
		 * Constructor
		 * @param date
		 * @param content
		 */		
		public Post(Date date, String content){
			//TODO
			this.date = date;
			this.content = content;
		}
		
		public Post(){
			//TODO
			this.date = new Date();
			this.content = "";
			
			//System.out.println("WARNING: Empty constructor");
		}
		
		/**
		 * @return the date of the blog
		 */
		public Date getDate(){
			return this.date;
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
			return date.toString() + "\n" + content;				
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
			Post post = (Post) o;
			
			// In what circumstance will you think that post A is equal to post B?
			if (!this.date.equals(post.date)) {return false;}
			if (!this.content.equals(post.content)) {return false;}
			
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
			
			return date.hashCode() + content.hashCode();
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

		@Override
		public int compareTo(Post p) {
			// TODO Auto-generated method stub
			return this.date.compareTo(p.date);
		}
}

