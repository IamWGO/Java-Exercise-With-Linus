package com.wgoweb.readAndWriteFile;

import com.wgoweb.todoList.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileManager {
  Scanner scan = new Scanner(System.in);
  String filepath = "src/main/java/com/wgoweb/readAndWriteFile/source/";
  public void menu(){
    boolean run = true;
    while (run) {
      printMenu();
      String choice = scan.nextLine();
      System.out.println();

      // toUpperCase to check Q command
      switch (choice.toUpperCase()) {
        case "1" -> getIngredients();
        case "2" -> getMovies();
        case "3" -> writeSentenceFromSpecificWord();
        case "4" -> searchEmployee();
        case "Q" -> {
          System.out.println("Exit Program :)");
          run = false; // quit while loop
        }
        default -> System.out.println("Input number 1-4 or Q to exit program");
      }
    }

  }

  // ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
  //1. Get ingredients
  private void getIngredients(){
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

  // ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
  // 2. Get Movies (get every 3rd movie title)
  private void getMovies(){
    System.out.println(":::::::::::::::::::: Get Movie every 3rd in the list :::::::::::::::::::");
    String filename = filepath + "films.txt";
    Scanner contentLines;
    try {
      contentLines  = new Scanner(new File(filename));
      int loop = 0;
      while (contentLines.hasNextLine()) {
        String rad = contentLines.nextLine();
        if (++loop%3 == 0) System.out.println(loop + "-" + rad);
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found " + ex);
    }

  }

  // ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
  //3. Write example sentence from a specific word in lyrics
  ArrayList<SpecificWord> specificWords = new ArrayList<>();
  private void writeSentenceFromSpecificWord(){
    // Save words to ArrayList
    getLyricsFromTextFile();

    // Sort the ArrayList in ascending order
    SpecificWord.OutPut.printHeader();
    for (int i = 0; i < specificWords.size(); i++) {
      SpecificWord.OutPut.printWord(i, specificWords.get(i));
    }

    SpecificWord.OutPut.printDashLine();

    while (true) {
      // random a word
      int randomIndex = randomNumber(0, specificWords.size() -1);
      String randomWord = specificWords.get(randomIndex).getWord();
      System.out.println(
              "Q - Go back or\n" +
              "Use \""+ randomWord +"\" write your own text");

      System.out.print("Your Text: ");
      String inputString = scan.nextLine();

      // quit while loop if user type q
      if(inputString.equalsIgnoreCase("q")){
        break; // exit search
      }

      if (getIsTextContainSpecificWord(inputString, randomWord)) {
        System.out.println(" >> You use \""+ randomWord +"\" in your text.");
      } else {
        System.out.println(" >> The \""+ randomWord +"\" is not contain in your text.");
      }

      SpecificWord.OutPut.printDashLine();

    }

  }

  private boolean getIsTextContainSpecificWord(String inputText, String randomWord) {
    // Remove all special characters and numbers using a regular expression
    String cleanedString = inputText.replaceAll("[^a-zA-Z\\s]", "");
    String[] words = cleanedString.split(" ");
    for (int i = 0; i < words.length; i++) {
      if (words[i].equalsIgnoreCase(randomWord)) {
        return true;
      }
    }
    return  false;
  }

  static int randomNumber(int min, int max) {
    int range = max - min + 1;
    return  (int)(Math.random() * range) + min;
  }


  private void getLyricsFromTextFile(){
    String filename = filepath + "lyrics.txt";
    Scanner contentLines;
    try {
      contentLines  = new Scanner(new File(filename));
      while (contentLines.hasNextLine()) {
        String contentLine = contentLines.nextLine();
        setCountSpecificWord(contentLine);
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found " + ex);
    }
  }
  private void setCountSpecificWord(String contentLine){
    // Remove all special characters and numbers using a regular expression
    String cleanedString = contentLine.replaceAll("[^a-zA-Z\\s]", "");

    String[] words = cleanedString.split(" ");

    for (int i = 0; i < words.length; i++) {
      boolean isContain = false;
      String currentWord = words[i];

      if (currentWord.length() == 1 || currentWord.isEmpty()) continue;

      if (specificWords != null) {
        for (int j = 0; j < specificWords.size(); j++) {
          if (currentWord.equalsIgnoreCase(specificWords.get(j).word)) {
            specificWords.get(j).setCount();
            isContain = true;
            break;
          }
        }
      }

      if (!isContain) {
        assert specificWords != null;
        specificWords.add(new SpecificWord(currentWord));
      }

    }

    //if (specificWords.isEmpty())

  }

  // ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
  //4. Get Employee detail
  // For a real project, We could move employees variable to the top of the class
  // easier to read if I keep it here.
  ArrayList<Employee> employees  = new ArrayList<>();
  private void searchEmployee(){
    getEmployeeFromTextFile(); //employees
    printAllEmployee();
    searchEmployeeByName();
  }

  private void printAllEmployee(){
    Employee.OutPut.printHeadLine();
    if (employees.isEmpty()) {
      Employee.OutPut.printEmptyRecord();
    } else {
      for (Employee employee : employees) {
        Employee.OutPut.printTaskRow(employee);
      }
      //  for (int i = 0; i < employees.size(); i++) {
      //     Employee.OutPut.printTaskRow(employees.get(i));
      //  }
      Employee.OutPut.printDashLine();
    }

  }

  private void searchEmployeeByName(){
    while (true) {
      // quit while loop if it has no task
      if (employees.isEmpty()) break;

      System.out.println(
              "Q - Go back\n" +
                      ":: Search employee by first name :: " );
      System.out.print("First name: ");
      String inputString = scan.nextLine();

      // quit while loop if user type q
      if(inputString.equalsIgnoreCase("q")){
        break; // exit search
      }

      //Style 1: inputString uppercase contains
      ArrayList<Employee> foundEmployees  = new ArrayList<>();
      for (int i = 0; i < employees.size(); i++) {
        boolean isContain = employees.get(i).getFirstName().toUpperCase().contains(inputString.toUpperCase());
        if (isContain) {
          foundEmployees.add(employees.get(i));
        }
      }

      if (foundEmployees.isEmpty()) {
        Employee.OutPut.printNotFoundEmployee(inputString);
        continue; // next search
      }

      if (foundEmployees.size() == 1) {
        Employee.OutPut.printEmployeeDetail(foundEmployees.get(0));
      } else {
        Employee.OutPut.printHeadLine();
        for (Employee employee : foundEmployees) {
          Employee.OutPut.printTaskRow(employee);
        }
        Employee.OutPut.printDashLine();
      }

      // Style 2: inputString equal
//      boolean isFound = false;
//      for (int i = 0; i < employees.size(); i++) {
//        boolean isContain = inputString.equalsIgnoreCase(employees.get(i).getFirstName());
//        if (isContain) {
//          Employee.OutPut.printEmployeeDetail(employees.get(i));
//          isFound = true;
//          break;
//        }
//      }
//
//      if (!isFound) Employee.OutPut.notFoundEmployee(inputString);

    }

  }

  private void getEmployeeFromTextFile(){
    String filename = filepath + "employees.txt";
    Scanner contentLines;
    try {
      contentLines  = new Scanner(new File(filename));
      while (contentLines.hasNextLine()) {
        String contentLine = contentLines.nextLine();
        saveEmployeeToArrayList(contentLine);
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found " + ex);
    }
  }

  private void saveEmployeeToArrayList(String contentLines) {
    //Paul,Whitehouse,0992 1256347,Voice Designer,Paul.Whitehouse@ubisoft.com
    String[] parts = contentLines.split(",");
    try {
      // Extract the values from the split parts and create a Dog object
      String firstName = parts[0];
      String lastName = parts[1];
      String id = parts[2];
      String position = parts[3];
      String email = parts[4];

      Employee newEmployee = new Employee(firstName, lastName, id, position, email);
      employees.add(newEmployee);

    } catch (IllegalStateException ex) {
      System.out.println("Invalid input string. Expected 8 fields." + ex);
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

/*
* private void removeByTitle(){
    printAllTask();
    System.out.println("Q - Go back\n" +
            "Which title do you want to remove? (ex: Do Homework , you could put only 'homework')");
    System.out.print("Input title: ");
    String searchString = scan.nextLine();

    boolean isDelete = false;

    for (int i = 0; i < taskList.size(); i++) {
      // I choose uppercase contains instead of equal
      boolean isContain = taskList.get(i).getTitle().toUpperCase().contains(searchString.toUpperCase());

      if (isContain) {
        String removingTitle = taskList.get(i).getTitle();
         // remove record
        taskList.remove(i);
        printAllTask();
        isDelete = true;
        System.out.println(" :: Record \""+ removingTitle +"\" is removed :: ");
        break; // Stop searching once found
      }
    }

    if (!isDelete) System.out.println("Waring: No \""+ searchString+"\" in Task List !");

  }*/