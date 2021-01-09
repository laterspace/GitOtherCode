import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleChatClietA {
	
	JTextField outgoing;
	PrintWriter writer;
	Socket sock;
	
	public void go(){
		//注册按钮的监听者
		//调用setUpNetworking()
		
		JFrame frame=new JFrame("Ludicrously Simple Chat Client");
		JPanel mainPanel=new JPanel();
		outgoing =new JTextField(20);
		Button sendButton=new JButton("Send");
		sendButton.addActionListener(new SendButttonListener());
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		setUpNetworking();
		frame.setSize(400,500);
		frame.setVisible(true);
		
		
	}//close go-method
	
	private void setUpNetworking(){
		// 建立Socket、PrintWriter
		// 赋值PrintWriter给实例变量
		
		try{
			sock =new Socket("127.0.0.1",5000);
			writer =new PrintWriter(sock.getOutputStream());
			System.out.println("networking estalished");
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		
		
		
	} //close setUpNetworking-method
	
	
	
	
	
	public class SendButttonListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
		// 取得文字字段内容
		// 传送到服务器上
		try{
			writer.println(outgoing.getText());
			writer.flush();
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		outgoing.setText("");
		outgoing.requestFocus();
		
		}
	
	}	//close SendButttonListener-inner-class
	
	public static void main(String[] args){

		new SimpleChatClietA().go();
	}	//	Close main

}	//	Close class





