class output{
	public static void main(String [] args){
		output o = new output();
		o.go();		
	}
	void go(){
		int y =7;
		for(int x=1;x<8;x++){
			y++;
			if(x>4){
				System.out.print(++y + " ");
			}
			if (y>14){
				System.out.print("x= " + x);
				break;
			}
			{
			}
		}
	}







}

/*
Ñ­»· x y
	1	7
	2	8
	3	9
	4	10
	5	11   12
	6	13	14
	7	15
	8
	*/