package com.wgoweb.readAndWriteFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Del4Employee {
  Scanner scan = new Scanner(System.in);
  String filepath;

  public Del4Employee(String filepath) {
    this.filepath = filepath;
  }

  // ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
  //4. Get Employee detail
  ArrayList<Employee> employees  = new ArrayList<>();
  public void searchEmployee(){
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
      /*
      //  for (int i = 0; i < employees.size(); i++) {
      //     Employee.OutPut.printTaskRow(employees.get(i));
      //  } */
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
      for (Employee value : employees) {
        boolean isContain = value.getFirstName().toUpperCase().contains(inputString.toUpperCase());
        if (isContain) {
          foundEmployees.add(value);
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
      /*
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
*/
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
}
