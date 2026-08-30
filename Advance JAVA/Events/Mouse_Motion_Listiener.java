import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Mouse_Motion_Listiener extends JFrame implements MouseMotionListener{
    JLabel l1 = new JLabel();
    Mouse_Motion_Listiener(){
        setSize(400,500);
        setVisible(true);
        setLayout(new FlowLayout());
        add(l1);
        addMouseMotionListener(this);
    }
    public void mouseMoved(MouseEvent e){
        int x = e.getX();//x-coordinate
        int y = e.getY();//y-coordinate
        l1.setText("Mouse Moved to position: x="+x+" y="+y);
    }
    public void mouseDragged(MouseEvent e){
        int x = e.getX();//x-coordinate
        int y = e.getY();//y-coordinate
        l1.setText("Mouse Dragged to position: x="+x+" y="+y);
    }
    public static void main(String[] args) {
        new Mouse_Motion_Listiener();
    }
}