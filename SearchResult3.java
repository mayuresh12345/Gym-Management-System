import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;

public class SearchResult3 {
	JFrame frame, frame1;
	JPanel panel;
	static JTable table;
	
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/gym";
	String userName = "root";
	String password = "Mayur@1998";
	String[] columnNames = {"Customer_Id","Calories Required"};

	public void showTableData()
	{
		
		frame1 = new JFrame("Database Search Result");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLayout(new BorderLayout());		
		
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		
		table = new JTable();
		table.setModel(model);		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);		
		int course_id;
		int calories_per_day;
		try
		{			
			Class.forName(driverName);		
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("select * from nutritionreq");
	        ResultSet rs = ps.executeQuery();
	        int i =0;
			while(rs.next())
	        {
				course_id=rs.getInt("course_id");
				calories_per_day=rs.getInt("calories_per_day");
				model.addRow(new Object[]{course_id,calories_per_day});
				i++;				
	        }
			if(i <1)
			{
				JOptionPane.showMessageDialog(null, "No Record Found","Error",
						JOptionPane.ERROR_MESSAGE);
			}
			if(i ==1)
			{
			System.out.println(i+" Record Found");
			}
			else
			{
				System.out.println(i+" Records Found");
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
					JOptionPane.ERROR_MESSAGE);
		}
		frame1.add(scroll);
		frame1.setVisible(true);
		frame1.setSize(400,300);
	}
	
	public static void main(String args[])
	{
		SearchResult3 sr3 = new SearchResult3();
		sr3.showTableData();
	}
}
