package base;

import java.io.Serializable;
import java.util.Date;

public class Post implements Comparable<Post>, Serializable {

	/**
	 * Don't know what it means; generated in auto
	 */
	private static final long serialVersionUID = 6526266097594730252L;
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
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Post other = (Post) obj;
			if (content == null) {
				if (other.content != null)
					return false;
			} else if (!content.equals(other.content))
				return false;
			if (date == null) {
				if (other.date != null)
					return false;
			} else if (!date.equals(other.date))
				return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((content == null) ? 0 : content.hashCode());
			result = prime * result + ((date == null) ? 0 : date.hashCode());
			return result;
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

