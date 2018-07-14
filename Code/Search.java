package project;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Search extends Frame implements ActionListener{
	public JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,lb1,lb2,lb3,lb4,lb5;
	public JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,tf1,tf2,tf3,tf4,tf5,tf6;
	public JButton b1,b2,b3;
	public JTextArea ta1;
	JPanel p;
	Connection cn=null;
	Statement sm=null,st1=null;
	ResultSet rs=null;
	ResultSetMetaData rsmd=null;
	String sql=" ";
	Search()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mySQL://localhost:3306/addressbook",
					"root","password");
			System.out.println("Connected to database");
			sm=cn.createStatement();
		}
		catch(SQLException e1)
		{
			if(e1.getErrorCode()!=1050)
				System.out.println(e1.getMessage()+""+e1.getErrorCode());
				
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		l1=new JLabel("First Name:");
		l2=new JLabel("Last Name:");
		l3=new JLabel("Father's Name:");
		l4=new JLabel("Gender:");
		l5=new JLabel("Age:");
		l6=new JLabel("Blood Group:");
		l7=new JLabel("Native Language/Mother Tongue:");
		l8=new JLabel("Nationality:");
		l10=new JLabel("ID:");
		t1=new JTextField();
		t1.setEditable(false);
		t2=new JTextField();
		t2.setEditable(false);
		t3=new JTextField();
		t3.setEditable(false);
		t4=new JTextField();
		t4.setEditable(false);
		t5=new JTextField();
		t5.setEditable(false);
		t6=new JTextField();
		t6.setEditable(false);
		t7=new JTextField();
		t7.setEditable(false);
		t9=new JTextField();
		t9.setEditable(false); 
		lb1=new JLabel("Address:");
		lb2=new JLabel("PIN Code:");
		lb3=new JLabel("Phone Number:");
		lb4=new JLabel("Home Phone Number:");
		lb5=new JLabel("Email ID:");
		tf2=new JTextField();
		tf2.setEditable(false);
		tf3=new JTextField();
		tf3.setEditable(false);
		tf4=new JTextField();
		tf4.setEditable(false);
		tf5=new JTextField();
		tf5.setEditable(false);
		tf1=new JTextField();
		tf1.setEditable(false);
		t8=new JTextField();
		b1=new JButton("SHOW");
		b2=new JButton("CANCEL");
		b3=new JButton("EXIT");
		p=new JPanel(new GridLayout(16,2));
		p.add(l10);p.add(t8);
		p.add(l1);p.add(t1);
		p.add(l2);p.add(t2);
		p.add(l3);p.add(t3);
		p.add(l4);p.add(t7);
		p.add(l5);p.add(t4);
		p.add(l6);p.add(t9);
		p.add(l7);p.add(t5);
		p.add(l8);p.add(t6);
		p.add(lb1);p.add(tf1);
		p.add(lb2);p.add(tf2);
		p.add(lb3);p.add(tf3);
		p.add(lb4);p.add(tf4);
		p.add(lb5);p.add(tf5);
		p.add(b1);p.add(b2);
		p.add(b3);
		add(p);
		this.setSize(600,600);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		this.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Personal();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b3)
			dispose();
		if(e.getSource()==b2)
			t8.setText("");
		if(e.getSource()==b1)
		{
			int m=Integer.parseInt(t8.getText());
			try{
					Class.forName("com.mysql.jdbc.Driver");
					cn=DriverManager.getConnection("jdbc:mySQL://localhost:3306/addressbook",
							"root","password");
					System.out.println("Connected to database");
					sm=cn.createStatement();
				rs=sm.executeQuery("Select * from adbook where id="+m);
				rsmd=rs.getMetaData();
				System.out.println("\n\n");
				while(rs.next())
				{
					t1.setText(rs.getString(1));//first
					t2.setText(rs.getString(2));//last
					t3.setText(rs.getString(3));//father
					t7.setText(rs.getString(4));//gender
					t4.setText(rs.getString(5));//age
					t9.setText(rs.getString(6));//blood
					t5.setText(rs.getString(7));//native lang
					t6.setText(rs.getString(8)); //nation
					tf1.setText(rs.getString(10));//address
					tf2.setText(rs.getString(11));//pin
					tf3.setText(rs.getString(12));//phno
					tf4.setText(rs.getString(13));//home
					tf5.setText(rs.getString(14));//email
					
				}
			
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}	
		}
	}
}

