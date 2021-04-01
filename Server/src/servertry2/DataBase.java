/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servertry2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omniahassan
 */
public class DataBase {

    Statement stmt;
    PreparedStatement stmt2;
    Connection con;
    ResultSet result;
    int num;

    DataBase(String name, String pass) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tic_tac_toe", name, pass);
            stmt = con.createStatement();
            ServerPage.viewPane(ServerPage.serverrunPane);
            System.out.println("Succeeded connecting to the Database!");
        } catch (SQLException ex) {
            System.out.println("Connection to database is failed");
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }

    public ResultSet executeMyQuery(String queryString) throws SQLException {
        result = stmt.executeQuery(queryString);
        return result;
    }

    public int executeMyUpdate(String queryString) throws SQLException {
        num = stmt.executeUpdate(queryString);
        return num;
    }

    public int executeMyPrepared(String queryString2, int x, String xx, int y, String yy, int z, String zz) throws SQLException {
        stmt2 = con.prepareStatement(queryString2);
        stmt2.setString(x, xx);
        stmt2.setString(y, yy);
        stmt2.setString(z, zz);
        num = stmt2.executeUpdate();
        return num;
    }

    public void closeConnection() throws SQLException {
        stmt.close();
        stmt2.close();
        con.close();
    }

}
