package com.wgoweb.loop;

/**
 *
 3.Skriv ett program som skriver ut alla ojämna tal mellan 0 - 20.
 * */

public class Exercise3 {

  public static void main(String[] args) {
    for (int i=0; i<=20; i++) {
      if (i%2==0) System.out.println("Odd number : " + i);
    }
  }
}
