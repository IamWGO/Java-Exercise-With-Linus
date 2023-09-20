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
        case "4" -> moveRecode(true);
        case "5" -> moveRecode(false);
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

  private void checkDoneTask(){
    String warning = "Select number 1-"+ taskList.size() +".";
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
        System.out.println(warning);
      }

    }

  }

  private void moveRecode(boolean isMoveToTop){
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

      }  else {
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
    printAllTask();

    System.out.println("Q - Go back\n" +
            "Which one do you want to move ?");
    System.out.print("Select Index: ");
    String searchString = scan.nextLine();
    String guideText = " Input number from 1 - " + taskList.size() + " or Q";

    while (true) {
      try {
        int index = Integer.parseInt(searchString);
        // check if index is in range
        if (index < 0 || index > (taskList.size() + 1)) {
          System.out.println(guideText);
          scan.next();
          break;
        }
        String removingTitle = taskList.get(index).getTitle();
        // remove record
        taskList.remove(index - 1);
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
    String filename = "src/main/java/com/wgoweb/todoList/TodoListContent.txt";

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
    } catch (IOException ex) {
      System.out.println("An error occurred." + ex);
    }

  }

  private void saveTodoList(String contentLines) {
    //split contentLine : 0,Exercise,Go for a 30-minute jog in the park,07:00
    String[] parts = contentLines.split(",");
    try {
      // Extract the values from the split parts and create a Dog object
      String isDoneFlag = parts[0];
      String title = parts[1];
      String description = parts[2];
      String time = parts[3];

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

 

 

}
