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
		//ע�ᰴť�ļ�����
		//����setUpNetworking()
		
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
		// ����Socket��PrintWriter
		// ��ֵPrintWriter��ʵ������
		
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
		// ȡ�������ֶ�����
		// ���͵���������
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





