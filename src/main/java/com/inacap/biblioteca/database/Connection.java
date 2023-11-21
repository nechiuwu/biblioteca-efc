/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inacap.biblioteca.database;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author otaku
 */
public class Connection {
    public static java.sql.Connection connectSql(){
        try{
            String user="Inacap";
            String password= "Inacap";
            String sqlConnection="jdbc:oracle:thin:@localhost:1521:XE";
            Class.forName("oracle.jdbc.OracleDriver");
            java.sql.Connection conn = DriverManager.getConnection(sqlConnection,user,password);
            return conn;
        }catch(ClassNotFoundException | SQLException ex){
        JOptionPane.showMessageDialog(null, ex);
        }
        return null;
    }
}
