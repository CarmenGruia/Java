package com.data;
import java.sql.*;
import com.mysql.jdbc.Driver;

/*Clasa AlbumController ce se ocupa cu gestionarea datelor din tabela Albums */

public class AlbumController {

    String name, country;
    int id;
    Connection conn;
    public  AlbumController(Connection conn)//constructorul ce preia conexiunea
    {
        this.conn=conn;
    }
    public int get_the_last_id_alb() throws SQLException//metoda ce returneaza ultimul id din tabela Albums la momentul apelarii
    {
        int id=0;
        Statement myStatement = conn.createStatement();
        ResultSet myResult = myStatement.executeQuery("SELECT id FROM albums");
        while(myResult.next())
            id=myResult.getInt("id");
        return id;

    }
    public void create(int id,String name,int artistId, int releaseYear ) throws SQLException
    {

            id++;//id-ul elementului ce se insereaza este ultimul id din tabela incrementat cu 1
        Statement myStatement = conn.createStatement();
        myStatement.executeUpdate(String.format("INSERT INTO albums (id, name, artist_id,release_year) VALUES (%d, '%s',%d,%d)",id,name,artistId,releaseYear));

    }

    public void findByName(int artistId) throws SQLException
    {
        this.name=name;
        Statement myStatement = conn.createStatement();
        ResultSet myResult = myStatement.executeQuery(String.format("SELECT * FROM albums WHERE artist_id=%d",artistId));
        while (myResult.next()) {
            System.out.println("Album:" + myResult.getString("name") + " "+ myResult.getInt("release_year"));

        }

    }
}
