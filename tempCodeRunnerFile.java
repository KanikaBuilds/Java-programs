import java.awt.*;
import java.awt.event.*;

class AWTExample extends Frame implements ActionListener {

    // Declare components
    TextField numField1, numField2, resultField;
    Button addBtn, subBtn, clearBtn, nextFrameBtn;

    // Constructor
    AWTExample() {
        setTitle("AWT Example Calculator");

        // Labels
        Label label1 = new Label("Enter First Number:");
        label1.setBounds(40, 60, 140, 30);
        add(label1);

        Label label2 = new Label("Enter Second Number:");
        label2.setBounds(40, 100, 140, 30);
        add(label2);

        Label label3 = new Label("Result:");
        label3.setBounds(40, 140, 140, 30);
        add(label3);

        // TextFields
        numField1 = new TextField();
        numField1.setBounds(190, 60, 150, 30);
        add(numField1);

        numField2 = new TextField();
        numField2.setBounds(190, 100, 150, 30);
        add(numField2);

        resultField = new TextField();
        resultField.setBounds(190, 140, 150, 30);
        resultField.setEditable(false);
        add(resultField);

        // Buttons
        addBtn = new Button("Add");
        addBtn.setBounds(60, 210, 70, 30);
        addBtn.addActionListener(this);
        add(addBtn);

        subBtn = new Button("Subtract");
        subBtn.setBounds(140, 210, 80, 30);
        subBtn.addActionListener(this);
        add(subBtn);

        clearBtn = new Button("Clear");
        clearBtn.setBounds(230, 210, 70, 30);
        clearBtn.addActionListener(this);
        add(clearBtn);

        nextFrameBtn = new Button("Next Frame");
        nextFrameBtn.setBounds(120, 260, 100, 30);
        nextFrameBtn.addActionListener(this);
        add(nextFrameBtn);

        // Frame settings
        setSize(400, 340);
        setLayout(null);
        setVisible(true);

        // Window close operation
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            try {
                int a = Integer.parseInt(numField1.getText());
                int b = Integer.parseInt(numField2.getText());
                resultField.setText(String.valueOf(a + b));
            } catch (Exception ex) {
                resultField.setText("Invalid Input!");
            }
        } else if (e.getSource() == subBtn) {
            try {
                int a = Integer.parseInt(numField1.getText());
                int b = Integer.parseInt(numField2.getText());
                resultField.setText(String.valueOf(a - b));
            } catch (Exception ex) {
                resultField.setText("Invalid Input!");
            }
        } else if (e.getSource() == clearBtn) {
            numField1.setText("");
            numField2.setText("");
            resultField.setText("");
        } else if (e.getSource() == nextFrameBtn) {
            openSecondFrame();
        }
    }

    // Second frame
    void openSecondFrame() {
        Frame secondFrame = new Frame("Second Frame");
        Label msg = new Label("Welcome to the Second Frame!");
        msg.setBounds(60, 60, 200, 25);
        secondFrame.add(msg);

        Button closeButton = new Button("Close");
        closeButton.setBounds(100, 100, 80, 30);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secondFrame.dispose();
            }
        });
        secondFrame.add(closeButton);

        secondFrame.setSize(300, 200);
        secondFrame.setLayout(null);
        secondFrame.setVisible(true);

        secondFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                secondFrame.dispose();
            }
        });
    }

    // Main method
    public static void main(String[] args) {
        new AWTExample();
    }
}
