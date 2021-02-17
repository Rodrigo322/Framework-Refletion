/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Max Cell
 */
public class ConexcaoDB {

    private Connection conn;
    private String host = "localhost";
    private String user = "root";
    private String pass = "";
    private String banco = "refletiondb";
    private String url = "jdbc:mysql://" + this.host + "/" + this.banco;

    public Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //carerega o driver mysql
            conn = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);//conecta ao banco
            System.out.println("Conectado com sucesso!");
        } catch (ClassNotFoundException e) {//exessão se no caso o driver não existir
            System.out.println(e);
        }
        return conn;
    }

}
