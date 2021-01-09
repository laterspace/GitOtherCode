import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizCardPlayer {
	
	private JTextArea display;
	private JTextArea answer;
	private ArrayList<QuizCard> cardList;
	private QuizCard currentCard;
	private int currentCardIndex;
	private JFrame frame;
	private JButton nextButton;
	private boolean isShowAnswer;
	
	
	
	
	public static void main(String[] args){
		QuizCardPlayer reader=new QuizCardPlayer();
		reader.go();
		
	}	//	Close main
	
	public void go(){
		frame=new JFrame("Quiz Card Player");
		JPanel mainPanel=new JPanel();
		Font bigFont=new Font("sanserif",Font.BOLD,24);
		
		display=new JTextArea(10,20);
		display.setFont(bigFont);
		
		display.setLineWrap(true);
		display.setEditable(false);
		
		JScrollPane qScroller=new JScrollPane(display);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		nextButton =new JButton("Show Question");
		mainPanel.add(qScroller);
		mainPanel.add(nextButton);
		nextButton.addActionListener(new NextCardListener());
		
		JMenuBar menuBar =new JMenuBar();
		JMenu fileMenu=new JMenu("file");
		JMenuItem loadMenuItem=new JMenuItem("Load Card Set");
		loadMenuItem.addActionListener(new OpenMenuListener());
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);
		
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
		frame.setSize(640,500);
		frame.setVisible(true);

	} //close go Method
	
	class NextCardListener implements ActionListener{
		public  void ationPerformed(ActionEvent ev){
			if (isShowAnswer){
				//显示答案
				display.setText(currentCard.getAnswer());
				nextButton.setText("Next Card");
				isShowAnswer=false;
				
			} 
			else {
				//显示问题
				if (currentCardIndex<cardList.size()){
					showNextCard();
				}
				else{
					//没有更多的卡片了
					display.setText("That was last card");
					nextButton.setEnabled(false);
				}
			}
			
		}
	}
	
	class OpenMenuListener implements ActionListener{
		public  void ationPerformed(ActionEvent ev){
			JFileChooser fileOpen =new JFileChooser();
			fileOpen.showOpendialog(frame);
			loadFile(fileOpen.getSelectedFile());
			
		}
	}
	
	private void loadFile(File file){
		cardList =new ArrayList<QuizCard>();
		try{
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String line=null;
			while ((line=reader.readLine())!=null){
				makeCard(line);
			}
			reader.close();
		}
		catch(IOException ex){
			System.out.println("could't read the card file");
			ex.printStackTrace();
		}
		//显示第一个卡片
		
	}
	
	private void makeCard(String lineToParse){
		String[] result =lineToParse.split("/");
		QuizCard card=new QuizCard(result[0],result[1]);
		cardList.add(card);
		System.out.println("made a card");
		
		
	}
	
	private void showNextCard(){
		currentCard=cardList.get(currentCardIndex);
		currentCardIndex++;
		display.setText(currentCard.getQuestion());
		nextButton.setText("Show Answer");
		isShowAnswer=true;
	}
	
}	//	Close class
