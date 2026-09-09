import java.sql.*;
class dbConnection{
    public static void main(String args[]){
        try{
            String url = "jdbc:mysql://localhost:3306/jdbcdb";//3306 is a default port number of mysql
            String user = "root";
            String password = "P2003r@";
            //step-1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //step-2: Establish the Connection
            Connection con = DriverManager.getConnection(url,user,password);
            System.out.println("Connection Sucessfull");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}