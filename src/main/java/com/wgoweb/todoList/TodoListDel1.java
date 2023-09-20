package com.wgoweb.todoList;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
* Del 1
Skapa en att göra lista genom att deklarera en variabel med namnet todoList som en tom ArrayList.

Skapa en meny som innehåller valen

 - Skriv ut listan
 - Lägg till något i listan
 - Ta bort en sak överst i listan
 - Ta bort en sak längst ner i listan
 - Avsluta programmet

* */
public class TodoListDel1 {
  Scanner scan = new Scanner(System.in);
  ArrayList<Task> taskList  = new ArrayList<>();

  public void run() {
    getTaskFromFile();

    boolean run = true;
    while (run) {
      printMenu();
      String choice = scan.next();
      System.out.println();
      // toUpperCase to check Q command
      switch (choice.toUpperCase()) {
        case "1" -> printAllTask();
        case "2" -> newTask();
        case "3" -> removeFirstList();
        case "4" -> removeLastList();
        case "Q" -> {
          System.out.println("Exit Del 1 :)");
          run = false; // quit while loop
        }
        default -> System.out.println("Input number 1-4 or Q to exit program");
      }
    }
  }

  private void newTask(){
    System.out.println(":::::: New Task ::::::");
    // Clear value
    String title = "";
    String description = "";
    int hour = 0;
    int minute = 0;
    boolean isDone = false;

    boolean run = true;
    while (run) {
      System.out.print("<< Add a new task >>" +
              "\n1. title - " + title +
              "\n2. description - " + description +
              "\n3. Time - " + Task.output.getTime(hour, minute) +
              "\n4. Save" +
              "\nQ. Go back" +
              "\n\n Select : ");
      String inputString = scan.nextLine();
      // use toUpperCase to Q command
      switch (inputString.toUpperCase()) {
        case "1" -> {
          System.out.print("Title: ");
          title = scan.nextLine();
        }
        case "2" -> {
          System.out.print("description: ");
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
          System.out.println(":::::: "+ title +" saved ::::::");
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

  private void removeFirstList(){
    System.out.println(":::::: First Record "+ taskList.get(0).getTitle() +" is removed ::::::");
    taskList.remove(0);
    printAllTask();
  }
  private void removeLastList(){
    System.out.println(":::::: Last Record "+ taskList.get(taskList.size() -1).getTitle() +" is removed ::::::");
    taskList.remove(taskList.size() -1);
    printAllTask();
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

             Todo List - Menu
             -------------------------
              1. Skriv ut listan
              2. Lägg till något i listan
              3. Ta bort en sak överst i listan
              4. Ta bort en sak längst ner i listan
              
              Q. Avsluta programmet
             Select :\s""");
  }
}
