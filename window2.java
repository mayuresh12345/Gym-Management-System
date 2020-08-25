import java.awt.event.*;
import javax.swing.*;
public class window2 implements ActionListener{
	JFrame jfrm1;
	JButton jbt1,jbt2,prev;
	window2()
	{
		jfrm1=new JFrame("Contents");
		jfrm1.setLayout(null);
		jfrm1.setSize(500,400);
		jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jbt1=new JButton("Insert new entry");
		jbt2=new JButton("Delete entry");
		prev=new JButton("PREV");
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
		prev.addActionListener(this);
		jbt1.setBounds(130,30,180,20);
		jbt2.setBounds(130,100,180,20);
		prev.setBounds(10,300,100,20);
		jfrm1.add(jbt1);
		jfrm1.add(jbt2);
		jfrm1.add(prev);
		jfrm1.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("Insert new entry")||ae.getActionCommand().equals("Delete entry"))
		{
			test ob=new test();
			jfrm1.dispose();
		}
		if(ae.getActionCommand().equals("PREV"))
		{
			window o=new window();
			jfrm1.dispose();
		}
	}
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				new window2();
			}
		});
	}
}
