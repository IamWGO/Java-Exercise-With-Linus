package com.wgoweb.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadWithBufferedReader {
  public static void main(String[] args) {
    //style1();
    //style2();
    style3();
  }

  static void style1() {
    String filename = "src/ContentFile.text";
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
      String inputLine;
      while((inputLine = reader.readLine()) != null) {
        System.out.println("Content : " + inputLine);
      }

    } catch(FileNotFoundException ex) {
      System.out.println("File not found: " + filename);
    } catch(IOException ex) {
      System.out.println("Error - " + ex.getMessage());
    } catch(Exception ex) {
      System.out.println("Error processing file - " + ex.getMessage());
    }
  }

  static void style2(){
    String filename = "src/ContentFile.text";
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(filename));
      String inputLine;
      while((inputLine = reader.readLine()) != null) {
        System.out.println("Content : " + inputLine);
      }
    } catch(FileNotFoundException ex) {
      System.out.println("File not found: " + filename);
    } catch(IOException ex) {
      System.out.println("Error - " + ex.getMessage());
    } catch(Exception ex) {
      System.out.println("Error processing file - " + ex.getMessage());
    }
  }

  static void style3()   {
    String filename = "src/ContentFile.text";
    BufferedReader reader = null;
    // check file
    try {
      reader = new BufferedReader(new FileReader(filename));
    } catch(FileNotFoundException ex) {
      System.out.println("File not found: " + filename);
    }

    // read file
    if (reader != null) {
      String inputLine;
      try {
        while((inputLine = reader.readLine()) != null) {
          System.out.println("Content : " + inputLine);
        }
      } catch(IOException ex) {
        System.out.println("Error - " + ex.getMessage());
      }
    }

  }
}