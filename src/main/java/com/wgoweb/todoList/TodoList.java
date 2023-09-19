package com.wgoweb.todoList;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TodoList {
  Scanner scan = new Scanner(System.in);

  ArrayList<Task> taskList  = new ArrayList<>();

  public void run() {
    Scanner scan = new Scanner(System.in);
    boolean run = true;
    while (run) {
      printMenu();
      String choice = scan.next();
      // toUpperCase to check Q command
      switch (choice.toUpperCase()) {
        case "1" -> printAllTask();
        case "2" -> newTask();
        case "3" -> updateTaskMenu();
        case "4" -> removeTaskMenu();
        case "Q" -> {
          System.out.println("Exit Program :)");
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
      System.out.print("Registrera Hund" +
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

  private void updateTaskMenu(){
    System.out.println(":::::: Update Status ::::::");
    String warning = "Select number 1-"+ taskList.size() +" or Q.";

    System.out.println();
    while (true) {
      printAllTask();
      // quit while loop if it has no task
      if (taskList.isEmpty()) break;

      System.out.println(warning);
      System.out.print("Select : ");
      String inputString = scan.nextLine();

      // quit while loop if user type q
      if(inputString.equalsIgnoreCase("q")){
        break;
      }
      // check if choice is number
      try {
        int choice = Integer.parseInt(inputString);
        if (choice <= this.taskList.size() && choice > 0){
          this.taskList.get(choice - 1).updateStatus();
        } else {
          System.out.println(warning);
        }
      } catch (NumberFormatException ex) {
        System.out.println(warning);
      }

    }
  }
  private void removeTaskMenu(){
    System.out.println(":::::: Remove Task ::::::");
    String warning = "Select number 1-"+ taskList.size() +" or Q.";

    System.out.println();
    while (true) {
      printAllTask();

      // quit while loop if it has no task
      if (taskList.isEmpty()) break;

      System.out.println(warning);
      System.out.print("Select : ");
      String inputString = scan.nextLine();

      // quit while loop if user input q
      if(inputString.equalsIgnoreCase("q")){
        break;
      }

      // check if choice is a number
      try {
        int choice = Integer.parseInt(inputString);
        if (choice <= this.taskList.size() && choice > 0){
          this.taskList.remove(choice - 1);
        } else {
          System.out.println(warning);
        }
      } catch (NumberFormatException ex) {
        System.out.println(warning);
      }

    }

  }

  private void printAllTask(){
    System.out.println();
    Task.output.printHeadLine();

    if (taskList.isEmpty()) {
      System.out.println(Task.output.emptyRecord());
    } else {
      for (int i = 0; i < taskList.size(); i++) {
        System.out.println(taskList.get(i).printTaskRow(i));
      }
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

  void printMenu(){
    System.out.print("""

              Todo List - Menu
              -------------------------
              1. All Task
              2. New Task
              3. Update Status
              4. Remove Task
              Q. Exit Program

              Select :\s""");
  }
}
