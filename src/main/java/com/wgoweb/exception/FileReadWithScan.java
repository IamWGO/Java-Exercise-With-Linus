package com.wgoweb.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReadWithScan {
  public static void main(String[] args) throws FileNotFoundException {
    style1();
    //style2();
    //style3();
  }

  static void style1(){
    String filename = "src/ContentFile.text";
    try (Scanner contentLines  = new Scanner(new File(filename))) {
      while (contentLines.hasNextLine()) {
        String rad = contentLines.nextLine();
        System.out.println(rad);
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found " + ex);
    }
  }

  static void style2(){
    String filename = "src/ContentFile.text";
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

  static void style3(){
    String filename = "src/ContentFile.text";
    Scanner contentLines = null;
    try {
      contentLines  = new Scanner(new File(filename));

    } catch (FileNotFoundException ex) {
      System.out.println("File not found " + ex);
    }

    if (contentLines != null) {
      while (contentLines.hasNextLine()) {
        String rad = contentLines.nextLine();
        System.out.println(rad);
      }
    }

  }
}
