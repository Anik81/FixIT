/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaaal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class DbHandler {
    protected Connection connection;
    public Connection getConnection(){
        final String connectionString="jdbc:mysql://localhost:3306/student";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException ex)
        {
            Logger.getLogger(DbHandler.class.getName()).log(Level.SEVERE,null,ex);
        }
        try{
            connection=DriverManager.getConnection(connectionString,"root","");
        }catch(SQLException ex)
        {
            Logger.getLogger(DbHandler.class.getName()).log(Level.SEVERE,null,ex);
        }
        return connection;
    }
    
}
