//SIGNUP PAGE


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;



public class ui1 implements ActionListener {

	JFrame frame;
	JPanel panel;
	JTextField tusername,tname,tclg,tmobileno;
	JPasswordField ppassword;
	JLabel lusername,lpassword,lname,lbranch,lclg,lmobileno,lsem;
	JButton bsignup,bclear;
	JRadioButton sem1,sem2;
	JComboBox branch;
	
	ui1()
	{
		String str[]= {"Computer","IT","Mechanical","Electronic","Civil"};
		frame= new JFrame("Signup Window");
		panel= new JPanel();
		
		frame.setLayout(null);
		frame.setSize(800,750);
		Container c=frame.getContentPane();
		Color myColor = new Color(50, 150, 150);
		c.setBackground(myColor);
				
		lname=new JLabel("<html><span style='font-size:16px'>Name: </span></html>");
		lname.setBounds(100,30,80,40);
		frame.add(lname);
		tname=new JTextField(20);
		tname.setBounds(280,32,200,30);
		frame.add(tname);
		
		lmobileno=new JLabel("<html><span style='font-size:16px'>Mobile No.: </span></html>");
		lmobileno.setBounds(100,80,150,40);
		frame.add(lmobileno);
		tmobileno=new JTextField(15);
		tmobileno.setBounds(280,82,100,30);
		frame.add(tmobileno);
		
		lclg=new JLabel("<html><span style='font-size:16px'>College: </span></html>");
		lclg.setBounds(100,130,200,40);
		frame.add(lclg);
		tclg=new JTextField(20);
		tclg.setBounds(280,132,200,30);
		frame.add(tclg);
		
		lbranch=new JLabel("<html><span style='font-size:16px'>Branch: </span></html>");
		lbranch.setBounds(100,180,200,40);
		frame.add(lbranch);
		branch=new JComboBox(str);
		branch.setBounds(280,192,200,30);
		frame.add(branch);
		
		lsem=new JLabel("<html><span style='font-size:16px'>Sem:</span></html>");
		lsem.setBounds(100,230,200,40);
		frame.add(lsem);
		sem1=new JRadioButton("I");
		sem1.setBounds(280,240,50,30);
		frame.add(sem1);
		sem2=new JRadioButton("II");
		sem2.setBounds(340,240,50,30);
		frame.add(sem2);
		ButtonGroup bg=new ButtonGroup();
		bg.add(sem1);
		bg.add(sem2);
		frame.add(sem1);
		frame.add(sem2);
		
		lusername=new JLabel("<html><span style='font-size:16px'>Username(email): </span></html>");
		lusername.setBounds(100,280,200,40);
		frame.add(lusername);
		tusername=new JTextField(20);
		tusername.setBounds(280,290,200,30);
		frame.add(tusername);
		
		lpassword=new JLabel("<html><span style='font-size:16px'>Password: </span></html>");
		lpassword.setBounds(100,338,200,30);
		frame.add(lpassword);
		ppassword= new JPasswordField(20);
		ppassword.setBounds(280,340,200,30);
		frame.add(ppassword);
		
		bsignup=new JButton("Sign up");
		bsignup.setFont(new Font("Monospace",Font.PLAIN,20));          //Added only for styling
		bsignup.setBounds(150,450,100,40);
		frame.add(bsignup);
		
		bclear=new JButton("Clear");
		bclear.setFont(new Font("Monospace",Font.PLAIN,20));
		bclear.setBounds(350,450,100,40);
		frame.add(bclear);
		
		bsignup.addActionListener(this);
		bclear.addActionListener(this);
//		panel.add(lname);
//		panel.add(tname);
//		panel.add(lclg);
//		panel.add(tclg);
//		panel.add(lbranch);
//		panel.add(branch);
//		panel.add(lsem);
//		panel.add(sem1);
//		panel.add(sem2);
//		panel.add(lmobileno);
//		panel.add(tmobileno);
//		panel.add(lusername);
//		panel.add(tusername);
//		panel.add(lpassword);
//		panel.add(ppassword);
//		panel.add(bclear);
//		panel.add(bsignup);
		
		//frame.add(panel);	
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		
		
		if(e.getSource()==bclear)
		{
			tname.setText("");
			tclg.setText("");
			tmobileno.setText("");
			tusername.setText("");
			ppassword.setText("");
		}
			if(e.getSource()==bsignup)
			{
				String username=null,password=null,name=null,clg=null,Branch=null,sem=null,mobileno=null;
				username=tusername.getText();
				password=ppassword.getText();
				name=tname.getText();
				clg=tclg.getText();
				Branch=(String) branch.getItemAt(branch.getSelectedIndex());
				if(sem1.isSelected())
					sem="I";
				if(sem2.isSelected())
					sem="II";
				mobileno=tmobileno.getText();
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","xyz","xyz");
					PreparedStatement stm=con.prepareStatement("insert into mcq_proj values(?,?,?,?,?,?,?)");
					stm.setString(1, name);
					stm.setString(2,clg);
					stm.setString(3, Branch);
					stm.setString(4, sem);
					stm.setString(5, mobileno);
					stm.setString(6, username);
					stm.setString(7, password);				
					stm.execute();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				int i=JOptionPane.showConfirmDialog(frame, "sign up successful....Do you want to continue");
				if(i==JOptionPane.YES_OPTION)
				{
					frame.dispose();
					 new ui3();
				}
				else
				{
					frame.dispose();
				}
			}			
	}	
}
