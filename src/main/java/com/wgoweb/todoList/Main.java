package com.wgoweb.todoList;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // if you like to run as menu
    //mainMenu();

    // TodoListDel2
    TodoListDel2 task = new TodoListDel2();
    task.run();
  }

  private void mainMenu(){
    Scanner scan = new Scanner(System.in);
    boolean run = true;
    while (run) {
      System.out.print("""
              1. Todo list like Linus's Dog school
              2. Exercise Del1
              3. Exercise Del2 and Del 3
              Q. Exit Program

               Select :\s""");
      String choice = scan.next();
      System.out.println();
      // toUpperCase to check Q command
      switch (choice.toUpperCase()) {
        case "1" -> {
          TodoList task = new TodoList();
          task.run();
        }
        case "2" -> {
          TodoListDel1 task = new TodoListDel1();
          task.run();
        }
        case "3" -> {
          TodoListDel2 task = new TodoListDel2();
          task.run();
        }
        case "Q" -> {
          System.out.println("Exit Program :)");
          run = false; // quit while loop
        }
        default -> System.out.println("Input number 1-4 or Q to exit program");
      }
    }
  }
}
