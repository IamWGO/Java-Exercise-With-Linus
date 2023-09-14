package com.wgoweb.ifElseExercise;

/*
Skriv om denna koden så den är lättare att läsa
if(x == 10) {
if(y == 15){
    z = 20;
}
}
* */
public class Exercise4 {

  public static void main(String[] args) {
    correctCode(10, 15);
  }

  static void correctCode(int x, int y) {
    if (x == 10 && y == 15) {
      int z = 20;
      System.out.println("if(x == " + x + " && y == " + y + ") { \n" +
              "   z = " + z + "\n" +
              "}\n");
    } else System.out.println(" do not thing");
  }
}
