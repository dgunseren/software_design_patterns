import javax.swing.*;
public class ButtonExample {
    public static void main(String[] args) {
        JFrame f=new JFrame("Button Example");
        JButton b=new JButton("Click Here");
        JLabel label = new JLabel("my text");

        b.setBounds(150,100,95,30);
        label.setBounds(250,100,95,30);
        f.add(b);
        f.add(label);
        f.setSize(500,900);
        f.setLayout(null);
        f.setVisible(true);
    }
}