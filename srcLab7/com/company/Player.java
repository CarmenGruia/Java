package com.company;

public class Player implements Runnable {
    String name;
     Game game;
     Board board;
    int nrofPlayer;
    int i=0;
    int number;
    public Player(String name, int nrofPlayer,Game game,Board board) {
        this.name = name;
        this.nrofPlayer = nrofPlayer;
        this.game=game;
        this.board=board;
    }

    @Override
    public void run() {
        while(i<board.n) {

            if (nrofPlayer == 1)
                game.Player1(board.extractToken(),name);
            else game.Player2(board.extractToken(),name);
            i++;
        }

    }

}