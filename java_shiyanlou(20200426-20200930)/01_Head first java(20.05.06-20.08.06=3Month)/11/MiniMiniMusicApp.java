import javax.sound.midi.*;
public class MiniMiniMusicApp {
	public static void main(String[] args){
		MiniMiniMusicApp mini=new MiniMiniMusicApp();
		mini.play();
	}//close main

	public void play(){
		try
		{
		//1.
		Sequencer player =MidiSystem.getSequencer();
		    player.open();
			
			//2.
			Sequence seq=new Sequence(Sequence.PPQ,4);
			
			//3.
			Track track=seq.createTrack();	//取得Track
			
			
			//4.
			ShortMessage a=new ShortMessage();
			a.setMessage(144,1,44,100);
			MidiEvent noteOn =new MidiEvent(a,1);
			track.add(noteOn);

			ShortMessage b=new ShortMessage();
			a.setMessage(128,1,44,100);
			MidiEvent noteOff =new MidiEvent(b,16);
			track.add(noteOff);

			player.setSequence(seq);	//将sequence送到sequencer

			player.start();	//play

			}
		catch (Exception ex)
		{
			   ex.printStackTrace();
		}

	}//关闭播放
}//close class
