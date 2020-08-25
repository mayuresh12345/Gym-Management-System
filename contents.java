import java.awt.event.*;
import javax.swing.*;
class contents implements ActionListener{
	JFrame jfrm1;
	JButton jbt1,jbt2,jbt3,jbt4,jbt5,prev,next;
	JLabel jl=new JLabel("OPERATIONS");
	contents()
	{
		jfrm1=new JFrame("Contents");
		jfrm1.setLayout(null);
		jfrm1.setSize(500,400);
		jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jl.setBounds(190,50,100,20);
		jbt1=new JButton("View Course Details");
		jbt2=new JButton("View Instructor Details");
		jbt3=new JButton("View Customer Details");
		jbt4=new JButton("Update Database");
		jbt5=new JButton("View Nutrition Details");
		prev=new JButton("LOGOUT");
        jbt1.addActionListener(this);
		jbt2.addActionListener(this);
		jbt3.addActionListener(this);
		jbt4.addActionListener(this);
		jbt5.addActionListener(this);
		prev.addActionListener(this);
		jbt1.setBounds(130,90,180,20);
		jbt2.setBounds(130,120,180,20);
		jbt3.setBounds(130,150,180,20);
		jbt4.setBounds(130,210,180,20);
		jbt5.setBounds(130,180,180,20);
		prev.setBounds(10,280,100,20);
		jfrm1.add(jbt1);
		jfrm1.add(jbt2);
		jfrm1.add(jbt3);
		jfrm1.add(jbt4);
		jfrm1.add(jbt5);
		jfrm1.add(prev);
		jfrm1.add(jl);
		jfrm1.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("View Course Details"))
		{
			SearchResult obj=new SearchResult();
			obj.showTableData();
			jfrm1.dispose();
		}
		else if(ae.getActionCommand().equals("View Instructor Details"))
		{
			SearchResult1 obj1=new SearchResult1();
			obj1.showTableData();
			jfrm1.dispose();
		}
		else if(ae.getActionCommand().equals("View Customer Details"))
		{
			SearchResult2 obj2=new SearchResult2();
			obj2.showTableData();
			jfrm1.dispose();
		}
		else if(ae.getActionCommand().equals("View Nutrition Details"))
		{
			SearchResult3 obj5=new SearchResult3();
			obj5.showTableData();
			jfrm1.dispose();
		}
		else if(ae.getActionCommand().equals("Update Database"))
		{
			window ob=new window();
			jfrm1.dispose();
		}
		else if(ae.getActionCommand().equals("LOGOUT"))
		{
			Login ob=new Login();
			jfrm1.dispose();
		}
	}
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				new contents();
			}
		});
	}
}
