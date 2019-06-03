package Pachet;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import
public class ServiceCRUD {
    void Read(String JDBC_driver,String DB_URL,String User,String Pass)
    {
        Connection conn = null;
        Statement stmt = null;
        try{

            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,User,Pass);


            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT name,price FROM Cars";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                String nume = rs.getString("name");
                int price  = rs.getInt("pret");
                Car X=new Car(nume,price);

}

            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
 */   }
}