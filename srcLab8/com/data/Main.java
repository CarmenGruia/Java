package com.data;
import java.sql.*;

/*Gruia Carmen-Andreea, grupa E1*/
/* Programul realizat respecta partea Compulsory a laboratorului 8.*/

public class Main {
    public static void main(String[] args) throws SQLException {

         int id;//id-ul unic al fiecarui element din tabela

         Connection conn=Database.Database();//conectarea la baza de date

         ArtistController artist=new ArtistController(conn);//accesarea tabelei Artist

         id=artist.get_the_last_id_art();//ultimul id din tabela Artist
        System.out.println(id);
         artist.create(id,"Timberlake","SUA");
         id=artist.get_the_last_id_art();
         artist.create(id,"Martin","Spain");
         id=artist.get_the_last_id_art();
         artist.create(id,"Smiley","Romania");

         artist.findByName("Martin");

         AlbumController album=new AlbumController(conn);//accesarea tabelei Album

         id=album.get_the_last_id_alb();//ultimul id din tabela Album
         album.create(id,"Justified",1,2002);

         id=album.get_the_last_id_alb();
         album.create(id,"The 20/20 Experience",1,2013);

         id=album.get_the_last_id_alb();
         album.create(id,"Vuelve",2,1998);

         id=album.get_the_last_id_alb();
         album.create(id,"Confesiune",3,2017);

         album.findByName(1);

         conn.close();//inchiderea conexiunii
    }
}
