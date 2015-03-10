package blog;

import java.util.ArrayList;
import java.util.Calendar;

import base.*;

public class Blog {

	private User user;
	private ArrayList<Post> allPosts;
	
	/**
	 * Constructor
	 * @param user
	 */
	public Blog(User user){
		// TODO
		this.user = user;
		this.allPosts = new ArrayList<Post>();
	}
	
	public Blog(){
		// TODO
		this.user = new User();
		this.allPosts = new ArrayList<Post>();
		//System.out.println("WARNING: Empty Constructor");
	}
	
	/**
	 * 
	 * @param user
	 */
	public void setUser(User user){
		// TODO
		this.user = user;
	}
	
	/**
	 * 
	 * @param user
	 */
	public User getUser(){
		// TODO
		return user;
	}
	
	/**
	 * create a new post in your blog
	 * @param post
	 */
	public void post(Post p){
		//TODO add Post p to your blog
		allPosts.add(p);
		//TODO print a message if succeed
		System.out.println("A new Post:");
		System.out.println(p);
	}
	
	/**
	 * list all posts in the blog
	 * 
	 */
	public void list(){
		//TODO
		System.out.println("Current posts:");
		
		int i = 0;
		while(i < allPosts.size()){
			System.out.println("Post:["+(i+1)+"]:"+allPosts.get(i));
			i++;
		}
	}
	
	/**
	 * delete a post from the blog
	 * @param index
	 */
	public void delete(int index){
		boolean removeable = true;
		index--; //IDK why it needs to be count from 1 instead of 0 
		//Is the index legal? The index should be neither too high nor negative
		if ((index < 0)||(index>=allPosts.size())) {removeable = false;}
		//If the index is legal, delete the corresponding Post
		if (removeable) {allPosts.remove(index);}
		//Otherwise print a fault message
		else {System.out.println("Illegal deletion.");}
	}
	
	@Override
	/**
	 * Output this object in string format
	 * @return String
	 * 
	 */
	public String toString(){
		//TODO
		return "[Blog]";
	}
	
	@Override
	/**
	 * 
	 */
	public boolean equals(Object o) {
		
		// Should it be equal compared to itself?
		if (o == this) {return true;}
		
		// What if if object is null?
		if (o == null) {return false;}
		
		// Are they the same class?
		// You can get the class of object o
		if (o.getClass() != getClass()) {return false;};
		
		// You can transfer object o to POST
		Blog blog = (Blog) o;
		
		// In what circumstance will you think that blog A is equal to blog B?
		if (!this.user.equals(blog.user)) {return false;}
		if (!this.allPosts.equals(blog.allPosts)) {return false;}	
		
		return true;
	}
	
	@Override
	/**
	 * 
	 * @return
	 */
	public int hashCode(){
		//TODO
		return this.user.hashCode() + allPosts.hashCode();
	}
	

	/**
	 * Search posts created in month and mentioned someone
	 * 
	 * @param month
	 * @param someone
	 */
	public void search(int month, String someone) {
		
		Calendar cal = Calendar.getInstance();
		// search from all posts
		for (Post p: allPosts) {
			// get then current post's month (note that Calaendar.Month starts
			// with 0, not 1)
			cal.setTime(p.getDate());
			int postMonth = cal.get(Calendar.MONTH) + 1;
			
			// TODO write your things here
			if ((postMonth == month) && (p.getContent().contains(someone))) {
				System.out.println(p);
			}
			
		}
	}

	public void setPosts(ArrayList<Post> posts) {
		if (posts != null) {
			for (Post p: posts) {
				allPosts.add(p);
			}
		}
	}
}
