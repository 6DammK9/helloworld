package blog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import base.*;

public class Blog implements Serializable {

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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		if (allPosts == null) {
			if (other.allPosts != null)
				return false;
		} else if (!allPosts.equals(other.allPosts))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((allPosts == null) ? 0 : allPosts.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
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
	
	public void save(String filepath) {
		// TODO		
		try {
			FileOutputStream fs = new FileOutputStream(filepath);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(this);
			os.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void load(String filepath) {
		// TODO		
		try {
			FileInputStream fs = new FileInputStream(filepath);
			ObjectInputStream os = new ObjectInputStream(fs);
			Blog blog = (Blog)os.readObject();
			this.user = blog.user;
			this.allPosts = blog.allPosts;
			os.close();
		} catch (FileNotFoundException fnd) {
			System.out.println("Wait! There is something wrong. I cannot find the file..");
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
}
