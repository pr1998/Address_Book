package project;
import java.awt.Choice;
import java.awt.Frame;
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

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class Update extends Frame implements ActionListener {
	JLabel l1,l2,l3;
	JButton b1,b2,b3;
	JTextField t1,t2;
	JPanel p;
	JList lt;
	Connection cn=null;
	Statement sm=null;
	ResultSet rs=null;
	ResultSetMetaData rsmd=null;
	String sql=" ";
	
	Update()
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		cn=DriverManager.getConnection("jdbc:mySQL://localhost:3306/addressbook",
				"root","panchapasha123");
		sm=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		String[] c={"First Name","Last Name","Father's Name","Gender","Age","Blood Group","Mother Tongue","Nationality","Address","PIN Code","Phone Number","Home-Phone Number","Email-ID"};
		l1=new JLabel("Enter ID:");
		t1=new JTextField();
		l2=new JLabel("Enter field:");
		lt=new JList(c);
		l3=new JLabel("Enter new value:");
		t2=new JTextField();
		b1=new JButton("Update");
		b2=new JButton("Cancel");
		b3=new JButton("Exit");
		p=new JPanel(new GridLayout(10,2));
		p.add(l1);
		p.add(t1);
		p.add(l2);
		p.add(new JScrollPane(lt));
		p.add(l3);
		p.add(t2);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		add(p);
		this.setSize(600,600);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		this.setVisible(true);
		
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Deletion();

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
			lt.setSelectedIndex(0);
			//lt.setText("");
			}
		if(e.getSource()==b1)
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mySQL://localhost:3306/addressbook",
					"root","panchapasha123");
			sm=cn.createStatement();
			String fin="";
			String val=t2.getText();
			String field="";
			if(lt.getSelectedValue()=="First Name")
				field="first";
			else if(lt.getSelectedValue()=="Last Name")
				field="last";
			else if(lt.getSelectedValue()=="Father's Name")
				field="father";
			else if(lt.getSelectedValue()=="Gender")
				field="gender";
			else if(lt.getSelectedValue()=="Age")
				field="age";
			else if(lt.getSelectedValue()=="Blood Group")
				field="blood";
			else if(lt.getSelectedValue()=="Mother Tongue")
				field="mother";
			else if(lt.getSelectedValue()=="Nationality")
				field="nation";
			else if(lt.getSelectedValue()=="Address")
				field="address";
			else if(lt.getSelectedValue()=="PIN Code")
				field="pin";
			else if(lt.getSelectedValue()=="Phone Number")
				field="phno";
			else if(lt.getSelectedValue()=="Home-Phone Number")
				field="home";
			else if(lt.getSelectedValue()=="Email-ID")
				field="email";
			fin="update adbook set "+field+"='"+val+"' where id="+Integer.parseInt(t1.getText());
			System.out.println(fin);
			sm.execute(fin);
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
