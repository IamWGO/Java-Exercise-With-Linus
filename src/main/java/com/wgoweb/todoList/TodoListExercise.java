package com.wgoweb.todoList;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
*
* Del 1
Skapa en att göra lista genom att deklarera en variabel med namnet todoList som en tom ArrayList.

  - Skapa en meny som innehåller valen
  - Skriv ut listan
  - Lägg till något i listan
  - Ta bort en sak överst i listan
  - Ta bort en sak längst ner i listan
  - Avsluta programmet
  - Programmet ska köras tills vi väljer att avsluta. Alla andra menyval ska göra det som står.

Del 2
  - Lägg till ett menyval som raderar något i listan baserat på dess index värde
  - Lägg till ett menyval som raderar något i listan baserat på dess namn
  - Skapa en ”har gjort”-lista genom att deklarera en variabel med namnet doneList som en ArrayList.
  - Flytta en sak till toppen i todoList
  - Flytta en sak till botten av todoList

Del 3
  - Flytta en sak ett steg ner i todoList
  - Flytta en sak ett steg upp i todoList
*
* */
public class TodoListExercise {
  Scanner scan = new Scanner(System.in);
  ArrayList<Task> taskList  = new ArrayList<>();
  String filename = "src/main/java/com/wgoweb/todoList/TodoListContent.txt";
  public void run() {
    // GET CONTENT FROM FILE
    getTaskFromFile();

    boolean run = true;
    while (run) {
      printMenu();
      String choice = scan.nextLine();
      System.out.println();

      // toUpperCase to check Q command
      switch (choice.toUpperCase()) {
        case "1" -> printAllTask();
        case "2" -> newTask();
        case "3" -> checkDoneTask();
        case "4" -> moveRecodeToTopOrBottom(true);
        case "5" -> moveRecodeToTopOrBottom(false);
        case "6" -> moveRecodeOneStep(true);
        case "7" -> moveRecodeOneStep(false);
        case "8" -> removeRecodeWithFilter();
        case "9" -> removeFirstOrLast(true);
        case "10" -> removeFirstOrLast(false);
        case "Q" -> {
          System.out.println("Exit Program :)");
          run = false; // quit while loop
        }
        default -> System.out.println("Input number 1-4 or Q to exit program");
      }

    }
  }

  // print all task
  private void printAllTask(){
    Task.output.printHeadLine();
    if (taskList.isEmpty()) {
      System.out.println(Task.output.emptyRecord());
    } else {
      for (int i = 0; i < taskList.size(); i++) {
        Task.output.printTaskRow(i, taskList.get(i));
      }
      System.out.println();
    }
  }

  private void newTask(){

    // Clear value
    String title = "";
    String description = "";
    int hour = 0;
    int minute = 0;
    boolean isDone = false;

    boolean run = true;
    while (run) {
      System.out.print(":::::: NEW TASK ::::::" +
              "\n1. title       - " + title +
              "\n2. description - " + description +
              "\n3. Time        - " + Task.output.getTime(hour, minute) +
              "\n4. Save" +
              "\nQ. Go back" +
              "\n\n Select choice : ");
      String inputString = scan.nextLine();
      // use toUpperCase to Q command
      switch (inputString.toUpperCase()) {
        case "1" -> {
          System.out.print("Title: ");
          title = scan.nextLine();
        }
        case "2" -> {
          System.out.print("Description: ");
          description = scan.nextLine();
        }
        case "3" -> {
          // input only number from 0-23
          hour = inputHour();
          // input number from 0-59
          minute = inputMinute();        }
        case "4" -> {
          // add to list
          Task newTask = new Task(title, description, hour, minute, isDone);
          taskList.add(newTask);

          // save task to textFile
          String inputLine = newTask.objectToLineFormat();
          addLineToTextFile(inputLine);

          System.out.println("> \""+ title +"\" saved !! ");

          // clear value after add to list
          title = "";
          description = "";
          hour = 0;
          minute = 0;

        }
        case "Q" -> run = false; // exit while loop
        default -> System.out.println("Input number 1-4 or Q.");
      }
    }

  }

  private void checkDoneTask(){
    String guideText = "Select number 1-"+ taskList.size() +".";
    System.out.println("::::: CHECK DONE TASK ::::");
    while (true) {
      printAllTask();
      // quit while loop if it has no task
      if (taskList.isEmpty()) break;

      System.out.println(
              "Q - Go back\n" +
                      "Which one do you want to change status ? " );

      System.out.print("Select index : ");
      String inputString = scan.nextLine();

      // quit while loop if user type q
      if(inputString.equalsIgnoreCase("q")){
        break;
      }
      // return -1 if no record
      int selectedIndex = searchTaskByIndex(inputString);

      if (selectedIndex >= 0) {
        this.taskList.get(selectedIndex).setDone();
      } else {
        System.out.println(guideText);
      }

    }
  }

  private void moveRecodeToTopOrBottom(boolean isMoveToTop){
    String guideText = " Input number from 1 - " + taskList.size();
    System.out.println("::::: MOVE MOVE TASK TO " + ((isMoveToTop) ? "THE TOP" : "THE BOTTOM") + " ::::");
    while (true) {
      printAllTask();

      System.out.println(
              "Q - Go back \n" +
                      "Which one do you want to move" + ((isMoveToTop) ? "the top" : "the bottom") + " ? " );
      System.out.print("Select Index: ");
      String inputString = scan.nextLine();

      // quit while loop if user type q
      if(inputString.equalsIgnoreCase("q")){
        break;
      }

      // return -1 if no record
      int selectedIndex = searchTaskByIndex(inputString);

      if (selectedIndex == -1) {
        System.out.println("Not found recode !!");
        System.out.println(guideText);
        continue;
      }

      Task selectedTask = taskList.get(selectedIndex);
      if (isMoveToTop){
        if (selectedIndex == 0) {
          System.out.println("> \""+ selectedTask.getTitle() +"\" already in the top. ");
          continue;
        }

        taskList.remove(selectedIndex);
        taskList.add(0, selectedTask);
        System.out.println("> Moved \""+ selectedTask.getTitle() +"\" to the top. ");

      }  else {
        if (selectedIndex == taskList.size()-1) {
          System.out.println("> \""+ selectedTask.getTitle() +"\" already in the bottom. ");
          continue;
        }

        taskList.remove(selectedIndex);
        taskList.add(selectedTask);
        System.out.println("> Moved \""+ selectedTask.getTitle() +"\" to the bottom. ");
      }

    }
  }

  private void moveRecodeOneStep(boolean isMoveUp) {
    String guideText = " Input number from 1 - " + taskList.size();
    System.out.println("::::: MOVE MOVE TASK ONE STEP " + ((isMoveUp) ? "UP" : "DOWN") + " ::::");
    while (true) {
      printAllTask();
      System.out.println(
              "Q - Go back\n" +
                      "Which one do you want to move " + ((isMoveUp) ? "up" : "down") + " ? " );
      System.out.print("Select Index: ");

      String inputString = scan.nextLine();

      // quit while loop if user type q
      if(inputString.equalsIgnoreCase("q")){
        break;
      }

      // return -1 if no record
      int selectedIndex = searchTaskByIndex(inputString);

      if (selectedIndex == -1){
        System.out.println("Not found recode !!");
        System.out.println(guideText);
        scan.next();
        continue;
      }

      Task selectedTask = taskList.get(selectedIndex);
      if (isMoveUp){
        if (selectedIndex == 0) {
          System.out.println("> \""+ selectedTask.getTitle() +"\" already in first of the list. ");
          continue;
        }

        taskList.remove(selectedIndex);
        taskList.add(selectedIndex -1, selectedTask);
        System.out.println("> Moved \""+ selectedTask.getTitle() +"\" up 1 step. ");

      }
      if (!isMoveUp){
        if (selectedIndex == (taskList.size() -1)) {
          System.out.println("> \""+ selectedTask.getTitle() +"\" already in last of the list. ");
          continue;
        }

        taskList.remove(selectedIndex);
        taskList.add(selectedIndex + 1 ,selectedTask);
        System.out.println("> Moved \""+ selectedTask.getTitle() +"\" down 1 step. ");
      }
    }
  }

  private void removeRecodeWithFilter(){
    boolean run = true;
    while (run) {
      System.out.println("""
              
              ::::: REMOVE RECORD MENU ::::
              1. Remove by index
              2. Remove by name
              Q. Go back
               \s""");
      System.out.print(" Select Choice : " );
      String inputString = scan.nextLine();
      // use toUpperCase to Q command
      switch (inputString.toUpperCase()) {
        case "1" -> removeByIndex();
        case "2" -> removeByTitle();
        case "Q" -> run = false; // exit while loop
        default -> System.out.println("Input number 1, 2 or Q.");
      }
    }

  }

  private void removeFirstOrLast(boolean isFirstList){

    System.out.println(":::::  REMOVE " + ((isFirstList) ? "FIRST" : "LAST") + " ITEM IN THE LIST ::::");

    while (true) {
      int index = (isFirstList) ? 0 : taskList.size() -1;
      String removingTitle = taskList.get(index).getTitle();
      printAllTask();
      // quit while loop if it has no task
      if (taskList.isEmpty()) break;

      System.out.print(
              "Q - Go back\n" +
              "The " + ((isFirstList) ? "first" : "last") +
              " item is \""+ removingTitle +"\".\n Input any key to delete : ");
      String inputString = scan.nextLine();

      // quit while loop if user type q
      if (inputString.equalsIgnoreCase("q")) {
        break;
      }
      taskList.remove(index);
      System.out.println("> Record \""+ removingTitle +"\" is removed");
    }
  }


// -----------------------------

  private int searchTaskByIndex(String inputString){
    try {
      int choice = Integer.parseInt(inputString);
      // check if index is in range
      if (choice < 0 || choice > (taskList.size())) {
        return  -1;
      }
      // now we get selected task , exit loop
      return choice -1;

    } catch (InputMismatchException ex) {
      return  -1;
    }
  }

  private void removeByIndex(){
    String guideText = " Input number from 1 - " + taskList.size() + ".";

    while (true) {
      try {
        printAllTask();
        System.out.println("Q - Go back\n" +
                "Which one do you want to remove ?");
        System.out.print("Select Index: ");

        String inputString = scan.nextLine();

        // quit while loop if user type q
        if(inputString.equalsIgnoreCase("q")){
          break;
        }

        // return -1 if no record
        int selectedIndex = searchTaskByIndex(inputString);

        if (selectedIndex == -1){
          System.out.println("Not found recode !!");
          System.out.println(guideText);
          scan.next();
          continue;
        }

        String removingTitle = taskList.get(selectedIndex).getTitle();
        // remove record
        taskList.remove(selectedIndex);
        printAllTask();
        System.out.println(" :: Record \""+ removingTitle +"\" is removed :: ");

        break;

      } catch (InputMismatchException ex) {
        System.out.println(guideText);
        scan.next();
      }
    }

  }

  private void removeByTitle(){
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

  }

  private void getTaskFromFile(){
    try {
      File file = new File(filename);
      if (file.createNewFile()) {
        // Create file TodoListContent.txt and write content
        FileWriter writer = new FileWriter(file);
        writer.write(getFirstContent());
        writer.close();
        System.out.println("Content written to the file.");
      } else {
        //"File already exists."
        // Style 1 * not recommend
        //readWithFileInputStream(filename);
        // style 2
        //readWithScanner(filename);
        // Style 3
        readWithBufferedReader(filename);
      }
    } catch (IOException ex) {
      System.out.println("An error occurred." + ex);
    }

  }

  private void saveTodoList(String contentLine) {
    //split contentLine : 0,Exercise,Go for a 30-minute jog in the park,07:00
    String[] parts = contentLine.split(",");
    try {
      // Extract the values from the split parts and create a Dog object
      String title = parts[0];
      String description = parts[1];
      String time = parts[2];
      String isDoneFlag = parts[3];

      boolean isDone = (isDoneFlag.equals("1"));
      // split hour and minute 07:00
      String[] times = time.split(":");
      int hour = Integer.parseInt(times[0]);
      int minute = Integer.parseInt(times[1]);

      Task newTask = new Task(title, description, hour, minute, isDone);
      taskList.add(newTask);

    } catch (NumberFormatException ex) {
      System.out.println(parts[0] + " > Invalid format" + ex);
    } catch (IllegalStateException ex) {
      System.out.println("Invalid input string. Expected 8 fields." + ex);
    }
  }

  /*
  Both FileOutputStream and FileWriter can be used to write to a text file in Java,
   but FileWriter is specifically designed for writing character data to text files,
   so it's generally a better choice for working with text files.
   It abstracts away some of the lower-level details, such as character encoding,
   making it easier to work with text.
  * Simplicity: FileWriter provides a higher-level, more user-friendly API for working with text,
  while FileOutputStream is a lower-level byte stream that requires additional steps for encoding text properly.
  * */
  // BufferedWriter doesn't need \n
  private void addLineToTextFile(String inputLine){
    try {
      // Create a FileWriter in append mode (true as the second argument)
      FileWriter fileWriter = new FileWriter(filename, true);

      // Create a BufferedWriter for efficient writing
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

      // Write the new line to the file
      bufferedWriter.write(inputLine);
      bufferedWriter.newLine(); // Add a newline character

      // Close the BufferedWriter and FileWriter
      bufferedWriter.close();
      fileWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred while adding a line to the file.");
    }
  }

  private int inputHour(){
    int hour;
    // loop until user input number between 0 and 23
    while (true) {
      try {
        System.out.print("Hour: ");
        hour = scan.nextInt();

        if (hour < 0 || hour > 23)
          System.out.println(" must be number from 0 - 23 ");
        else  break;

      } catch (InputMismatchException ex) {
        System.out.println(" must be number from 0 - 23 ");
        scan.next();
      }
    }

    return hour;
  }

  private int inputMinute(){
    // loop until user input number between 0 and 59
    int minute;
    while (true) {
      try {
        System.out.print("Minute: ");
        minute = scan.nextInt();

        if (minute < 0 || minute > 59)
          System.out.println(" must be number from 0 - 59 ");
        else  break;

      } catch (InputMismatchException ex) {
        System.out.println(" must be number from 0 - 23 ");
        scan.next();
      }
    }

    return minute;
  }

  String getFirstContent(){
    return
            """
                    0,Exercise,Go for a 30-minute jog in the park,07:00
                    0,Check Email,Review and respond to important emails,09:15
                    1,Go Shopping,Need to buy groceries and household items,11:00
                    0,Pick Up Kids,Go to school to pick up the children,15:30
                    1,Do Homework,Complete math and science assignments,18:00
                    """
            ;
  }

  void printMenu(){
    System.out.print("""

             :::::::::::::::::::: TODO LIST MENU :::::::::::::::::::
              1. All records               6. Move task 1 step up
              2. Add new task              7. Move task 1 step down
              3. Check done task           8. Remove task by index or title
              4. Move task to the top      9. Remove the first task
              5. Move task to the bottom   10. Remove the last task
              
              Q. Exit Program
              :::::::::::::::::::::::::::::::::::::::::::::::::::::::
             Select :\s""");
  }


  // #Style 1 Use Scanner ----
  // #Use Scanner when you need to read and parse various types of data from a file.
  private void readWithScanner(String filename){
    try(Scanner contentLines  = new Scanner(new File(filename))) {
      while (contentLines.hasNextLine()) {
        String inputLine = contentLines.nextLine();
        // save to TaskList
        saveTodoList(inputLine);
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found " + ex);
    }
  }

  // # Style 2 Use BufferedReader ----
  // # Use BufferedReader for efficiently reading text data from a file.
  private void readWithBufferedReader(String filename){

    try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
      String inputLine;
      while((inputLine = reader.readLine()) != null) {
        // save to TaskList
        saveTodoList(inputLine);
      }
    } catch(IOException ex) {
      System.out.println("Error - " + ex.getMessage());
    } catch(Exception ex) {
      System.out.println("Error processing file - " + ex.getMessage());
    }
  }


  //# Style 3.Use FileOutputStream for writing binary data to a file.
  //# This class is used for writing binary data to a file.
  // If your goal is to write data to a file, you would use FileOutputStream.
  // It's not meant for reading files.
  // *** Just show how to get content ,but I am not recommend it good for media file ex. image, mp3, ...
  private void readWithFileInputStream(String filename){

    try (FileInputStream fis = new FileInputStream(filename)) {
      int byteRead;
      String fileContent = "";
      while ((byteRead = fis.read()) != -1) {
        // Convert the byte to a char and append it to the StringBuilder
        assert false;
        fileContent = fileContent.concat(String.valueOf((char) byteRead));

      }
      String[] inputLines = fileContent.split("\n");
      for (String inputLine : inputLines) {
        saveTodoList(inputLine);
      }

    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Error - " +  e);
    } catch (IOException ex) {
      System.out.println("Error - " + ex.getMessage());
    }
  }

}