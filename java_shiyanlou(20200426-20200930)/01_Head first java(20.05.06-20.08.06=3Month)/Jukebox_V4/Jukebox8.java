import java.lang.*;
import java.util.*;
import java.io.*;

public class Jukebox8 {
		
	ArrayList<Song> songList=new ArrayList<Song>();


	public static void main(String[] args){
		
		new Jukebox8().go();
			

	}	//	Close main
	
	class ArtistCompare implements Comparator<Song>{
		public int compare(Song one,Song two){
			return one.getArtist().compareTo(two.getArtist());
		}
		
	}
	
	
	public void go(){
		getSongs();
		System.out.println(songList);

		Collections.sort(songList);
		System.out.println(songList);
		
		
		ArtistCompare artistCompare =new ArtistCompare();
		Collections.sort(songList,artistCompare);
		System.out.println(songList);

		//HashSet<Song> songSet=new HashSet<Song>();

		TreeSet<Song> songSet=new TreeSet<Song>();
		songSet.addAll(songList);
		System.out.println(songSet);

		//Collections.sort(songSet);
		//System.out.println(songSet);

	}
	
	void getSongs(){
		//read file
		try{
			File file =new File("SongListMore.txt");
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String line=null;
			while((line=reader.readLine())!=null){
				addSong(line);
			}
		}
		catch(Exception ex){ex.printStackTrace();}
		
	}
	
	void addSong(String lineToParse){
		String[] tokens=lineToParse.split("/");
		//songList.add(tokens[0]);
		
		Song nextSong=new Song(tokens[0],tokens[1],tokens[2],tokens[3]);
		songList.add(nextSong);
	}
	
	
	
}	//	Close class

class Song implements Comparable<Song>{
	String title;
	String artist;
	String rating;
	String bpm;

	public boolean equals(Object aSong){
		Song s =(Song) aSong;
		return getTitle().equals(s.getTitle());
	}

	public int hashCode(){
		return title.hashCode();
	}
	
	public int compareTo(Song s){
		return title.compareTo(s.getTitle());
	}

	Song(String t,String a, String r, String b){
		title =t;
		artist=a;
		rating=r;
		bpm=b;
	}
	
	
	public String getTitle(){
		return title;
	}
	
	public String getArtist(){
		return artist;
	}
	
	public String getRating(){
		return rating;
	}
	
	public String getBpm(){
		return bpm;
	}
	public String toString(){
		return title;
	}
}  //  Close class
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	