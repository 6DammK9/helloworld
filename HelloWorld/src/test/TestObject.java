package test;

import java.util.Date;
import java.lang.*;

import base.FriendsPost;
import base.User;

public class TestObject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello World 1.8");
		
		User user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		Date date = new Date();
		String content = "This is my first post";
		FriendsPost postFromFriend = new FriendsPost(date,content,user);
		System.out.println(postFromFriend);
		
		System.out.println(postFromFriend.contains("first"));
		System.out.println(postFromFriend.contains("HKUST"));
		//System.out.println(lol("aoe", -1000));
	}

	public static String lol (String a, int b) {
		StringBuilder ans = new StringBuilder();
		if(a != null)
			for (char c:a.toCharArray())
				ans.append( (char)((c+b%26) > 122 ? c-26+b%26 : ((c+b%26) < 97? c+26+b%26 : c+b%26)));
		return ans.toString();
	}
}
