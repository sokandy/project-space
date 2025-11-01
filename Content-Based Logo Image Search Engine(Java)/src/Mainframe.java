import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Mainframe extends WindowAdapter implements ActionListener
{
	
	JFrame f = null;
    
    	public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Image Search")) {
            new Ims(f);
        } else if (cmd.equals("Build Index")) {
            new Bindex(f);
        } else if (cmd.equals("Exit")) {
            System.exit(0);
        }
    	}
	
	
public Mainframe()                           
    {
        f = new JFrame("Image Search Engine");
        Container contentPane = f.getContentPane();
        contentPane.setLayout(null);
        JButton b1 = new JButton("Build Index");
        JButton b2 = new JButton("Image Search");
        b1.addActionListener(this);
        b2.addActionListener(this);
        contentPane.add(b1);
        contentPane.add(b2);
        b1.setBounds(120,100,130,40);
        b2.setBounds(120,150,130,40);
        f.setSize(400,330);
        f.setVisible(true);
               
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] args)
    {
        new Mainframe();
    }
}
	