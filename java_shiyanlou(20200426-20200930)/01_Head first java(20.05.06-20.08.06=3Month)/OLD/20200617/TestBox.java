import java.util.*;
public class TestBox  
{
	Integer i = 0;
	int j;
	String s= String.format("%tr",new Date());
	
	public static void main(String[] args) 
	{
		TestBox t =new TestBox();
		t.go();
	}

	public void go(){
	j=i;
	System.out.println(j);
	System.out.println(s);
	
	}


}
