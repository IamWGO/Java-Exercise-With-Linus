package com.wgoweb.powerFizzProject.Colors;


public class Main {
  // Declaring ANSI_RESET so that we can reset the color
  public static final String ANSI_RESET = "\u001B[31m";
  // Declaring the background color
  public static final String ANSI_RED_BACKGROUND
          = "\u001B[41m";

  // Main driver method
  public static void main(String[] args)
  {

    // Admin Theme
    Color adminColor = new AdminColor();
    System.out.println(adminColor.text
            + "Admin theme"
            +  adminColor.reset);
    Color orderColor = new OrderColor();


    // Order Theme
    System.out.println(orderColor.text
            + "Order theme"
            +  orderColor.reset);
    Color productColor = new ProductColor();

    // Product Theme
    System.out.println(productColor.text
            + "Order theme"
            +  productColor.reset);

    System.out.println(productColor.successBackground
            + "Order theme"
            +  productColor.reset);
  }
}
