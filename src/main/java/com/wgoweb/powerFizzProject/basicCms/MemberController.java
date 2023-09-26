package com.wgoweb.powerFizzProject.basicCms;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class MemberController {
  Scanner scan = new Scanner(System.in);
  ArrayList<Member> members = new ArrayList<>();
  String filename = "src/main/java/com/wgoweb/powerFizzProject/basicCms/MemberFile.txt";
  public void menu(){
    // GET CONTENT FROM FILE
    getContentFromFile();

    boolean run = true;
    while (run) {
      printMenu();
      String choice = scan.nextLine();
      System.out.println();

      // toUpperCase to check Q command
      switch (choice.toUpperCase()) {
        case "1" -> printAllRecords();
        case "2" -> newRecord();
        case "3" -> updateById();
        case "4" -> deleteById();
        case "Q" -> {
          System.out.println("Exit Program :)");
          run = false; // quit while loop
        }
        default -> System.out.println("Input number 1-4 or Q to exit program");
      }
    }

  }

  private void printAllRecords(){
    Member.OutPut.printHeadLine();
    if (members.isEmpty()) {
      Member.OutPut.printEmptyRecord();
    } else {
      for (int i = 0; i < members.size(); i++) {
        Member.OutPut.printRow(i, members.get(i));
      }
      Member.OutPut.printEndOfList();
    }

  }
  private void newRecord(){
    // Clear value
    String firstName = "";
    String lastName = "";

    boolean run = true;
    while (run) {
      System.out.print(":::::: NEW Member ::::::" +
              "\n1. First Name       - " + firstName +
              "\n2. Last Name - " + lastName +
              "\n3. Save" +
              "\nQ. Go back" +
              "\n\n Select choice : ");
      String inputString = scan.nextLine();
      // use toUpperCase to Q command
      switch (inputString.toUpperCase()) {
        case "1" -> {
          System.out.print("First Name: ");
          firstName = scan.nextLine();
        }
      case "2" -> {
        System.out.print("Last Name: ");
        lastName = scan.nextLine();
      }
        case "3" -> {
          // add to arrayList
          Member newMember = new Member(firstName, lastName);
          members.add(newMember);

          // save task to textFile ex. Lee,Gottlieb
          String inputLine = newMember.objectToLineFormat();
          //isRewrite=false -> to add the new line
          writeToFile(inputLine, false);

          System.out.println("> \""+ firstName +"\" \"" + lastName + "\" is saved !! ");

          // clear value and show ADD MENU again
          firstName = "";
          lastName = "";
        }
        case "Q" -> run = false; // exit while loop
        default -> System.out.println("Input number 1-4 or Q.");
      }
    }

  }
  private void updateById(){
    while (true) {
      try {
        // Print All Records
        printAllRecords();
        // Input number or Q
        System.out.println("Q - Go back\n" +
                "Which one do you want to update ?");
        System.out.print("Select Index: ");
        String inputChoice = scan.nextLine();

        // quit while loop if user type q
        if(inputChoice.equalsIgnoreCase("q")){
          break;
        }

        // check if inputChoice is number and in ArrayList Range
        // will return -1 if no record
        int selectedIndex = searchRecordByIndex(inputChoice);

        // if not found then ask to input a number or Q
        if (selectedIndex == -1){
          System.out.print("Not found recode - Select Index: ");
          scan.nextLine();
          continue;
        }

        // if found record then get data by index
        Member selectedMember = members.get(selectedIndex);
        // update data
        doUpdate(selectedMember);

        System.out.println(" :: Record \""+ selectedMember.getMemberInfo() +"\" is Updated :: ");

        printAllRecords();

        break;

      } catch (InputMismatchException ex) {
        System.out.println(" Input number from 1 - " + members.size() + ".");
        scan.next();
      }
    }
  }

  private void doUpdate(Member selectedMember){
    String firstName = selectedMember.firstName;
    String lastName = selectedMember.lastName;

    boolean run = true;
    while (run) {
      System.out.print(":::::: Update Member ::::::" +
              "\n1. First Name       - " + firstName +
              "\n2. Last Name - " + lastName +
              "\n3. Update" +
              "\nQ. Go back" +
              "\n\n Select choice : ");
      String inputString = scan.nextLine();
      // use toUpperCase to Q command
      switch (inputString.toUpperCase()) {
        case "1" -> {
          System.out.print("First Name: ");
          firstName = scan.nextLine();
        }
        case "2" -> {
          System.out.print("Last Name: ");
          lastName = scan.nextLine();
        }
        case "3" -> {
          // update fields in ArrayList
          selectedMember.setFirstName(firstName);
          selectedMember.setLastName(lastName);

          // Rewrite file because we update some row in the file
          doRewriteContent();
          // exit while loop
          run = false;
        }
        case "Q" -> run = false; // exit while loop
        default -> System.out.println("Input number 1-4 or Q.");
      }
    }
  }
  private void deleteById(){

    while (true) {
      try {
        printAllRecords();
        System.out.println("Q - Go back\n" +
                "Which one do you want to remove ?");
        System.out.print("Select Index: ");

        String inputString = scan.nextLine();

        // quit while loop if user type q
        if(inputString.equalsIgnoreCase("q")){
          break;
        }

        // check if inputChoice is number and in ArrayList Range
        // will return -1 if no record
        int selectedIndex = searchRecordByIndex(inputString);

        if (selectedIndex == -1){
          //System.out.println("(-_-\")Not found recode !!");
          System.out.print("Select Index: ");
          scan.nextLine();
          continue;
        }

        // get member info before delete
        String removingTitle = members.get(selectedIndex).getMemberInfo();
        // remove Item
        members.remove(selectedIndex);
        // Rewrite file because we remove an item form ArrayList
        doRewriteContent();
        System.out.println(" :: Record \""+ removingTitle +"\" is removed :: ");
        printAllRecords();

        break;

      } catch (InputMismatchException ex) {
        System.out.println(" Input number from 1 - " + members.size() + ".");
        scan.next();
      }
    }
  }

  private void doRewriteContent(){
    // do nothing, if members is empty
    if (members.isEmpty()) { return; }

    // get the content from ArrayList
    String contentLines = "";
    for (int i = 0; i < members.size(); i++) {
      contentLines = contentLines.concat(members.get(i).objectToLineFormat() +
              ((i < (members.size()-1)) ? "\n": ""));
    }
    //Rewrite Content
    writeToFile(contentLines, true);

  }

  private void getContentFromFile(){
    try {
      File file = new File(filename);
      if (file.createNewFile()) {
        // Create file with empty string
        FileWriter writer = new FileWriter(file);
        writer.write("");
        writer.close();
      } else {
        // Convert content to ArrayList
        getDataFromTextFile();
      }
    } catch (IOException ex) {
      System.out.println("An error occurred." + ex);
    }
  }

  /* We use write BufferedWriter */
  private void writeToFile(String writeContent, boolean isRewrite){
    try {
      // Create a FileWriter in append mode (true as the second argument)
      FileWriter fileWriter = new FileWriter(filename, !isRewrite);

      // Create a BufferedWriter for efficient writing
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

      // Write the new line to the file
      bufferedWriter.write(writeContent);
      bufferedWriter.newLine(); // Add a newline character

      // Close the BufferedWriter and FileWriter
      bufferedWriter.close();
      fileWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred while adding a line to the file.");
    }
  }

  private void getDataFromTextFile(){
    Scanner contentLines;
    try {
      contentLines  = new Scanner(new File(filename));
      while (contentLines.hasNextLine()) {
        String contentLine = contentLines.nextLine();
        // add EachLine to ArrayList
        saveContentLineToArrayList(contentLine);
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found " + ex);
    }
  }

  private void saveContentLineToArrayList(String contentLine) {
    String[] parts = contentLine.split(",");
    try {
      String firstName = parts[0];
      String lastName = parts[1];

      Member newMember = new Member(firstName, lastName);
      members.add(newMember);
    } catch (ArrayIndexOutOfBoundsException ex) { // Skip if the last item is empty
      System.out.println("Index out of bounds." + ex);
    } catch (IllegalStateException ex) {  // Skip
      System.out.println("Invalid input string. Expected 2 fields." + ex);
    }
  }

  private int searchRecordByIndex(String inputString){
    try {
      int choice = Integer.parseInt(inputString);
      // if choice is not in range then return -1
      if (choice < 0 || choice > (members.size())) {
        return -1;
      }
      // return selected index
      return choice - 1;
    } catch (NumberFormatException ex) {
      // if user input string then return -1
      return  -1;
    }
  }


  private void printMenu(){
    System.out.print("""

             :::::::::::::::::::: MENU :::::::::::::::::::
              1. All records
              2. Insert
              3. Update
              4. Delete
              
              Q. Exit Program
              :::::::::::::::::::::::::::::::::::::::::::::::::::::::
             Select :\s""");
  }
}
