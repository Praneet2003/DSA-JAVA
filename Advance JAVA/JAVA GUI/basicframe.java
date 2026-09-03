import java.awt.*;
import javax.swing.*;
class basicframe extends JFrame{
    JLabel l1 = new JLabel("Name");
    JTextField tf1 = new JTextField();
    JButton b1 = new JButton("Save");
    JButton b2 = new JButton("Update");
    basicframe(){
        setSize(400,200);//necessary
        setVisible(true);//necessary
        setTitle("Basic Student frame");
        setLocation(100,70);
        setLayout(new FlowLayout());
        setLayout(null);
        l1.setBounds(100,70,80,30);
        tf1.setBounds(200,70,80,30);
        add(l1);
        add(tf1);
        add(b1);
        add(b2);
        
    }
    public static void main(String[] args) {
        new basicframe();
    }
}