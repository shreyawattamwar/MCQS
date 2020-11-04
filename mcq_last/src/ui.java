//WELCOME


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ui implements ActionListener
{
	JFrame frame;
	JPanel panel;
	JLabel lsignup,llogin,lwel;
	JButton bsignup,blogin;
	ui()
	{
		frame =new JFrame(" Hello ");
		panel=new JPanel();
		
		frame.setLayout(null);
		frame.setSize(550,550);
		Container c=frame.getContentPane();
		Color myColor = new Color(50, 150, 150);
		c.setBackground(myColor);
		
		lwel=new JLabel("<html><span style='font-size:35px'> Welcome </span></html>");
		//lwel.setFont(new Font("Monospace",Font.BOLD,500));
		lwel.setBounds(140,30,250,100);
		frame.add(lwel);
		
		lsignup=new JLabel("<html><span style='font-size:14px'>Don't have an account ?</span></html>");
		//lwel.setFont(new Font("Monospace",Font.PLAIN,80));
		lsignup.setBounds(100,140,300,60);
		frame.add(lsignup);
		
		llogin=new JLabel("<html><span style='font-size:14px'>Already have an account ?</span></html>");
		//lwel.setFont(new Font("Monospace",Font.PLAIN,20));
		llogin.setBounds(100,250,300,60);
		frame.add(llogin);
		
		bsignup=new JButton("Sign up");
		bsignup.setFont(new Font("Monospace",Font.PLAIN,20));
		bsignup.setBounds(160,200,100,40);
		frame.add(bsignup);
		
		blogin=new JButton("Login");
		blogin.setFont(new Font("Monospace",Font.PLAIN,20));
		blogin.setBounds(160,310,100,40);
		frame.add(blogin);
		
		bsignup.addActionListener(this);
		blogin.addActionListener(this);
		
		
		
//		panel.add(lwel);
//		panel.add(lsignup);
//		panel.add(bsignup);
//		panel.add(llogin);
//		panel.add(blogin);
//		frame.add(panel);
		
		frame.setVisible(true);
	}
	public static void main(String args[]) {
		new ui();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bsignup)
		{
			frame.dispose();
			new ui1();
			
		}
		if(e.getSource()==blogin)
		{
			frame.dispose();
			new ui2();
			
		}
			
	}

	
}
