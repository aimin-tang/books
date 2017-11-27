package gui;

/**
 * Created by aitang on 10/27/17.
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame {
    private JButton b1;
    private JButton b2;

    public ButtonFrame() {
        super("Testing JButton");
        setLayout(new FlowLayout());

        b1 = new JButton("Plain Button");
        add(b1);

        Icon bug1 = new ImageIcon(getClass().getResource("bug1.gif"));
        Icon bug2 = new ImageIcon(getClass().getResource("bug2.gif"));
        b2 = new JButton("Fancy Button", bug1);
        b2.setRolloverIcon(bug2);
        add(b2);


        ButtonHandler handler = new ButtonHandler();
        b1.addActionListener(handler);
        b2.addActionListener(handler);
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(ButtonFrame.this,
                    String.format("You pressed %s", e.getActionCommand()));
        }
    }
}

