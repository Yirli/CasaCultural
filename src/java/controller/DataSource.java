/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author yir
 */
public class DataSource {
    private static DataSource instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/db_sistemamatriculacc?zeroDateTimeBehavior=convertToNull&autoReconnect=true&useSSL=false"; 
    private String username = "root";
    private String password = "Popikracipipi27";

    private DataSource() throws SQLException{
         try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }
    
   public Connection getConnection(){
        try {
            if(connection.isClosed()){
                instance = new DataSource();
            }
        } catch (SQLException ex) {
            System.out.println("Error: "+ex.getMessage());
        }
        return instance.connection;
   }
   
   public static DataSource getInstance()throws SQLException{
         if (instance == null) {
            instance = new DataSource();
        } else if (instance.getConnection().isClosed()) {
            instance = new DataSource();
        }

        return instance;
   }
   
    public void closeConnection() throws SQLException{
        try{
        connection.close();
        }catch(SQLException e){
            throw new SQLException(e);
        }
    }
}


