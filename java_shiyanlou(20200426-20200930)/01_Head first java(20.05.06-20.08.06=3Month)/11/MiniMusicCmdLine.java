import javax.sound.midi.*;

public class MiniMusicCmdLine {
	public static void main(String[] args){
		MiniMusicCmdLine mini=new MiniMusicCmdLine();
		if (args.length<2)
		{
			System.out.println("Don't forget the instrument and note args!");
		}
		else {
			int instrument =Integer.parseInt(args[0]);
			int note=Integer.parseInt(args[1]);
			mini.play(instrument,note);
		}  //  End if
	}
	public void play(int instrument ,int note){
			try
			{
				//1.
			Sequencer player =MidiSystem.getSequencer();
		    player.open();
			
			//2.
			Sequence seq=new Sequence(Sequence.PPQ,4);
			
			//3.
			Track track=seq.createTrack();	//取得Track

			MidiEvent event=null;

			//4.
			ShortMessage first=new ShortMessage();
			first.setMessage(192,1,instrument,0);
			MidiEvent changeInstrument=new MidiEvent(first,1);
			track.add(changeInstrument);
			
			ShortMessage a=new ShortMessage();
			a.setMessage(144,1,note,100);
			MidiEvent noteOn =new MidiEvent(a,1);
			track.add(noteOn);

			ShortMessage b=new ShortMessage();
			a.setMessage(128,1,note,100);
			MidiEvent noteOff =new MidiEvent(b,16);
			track.add(noteOff);

			player.setSequence(seq);	//将sequence送到sequencer

			player.start();	//play

			}
		catch (Exception ex)
		{
			   ex.printStackTrace();
		}

	}	//关闭播放
}	//close class
