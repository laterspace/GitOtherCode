import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardBuilder {
	
	private JTextArea question;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private JFrame frame;
	
	
	public static void main(String[] args){

		QuizCardBuilder buiider=new QuizCardBuilder();
		buiider.go();
		
	}	//	Close main
	
	
	public void go(){
		//创建GUI
		
		frame=new JFrame("Quiz Card Builder");
		JPanel mainPanel=new JPanel();
		Font bigFont=new Font("sanserif",Font.BOLD,24);
		question=new JTextArea(6.20);
		question.setLineWrap(true);//开启换行
		question.setWrapStyleWord(true);//在边界空白处换行，false则边界处换行
		question.setFont(bigFont);
		
		JScrollPane qScroller=new JScrollPane(question);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		answer=new JTextArea(6,20);
		answer.setLineWrap(true);//开启换行
		answer.setWrapStyleWord(true);//在边界空白处换行，false则边界处换行
		answer.setFont(bigFont);
		
		JScrollPane aScroller=new JScrollPane(question);
		aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		JButton nextButton =new JButton("Next Card");
		
		cardList =new ArrayList<QuizCard>();
		
		JLabel qLabel=new JLabel("Question:");
		JLabel aLabel=new JLabel("Answer:");
		
		mainPanel.add(qLabel);
		mainPanel.add(qScroller);
		mainPanel.add(aLabel);
		mainPanel.add(aScroller);
		mainPanel.add(nextButton);
		
		nextButton.addActionListener(new NextCardListener());
		JMenuBar menuBar =new JMenuBar();//菜单栏是载体，菜单要放上面的
		JMenu fileMenu=new JMenu("File");
		JMenuItem newMenuItem =new JMenuItem("New");
		
		JMenuItem saveMenuItem =new JMenuItem("Save");
		newMenuItem.addActionListener(new NewMenuListener());
		
		saveMenuItem.addActionListener(new SaveMenuListener());
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		frame.setSize(500,600);
		frame.setVisible(true);
	
	}
	
	//Inner Class
	public class NextCardListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			
			QuizCard card =new QuizCard(question.getText(),answer.getText());
			cardList.add(card);
			clearCard();
		}
	}
	
	public class SaveMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			
			QuizCard card =new QuizCard(question.getText(),answer.getText());
			cardList.add(card);
			
			//调出存盘对话框（dialog），靠JFileChooser完成
			JFileChooser fileSave=new JFileChooser();
			fileSave.showSaveDialog(frame);
			saveFile(fileSave.getSelectFile());
			
		}
	}
	
	public class NewMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent ev){
			
			cardList.clear();
			clearCard();
		}
	}
	
	
	private void clearCard(){
		question.setText("");
		answer.setText("");
		question.requestFocus();		
	}
	
	private void saveFile(File file){
		try{
			
			BufferedWriter writer =new BufferedWriter(new FileWriter(file));
			
			for(QuizCard card:cardList){
				writer.write(card.getQuestion()+"/");
				writer.write(card.getAnswer()+"\n");
			}
			writer.close();
		}
		catch(IOException ex){
			System.out.println("could't write the cardList out");
			ex.printStackTrace();
		}
		
		
		
		
	}
	
	
}	//	Close class
