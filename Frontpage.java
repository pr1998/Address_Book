package project;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frontpage extends Applet implements ActionListener{
	String msg=" ";
	Image img1;
	Button insert,update,quit,search;
	Panel p1;
	Frontpage()
	{
		init();
		start();
	}
	public void init()
	{
		setSize(600,600);
		p1=new Panel();
		search=new Button("SEARCH RECORDS");
		update=new Button("UPDATE RECORDS");
		quit=new Button("QUIT");
		
		
	}
	public void start()
	{
		msg+="ADDRESS BOOK";
		setLayout(null);
		search.setBounds(180, 200, 200, 50);
		add(search);
		search.addActionListener(this);
		update.setBounds(180, 300, 200, 50);
		add(update);
		update.addActionListener(this);
		quit.setBounds(180, 400, 200, 50);
		add(quit);
		quit.addActionListener(this);
		
	}
	public void paint(Graphics g)
	{
		Font ft=new Font("Arial",Font.BOLD,30);
		g.setFont(ft);
		g.setColor(Color.blue);
		g.drawString(msg, 150, 100);
	}
	
	public void dispose()
	{
		System.exit(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==search)
			new Search();
		if(e.getSource()==update)
			new Update();
		if(e.getSource()==quit)
			dispose();
	
	}
	
	public static void main(String[] args)
	{
		
	}

}
