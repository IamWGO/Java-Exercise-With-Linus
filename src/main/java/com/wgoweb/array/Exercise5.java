package com.wgoweb.ArrayExercise;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/*
* Skapa ett program där användaren först skriver in hur många tal dem ska mata in.
* Sen ska programmet skriva ut talen baklänges och sen i den ordning dem matades in.
* Om användaren skriver in 1 4 3 5 ska programmet skriva ut 5 3 4 1 1 4 3 5.
*
* Create a program where the user first enters how many numbers they should enter.
* Then the program should print the numbers backwards and then in the order they were entered.
* If the user enters 1 4 3 5, the program should print 5 3 4 1 1 4 3 5.
*
* */
public class Exercise5 {

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
    // input amount of input number [N]
    System.out.print("many numbers you want to enter : ");
    int amountNumber = input.nextInt();

    // set array size = N
    int[] inputNumbers = new int[amountNumber];

    // Check if input N > 0
    if (amountNumber > 0) {
      // input N numbers
      for (int i=0; i< amountNumber; i++) {
        System.out.print("Input number "+ (i+1) +" : ");
        inputNumbers[i] = input.nextInt();
      }

      //Source number min -> max  and max -> min
      int[] minToMax = sortMinToMax(inputNumbers);
      int[] maxToMin = sortMaxToMin(inputNumbers);

      // add 2 arrays together
      int[] combineArray = combinedArray(maxToMin, minToMax);
      // print out result
      System.out.println("\ninput numbers :  " + Arrays.toString(inputNumbers));
      System.out.println("input order :  " + Arrays.toString(combineArray));

    } else {
      // print out warning !!
      System.out.print("Amount of number must be more than 0");
    }
  }

  /*
  * After use Arrays.sort, we need to copy to the new array before return back
  * if we don't do it program will return the original array
  * */
  static int[] sortMinToMax(int[] numbers){
    int[] soredNumbers = new int[numbers.length];
    Arrays.sort(numbers);
    System.arraycopy(numbers, 0, soredNumbers, 0, numbers.length);
    return soredNumbers;
  }


  /* Solution 1 : Sort Min to Max with array */
  static int[] sortMaxToMin(int[] numbers) {
    // Solution 1
    int[] soredNumbers = new int[numbers.length];

    for (int i = 0; i < numbers.length - 1; i++) {
      for (int j = 0; j < numbers.length - 1 - i; j++) {
        if (numbers[j] < numbers[j + 1]) {
          // Swap the elements
          int temp = numbers[j];
          numbers[j] = numbers[j + 1];
          numbers[j + 1] = temp;
        }
      }
    }

    return numbers;
  }

  /*Solution 2: Sort Max to min with copy one by one
   * */
  static int[] sortMaxToMinV3(int[] numbers){
    Arrays.sort(numbers);

    int[] soredNumbers = new int[numbers.length];

    for (int i=0; i<numbers.length; i++) {
      soredNumbers[i] = numbers[(numbers.length - i) - 1];
    }
    return soredNumbers;
  }

  static int[] combinedArray(int[] array1, int[] array2) {

    int[] combinedArray = new int[array1.length + array2.length];

    // Copy elements from array1 to combinedArray
    System.arraycopy(array1, 0, combinedArray, 0, array1.length);

    // Copy elements from array2 to combinedArray
    System.arraycopy(array2, 0, combinedArray, array1.length, array2.length);

    return combinedArray;
  }



}
