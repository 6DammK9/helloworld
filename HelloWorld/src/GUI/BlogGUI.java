package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class BlogGUI implements ActionListener{
	private JFrame mainFrame;
	private JTextArea postTextArea;
	private JTextField postContent;
	private JButton refresh;
	private JButton post;
	private JLabel limit;
	private JPanel inputPanel;
	private JPanel inputBtnPanel;

	public BlogGUI() {
		
	}

	public void setWindow() {
		int size = 480;
		mainFrame = new JFrame("Micro Blog Demo");
		postTextArea = new JTextArea();
		postContent = new JTextField();
		refresh = new JButton();
		post = new JButton();
		limit = new JLabel();
		inputPanel = new JPanel();
		inputBtnPanel = new JPanel();
		
		mainFrame.setSize(size,size);
		mainFrame.setLayout(new GridLayout(2,0));
		//mainFrame.setBackground(new Color(128,128,128));
		mainFrame.getRootPane().setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		inputPanel.setLayout(new BorderLayout(5,5));
		inputPanel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		inputBtnPanel.setLayout(new GridLayout(0,2));
		
		postContent.setBackground(new Color(240,240,240));
		postContent.setText("Here is put mt posts!");
		postContent.setHorizontalAlignment(JTextField.CENTER);
		postContent.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		
		postTextArea.setBackground(new Color(255,255,216));
		postTextArea.setText("What's on your mind?");
		postTextArea.setBorder(BorderFactory.createLoweredBevelBorder());
		
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
			postContent.setText("You click POST!");		
		} else if (e.getSource() == refresh) {
			postContent.setText("You click REFRESH!");
		}
	}
}