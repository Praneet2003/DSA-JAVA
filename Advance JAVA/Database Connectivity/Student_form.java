import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class Student_form extends JFrame implements ActionListener{
    static Connection con = null;//we need it globally to use actionPerformed method
    static Statement stmt = null;//we need it globally to use actionPerformed method
    JLabel l1 = new JLabel("Roll No");
    JLabel l2 = new JLabel("Name");
    JLabel l3 = new JLabel("Marks");
    JTextField tf1 = new JTextField(30);
    JTextField tf2 = new JTextField(30);
    JTextField tf3 = new JTextField(30);
    JButton b1 = new JButton("Add");
    JButton b2 = new JButton("Delete");
    JButton b3 = new JButton("Update");
    JButton b4 = new JButton("Retrive");
    public Student_form(){
        setSize(600,500);
        setLayout(new FlowLayout());
        add(l1);add(tf1);add(b4);
        add(l2);add(tf2);
        add(l3);add(tf3);
        add(b1);
        add(b2);
        add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void dbConnection(){
        try{
            String url = "jdbc:mysql://localhost:3306/lpudatabase";
            String user = "root";
            String password = "P2003r@";   
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            con = DriverManager.getConnection(url,user,password);
            //create the statement object
            stmt = con.createStatement();
            stmt.executeUpdate("create table if not exists student(roll int primary key, Name varchar(20), Marks int)");
            System.out.println("Student table created");
        }catch(Exception e){
            System.out.println("ERROR");
        }
    }
    public static void main(String[] args) {
        dbConnection();
        new Student_form();
    }
    public void actionPerformed(ActionEvent e){
        try {
            //retrive
            
            if(e.getSource()==b4){//or e.getAction()
                int roll = Integer.parseInt(tf1.getText());
                ResultSet rs = stmt.executeQuery("select Name,Marks from student where roll ='"+roll+"'");
                if(rs.next()){
                    tf2.setText(rs.getString("Name"));
                    tf3.setText(rs.getString("Marks"));
                }else{
                    JOptionPane.showMessageDialog(null, "Record Not Found");
                }
            }
            if(e.getSource()==b1){//add
                int roll = Integer.parseInt(tf1.getText());
                String name = tf2.getText();
                int marks = Integer.parseInt(tf3.getText());
                stmt.executeUpdate("insert ignore into student values('"+roll+"','"+name+"','"+marks+"')");//we used ignore here to handle the case whenrecord is already present.
                JOptionPane.showMessageDialog(null, "The Record Inserted Sucessfully");
                tf1.setText("");
                tf2.setText("");
                tf3.setText(""); 
            }
            if(e.getSource()==b2){//delete
                int roll = Integer.parseInt(tf1.getText());
                stmt.executeUpdate("delete from student where roll ='"+roll+"'");
                JOptionPane.showMessageDialog(null, "The Record Deleted Successfully");
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
            }
            if(e.getSource()==b3){//update
                int roll = Integer.parseInt(tf1.getText());
                String name = tf2.getText();
                int marks = Integer.parseInt(tf3.getText());
                stmt.executeUpdate("update student set Name='"+name+"', Marks='"+marks+"' where roll='"+roll+"'");
                JOptionPane.showMessageDialog(null, "The Record Updated Successfully");
                tf1.setText("");
                tf2.setText("");
                tf3.setText("");
            }
        } catch (Exception e1) {
            System.out.println("ERROR!! in actionPerformed");
            System.out.println(e1);
        }
    }
}