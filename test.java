import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

 class test implements ActionListener{
	JFrame frame, frame1;
	JTextField textbox;
	JLabel label;
	JButton button;
	JPanel panel;
	
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/gym";
	String userName = "root";
	String password = "Mayur@1998";

	test()
	{
		frame = new JFrame("Database Search Result");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		textbox = new JTextField();
		textbox.setBounds(120,30,150,20); 
		label = new JLabel("Enter your query");
		label.setBounds(10, 30, 100, 20);
		button = new JButton("Apply");
		button.setBounds(120,130,150,20);
		button.addActionListener(this);

		frame.add(textbox);
		frame.add(label);
		frame.add(button);
		frame.setVisible(true);
		frame.setSize(500, 400);		
	}	
	
	public void actionPerformed(ActionEvent ae)
	{
		button = (JButton)ae.getSource();
		System.out.println("Showing Table Data.......");
			showTableData();			
	}	
	
	public void showTableData()
	{	
		String textvalue = textbox.getText();
		try
		{			
			Class.forName(driverName);		
			Connection con = DriverManager.getConnection(url, userName, password);
			String sql = textvalue;
			Statement stmt=con.createStatement();
			stmt.executeUpdate(sql);
	        int i =0;
			if(i <1)
			{
				JOptionPane.showMessageDialog(frame,"Record successfully updated");
			}
			if(i ==1)
			{
			System.out.println(i+" Record Found");
			}
			else
			{
				System.out.println("1 Record Found");
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void main(String args[])
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				new test();
			}
		});	        
	}
}
