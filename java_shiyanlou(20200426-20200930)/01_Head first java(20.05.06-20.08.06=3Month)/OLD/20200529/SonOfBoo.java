public class Boo{
	public Boo(int i){}
	public Boo(String a){}
	public Boo(String a,int i){}
}



class SonOfBoo extends Boo 
{
	public Boo(){
		super("boo");
	}

	public Boo(int i){
		super("Fred");
	}
	
	public Boo(String s){
		super(42);
	}

	public Boo(int i, String s){
	}

	public Boo(String a,String b,String C){
		super(A,b);
	}

	public Boo(int i,int j){
		super("man", j);
	}

	public Boo(int i ,int x, int y){
		super(i ,"star");
	}




}

	//public static void main(String[] args) 
	//{
//System.out.println("Hello World!");
	//}

