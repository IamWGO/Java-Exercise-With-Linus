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
      // print main menu
      Member.OutPut.printMenu();
      // select menu
      String choice = scan.nextLine();
      System.out.println();

      // toUpperCase to check Q command
      switch (choice.toUpperCase()) {
        case "1" -> printAllItems();
        case "2" -> insertNewItem();
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

  private void printAllItems(){
    Member.OutPut.printHeadLine();
    if (members.isEmpty()) {
      Member.OutPut.set.printEmptyItem();
    } else {
      // print all items
      for (int i = 0; i < members.size(); i++) {
        Member.OutPut.printRow(i, members.get(i));
      }
      Member.OutPut.set.printEndOfList();
    }

  }
  private void insertNewItem(){
    // Clear value
    String firstName = "";
    String lastName = "";

    boolean run = true;
    while (run) {
      // print menu
       Member.OutPut.printInsertUpdateMenu(true, firstName, lastName);

      String choiceString = scan.nextLine();
      // use toUpperCase to Q command
      switch (choiceString.toUpperCase()) {
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

          Member.OutPut.set.printInfo("> \""+ firstName +"\" \"" + lastName + "\" is saved !! ");

          // clear value and show ADD MENU again
          firstName = "";
          lastName = "";
        }
        case "Q" -> run = false; // exit while loop
        default -> Member.OutPut.set.printInfo("Input number 1-4 or Q.");
      }
    }

  }
  private void updateById(){
    // Print All items
    printAllItems();

    while (true) {
      try {
        // Input number or Q
        System.out.println(
                "Q - Go back | "
                + "Which one do you want to update ?");
        System.out.print("Select Index: ");
        String choiceString = scan.nextLine();

        // quit while loop if user type q
        if(choiceString.equalsIgnoreCase("q")){
          break;
        }

        // check if inputChoice is number and in ArrayList Range
        // will return -1 if no item
        int selectedIndex = searchItemByIndex(choiceString);

        // if not found then ask to input a number or Q
        if (selectedIndex == -1){
          System.out.println(
                  Member.OutPut.set.color.warningText
                  + "Not found item - "
                  + Member.OutPut.set.color.reset);
          continue;
        }

        // if found item then get data by index
        Member selectedMember = members.get(selectedIndex);
        // update data
        doUpdate(selectedMember);
        // print success message
        Member.OutPut.printSuccessUpdate(selectedMember);

        printAllItems();

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
      // print Menu
      Member.OutPut.printInsertUpdateMenu(false, firstName, lastName);

      String choiceString = scan.nextLine();
      // use toUpperCase to Q command
      switch (choiceString.toUpperCase()) {
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
        default -> Member.OutPut.set.printInfo("Input number 1-4 or Q.");
      }
    }
  }
  private void deleteById(){
    printAllItems();

    while (true) {
      try {

        System.out.println("Q - Go back |" +
                "Which one do you want to remove ?");
        System.out.print("Select Index: ");

        String choiceString = scan.nextLine();

        // quit while loop if user type q
        if(choiceString.equalsIgnoreCase("q")){
          break;
        }

        // check if inputChoice is number and in ArrayList Range
        // will return -1 if no item
        int selectedIndex = searchItemByIndex(choiceString);

        if (selectedIndex == -1){
          System.out.println(
                  Member.OutPut.set.color.warningText
                  + "Not found item - "
                  + Member.OutPut.set.color.reset
                  + "enter any key to continue ");
          continue;
        }

        // get member info before delete
        Member selectedItem = members.get(selectedIndex);
        // remove Item
        members.remove(selectedIndex);
        // Rewrite file because we remove an item form ArrayList
        doRewriteContent();
        // print success delete
        Member.OutPut.printSuccessDelete(selectedItem);
        // print all items
        printAllItems();

        break;

      } catch (InputMismatchException ex) {
        Member.OutPut.set.printInfo(" Input number from 1 - " + members.size() + ".");
        scan.next();
      }
    }
  }

  private void doRewriteContent(){
    // do nothing, if members is empty
    //if (members.isEmpty()) { return; }

    // get the content from ArrayList
    String contentLines = "";
    for (int i = 0; i < members.size(); i++) {
      contentLines = contentLines.concat(members.get(i).objectToLineFormat()
                      + ((i < (members.size()-1)) ? "\n": ""));
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
      Member.OutPut.set.printWarning("An error occurred." + ex);
    }
  }

  /* We use write BufferedWriter */
  //TODO: fix empty line created when delete all  : might have to change write file library
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
      Member.OutPut.set.printWarning("An error occurred while adding a line to the file.");
    }
  }

  private void getDataFromTextFile(){
    Scanner contentLines;
    try {
      contentLines  = new Scanner(new File(filename));
      while (contentLines.hasNextLine()) {
        String contentLine = contentLines.nextLine();
        // ignore if empty line
        if (!contentLine.isEmpty()) saveContentLineToArrayList(contentLine);
      }
    } catch (FileNotFoundException ex) {
      Member.OutPut.set.printWarning("File not found " + ex);
    }
  }

  private void saveContentLineToArrayList(String contentLine) {
    String[] parts = contentLine.split(",");
    try {
      String firstName = parts[0];
      String lastName = parts[1];

      Member newMember = new Member(firstName, lastName);
      members.add(newMember);
    } catch (IllegalStateException ex) {  // Skip
      Member.OutPut.set.printWarning("Invalid input string. Expected 2 fields." + ex);
    }
  }

  private int searchItemByIndex(String inputString){
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
}
