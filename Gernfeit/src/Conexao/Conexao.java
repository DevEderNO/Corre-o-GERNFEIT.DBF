/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Masterkaos
 */
public class Conexao {
    private final static String DRIVER = "com.hxtt.sql.dbf.DBFDriver";
    private final static String URL = "jdbc:DBF:/";
    
    public static Connection getConexao() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL + "C:\\sfarma\\");
    }

}
