

public class Foo5
{
	static final int x=12;
	public void go(final int x) 
	{
		System.out.println(x);
	}
}


/*

+
public class Foo 
{
	static int x;
	public void go() 
	{
		System.out.println(x);
	}
}


-
public class Foo2 
{
	int x;
	public static void go() 
	{
		System.out.println(x);
	}
}

-Foo3.java:5: ����: ���� x δ��Ĭ�Ϲ������г�ʼ��
public class Foo3 
{
	final int x;
	public void go() 
	{
		System.out.println(x);
	}
}


+
public class Foo4
{
	static final int x=12;
	public void go() 
	{
		System.out.println(x);
	}
}

*/