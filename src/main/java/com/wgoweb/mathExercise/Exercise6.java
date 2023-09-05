package com.wgoweb.mathExercise;

/**
 * 6. Skriv ett program som räknar ut volymen på en kub.*/
public class Exercise6 {
  public static void main(String[] args) {
    int cube = 3;
    System.out.println("6) räknar ut volymen på en kub ["+ cube +"]  : " +
            volumeOfCube(cube));
  }

  //https://tutors.com/lesson/volume-of-a-cube
  static int volumeOfCube(int a) {
    // a x a x a
    return (int) Math.pow(a, 3);
  }
}
