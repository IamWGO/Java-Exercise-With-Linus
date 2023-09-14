package com.wgoweb.switchCase;

import java.util.Scanner;

public class Exercise1 {
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println(" \n -- Start Program --");

    int exitProgram;

    do {
      // input numbers
      System.out.print("Input number1  -> ");
      int number1 = input.nextInt();

      System.out.print("Input number2  -> ");
      int number2 = input.nextInt();

      // Print help commands
      helpOperation();

      // Check if is correct
      boolean isCorrectCommand;
      int operation;
      do {
        System.out.print("Input operation  -> ");
        operation = input.nextInt();
        isCorrectCommand = (operation >= 1 && operation <= 6) || operation == 0;

        // if not correct print help
        if (!isCorrectCommand) {
          System.out.print(" \n ------ \n Wrong format \n");
          helpOperation();
        }

      } while (!isCorrectCommand);

      // Check if exit program
      if (operation == 0) {
        exitProgram = operation;
      } else {
        // get answer
        System.out.print("\n-------Answer--------\n"
                + number1 + "  " + getSign(operation) + " " + number2
                + " = " + getAnswer(number1, number2, operation)
                + "\n-------Answer--------\n"
        );

        // ask if wanted to exit
        System.out.print("\n Press 0  or any number to continue");
        exitProgram = input.nextInt();
      }

      if (exitProgram == 0) {
        System.out.println("--- Exit ---");
      }

      // Do again if exitProgram != 0
    } while (exitProgram != 0);

  }

  static void helpOperation(){
    System.out.println(
            "[1] Addera"
                    + "[2] Subtrahera "
                    + "[3] Multiplicera "
                    + "[4] Dividera "
                    + "[5] Roten ur "
                    + "[6] Upphöjt till "
                    + "[0] Stäng av "
    );
  }

  static String getSign(int operation) {
    return switch (operation) {
      case 1 -> "+";
      case 2 -> "-";
      case 3 -> "*";
      case 4 -> "/";
      case 5 -> "%";
      case 6 -> "^";
      default -> throw new IllegalStateException("Unexpected value: " + operation);
    };
  }

  static int getAnswer(int number1, int number2, int operation){
    return switch (operation) {
      case 1 -> number1 + number2;
      case 2 -> number1 - number2;
      case 3 -> number1 * number2;
      case 4 -> number1 / number2;
      case 5 -> number1 % number2;
      case 6 -> (int) Math.pow(number1, number2);
      default -> throw new IllegalStateException("Unexpected value: " + operation);
    };
  }
}
