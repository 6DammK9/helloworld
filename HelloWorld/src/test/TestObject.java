package test;

import java.util.Date;

import base.BinaryTree;
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
		//BinaryTree[] temp;
		//temp = makeTree();
		String time = "123D 0H 123M 123S";
        String[] time2 = time.split(" ");
        for (int i=0; i<4; i++) {
            time2[i] = time2[i].substring(0,time2[i].length() - 1);
        }
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
		//System.out.println(fake);
		//System.out.println(TextToDate(fake.toString()));
		//System.out.println(temp[0]);
		//System.out.println(temp[0]);
		//System.out.println(temp[0]);
		System.out.println(time2[1]);
	}

	public static String lol (String a, int b) {
		StringBuilder ans = new StringBuilder();
		if(a != null)
			for (char c:a.toCharArray())
				ans.append( (char)((c+b%26) > 122 ? c-26+b%26 : ((c+b%26) < 97? c+26+b%26 : c+b%26)));
		return ans.toString();
	}
	
	public static BinaryTree[] makeTree() {
		BinaryTree[] temp = new BinaryTree[32];
		
		for (int i=0; i<32; i++) {
			temp[i] = new BinaryTree(i);
		}
		
		for (int i=1; i<32; i++) {
			if ((i-1)%2 == 0)
				temp[(i/2)].setLeft(temp[i]);
			else 
				temp[(i/2)].setRight(temp[i]);
		}	
		return temp;
	}
}
