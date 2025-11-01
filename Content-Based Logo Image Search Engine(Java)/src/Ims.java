/*
 * Imsearch.java (requires Java 1.2+)
 */

import java.awt.*;
import java.io.*;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;

public class Ims implements ActionListener {

    JButton b1 = null;
    JButton b2 = null;
    JButton b3 = null;
    JTextField t1 = null;
    JTextField t2 = null;
    JLabel j1 = null;
    JLabel j2 = null;
    JDialog d;
    JFileChooser fileChooser = null;
    JFrame f = null;
        
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Browse")) {
            fileChooser = new JFileChooser("c:\\winnt");
            int result = fileChooser.showOpenDialog(d);
            if(result == JFileChooser.APPROVE_OPTION)
              {
            	File file = fileChooser.getSelectedFile();
            	t2.setText(file.getAbsolutePath());
              }else if (result == fileChooser.CANCEL_OPTION){
            	t2.setText("");
        }
        } else if (cmd.equals("Search")) {
            int isize = Integer.parseInt(t1.getText());
            newsearch aa = new newsearch(t2.getText(),isize);
        } 
        else if (cmd.equals("Main Menu")) {
            d.dispose();
        }
    }
    
    public Ims(JFrame f)
    {
    	try {
      	  jbInit(f);
    	}
    	catch(Exception e) {
      	  e.printStackTrace();
    	}
    }
    
    private void jbInit(JFrame f) throws Exception  {
        d = new JDialog(f,"Search Page",true);
        Container contentPane = d.getContentPane();
        contentPane.setLayout(null);
        b1 = new JButton("Browse");
        b2 = new JButton("Search");
        b3 = new JButton("Main Menu");
        j1 = new JLabel("No of Top:");
        j2 = new JLabel("Location:");
        t1 = new JTextField();
        t2 = new JTextField();
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        //t1.addActionListener(this);
        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.add(b3);
        contentPane.add(j1);
        contentPane.add(j2);
        contentPane.add(t1);
        contentPane.add(t2);
        b1.setBounds(120,130,130,40);
        b2.setBounds(120,180,130,40);
        b3.setBounds(120,230,130,40);
        j2.setBounds(40,80,80,40);
        j1.setBounds(40,40,80,40);
        t1.setBounds(125,50,80,20);
        t2.setBounds(125,90,200,20);
      //  t2.setEnabled(false);
        d.setSize(400,330);
        d.show();
        
        
    }
	
}
