package com.company;

import java.util.Random;

public class Token {
    int token;
    int m;
    Random rand=new Random();
  public Token(int m)
  { this.m=m;

}
   public int getToken()
   {

       token=1+rand.nextInt(m);//tokenurile sunt numere alese random de la 1 la m
       return token;
   }
}
