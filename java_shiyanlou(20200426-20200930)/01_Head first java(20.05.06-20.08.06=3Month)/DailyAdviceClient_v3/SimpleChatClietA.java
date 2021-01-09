import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleChatCliet {
	
	JTextArea incoming;
	JTextField outgoing;
	BufferedReader reader;
	PrintWriter writer;
	Socket sock;
	
	public static void main(String[] args){

		SimpleChatClient() client=new SimpleChatCliet();
		client.go();
	}	//	Close main
	
	public void go(){
		//ע�ᰴť�ļ�����
		//����setUpNetworking()
		
		JFrame frame=new JFrame("Ludicrously Simple Chat Client");
		JPanel mainPanel=new JPanel();
		
		//
		incoming =new JTextArea(15,50);
		incoming.setLIneWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEdited(false);
		JScrollPane qScroller=new JScrollPane(incoming);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneContents.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneContents.HORIZONTAL_SCROLLER_NEVER);
		
		
		outgoing =new JTextField(20);
		Button sendButton=new JButton("Send");
		sendButton.addActionListener(new SendButttonListener() );
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		//
		mainPanel.add(qScroller);
		
		
		
		setUpNetworking();
		
		//
		Thread readerThread =new Thread(new IncomingReader() );
		readerThread.start();
		
		
		
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		frame.setSize(400,500);
		frame.setVisible(true);
		
		
	}//close go-method
	
	private void setUpNetworking(){
		// ����Socket��PrintWriter
		// ��ֵPrintWriter��ʵ������
		
		try{
			sock =new Socket("127.0.0.1",5000);
			InputStreamReader streamReader=new InputStreamReader(sock.getinputStream() );
			reader=new BufferedReader(streamReader);
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
	
	public class IncomingReader implements Runable{
		public void run(){
			String message;
			try{
				
				while((message =reader.readLine()) != null){
					System.out.println("read"+message);
					incoming.append(message+"\n");
					
					
				}//end while
			}
			catch(Exception ex){
			ex.printStackTrace();
			}
			
		}
		
		
	}
	

}	//	Close class





