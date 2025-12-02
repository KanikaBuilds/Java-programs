import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Exp4 {
    public static void main(String[] args)
    {   
      JFrame frame = new JFrame();
      frame.setLayout(new FlowLayout());
      frame.setSize(400,400);
      frame.setVisible(true);
      JTextField text1 = new JTextField(10);
      JTextField text2 = new JTextField(10);
      JButton b2=new JButton("CALCULATE");
      JLabel label1= new JLabel("NUMBER 1");
      JLabel label2= new JLabel("Number 2");
      JLabel label3= new JLabel("");

      b2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae){ 
            JDialog dialog=new JDialog(frame,"Hello",true);
            dialog.setSize(100,200);
            dialog.setLayout(new FlowLayout());
            JLabel label5=new JLabel("THE RESULT IS :");
            int lab1=Integer.parseInt(text1.getText());
            int lab2=Integer.parseInt(text2.getText());
            int result=lab1+lab2;
            label3.setText(result+"");
            JButton close=new JButton("CLOSE");
            close.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent r){
                    dialog.dispose();
                }
            });
            dialog.add(label5);
            dialog.add(label3);
            dialog.add(close);
            dialog.setVisible(true);  }});
      frame.add(label1);
      frame.add(text1);
      frame.add(label2);
      frame.add(text2);
      frame.add(b2);
      frame.setVisible(true);}}