package project;

import java.applet.Applet;
import java.awt.Frame;

import javax.swing.*;
public class TabbedPaneEx extends JApplet{
	
	
	public void init()   
	  {
	    JTabbedPane jt = new JTabbedPane();
	    setSize(600,600);
	    jt.add("Address Book",new Frontpage());
	    jt.add("Personal Details",new Personal());
	    jt.add("Contact Details",new Contact());
	    getContentPane().add(jt);
	  }
}
	
