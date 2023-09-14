package com.wgoweb.ArrayExercise;

import java.util.Objects;
import java.util.Scanner;

/*
* Skapa en array med 100 random värden från 1 till 10.
* Be sedan användaren skriva in ett tal från 1 till 10.
* Då ska programmet skriva ut hur många gånger det talet uppkommer i array.
*
* Create an array with 100 random values from 1 to 10.
* Then ask the user to enter a number from 1 to 10.
*  Then the program should print how many times that number appears in the array.
* */
public class Exercise6 {
  static Scanner input = new Scanner(System.in);
  static int maxArray = 100;
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
    int[] randomNumbers = new int[maxArray];
    // random 1 - 10 : 100 times
    for (int i=0; i<maxArray; i++) {
      randomNumbers[i] = getRandomNumber(1, 10);
    }

    // get input number
    int inputNumber = getInputNumber();

    // get result
    int count = getCountNumberInArray(inputNumber, randomNumbers);

    // print out result
    printAll(inputNumber,randomNumbers);
    System.out.println("\n ================  \n "+
            "Program shown number "+ inputNumber +" is "+count+" times ");

  }

  static int getCountNumberInArray(int selected,int[] numbers){
    int count = 0;
    for (int i=0; i<maxArray; i++) {
      if (numbers[i] == selected)
        count++;
    }
    return count;
  }

  static int getInputNumber(){
    // input number 1-10
    int inputNumber;
    do {
      System.out.print("Input number 1-10 : ");
      inputNumber = input.nextInt();

      if (inputNumber >= 1 && inputNumber <= 10) {
        break;
      }
      System.out.println("Input only number 1-10, please try again ");
    } while (true);

    return inputNumber;
  }

  static int getRandomNumber(int min, int max) {
    int range = max - min + 1;
    return  (int)(Math.random() * range) + min;
  }

  static void printAll(int selected, int[] numbers) {
    for (int i=0; i<maxArray; i++) {
      // show 10 number per line
      if (i%10 == 0) System.out.println(" ");

      // highlight selected number
      if (selected == numbers[i])
        System.out.print("[" + numbers[i] + "]   ");
      else
        System.out.print(" " + numbers[i] + "    ");

    }
  }
}
