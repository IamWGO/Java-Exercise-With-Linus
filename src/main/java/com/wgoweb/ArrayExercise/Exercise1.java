package com.wgoweb.ArrayExercise;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/*
* 1) Skriv ett program där användaren skriver in 5 integers,
* sparar dem i en array och sen:
*
a) Skriver ut värdena i en rad.
b) Skapa en metod som returnerar högsta värdet.
c) Skapar en metod som räknar ut summan av värden.
d) Skapa en metod som skriver ut medelvärdet av alla värden med decimaler.
*
*
*
Write a program where the user enters 5 integers,
saves them in an array and then:
a) Prints the values in one line.
b) Create a method that returns the highest value.
c) Creates a method that calculates the sum of values.
d) Create a method that prints the average of all values with decimals.
* */
public class Exercise1 {

  static Scanner input = new Scanner(System.in);
  static int maxArray = 5;

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
    int[] inputNumbers = new int[maxArray];
    // input 5 numbers
    for (int i=0; i<maxArray; i++) {
      System.out.print("Input number 1-10 : ");
      inputNumbers[i] = input.nextInt();
    }

    //a) Prints the values in one line.
//      for (int i=0; i<inputNumbers.length; i++) {
//        System.out.print(inputNumbers[i] + "  ");
//      }
    for (int inputNumber : inputNumbers) {
      System.out.print(inputNumber + "  ");
    }

    //b) Create a method that returns the highest value.
    System.out.println(" the highest value : " + getHighestValue(inputNumbers));

    //c) Creates a method that calculates the sum of values.
    int sumNumber = summaryNumbers(inputNumbers);
    System.out.println(" the sum of values : " + sumNumber);

    //d) Create a method that prints the average of all values with decimals.
    double average = averageNumbers(sumNumber, inputNumbers.length);
    System.out.println(" the sum of values : " +  String.format("%.2f", average));
  }

  static int getHighestValue(int[] numbers){

    int max = 0;
    for (int i=0; i<maxArray; i++) {
      if (numbers[i] > max)
        max = numbers[i];
    }
    return max;
  }

  static int summaryNumbers(int[] numbers){

    int sum = 0;
    for (int i=0; i<maxArray; i++) {
      sum = sum + numbers[i];
    }

    return sum;
  }

  static double averageNumbers(int sumNumber, int size){
    return (double) sumNumber/ size;
  }
}

 /*
 * Good to know :
How to Write Pseudocode
https://builtin.com/data-science/pseudocode
Array Data Structure
https://www.youtube.com/watch?v=QJNwK2uJyGs
 * */