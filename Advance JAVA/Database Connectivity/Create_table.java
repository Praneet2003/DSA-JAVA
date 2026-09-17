import java.sql.*;
class Create_table{
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
            Statement stmt = con.createStatement();
            stmt.executeUpdate("create table if not exists Student(roll int primary key, name varchar(10),marks int);");
            System.out.println("Table Created");
            //insert records in table.
            // stmt.executeUpdate("insert into Student values (101,'Praneet',89)");
            // stmt.executeUpdate("insert into Student values (102,'abc',80)");
            // stmt.executeUpdate("insert into Student values (103,'def',88)");
            ResultSet rs = stmt.executeQuery("select * from Student");
            while(rs.next()){
                System.out.print(rs.getInt(1)+" ");//either you can write column name or number over here
                System.out.print(rs.getString("name")+" ");
                System.out.print(rs.getInt(3));
                System.out.println("");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}