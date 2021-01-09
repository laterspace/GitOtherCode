import javax.swing.*;
import java.awt.*;

public class Panel2 {

	public static void main(String[] args){
		Panel2 gui=new Panel2();
		gui.go();
	}	//	Close main
	
	public void go(){
		JFrame frame=new JFrame();
		JPanel panela=new JPanel();
		panela.setBackground(Color.darkGray);
		
		JPanel panelb=new JPanel();
		panelb.setBackground(Color.green);
		
		/*JButton button =new JButton("shock me");
		JButton buttonTwo =new JButton("bliss");
		
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		
		panel.add(button);
		panel.add(buttonTwo);
		*/
		frame.getContentPane().add(panelb);
		frame.getContentPane().add(panela);
		
		frame.setSize(250,200);
		frame.setVisible(true);
		
		
		
		
	}
}	//	Close class
