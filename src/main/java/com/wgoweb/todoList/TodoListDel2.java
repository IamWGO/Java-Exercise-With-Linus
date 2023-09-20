package com.wgoweb.todoList;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
* Del 2
Lägg till ett menyval som raderar något i listan baserat på dess index värde
Lägg till ett menyval som raderar något i listan baserat på dess namn
Skapa en ”har gjort”-lista genom att deklarera en variabel med namnet doneList som en ArrayList.
Flytta en sak till toppen i todoList
Flytta en sak till botten av todoList*/
public class TodoListDel2 {
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
        case "2" -> removeRecode();
        case "3" -> checkDoneTask();
        case "4" -> moveRecode(true);
        case "5" -> moveRecode(false);
        case "6" -> moveRecodeOneStep(true);
        case "7" -> moveRecodeOneStep(false);
        case "Q" -> {
          System.out.println("Exit Del 2 :)");
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
    }
  }

  private void removeRecode(){
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

  private void checkDoneTask(){
    String warning = "Select number 1-"+ taskList.size() +" or Q.";
    System.out.println("::::: DONE TASK ::::");
    while (true) {
      printAllTask();
      // quit while loop if it has no task
      if (taskList.isEmpty()) break;

      System.out.println(warning);
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

      if (selectedIndex >= 0) {
        Task selectedTask = taskList.get(selectedIndex);
        if (isMoveToTop){
          taskList.remove(selectedIndex);
          taskList.add(0, selectedTask);
          System.out.print("> Moved "+ selectedTask.getTitle() +" to the top. ");
        }  else {
          taskList.remove(selectedIndex);
          taskList.add(selectedTask);
          System.out.print("> Moved "+ selectedTask.getTitle() +" to the bottom. ");
        }

        System.out.println(guideText);
        printAllTask();

      } else {
        System.out.println(guideText);
      }

    }
  }

  private void moveRecodeOneStep(boolean isMoveUp) {
    String guideText = " Input number from 1 - " + taskList.size() + " or Q";

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

      printAllTask();
      // return -1 if no record
      int selectedIndex = searchTaskByIndex(inputString);

      if (selectedIndex >= 0) {
        Task selectedTask = taskList.get(selectedIndex);
        if (isMoveUp){
          if (selectedIndex > 0) {
            taskList.remove(selectedIndex);
            taskList.add(selectedIndex -1, selectedTask);
            System.out.println("> Moved "+ selectedTask.getTitle() +" up 1 step. ");
          } else {
            System.out.println("> "+ selectedTask.getTitle() +" already in first of the list. ");
          }

        }  else {
          if (selectedIndex < (taskList.size() -1)) {
            taskList.remove(selectedIndex);
            taskList.add(selectedIndex + 1 ,selectedTask);
            System.out.println("> Moved "+ selectedTask.getTitle() +" down 1 step. ");
          } else {
            System.out.println("> "+ selectedTask.getTitle() +" already in last of the list. ");
          }
        }

        // Print current task list
        System.out.println(guideText);
        printAllTask();

      } else {
        System.out.println(guideText);
        scan.next();
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
    System.out.print("Which one do you want to move ? \n" +
            "Select Index:");
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
        System.out.println(" :: Record "+ removingTitle +" is removed :: ");

        break;

      } catch (InputMismatchException ex) {
        System.out.println(guideText);
        scan.next();
      }
    }

  }

  private void removeByTitle(){
    printAllTask();
    System.out.print("Which title do you want to remove? (ex: Do Homework , you could put only 'homework')\n" +
            "Input title:");
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
        System.out.println(" :: Record "+ removingTitle +" is removed :: ");
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

             Todo List - Menu
             -------------------------
              1. All records
              2. Remove record
              3. Check done task
              4. Move recode to the top
              5. Move recode to the bottom
              6. Move 1 step up
              7. Move 1 step down
              
              Q. Avsluta programmet
             Select :\s""");
  }

}

