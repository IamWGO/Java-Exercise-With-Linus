package com.wgoweb.mathExercise;

/**
 * 2. Skriv ett program som räknar ut hypotenusan på en rätvinklig triangel.*/
public class Exercise2 {
  public static void main(String[] args) {
    double base = 3;
    double height = 5;
    System.out.println("2) räknar ut hypotenusan på en rätvinklig triangel "
            //" (½ × "+ base +" × " + height + ") : "
            + " base > "+ base +" height > " + height + ") : "
            + hypotenuseOfRightTriangle(base, height));
  }

  //https://www.omnicalculator.com/math/right-triangle#:~:text=The%20hypotenuse%20is%20opposite%20the,%E2%88%9A(b%C2%B2%2Ba%C2%B2)%20.
  static double hypotenuseOfRightTriangle(Double base, Double height) {
    //area = ½ × base × height.
    // return  1.5 * base * height;

    return Math.sqrt(Math.pow(base, 2) + Math.pow(height,2));
  }
}
