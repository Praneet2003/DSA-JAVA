import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Button_Listner_Add_two_number_flow_layout extends JFrame implements ActionListener{
    JLabel l1 = new JLabel("First No.");
    JLabel l2 = new JLabel("Second No.");
    JLabel l3 = new JLabel("Result: ");
    JTextField tf1 = new JTextField(10);
    JTextField tf2 = new JTextField(10);
    JTextField tf3 = new JTextField(10);
    JButton b0 = new JButton("CLEAR");
    JButton b1 = new JButton("ADD");
    JButton b2 = new JButton("SUB");
    Button_Listner_Add_two_number_flow_layout(){
        setSize(500,400);
        setVisible(true);
        setLayout(new FlowLayout());
        setTitle("Sum of Two ");
        add(l1);
        add(tf1);
        add(l2);
        add(tf2);
        add(b0);
        add(b1);
        add(b2);
        add(l3);
        add(tf3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b0.addActionListener(this);
        tf3.setEditable(false);//textfeild only for display.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){
        String s1 = tf1.getText();
        String s2 = tf2.getText();
        if(e.getSource()==b1){// or e.getActionCommand().equals("ADD") it check the label of the object
            int res = Integer.parseInt(s1)+Integer.parseInt(s2);
            tf3.setText(res+""); // or tf3.setText(res.valueOf());
        }else if(e.getSource()==b2){// getSource cehck the object
            int res = Integer.parseInt(s1)-Integer.parseInt(s2);
            tf3.setText(res+"");
        }else{
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
        }
    }
    public static void main(String[] args) {
        new Button_Listner_Add_two_number_flow_layout();
    }
}