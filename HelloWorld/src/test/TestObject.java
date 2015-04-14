package test;

import java.util.Date;

import base.FriendsPost;
import base.User;

public class TestObject {

    public static Date TextToDate (String in) {
        String[] MonStr = {"Jun", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
                "Aug", "Sep", "Oct", "Nov", "Dec"};
        String[] prase1 = in.split(" "); //Tue Apr 07 17:32:47 CST 2015
        String[] prase2 = prase1[3].split(":");
        
        int mon = 0;
        while ((!prase1[1].equals(MonStr[mon])) || mon > 11) {
            mon++;
        }

        return new Date(Integer.parseInt(prase1[5]) - 1900, 
                mon, 
                Integer.parseInt(prase1[2]), 
                Integer.parseInt(prase2[0]), 
                Integer.parseInt(prase2[1]), 
                Integer.parseInt(prase2[2]));
    }
	
	public static void main(String[] args) {
		Date fake = new Date();
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
		System.out.println(fake);
		System.out.println(TextToDate(fake.toString()));
	}

	public static String lol (String a, int b) {
		StringBuilder ans = new StringBuilder();
		if(a != null)
			for (char c:a.toCharArray())
				ans.append( (char)((c+b%26) > 122 ? c-26+b%26 : ((c+b%26) < 97? c+26+b%26 : c+b%26)));
		return ans.toString();
	}
}
