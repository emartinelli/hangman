/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.hangman.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionHangman {
    private static ResourceBundle configuration;
    private static ConnectionHangman connection;
    
    private ConnectionHangman(){
       configuration = ResourceBundle.getBundle("br.mackenzie.hangman.util.hangman_conf");
    }
    
    public static ConnectionHangman getInstance() {
        if (connection == null) {
            connection = new ConnectionHangman();
        }
        return connection;
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(configuration.getString("br.mackenzie.db.driver.javadb"));
        return DriverManager.getConnection(configuration.getString("br.mackenzie.db.url.connection"),
                configuration.getString("br.mackenzie.db.user"), configuration.getString("br.mackenzie.db.password"));
    }
    public static void main(String[] args) {
        try {
            System.out.println(getInstance().getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

