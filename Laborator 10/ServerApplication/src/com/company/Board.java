package com.company;

public class Board {
    public static int[][] boardgame=new int[16][16];
    public Board(){
        for( int i=1;i<=15;i++)
            for(int j=1;j<=15;j++)
                boardgame[i][j]=0;
    }
    public void move(int line, int col,int player_nr)
    {
        if(player_nr==1)
         boardgame[line][col]=1;
        else boardgame[line][col]=2;
    }
    public boolean verify_board(){
        boolean ok=false;
        for(int i=1;i<=15;i++) {
            for (int j = 1; j <= 11; j++)
                if (boardgame[i][j] + boardgame[i][j + 1] + boardgame[i][j + 2] + boardgame[i][j + 3] + boardgame[i][j + 4] == 5
                ||  boardgame[i][j] + boardgame[i][j + 1] + boardgame[i][j + 2] + boardgame[i][j + 3] + boardgame[i][j + 4] == 10) {
                    ok=true;
                    break;
                }
        }
        for(int i=1;i<=11;i++) {
            for (int j = 1; j <= 15; j++)
                if (boardgame[i][j] + boardgame[i + 1][j] + boardgame[i + 2][j] + boardgame[i + 3][j] + boardgame[i + 4][j] == 5
                ||  boardgame[i][j] + boardgame[i + 1][j] + boardgame[i + 2][j] + boardgame[i + 3][j] + boardgame[i + 4][j] == 10) {
                    ok = true;
                    break;
                }
        }
        for(int i=1;i<=11;i++) {
            for (int j = 1; j <= 11; j++)
                if (boardgame[i][j] + boardgame[i + 1][j + 1] + boardgame[i + 2][j + 2] + boardgame[i + 3][j + 3] + boardgame[i + 4][j + 4] == 5
                    || boardgame[i][j] + boardgame[i + 1][j + 1] + boardgame[i + 2][j + 2] + boardgame[i + 3][j + 3] + boardgame[i + 4][j + 4] == 10){
                    ok = true;
                    break;
                }
        }
        for(int i=15;i>=5;i--) {
            for (int j=1;j<=11; j++)
                if (boardgame[i][j] + boardgame[i - 1][j + 1] + boardgame[i - 2][j + 2] + boardgame[i - 3][j + 3] + boardgame[i - 4][j + 4] == 5
                || boardgame[i][j] + boardgame[i - 1][j + 1] + boardgame[i - 2][j + 2] + boardgame[i - 3][j + 3] + boardgame[i - 4][j + 4] == 10) {
                    ok = true;
                    break;
                }
        }
        return ok;

    }
    public void turn()
    {
        for(int i=1;i<=15;i++)
        { for(int j=1;j<=15;j++)
             System.out.print(boardgame[i][j]+" ");
        System.out.println("");}
    }
}
