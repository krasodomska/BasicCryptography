import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class GUI{
    GUI() {
        JFrame f = new JFrame("Cezar cypher");
        //submit button
        JButton b = new JButton("Submit");
        b.setBounds(100, 150, 140, 40);
        //enter text label
        JLabel label = new JLabel();
        label.setText("Enter text :");
        label.setBounds(10, 10, 100, 100);
        //enter shift label
        JLabel labelShift = new JLabel();
        labelShift.setText("Enter shift value:");
        labelShift.setBounds(10, 60, 100, 100);
        //empty label which will show event after button clicked
        JLabel label1 = new JLabel();
        label1.setBounds(10, 160, 200, 100);
        //textField to enter text
        JTextField textField = new JTextField();
        textField.setBounds(110, 50, 130, 30);
        //textField to enter text
        JTextField shiftField = new JTextField();
        shiftField.setBounds(110, 100, 130, 30);

        //add to frame
        f.add(label1);
        f.add(textField);
        f.add(label);
        f.add(labelShift);
        f.add(shiftField);
        f.add(b);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //action listener
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                label1.setText(CezarCypher.textEncryption(textField.getText(), Integer.parseInt(shiftField.getText())));
            }
        });
    }


    public static void main(String[] args) {
        new GUI();
    }
}