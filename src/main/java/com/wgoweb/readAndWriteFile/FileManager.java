package com.wgoweb.readAndWriteFile;

import java.util.Scanner;

public class FileManager {
  Scanner scan = new Scanner(System.in);
  String filepath = "src/main/java/com/wgoweb/readAndWriteFile/source/";

  // ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
  // Main Menu
  public void menu(){
    boolean run = true;
    while (run) {
      printMenu();
      String choice = scan.nextLine();
      System.out.println();

      // toUpperCase to check Q command
      switch (choice.toUpperCase()) {
        case "1" -> {
          Del1Ingredients del1 = new Del1Ingredients(filepath);
          del1.getIngredients();
        }
        case "2" -> {
          Del2Films del2 = new Del2Films(filepath);
          del2.getMovies();
        }
        case "3" -> {
          Del3Lyrics del3 = new Del3Lyrics(filepath);
          del3.writeSentenceFromSpecificWord();
        }
        case "4" -> {
          Del4Employee del4 = new Del4Employee(filepath);
          del4.searchEmployee();
        }
        case "Q" -> {
          System.out.println("Exit Program :)");
          run = false; // quit while loop
        }
        default -> System.out.println("Input number 1-4 or Q to exit program");
      }
    }

  }

  void printMenu(){
    System.out.print("""

             :::::::::::::::::::: File Manager :::::::::::::::::::
              1. Get ingredients
              2. Get Movies (get every 3rd movie title)
              3. Write example sentence from a specific word in lyrics
              4. Get Employee detail
              
              Q. Exit Program
              :::::::::::::::::::::::::::::::::::::::::::::::::::::::
             Select :\s""");
  }
}
