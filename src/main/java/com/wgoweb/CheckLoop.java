package com.wgoweb;

import java.util.Objects;
import java.util.Scanner;

public class CheckLoop {
  static final Scanner input = new Scanner(System.in);
  public static void main(String[] args) {
    do {
      // Start game
      runJob();
      // Ask if you want to continue ....
      System.out.print("\n\n==== Do you want to exit ==== \n  [0]  to exit , [any key]  to continue -> ");
      String command = input.next();

      if (Objects.equals(command, "0")) break;

    } while (true);

    System.out.println("\n **** Program is ended *** ");
  }

  static void runJob(){
    System.out.println("= Start Game =");
    // input amount of input number [N]
    System.out.print("many numbers you want to enter : ");
    int amountNumber = input.nextInt();

    System.out.println("\n **** Number :  "+ amountNumber +"*** ");
  }
}
