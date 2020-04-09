package com.data;
import java.sql.*;
import com.mysql.jdbc.Driver;

/*Clasa de tip singleton Database ce se ocupa cu gestionarea conexiunii la baza de date */

public class Database {

   private static Database db=null;

    public static Connection myconn=null;

   private Database() throws SQLException {
       try {

           String dbURL = "jdbc:mysql://localhost:3306/MusicAlbums";
           String username = "dba";
           String password = "sql";

           myconn = DriverManager.getConnection(dbURL, username, password);


       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }

   }

   public static Connection Database() throws SQLException {
        if(db==null)
        {
            db=new Database();
        }
        return myconn;
    }
}

