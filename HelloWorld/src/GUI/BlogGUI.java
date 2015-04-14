package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import base.Post;
import base.User;
import blog.Blog;

public class BlogGUI implements ActionListener{
	private JFrame mainFrame;
	private JTextArea postTextArea;
	private JTextArea postContent;
	private JButton refresh;
	private JButton post;
	private JLabel limit;
	private JPanel inputPanel;
	private JPanel inputBtnPanel;
	private Blog myBlog;
	private User user;

	public BlogGUI() {
		user = new User(1, "COMP3021", "COMP3021@cse.ust.hk");
		myBlog = new Blog(user);		
	}

	public void setWindow() {
		int size = 480;
		mainFrame = new JFrame("Micro Blog Demo");
		postTextArea = new JTextArea();
		postContent = new JTextArea();
		refresh = new JButton();
		post = new JButton();
		limit = new JLabel();
		inputPanel = new JPanel();
		inputBtnPanel = new JPanel();
		
		mainFrame.setSize(size,size);
		mainFrame.setLayout(new GridLayout(2,0));
		mainFrame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		inputPanel.setLayout(new BorderLayout(5,5));
		inputPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		inputBtnPanel.setLayout(new GridLayout(0,2));
		
		postContent.setBackground(new Color(240,240,240));
		postContent.setText("Here is put mt posts!");
		//postContent.setHorizontalAlignment(JTextField.CENTER);
		postContent.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		postContent.setEditable(false);
		postContent.setLineWrap(true);
		postContent.setWrapStyleWord(true);		
		
		postTextArea.setBackground(new Color(255,255,216));
		postTextArea.setText("What's on your mind?");
		postTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
		postTextArea.addKeyListener(new lengthListener());
		postTextArea.setLineWrap(true);
		postTextArea.setWrapStyleWord(true);
		
		refresh.setBackground(new Color(128,160,192));
		refresh.setText("refresh");
		refresh.addActionListener(this);
		
		post.setBackground(new Color(128,192,240));
		post.setText("post");
		post.addActionListener(this);

		limit.setText("You can still input 140 Characters");
		
		inputPanel.add(limit, BorderLayout.NORTH);
		inputPanel.add(postTextArea, BorderLayout.CENTER);
		inputBtnPanel.add(refresh);
		inputBtnPanel.add(post);
		inputPanel.add(inputBtnPanel, BorderLayout.SOUTH);
		
		mainFrame.add(inputPanel);
		mainFrame.add(postContent); 
		
		//You have to setVisible() after adding all your elements, or you will see nothing!
		mainFrame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mainFrame.setVisible(true); 
		

	}

	public static void main(String[] args) {
		BlogGUI blogGUi = new BlogGUI();
		blogGUi.setWindow();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == post) {
			// TODO Auto-generated method stub
			//postContent.setText("You click POST!");
			String content = postTextArea.getText();
			// TODO whether the post is empty
			if (content.length() > 0) {
				// TODO whether the length of the post has exceeded 140
				if (content.length() <= 140) {
					Date date = new Date();
					Post post = new Post(date,content);
					myBlog.add(post);
					// TODO add the post to the file
					myBlog.save("C:/Temp/"+user.getUserName()+".blog");
					// TODO display the post in the display area and clear the edit area
					postContent.setText(postTextArea.getText());
					postTextArea.setText("");
				}
			}				
		} else if (e.getSource() == refresh) {
			//postContent.setText("You click REFRESH!");
			myBlog.load("C:/Temp/"+user.getUserName()+".blog");
			postContent.setText(myBlog.toString());
		}
	}
	
	class lengthListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			int length = postTextArea.getText().length();
			if (length <= 140) {
				limit.setText("You can still input " + (140 - length) + " Characters");
			} else  {
				limit.setText("Your post legth has exceed 140!");
			}
		}
		
	}
}