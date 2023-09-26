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
            +  adminColor.background);
    Color orderColor = new OrderColor();


    // Order Theme
    System.out.println(orderColor.text
            + "Order theme"
            +  orderColor.background);
    Color productColor = new ProductColor();

    // Product Theme
    System.out.println(productColor.text
            + "Order theme"
            +  productColor.background);
  }
}
