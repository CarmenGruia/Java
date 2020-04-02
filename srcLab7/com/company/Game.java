package com.company;

public class Game {
    private volatile boolean isPlayer1;
    int []tokens1=new int[101]; //numerele extrase de jucatorul 1 sunt stocate in tokens1
    int []tokens2=new int[101];//numerele extrase de jucatorul 2 sunt stocate in tokens2
    int l1=0,l2=0;//lungimile celor 2 vectori


    synchronized void Player1(int number, String name) {
        while (isPlayer1) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(name + " : " + number);
        l1++;
        tokens1[l1]=number;

        isPlayer1=true;
        notify();
    }


    synchronized void Player2(int number,String name) {
        while (!isPlayer1) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(name +" : " + number);
        l2++;
        tokens2[l2]=number;
       isPlayer1=false;
        notify();
    }


//sortarea vectorilor
    public void sort(int []array, int length)
    {
        int aux;
        for (int i=1;i<=length-1;i++)
            for(int j=i+1;j<=length;j++)
                if(array[i]>array[j])
                {aux=array[i];
                array[i]=array[j];
                array[j]=aux;
                }
    }

    //aflarea lungimii maxime a unei progresii aritmetice ce poate fi formata
    //pornesc de la primul element (array[i]), calculez posibila ratie dintre el si urmatorul element (aux) si verific daca
    // exista in continuare un element egal cu aux+ratia
    public int max_progression(int []array,int length)
    {
        int rate,i,j,k,aux,lmax=1,l;
        sort(array,length);//ordonarea vectorului
        for( i=1;i<=length-2;i++) {
            for (j = i + 1; j < length; j++) {
                rate = array[j] - array[i];
                aux = array[j];
                l = 2;
                for (k = j + 1; k <= length; k++)
                    if (aux + rate == array[k]) {
                        aux = array[k];
                        l++;
                    }
                if (l > lmax)
                    lmax = l;
            }
        }
        return lmax;
    }

    public void score()
    {
        int points1=max_progression(tokens1,l1);
        int points2=max_progression(tokens2,l2);
        if(points1>points2)
            System.out.println("The winner is player 1");
        else if(points2>points1)
            System.out.println("The winner is player 2");
        else System.out.println("Draw");

    }
}

