import java.lang.*;
import javax.sound.midi.*;
public class MiniMusicPlayer1 {
	public static void main(String[] args){
		try{
			//创建并打开队列器（sequencer）
			Sequencer sequencer=MidiSystem.getSequencer();
			sequencer.open();
			
			//创建队列（seq）并track（轨道）
			Sequence seq =new Sequence(Sequence.PPQ,4);
			Track track =seq.createTrack();
			
			//创建一堆连续的音符事件
			for (int i =5; i<64;i+=4){
				
				track.add(makeEvent(144,1,i,100,i));
				track.add(makeEvent(128,1,i,100,i+2));
			}
			
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
						
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}	//	Close main
	
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
}	//	Close class
