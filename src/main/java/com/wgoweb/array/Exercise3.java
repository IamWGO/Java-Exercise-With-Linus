package com.wgoweb.array;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/*
* Skapa en array som innehåller 10 random integer värden från 1 till 100.
* Där får finnas dubblett värden och sen:
a) Skriv ut resultatet i konsolen i en lång rad.
b) Skapa en metod som kopierar din array och skapar en ny array
* med samma värden där värdena är sorterade från minst till störst.
* Skriv sedan ut båda, först den osorterade och sedan den sorterade.
*
*
* Create an array containing 10 random integer values from 1 to 100.
* There may be duplicate values and then:
a) Print the result to the console in a long line.
b) Create a method that copies your array
* and creates a new array with the same values where the values are sorted
* from least to greatest. Then print both,
* first the unsorted one and then the sorted one.
* */
public class Exercise3 {
  static Scanner input = new Scanner(System.in);
  public static void main(String[] args) {

    do {

      runJob();

      System.out.print("\n\n==== Do you want to exit ==== \n  [0]  to exit , [any key]  to continue -> ");
      String command = input.next();

      if (Objects.equals(command, "0")) break;

    } while (true);

    System.out.println("\n **** Program is ended *** ");
  }

  static void runJob(){
    System.out.println("\n **** Program is ended *** ");

    int[] randomNumbers = new int[10];
    // random 10 numbers between 0 - 100
    for (int i=0; i<10; i++) {
      randomNumbers[i] = randomNumber(1, 100);
    }

    //a) Print the result to the console in a long line.
    System.out.println(" The random numbers are " + Arrays.toString(randomNumbers));

    //Create a method that copies your array, are sorted from least to greatest
    int[] sortedNumber = sortMinToMax(randomNumbers);
    System.out.println(" sorted from least to greatest " + Arrays.toString(sortedNumber));
  }

  static int randomNumber(int min, int max) {
    int range = max - min + 1;
    return  (int)(Math.random() * range) + min;
  }

  static int[] sortMinToMax(int[] numbers) {
    Arrays.sort(numbers);
    return numbers;
  }

}
