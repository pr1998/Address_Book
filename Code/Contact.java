package project;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import javax.swing.*;

public class Contact extends TabbedPaneEx implements ActionListener{
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7;
	JTextField tf2,tf3,tf4,tf5,tf6;
	JTextArea ta1;
	JButton bt1,bt2,bt3;
	JPanel p;
	Connection cn=null;
	Statement sm=null;
	ResultSet rs=null;
	ResultSetMetaData rsmd=null;
	String sql=" ",r;
	
	Contact()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mySQL://localhost:3306/addressbook",
					"root","password");
			System.out.println("Connected to database");
			sm=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			sql="select * from adbook";
		}
		catch(SQLException e1)
		{
			if(e1.getErrorCode()!=1050)
				System.out.println(e1.getMessage()+""+e1.getErrorCode());
				
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lb6=new JLabel("ID:");
		lb1=new JLabel("Address:");
		lb2=new JLabel("PIN Code:");
		lb3=new JLabel("Phone Number:");
		lb4=new JLabel("Home Phone Number:");
		lb5=new JLabel("Email ID:");
		lb7=new JLabel();
		tf6=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf5=new JTextField();
		ta1=new JTextArea();
		bt1=new JButton("SAVE");
		bt2=new JButton("CANCEL");
		bt3=new JButton("EXIT");
		p=new JPanel(new GridLayout(10,2));
		try
		{
			System.out.println(sql);
			rs=sm.executeQuery(sql);
			rs.last();
			int r=rs.getRow();
			r=r+1;
			tf6.setText(r+"");
			tf6.setEditable(false);
			}
		catch(Exception en)
		{
			en.printStackTrace();
		}
		p.add(lb6);p.add(tf6);
		p.add(lb1);p.add(ta1);
		p.add(lb2);p.add(tf2);
		p.add(lb3);p.add(tf3);
		p.add(lb4);p.add(tf4);
		p.add(lb5);p.add(tf5);
		p.add(bt1);p.add(bt2);
		p.add(bt3);p.add(lb7);
		add(p);
		this.setSize(600,600);
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		this.setVisible(true);
	}
	
	
	public void dispose()
	{
		System.exit(0);
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==bt3)
			dispose();
		if(e.getSource()==bt2)
		{
			tf6.setText("");
			ta1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
		}
		if(e.getSource()==bt1)
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mySQL://localhost:3306/addressbook",
					"root","password");
			sm=cn.createStatement();
			String addr,email;
			int pin,phno,home;
				addr=ta1.getText();
				pin=Integer.parseInt(tf2.getText());
				phno=Integer.parseInt(tf3.getText());
				home=Integer.parseInt(tf4.getText());
				email=tf5.getText();
				String fin="update adbook set address='"+ta1.getText()+"',pin='"+Integer.parseInt(tf2.getText())+"',phno='"+Integer.parseInt(tf3.getText())+"',home='"+Integer.parseInt(tf4.getText())+"',email='"+tf5.getText()+"' where id='"+Integer.parseInt(tf6.getText())+"'";
				sm.execute(fin);
				lb7.setText("Contact Details are saved!!!");				
			cn.close();
			}
			catch(SQLException en)
			{
			en.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		;
	}

}
