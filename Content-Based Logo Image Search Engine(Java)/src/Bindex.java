/*
 * Imsearch.java (requires Java 1.2+)
 */

import java.awt.*;
import java.io.*;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;

public class Bindex implements ActionListener {

    JButton b1 = null;
    JButton b2 = null;
    JTextField t1 = null;
    JLabel j1 = null;
    JDialog d;
        
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Start")) {
            int isize = Integer.parseInt(t1.getText());
            newIndex aa = new newIndex(isize);
        } else if (cmd.equals("Main Menu")) {
            d.dispose();
        }
    }
    
    public Bindex(JFrame f)
    {
    	try {
      	  jbInit(f);
    	}
    	catch(Exception e) {
      	  e.printStackTrace();
    	}
    }
    
    private void jbInit(JFrame f) throws Exception  {
        d = new JDialog(f,"Build Index",true);
        Container contentPane = d.getContentPane();
        contentPane.setLayout(null);
        b1 = new JButton("Start");
        b2 = new JButton("Main Menu");
        j1 = new JLabel("No. of Index:");
        t1 = new JTextField();
        b1.addActionListener(this);
        b2.addActionListener(this);
        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.add(j1);
        contentPane.add(t1);
        b1.setBounds(120,80,130,40);
        b2.setBounds(120,130,130,40);
        j1.setBounds(40,40,80,40);
        t1.setBounds(125,50,80,20);
        d.setSize(400,330);
        d.show();
    }
}
