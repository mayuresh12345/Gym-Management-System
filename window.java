import java.awt.event.*;
import javax.swing.*;

public class window implements ActionListener{
      JLabel jlb;
      JFrame jfrm1;
  	  JButton jbt1,jbt2,jbt3,jbt4,jbt5,prev;
  	  window()
  	  {
  		jfrm1=new JFrame("Contents");
		jfrm1.setLayout(null);
		jfrm1.setSize(500,400);
		jfrm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jlb=new JLabel("Relations");
		jlb.setBounds(200,10,100,10);
		jbt1=new JButton("Course");
		jbt2=new JButton("Instructor");
		jbt3=new JButton("Customer");
		jbt4=new JButton("Teaches");
		jbt5=new JButton("Takes");
		prev=new JButton("PREV");
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
		jbt3.addActionListener(this);
		jbt4.addActionListener(this);
		jbt5.addActionListener(this);
		prev.addActionListener(this);
		jbt1.setBounds(130,50,180,20);
		jbt2.setBounds(130,100,180,20);
		jbt3.setBounds(130,160,180,20);
		jbt4.setBounds(130,220,180,20);
		jbt5.setBounds(130,280,180,20);
		prev.setBounds(10,320,100,20);
		jfrm1.add(jbt1);
		jfrm1.add(jbt2);
		jfrm1.add(jbt3);
		jfrm1.add(jbt4);
		jfrm1.add(jbt5);
		jfrm1.add(jlb);
		jfrm1.add(prev);
		jfrm1.setVisible(true);
  	  }
  	  public void actionPerformed(ActionEvent ae)
  	  {
  		  if(ae.getActionCommand().equals("Course")||ae.getActionCommand().equals("Instructor")||ae.getActionCommand().equals("Customer")||ae.getActionCommand().equals("Teaches")||ae.getActionCommand().equals("Takes"))
  		  {
  			  window2 obj=new window2();
  			  jfrm1.dispose();
  		  }
  		  else if(ae.getActionCommand().equals("PREV"))
		  {
			  contents obj=new contents();
			  jfrm1.dispose();
		  }
  	  }
  	  public static void main(String args[])
  	  {
  		  SwingUtilities.invokeLater(new Runnable() {
  			  public void run()
  			  {
  				  new window();
  			  }
  		  });
  	  }
}
