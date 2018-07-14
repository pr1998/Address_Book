package project;

import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class Personal extends TabbedPaneEx implements ActionListener{
	public JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	public JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	public JButton b1,b2,b3;
	public Choice ch1,ch2;
	JPanel p;
	JList lt,lt2;
	Connection cn=null;
	Statement sm=null,st1=null;
	ResultSet rs=null;
	ResultSetMetaData rsmd=null;
	String sql=" ";
	Personal()
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
		l1=new JLabel("First Name:");
		l2=new JLabel("Last Name:");
		l3=new JLabel("Father's Name:");
		l4=new JLabel("Gender:");
		l5=new JLabel("Age:");
		l6=new JLabel("Blood Group:");
		l7=new JLabel("Native Language/Mother Tongue:");
		l8=new JLabel("Nationality:");
		l10=new JLabel("ID:");
		l11=new JLabel();
		String c[]={"Male","Female","Other"};
		lt=new JList(c);
		String cm[]={"A+","A-","B+","B-","AB+","AB-","O+","O-"};
		lt2=new JList(cm);
		t1=new JTextField();
		t2=new JTextField();
		t3=new JTextField();
		t4=new JTextField();
		t5=new JTextField();
		t6=new JTextField();
		t8=new JTextField();
		b1=new JButton("SAVE");
		b2=new JButton("CANCEL");
		b3=new JButton("EXIT");
		p=new JPanel(new GridLayout(12,2));
		try
		{
			System.out.println(sql);
			rs=sm.executeQuery(sql);
			rs.last();
			int r=rs.getRow();
			r=r+1;
			t8.setText(r+"");
			t8.setEditable(false);
			}
		catch(Exception en)
		{
			en.printStackTrace();
		}
		
		p.add(l10);
		p.add(t8);
		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(t2);
		p.add(l3);
		p.add(t3);
		p.add(l4);
		p.add(new JScrollPane(lt));
		p.add(l5);
		p.add(t4);
		p.add(l6);
		p.add(new JScrollPane(lt2));
		p.add(l7);
		p.add(t5);
		p.add(l8);
		p.add(t6);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(l11);
		add(p);
		this.setSize(600,600);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		this.setVisible(true);
		
		
	}
	
	public void dispose()
	{
		System.exit(0);
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
			{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t8.setText("");
			lt.setSelectedIndex(0);
			lt2.setSelectedIndex(0);
			t1.setText("");
			}
		if(e.getSource()==b1)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				cn=DriverManager.getConnection("jdbc:mySQL://localhost:3306/addressbook",
							"root","password");
				String s2="'"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+lt.getSelectedValue()+"','"+t4.getText()+"','"+lt2.getSelectedValue()+"','"+t5.getText()+"','"+t6.getText()+"'";
				String fin="insert into adbook(first,last,father,gender,age,blood,mother,nation) values("+s2+")";
				sm.execute(fin);
				l11.setText("Personal Details are Saved!!!");
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
}

