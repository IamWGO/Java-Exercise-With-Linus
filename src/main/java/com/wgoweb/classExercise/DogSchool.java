package com.wgoweb.classExercise;

import java.util.Scanner;

public class DogSchool {
  static Scanner input = new Scanner(System.in);
  static Boolean isContinue = true;
  public static void main(String[] args) {
    runJob();
  }
  static void runJob(){
    do {
      menu();
      doProcess();
    } while (isContinue);
  }

  public static void menu(){
    System.out.println("\n\nLee's Dog School - Menu " +
                    "\n   1. Register" +
                    "\n   2. Check in/ Check out" +
                    "\n   3. All Dogs" +
                    "\n   4. Close program" +
                    "\n   Select : "
            );

  }

  public static void doProcess(){
    String choice = input.nextLine();
    switch (choice) {
      case "1" -> System.out.println("Register !!");
      case "2" -> System.out.println("Check in / Check out !!");
      case "3" -> System.out.println("All dogs !!");
      case "4" -> {
        System.out.println("End program !!");
        isContinue = false;
      }
      default -> System.out.println("Failed !!");
    }
  }
}
