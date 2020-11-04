//NO NEED WASTE



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ui5 implements ActionListener {
	JFrame frame;
	JPanel panel;
	JButton bback;
	
	ui5()
	{
		frame=new JFrame();
		panel=new JPanel();
		bback=new JButton("Back");
		bback.addActionListener(this);
		
		
		panel.add(bback);
		frame.add(panel);
		frame.setSize(900, 800);
		frame.setVisible(true);
	}

	
	//ui4 b = new ui4();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bback)
		{
			frame.dispose();
			new ui4();
		}
		
	}
}

