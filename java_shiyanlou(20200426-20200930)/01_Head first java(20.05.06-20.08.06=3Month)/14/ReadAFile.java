import java.io.*;

public class ReadAFile {

	public static void main(String[] args){

		try{
			File myfile =new File("Foo,txt");
			FileReader filereader=new FileReader(myfile);
			
			BufferedReader reader=new BufferedReader(filereader);
			
			String line =null;
			
			while ((line=reader.readLine())!=null){
				System.out.println(line);
			}
			
			reader.close();
		}
		catch(IOException ex){ex.printStackTrace();}
	}	//	Close main

}	//	Close class
