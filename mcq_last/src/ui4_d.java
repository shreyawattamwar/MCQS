//PPL



import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ui4_d implements ActionListener{

	JFrame frame;
	JPanel panel;
	JButton bback,b1,b2,b3,b4,b5,b6;
	
	ui4_d()
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
		
		bback=new JButton("Back");
		bback.addActionListener(this);
		bback.setBounds(200,350,450,30);
		frame.add(bback);
		b1=new JButton("UNIT 1");
		b1.addActionListener(this);
		b1.setBounds(200,50,450,30);
		frame.add(b1);
		b2=new JButton("UNIT 2");
		b2.addActionListener(this);
		b2.setBounds(200,100,450,30);
		frame.add(b2);
		b3=new JButton("UNIT 3");
		b3.addActionListener(this);
		b3.setBounds(200,150,450,30);
		frame.add(b3);
		b4=new JButton("UNIT 4");
		b4.addActionListener(this);
		b4.setBounds(200,200,450,30);
		frame.add(b4);
		b5=new JButton("UNIT 5");
		b5.addActionListener(this);
		b5.setBounds(200,250,450,30);
		frame.add(b5);
		b6=new JButton("UNIT 6");
		b6.addActionListener(this);
		b6.setBounds(200,300,450,30);
		frame.add(b6);
		
		frame.setTitle("Principles Of Programming Language");
		frame.add(panel);
		frame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 
	    if( e.getSource()==b1)
		{
			try
			{
				Desktop.getDesktop().open(new java.io.File("File/mcq_ppl_u1.pdf"));
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			//frame.dispose();
			//new unit();
		}
		else if(e.getSource()==b2)
		{
			try
			{
				Desktop.getDesktop().open(new java.io.File("File/mcq_ppl_u2.pdf"));
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	//	        frame.dispose();
	//	        new ui5();
		}
		else if(e.getSource()==b3)
		{
			try
			{
				Desktop.getDesktop().open(new java.io.File("File/mcq_ppl_u3.pdf"));
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	//		frame.dispose();
	//		new ui5();
		}
		else if(e.getSource()==b4)
		{
			try
			{
				Desktop.getDesktop().open(new java.io.File("File/mcq_ppl_u4.pdf"));
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	//		frame.dispose();
	//		new ui5();
		}
		else if(e.getSource()==b5)
		{
			try
			{
				Desktop.getDesktop().open(new java.io.File("File/nirali_MP.pdf"));
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	//		frame.dispose();
	//		new ui5();
		}
		else if(e.getSource()==b6)
		{
			try
			{
				Desktop.getDesktop().open(new java.io.File("File/nirali_MP.pdf"));
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
	//		frame.dispose();
	//		new ui5();
		}
		else if(e.getSource() == bback)
		{
			frame.dispose();
			new ui3();
		}
		
		
	}
	
}
