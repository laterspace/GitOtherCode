import java.rmi.*;
import java.rmi.server.*;

public class MyRemoteImp1 extends UnicastRemoteObject implements MyRemote{
	
	public String sayHello(){
		return "Server Says , 'Hey'";
	}

	
	public MyRemoteImp1() throws RemoteException{}
	
	
	public static void main(String[] args){

	try{
		MyRemote server=new MyRemoteImp1();
		Naming.rebind("Remote Hello",service);
	}	catch(Exception ex){ex.printStackTrace();}

	}	//	Close main

	

}	//	Close class
