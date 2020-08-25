import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;

public class SearchResult2{
	JFrame frame, frame1;
	JPanel panel;
	static JTable table;
	
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/gym";
	String userName = "root";
	String password = "Mayur@1998";
	String[] columnNames = {"cus_id","name","gender","mob_num","address"};
	
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
		int cus_id;
	    String name="";
	    String gender="";
	    long mob_num;
	    String address="";
		try
		{			
			Class.forName(driverName);		
			Connection con = DriverManager.getConnection(url, userName, password);
			PreparedStatement ps = con.prepareStatement("select * from customer");
	        ResultSet rs = ps.executeQuery();
	        int i =0;
			while(rs.next())
	        {
				cus_id = rs.getInt("cus_id");
				name = rs.getString("name");
				gender = rs.getString("gender");
				mob_num = rs.getLong("mob_num");
				address = rs.getString("address");
				model.addRow(new Object[]{cus_id, name, gender, mob_num, address});
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
		SearchResult2 sr2 = new SearchResult2();
		        sr2.showTableData();		        
	}
}
