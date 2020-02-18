/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbccapas_165561;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author lv1013
 */
public class MySQLConnection implements ConnectionFactory {
    private final String connectionString;
    private final String user;
    private final String password;
    public MySQLConnection(String host,String database,int port,String user,String password){
        this.user=user;
        this.password=password;
        this.connectionString=String.format("jdbc:mysql://%s:%d/%s?serverTimezone=UTC",host,port,database);

    }

    @Override
    public Connection getConnection() throws SQLException {
       
        return DriverManager.getConnection(this.connectionString,this.user,this.password);
    
    }
}
