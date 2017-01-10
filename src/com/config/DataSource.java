/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.config;
import com.mysql.jdbc.Connection;
import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp2.BasicDataSource;
/**
 *
 * @author Programmer JUJU
 */
public class DataSource {
    private static DataSource ds;
    private BasicDataSource bds;
    private static String dbUser,
            dbPass,
            dbName,
            dbUrl,
            dbDriver,
            dbHost;
    private void getFileConfig(){
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("src/com/config/local.conf"));
            dbUser = p.getProperty("dbUser");
            dbPass = p.getProperty("dbPass");
            dbName = p.getProperty("dbName");
            dbUrl = p.getProperty("dbUrl");
            dbDriver = p.getProperty("dbDriver");
            dbHost = p.getProperty("dbHost");
        } catch (IOException ex) {
            System.out.println("\bError on Connection to Database \n Message:" + ex);
            System.out.println("Try to connect, Please Wait...");
            try {
                Properties p2 = new Properties();
                p2.load(new FileInputStream("local.conf"));
                dbUser = p2.getProperty("dbUser");
                dbPass = p2.getProperty("dbPass");
                dbName = p2.getProperty("dbName");
                dbUrl = p2.getProperty("dbUrl");
                dbDriver = p2.getProperty("dbDriver");
                dbHost = p2.getProperty("dbHost");
            } catch (IOException ex2) {
                System.out.println("\bError on Connection to Database \n Message:" + ex2);
                System.out.println("Fatal error");
                JOptionPane.showMessageDialog(null, "Maaf,\nKami telah mencoba tetapi tidak bisa!\n\nHubungi Developer! ", "Fatal ERROR", 0);
            }
        }
    }
    
    private DataSource() throws IOException, SQLException, PropertyVetoException{
        this.getFileConfig();
        bds = new BasicDataSource();
        bds.setDriverClassName(dbDriver);
        bds.setUsername(dbUser);
        bds.setPassword(dbPass);
        bds.setUrl(dbUrl);
        
         // the settings below are optional -- dbcp can work with defaults
        bds.setMinIdle(15);
        bds.setMaxIdle(20);
        bds.setMaxOpenPreparedStatements(180);
    }
    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (ds == null) {
            ds = new DataSource();
            return ds;
        } else {
            return ds;
        }
    }
    public java.sql.Connection getConnection() throws SQLException {
        return this.bds.getConnection();
    }
    public void closeConnection() throws SQLException {
        this.bds.close();
    }
}

