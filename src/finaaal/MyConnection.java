/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaaal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class MyConnection {
    private Connection con;
    private Statement st;
    String Name,Email,UserName,Area,Password,CPassword;
     public MyConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "" );
            st=con.createStatement();
        }
        catch(Exception ex){
            System.out.println("Error "+ex);
            
        }
        
    }
     
     public void insert(String Name,String Email,String UserName,String Area,String Password,String CPassword)
     {
         try{
             this.Name=Name;
             this.Email=Email;
             this.UserName=UserName;
             this.Area=Area;
             this.Password=Password;
             this.CPassword=CPassword;
             
        String query="INSERT INTO studenttable(Name, Email, UserName, Area, Password, CPassword)"+"VALUES('"+Name+"','"+Email+"','"+UserName+"','"+Area+"','"+Password+"','"+CPassword+"');";
             st.execute(query);
            
        }catch(Exception ex)
        {
             //Logger.getLogger(CreateAccountViewController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error 2 "+ex);
        }
        
     }
     
     public void login(String userID,String pass)
     {
            
     }
}
