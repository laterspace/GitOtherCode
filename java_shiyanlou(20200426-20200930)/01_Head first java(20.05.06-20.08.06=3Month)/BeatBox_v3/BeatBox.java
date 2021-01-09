import java.lang.*;
import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;
import java.io.*;

public class BeatBox {
	
	JPanel mainPanel;
	ArrayList<JCheckBox> checkboxlist;	//把checkbox储存在ArrayList中
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame theFrame;
	
	//乐器名称以数组来存储
	String[] instrumentNames={"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga" };
	
	int[] instruments ={
		35,42,46,28,
		49,39,50,60,
		70,72,64,56,
		58,47,67,63
	};//乐器的关键词。音道
	
		
	public static void main(String[] args){

		new BeatBox().buildGUI();
	}	//	Close main
	
	public void buildGUI(){
		theFrame=new JFrame("Cyber BeatBox");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout =new BorderLayout();
		JPanel backgound =new JPanel(layout);
		backgound.setBorder(BorderFactory.createEmptyBorder(10,10,10,10)); //设定面板边缘里组件的距离（留白）
		
		checkboxlist =new ArrayList<JCheckBox>();
		Box buttonBox=new Box(BoxLayout.Y_AXIS);
		
		//start
		JButton start =new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);
		
		//stop
		JButton stop =new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);
		
		//upTempo
		JButton upTempo =new JButton("Tempo Up");
		upTempo.addActionListener(new MyUpTempoListener());
		buttonBox.add(upTempo);
		
		//downTempo
		JButton downTempo =new JButton("Tempo Down");
		downTempo.addActionListener(new MyDownTempoListener());
		buttonBox.add(downTempo);
		
		//添加储存还原按钮
		JButton serializetl=new JButton("serializetl");
		serializetl.addActionListener(new MySendListener());
		buttonBox.add(serializetl);
		
		JButton restore=new JButton("restore");
		restore.addActionListener(new MyReadListener());
		buttonBox.add(restore);
		
		//instrumentNames Label Box
		Box nameBox=new Box(BoxLayout.Y_AXIS);
		for (int i=0; i<16; i++){
			nameBox.add(new Label(instrumentNames[i]));
		}
		
		backgound.add(BorderLayout.EAST,buttonBox);
		backgound.add(BorderLayout.WEST,nameBox);
		
		theFrame.getContentPane().add(backgound);
		
		//网格布局
		GridLayout grid =new GridLayout(16,16);
		grid.setVgap(1);//组件之间的垂直间距
		grid.setHgap(2);//组件之间的水平间距
		mainPanel=new JPanel(grid);
		backgound.add(BorderLayout.CENTER,mainPanel);
		
		
		//创建checkbox组，设定成勾选的weifalse并加到ArrayList和面板上
		for (int i=0; i<256; i++){
			
			JCheckBox c=new JCheckBox();
			c.setSelected(false);
			checkboxlist.add(c);
			mainPanel.add(c);
			
		} //end for
		
		setUpMidi();
		
		theFrame.setBounds(50,50,300,300);
		theFrame.pack();
		theFrame.setVisible(true);
	} //关闭方法
	
	public void setUpMidi(){
		//MIDi设置程序代码
		try{
		
		sequencer=MidiSystem.getSequencer();
		sequencer.open();
		sequence=new Sequence(Sequence.PPQ,4);
		track=sequence.createTrack();
		sequencer.setTempoInBPM(120);
		}
		catch(Exception e){e.printStackTrace();}
		
	}//Close method
	
	
	public void buildTrackAndStart(){
		
		int[] trackList=null;
		
		sequence.deleteTrack(track);
		track=sequence.createTrack();
		
		for (int i=0; i<16; i++){
			trackList=new int[16];
			
			int key =instruments[i];
			
			for (int j=0; j<16; j++){
				JCheckBox jc=(JCheckBox) checkboxlist.get(j+(16*i));
				if (jc.isSelected()){
					trackList[j]=key;
				}
				else{
					trackList[j]=0;
				}//end if
				
			}//close inner for
			
			makeTracks(trackList);
			track.add(makeEvent(176,1,127,0,16));
		}//close outter for
		
		track.add(makeEvent(192,9,1,0,15));
		try{
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		}
		catch(Exception e){e.printStackTrace();}
	
	}//close buildTrackAndStart method
	
	public class MyStartListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			buildTrackAndStart();
		}
	}//close inner class
	
	public class MyStopListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			sequencer.stop();
		}
	}//close inner class
	
	public class MyUpTempoListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			float tempoFactor =sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * 1.03));
		}
	}//close inner class
	
	public class MyDownTempoListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			float tempoFactor =sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * 0.97));
		}
	}//close inner class
	
	public void makeTracks(int[] list){
		for (int i=0; i<16; i++){
			int key=list[i];
			if (key !=0){
				track.add(makeEvent(144,9,key,100,i));
				track.add(makeEvent(128,9,key,100,i+1));
			}
		}
	}
	
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
		MidiEvent event =null;
		try{
			ShortMessage a=new ShortMessage();
			a.setMessage(comd,chan,one,two);
			event =new MidiEvent(a,tick);
		}
		catch(Exception e){}
		return event;
	}
	
	//存储状态
	public class MySendListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			boolean[] checkboxState=new boolean[256]; // 保存复选框
			
			for (int i=0; i<256; i++){
				
				JCheckBox check=(JCheckBox) checkboxlist.get(i);
				if (check.isSelected()){
					checkboxState[i]=true;
				}
			}
			
			
			JFileChooser fileSave=new JFileChooser();
			fileSave.showSaveDialog(theFrame);
			saveFile(fileSave.getSelectedFile(),checkboxState);
			
		
		}
		public void saveFile(File file,boolean[] checkboxState){
			try{
				FileOutputStream fileStream=new FileOutputStream(file);
				ObjectOutputStream os=new ObjectOutputStream(fileStream);
				os.writeObject(checkboxState);
				
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		
	}
	
	//还原状态
	public class MyReadListener implements ActionListener{
		public void actionPerformed(ActionEvent a){
			boolean[] checkboxState=null;
			
			//弹出打开文件选择对话框
			JFileChooser fileOpen =new JFileChooser();
			fileOpen.showOpenDialog(theFrame);
			
			
		
		try{
			FileInputStream fileIn=new FileInputStream(fileOpen.getSelectedFile());
			ObjectInputStream is=new ObjectInputStream(fileIn);
			checkboxState=(boolean[]) is.readObject();
			
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
		catch(ClassNotFoundException ce){
			ce.printStackTrace();
		}

			
			for (int i=0; i<256; i++){
				
				JCheckBox check=(JCheckBox) checkboxlist.get(i);
				if (checkboxState[i]){
					check.setSelected(true);
				}
				else{
					check.setSelected(false);
				}
			}
			
			sequencer.stop();
			buildTrackAndStart();
			
			
		
		}
		
	
		
		
	}
}	//	Close class
