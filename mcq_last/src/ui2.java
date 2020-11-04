//LOGIN PAGE
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




public class ui2 implements ActionListener
{

	JFrame frame;
	JPanel panel;
	JLabel lusername,lpassword;
	JTextField tusername;
	JPasswordField ppassword;
	JButton blogin,bclear;
	ui2()
	{
		frame=new JFrame("Login window");
		panel=new JPanel();
		
		frame.setLayout(null);
		frame.setSize(600,600);
		Container c=frame.getContentPane();
		Color myColor = new Color(50, 150, 150);
		c.setBackground(myColor);
		
		lusername=new JLabel("<html><span style='font-size:14px'>Username: </span></html>");
		lusername.setBounds(100,30,200,60);
		frame.add(lusername);
		tusername=new JTextField(20);
		tusername.setBounds(100,80,300,30);
		frame.add(tusername);
		lpassword=new JLabel("<html><span style='font-size:14px'>Password: </span></html>");
		lpassword.setBounds(100,110,200,60);
		frame.add(lpassword);
		ppassword=new JPasswordField(20);
		ppassword.setBounds(100,160,300,30);
		frame.add(ppassword);
		
		blogin=new JButton("Login");
		blogin.setFont(new Font("Monospace",Font.PLAIN,20));
		blogin.setBounds(160,310,100,40);
		frame.add(blogin);
		bclear=new JButton("Clear");
		bclear.setFont(new Font("Monospace",Font.PLAIN,20));
		bclear.setBounds(300,310,100,40);
		frame.add(bclear);
		blogin.addActionListener(this);
		bclear.addActionListener(this);
		
//		panel.add(lusername);
//		panel.add(tusername);
//		panel.add(lpassword);
//		panel.add(ppassword);
//		panel.add(blogin);
//		panel.add(bclear);
//		frame.add(panel);
		
		frame.setVisible(true);

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bclear)
		{
			tusername.setText(null);
			ppassword.setText(null);
		}
		else if(e.getSource()==blogin)
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
			try {
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","xyz","xyz");
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from mcq_proj");
			
				while(rs.next())
				{
					if(tusername.getText().equals(rs.getString(6)))
					{
						//System.out.println(rs.getString(6));
						if(ppassword.getText().equals(rs.getString(7)))
						{
							int i=JOptionPane.showConfirmDialog(frame, "Login successfully...Do you want to continue");
							if(i==JOptionPane.YES_OPTION)
							{
							frame.dispose();
							new ui3();
							break;
							}
							else
							{
								
								frame.dispose();
								break;
							}
						}
						else
						{
							int i=JOptionPane.showConfirmDialog(frame, "Wrong password...Do you want to continue");
							if(i==JOptionPane.YES_OPTION)
							{
							frame.dispose();
							new ui2();
							break;
							}
							else
							{
								frame.dispose();
								break;
							}
								
						}
					}
						
				}
				
				
				
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
