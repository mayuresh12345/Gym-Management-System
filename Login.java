import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class Login implements ActionListener
{
    JFrame jfrm;
    JTextField jtf1;
    JPasswordField jtf2;
    JButton jbtn;
    JLabel jlb;
     
    Login()
    {
        jfrm=new JFrame("Home Page");
        jfrm.setLayout(null);
        jfrm.setSize(500,400);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jlb1=new JLabel("ID:");
        jlb1.setBounds(130,50,50,50);
        JLabel jlb2=new JLabel("Password:");
        jlb2.setBounds(105,30,150,150);
        jlb=new JLabel();
        jlb.setBounds(100,200,1000,20);
        jtf1=new JTextField(2);
        jtf1.setBounds(170,70,100,20);
        jtf2=new JPasswordField();
        jtf2.setBounds(170,100,100,20);
        jbtn=new JButton("LOGIN");
        jbtn.setBounds(170,150,100,20);
        jbtn.addActionListener(this);
        jfrm.setBackground(Color.black);
        jfrm.add(jlb1);
        jfrm.add(jlb2);
        jfrm.add(jtf1);
        jfrm.add(jtf2);
        jfrm.add(jlb);
        jfrm.add(jbtn);
        jfrm.setVisible(true); 
     }

     public void actionPerformed(ActionEvent ae)
     {
         String str1="";
         String str2=jtf1.getText();
         str1+=new String(jtf2.getPassword());
         if(ae.getActionCommand().equals("LOGIN"))
         {
            if(str1.equals("Mayuresh")&&str2.equals("160905362"))
            {
            	contents cnt=new contents();
            	jfrm.dispose();
            }
            else
            JOptionPane.showMessageDialog(jfrm,"ID or Password Incorrect!");
         }
     }

     public static void main(String args[])
     {
         SwingUtilities.invokeLater(new Runnable(){
         public void run()
         {
             new Login();
         }
         });
     }
}