import java.lang.*;
import java.awt.*;
import javax.swing.*;

public class MyDrawPanel extends JPanel {
	public void paintComponent(Graphics g){
		//�������
	//	Graphics2D g2d=(Graphics2D) g;
	//	int red = (int) (Math.random()*255);
	//	int green = (int) (Math.random()*255);
	//	int blue = (int) (Math.random()*255);
	//	Color stratColor=new Color(red,green,blue);
		
	//	red = (int) (Math.random()*255);
	//	green = (int) (Math.random()*255);
	//	blue = (int) (Math.random()*255);
	//	Color endColor=new Color(red,green,blue);

	//	GradientPaint gradient =new GradientPaint(90,90,stratColor,150,150,endColor);
	//	g2d.setPaint(gradient);
	//	g2d.fillOval(70,70,100,100);
		
		//����
	//	Graphics2D g2d=(Graphics2D) g;

	//	GradientPaint gradient =new GradientPaint(90,90,Color.blue,150,150,Color.orange);
		
	//	g2d.setPaint(gradient);
	//	g2d.fillOval(70,70,100,100);
		
		
		
		//ԲȦ
	//	g.setColor(Color.green);
	//	g.fillRect(0,0,this.getWidth(),this.getHeight());
	//	int red = (int) (Math.random()*255);
	//	int green = (int) (Math.random()*255);
	//	int blue = (int) (Math.random()*255);

	//	Color randomColor=new Color(red,green,blue);
	//	g.setColor(randomColor);
	//	g.fillOval(70,70,100,100);
		
		//��ʾJPEG(û��ʾ��֪ԭ��)
		Image image=new ImageIcon("catailla.jpg").getImage();
		g.drawImage(image,3,4,this);

		//��ʾ����
	//	g.setColor(Color.orange);
	//	g.fillRect(20,50,100,100);
		
	}

	public void go(){
		JButton button =new JButton();

	
	}
	public static void main(String[] args){
		JFrame frame=new JFrame();
		MyDrawPanel a=new MyDrawPanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(a);
		
		frame.setSize(500,500);
		frame.setVisible(true);

		a.paintComponent(Graphics g);
	}	//	Close main

}	//	Close class