package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
class DataBaseCreation
{
	public static void main(String args[])
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is Registered");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		try
		{
			Connection cn=DriverManager.getConnection("jdbc:mySQL://localhost:3306/addressbook",
					"root","panchapasha123");
			Statement st=cn.createStatement();
			String sql="Create table adbook(first varchar(30), last varchar(30),father varchar(30),gender varchar(10),age int(5),blood varchar(10),mother varchar(20),nation varchar(20),id int(10) auto_increment primary key,address varchar(100),pin int(10),phno int(12),home int(12),email varchar(255))";
			st.execute(sql);
			System.out.println("Table is created successfully");
			cn.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
}
}
