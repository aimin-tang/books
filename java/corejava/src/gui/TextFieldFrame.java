package gui;

/**
 * Created by aitang on 10/27/17.
 */

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextFieldFrame extends JFrame {
    private JTextField f1;
    private JTextField f2;
    private JTextField f3;
    private JPasswordField f4;

    public TextFieldFrame() {
        super("Testing JTextField and JPasswordField");
        setLayout(new FlowLayout());

        f1 = new JTextField(10);
        add(f1);

        f2 = new JTextField("Enter text here");
        add(f2);

        f3 = new JTextField("Uneditable text", 21);
        f3.setEditable(false);
        add(f3);

        f4 = new JPasswordField("Hidden text");
        add(f4);

        TextFieldHandler handler = new TextFieldHandler();
        f1.addActionListener(handler);
        f2.addActionListener(handler);
        f3.addActionListener(handler);
        f4.addActionListener(handler);
    }

    private class TextFieldHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String string = "";

            if (e.getSource() == f1)
                string = String.format("f1: %s", e.getActionCommand());
            else if (e.getSource() == f2)
                string = String.format("f2: %s", e.getActionCommand());
            else if (e.getSource() == f3)
                string = String.format("f3: %s", e.getActionCommand());
            else if (e.getSource() == f4)
                string = String.format("f4: %s", new String(f4.getPassword()));

            JOptionPane.showMessageDialog(null, string);
        }
    }
}
