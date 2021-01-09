import java.lang.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleGui1B implements ActionListener {
	JButton button;
	public static void main(String[] args){
		SimpleGui1B gui =new SimpleGui1B();
		gui.go();
		
		
	}	//	Close main

	public void go(){
		JFrame frame=new JFrame();
		button = new JButton("click me");
		
		button.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(button);
		
		frame.setSize(300,300);
		frame.setVisible(true);
		
	}//Close go()
	
	public void actionPerformed(ActionEvent event){
		button.setText("T've been clicked!");
		
	}
	}	//	Close class
 