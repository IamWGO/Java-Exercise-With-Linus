package com.wgoweb.readAndWriteFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Del1Ingredients {

  String filepath;
  public Del1Ingredients(String filepath) {
    this.filepath = filepath;
  }

  // ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
  //1. Get ingredients
  public void getIngredients(){
    System.out.println(":::::::::::::::::::: Ingredients :::::::::::::::::::");
    String filename = filepath + "ingredients.txt";
    Scanner contentLines;
    try {
      contentLines  = new Scanner(new File(filename));
      while (contentLines.hasNextLine()) {
        String rad = contentLines.nextLine();
        System.out.println(rad);
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found " + ex);
    }
  }
}
