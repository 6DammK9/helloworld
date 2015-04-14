package test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import base.Post;
import base.User;
import blog.Blog;

public class TestBlog {
	
	/**
	 * Get user's input
	 * @return String
	 */
	public String getInput(){
		String line = "";
		System.out.print("Enter the prompt:");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br. readLine();
		} catch(IOException e){
			e.printStackTrace();
		}
		return line;
	}
	
	public static void main(String[] args) {
		
		TestBlog testBlog = new TestBlog();
		User user = new User(1, "COMP3021","COMP3021@cse.ust.hk");
		Blog myblog = new Blog(user);
		String prompt = null;
		
		while(!(prompt = testBlog.getInput()).equals("exit")){
			//String prompt has already stores the input. now deal with it!
			
			if(prompt.startsWith("list")){
				myblog.list();
			}
			else if(prompt.startsWith("post")){
				//TODO How to get content from the prompt?
				Date date = new Date();
				String content = prompt.substring(5);
				Post post = new Post(date,content);
				myblog.post(post);
			}
			else if(prompt.startsWith("delete")){
				//Delete the post at the index parameter
				//TODO How to get the index from the prompt
				int index = Integer.parseInt(prompt.substring(7));
				myblog.delete(index);
			}
		}
	}
}
