package com.data;
import java.sql.*;
import com.mysql.jdbc.Driver;

/* Clasa ArtistController ce se ocupa cu gestionarea datelor din tabela Artists*/

public class ArtistController {

    int id;
    String name, country;
    Connection conn;

    public  ArtistController(Connection conn)// constructorul care preia conexiunea
    {
        this.conn=conn;
    }
    public int get_the_last_id_art() throws SQLException //metoda ce returneaza ultimul id din tabela Artists de la momentul apelarii
    {
        int id = 0;
        Statement myStatement = conn.createStatement();
        ResultSet myResult = myStatement.executeQuery("SELECT id FROM artists");
        while(myResult.next())
            id=myResult.getInt("id");

        return id;

    }
    public void create(int id,String name, String country) throws SQLException
    {
          id++;//id-ul elementului ce se insereaza este ultimul id din tabela incrementat cu 1
        Statement myStatement = conn.createStatement();
        myStatement.executeUpdate(String.format("INSERT INTO artists (id, name, country) VALUES (%d, '%s','%s')",id,name,country));

    }

    public void findByName(String name) throws SQLException
    {
        Statement myStatement = conn.createStatement();
        ResultSet myResult = myStatement.executeQuery(String.format("SELECT * FROM artists WHERE name='%s'",name));
        while (myResult.next()) {
            System.out.println("Artist:" + myResult.getString("name") + " "+ myResult.getString("country"));

        }

    }
}
