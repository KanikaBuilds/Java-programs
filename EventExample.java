import java.awt.*;
import java.awt.event.*;

public class EventExample extends Frame implements ActionListener {
    TextField tf;
    Button btn;

    EventExample() {
        tf = new TextField();
        tf.setBounds(60, 80, 170, 30);

        btn = new Button("Click Me");
        btn.setBounds(100, 150, 80, 30);

        btn.addActionListener(this);

        add(tf);
        add(btn);
        setSize(300, 300);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        tf.setText("Button Clicked!");
    }

    public static void main(String[] args) {
        new EventExample();
    }
}
