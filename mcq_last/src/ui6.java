

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ui6 implements ActionListener{

	JFrame frame;
	JPanel panel;
	public JButton bdsa,bmp,bcg,bm3,bppl,bquit,bback;
	
	ui6()
	{
		frame=new JFrame();
		panel=new JPanel();
		frame.setLayout(null);
		frame.setSize(1000, 600);
//		Container c = frame.getContentPane();
//		c.setBackground(Color.pink);
		
		Container c=frame.getContentPane();
		Color myColor = new Color(50, 150, 150);
		c.setBackground(myColor);
		
		bdsa=new JButton("Advanced Data Structures");
		bdsa.addActionListener(this);
		bdsa.setBounds(200,50,450,30);
		frame.add(bdsa);
		bmp=new JButton("Microprocessor");
		bmp.addActionListener(this);
		bmp.setBounds(200,100,450,30);
		frame.add(bmp);
		bcg=new JButton("Computer Graphics");
		bcg.addActionListener(this);
		bcg.setBounds(200,150,450,30);
		frame.add(bcg);
		bm3=new JButton("Engineering Mathematics");
		bm3.addActionListener(this);
		bm3.setBounds(200,200,450,30);
		frame.add(bm3);
		bppl=new JButton("Principles Of Programming Languages");
		bppl.addActionListener(this);
		bppl.setBounds(200,250,450,30);
		frame.add(bppl);
		bback=new JButton("Back");
		bback.addActionListener(this);
		bback.setBounds(200,300,450,30);
		frame.add(bback);
		bquit=new JButton("Quit");
		bquit.addActionListener(this);
		bquit.setBounds(200,350,450,30);
		frame.add(bquit);
				
		frame.setTitle("Select subject for test");
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bdsa)
		{
			frame.dispose();
			new ui7_a();
		}
		else if(e.getSource()==bmp)
		{
			frame.dispose();
			//new ui7_m3();
		}
		else if(e.getSource()==bm3)
		{
			frame.dispose();
			new ui7_m3();
			
		}
		else if(e.getSource()==bcg)
		{
			frame.dispose();
			//new ui10();
		}
		else if(e.getSource()==bppl)
		{
			frame.dispose();
			//new ui11();
		}
		else if(e.getSource()==bback)
		{
			frame.dispose();
			new ui3();
		}
		else if(e.getSource()==bquit)
		{
			frame.dispose();
			
		}
		
			
		
	}

}