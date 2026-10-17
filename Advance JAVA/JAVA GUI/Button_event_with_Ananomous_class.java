import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Button_even_with_Ananomous_class extends JFrame{
    JButton b1  = new JButton("Click Here");
    Button_even_with_Ananomous_class(){
        setSize(500,400);
        setVisible(true);
        setLayout(new FlowLayout());
        add(b1);
        b1.addActionListener(new EventHandler());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Button_even_with_Ananomous_class();
    }
}
class EventHandler implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(null, "Button Clicked");
    }
}