package com.wgoweb.mathExercise;

import java.util.Random;

/**
 * 5. Skriv ett program som genererar ett jämnt tal mellan 0 och 20.*/
public class Exercise5 {

  public static void main(String[] args) {
    int number = 20;
    System.out.println("5) genererar ett jämnt tal mellan 0 och " + number + " : "
            + randomEvenNumber(number));
  }

  //https://stackoverflow.com/questions/33870759/generate-a-random-even-number-inside-a-range
  static int randomEvenNumber(int number) {
    Random rand = new Random();
    return rand.nextInt(number/2) * 2;
  }
}
