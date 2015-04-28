package base;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	private int data;
	private BinaryTree left;
	private BinaryTree right;
	Queue<BinaryTree> queue = new LinkedList<BinaryTree>() ;
	
	public static int count = 0;
	
	public BinaryTree(int a){
		data = a;
	}
	
	public int getData(){
		return data;
	}
	
	public void setData(int d){
		data = d;
	}

	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	public BinaryTree getRight() {
		return right;
	}

	public void setRight(BinaryTree right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		String ans = "";
		BinaryTree node;
		queue.clear();
		queue.add(this);
	    while(!queue.isEmpty()){
	    	node = queue.remove();
	    	ans += node.getData() + " ";
	        if(node.right != null) queue.add(node.right);
	        if(node.left != null) queue.add(node.left);
	    }
		return ans.trim();
	}
}
