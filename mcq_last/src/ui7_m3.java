//M3 TEST



import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.text.View;


	public class ui7_m3 implements ActionListener{
		
		JFrame fr;
		JRadioButton rb1,rb2,rb3,rb4;
		JButton b1,b2;
		JLabel lb1;
		JPanel panel;
		ButtonGroup bg;
		String ques[] = new String[25];
		String op1[] = new String[25];
		String op2[] = new String[25];
		String op3[] = new String[25];
		String op4[] = new String[25];
		String ans[] = new String[25];
		int cn=0;
		int cn1=0;
		int count=0;
	    int score=0;
		ui7_m3() 
		{
			try 
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} 
			catch (ClassNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Connection con;
			try
			{
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","xyz","xyz");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from mcq_proj7");
				System.out.println("done");
				while(rs.next())
				{
					 ques[cn]=rs.getString(2);
					 op1[cn]=rs.getString(3);
					 op2[cn]=rs.getString(4);
					 op3[cn]=rs.getString(5);
					 op4[cn]=rs.getString(6);
					 ans[cn]=rs.getString(7);
					 cn++;
					// rs.next();
				}	
						
				
			fr= new JFrame("Questions");
			fr.setLayout(null);
			fr.setSize(1650,900);
//			Container c=fr.getContentPane();
//			c.setBackground(Color.GRAY);
			
			Container c=fr.getContentPane();
			Color myColor = new Color(50, 150, 150);
			c.setBackground(myColor);


			
			//panel= new JPanel();
			lb1=new JLabel("<html><p>"+ques[cn1]+"</p></html>");
			//lb1=new JTextArea(ques[cn1]);
			lb1.setBounds(25,50,1200,40);
     		lb1.setForeground(Color.black);
			lb1.setFont(new Font("Monospace",Font.BOLD,20));
			fr.add(lb1);
			
			rb1=new JRadioButton(op1[cn1]);
			rb1.setBounds(100,120,500,30);
			fr.add(rb1);
			
			rb2=new JRadioButton(op2[cn1]);
			rb2.setBounds(100,180,500,30);
			fr.add(rb2);
			
			rb3=new JRadioButton(op3[cn1]);
			rb3.setBounds(100,240,500,30);
			fr.add(rb3);
			
			rb4=new JRadioButton(op4[cn1]);
			rb4.setBounds(100,300,500,30);
			fr.add(rb4);
			bg =new ButtonGroup();
			bg.add(rb1);
			bg.add(rb2);
			bg.add(rb3);
			bg.add(rb4);
			rb1.addActionListener(this);
			rb2.addActionListener(this);
			rb3.addActionListener(this);
			rb4.addActionListener(this);
			b1=new JButton("Sumbit");
			b1.setBounds(100,400,100,30);
			fr.add(b1);
			b2=new JButton("Next");
			b2.setBounds(250,400,100,30);
			fr.add(b2);
			b1.addActionListener(this);
			b2.addActionListener(this);
			
			fr.setVisible(true);
				

			} 
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==b1)
			{
			String en="";
			if(rb1.isSelected())
			en="a";
			if(rb2.isSelected())
			en="b";
			if(rb3.isSelected())
			en="c";
			if(rb4.isSelected())
			en="d";
			if(en.equals(ans[cn1]))
			{
				score++;
			//JOptionPane.showMessageDialog(null,"Answer Submitted");
			}
			//else
			//JOptionPane.showMessageDialog(null,"Answer Submitted");
			}
			
			if (e.getSource()==b2)
			{
			cn1++;
			count++;
			if(count<10)
			{
			lb1.setText(ques[cn1]);
			rb1.setText(op1[cn1]);
			rb2.setText(op2[cn1]);
			rb3.setText(op3[cn1]);
			rb4.setText(op4[cn1]);
			}
			else
			{
				JOptionPane.showMessageDialog(null,score);
				fr.setVisible(false);
				new ui6();
			}

			
			}

		}
		public static void main(String args[])
		{
			new ui7_m3();
		}
	}