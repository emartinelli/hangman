/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.hangman.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionHangman {
    private static ResourceBundle configuration;
    private static ConnectionHangman connection;
    
    private ConnectionHangman(){
       configuration = ResourceBundle.getBundle("br.mackenzie.fci.cc.shm.util.hangman_conf");
    }
    
    public static ConnectionHangman getInstance() {
        if (connection == null) {
            connection = new ConnectionHangman();
        }
        return connection;
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(configuration.getString("br.mackenzie.bd.driver.javadb"));
        return DriverManager.getConnection(configuration.getString("br.mackenzie.bd.url.connection"),
                configuration.getString("br.mackenzie.bd.user"), configuration.getString("br.mackenzie.bd.password"));
    }
    public static void main(String[] args) {
        try {
            System.out.println(getInstance().getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

