

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

public class ui7 implements ActionListener{
	
	int i;
	String op;
	JFrame frame;
	JPanel panel;
	JLabel lq1;
	JRadioButton rop1,rop2,rop3,rop4;
	JButton bs,bn;
	
	ui7() 
	{
		
		frame= new JFrame("Questions");
		panel= new JPanel();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try
		{
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","xyz","xyz");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from mcq_proj2");
			System.out.println("done");
			
			
		  while(rs.next())	
			if(rs.next())
			{
				i= rs.getInt(1);
				lq1=new JLabel(rs.getString(2));
				lq1.setBounds(50,50,300,30);
				lq1.setFont(new Font("chiller",Font.BOLD,30));
				rop1=new JRadioButton(rs.getString(3));
				rop2=new JRadioButton(rs.getString(4));
				rop3=new JRadioButton(rs.getString(5));
				rop4=new JRadioButton(rs.getString(6));
				ButtonGroup bg=new ButtonGroup();
				bg.add(rop1);
				bg.add(rop2);
				bg.add(rop3);
				bg.add(rop4);
				bs=new JButton("Sumbit");
				bs.setBounds(100,400,100,30);
				bn=new JButton("Next");
				bn.setBounds(250,400,100,30);
				op=rs.getString(7);
				
				rop1.addActionListener(this);
				rop2.addActionListener(this);
				rop3.addActionListener(this);
				rop4.addActionListener(this);
				bs.addActionListener(this);
				bn.addActionListener(this);
				panel.add(lq1);
				panel.add(rop1);
				panel.add(rop2);
				panel.add(rop3);
				panel.add(rop4);
				//panel.add(bs);
				//panel.add(bn);
				frame.add(panel);
				frame.setSize(1000, 500);
				frame.setVisible(true);
				
	
			}
			
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel.add(bs);
		panel.add(bn);
		frame.add(panel);
		frame.setSize(1000, 500);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new ui7();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == bs)					//SUBMIT
		{
			String ans=" ";
			if(rop1.isSelected())
				ans=rop1.getText();
			if(rop2.isSelected())
				ans=rop2.getText();
			if(rop3.isSelected())
				ans=rop3.getText();
			if(rop4.isSelected())
				ans=rop4.getText();
			if(ans.equals(op))
			{
				JOptionPane.showMessageDialog(null,"Right");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Wrong");
			}
		}
		
		if(e.getSource() == bn)									//NEXT
		{
			 ui7 obj  = new ui7();
		}		
	}
}
