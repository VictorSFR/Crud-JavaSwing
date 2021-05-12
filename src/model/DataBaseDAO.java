package model;

import java.sql.Connection;
import java.sql.DriverManager;


public class DataBaseDAO {
    Connection conn;
    String user = "root";
    String pass = "12345678";
    String host = "jdbc:mysql://localhost/carro";
    
    public void connectar() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(host, user, pass);
        
    }
    public void desconnectar() throws Exception{
        if(!conn.isClosed()){
            conn.close();
        }
    }
}
