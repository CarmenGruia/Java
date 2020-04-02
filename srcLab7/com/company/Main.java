package com.company;
import java.io.*;

/*
Gruia Carmen-Andreea , grupa E1

Am realizat partea Compulsory din cadrul Laboratorului 7, doar ca partea de scor a jocului se ruleaza inainte ca jocul sa
inceapa datorita threadurilor si nu am reusit sa gasesc o solutie pentru aceasta problema.


 */
public class Main {
    public static void main(String[] args) throws IOException {
        // citirea de la tastatura a numarului de tokenuri (maxim valoarea 100)
       int n;
        System.out.println("Number of tokens: ");
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(stdin.readLine());
        // citirea de la tastatura a valorii maxime a unui token (maxim valoarea 100)

        int m;
        System.out.println ("The max value of a token (m) : ");
        BufferedReader stdin1 = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(stdin1.readLine());

        Board board=new Board(n,m);
        //umplerea bordului cu n tokenuri
        board.filltheBoard();

      Game game=new Game();
      Thread t1 = new Thread(new Player("Ana",1,game,board));
        Thread t2 = new Thread(new Player("Ion",2,game,board));
        new Thread(t1).start();
        new Thread(t2).start();
        // stabilirea scorului
      game.score();


    }
}
