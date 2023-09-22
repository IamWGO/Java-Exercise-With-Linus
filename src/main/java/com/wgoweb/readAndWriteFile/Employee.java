package com.wgoweb.readAndWriteFile;

import com.wgoweb.todoList.Task;

public class Employee {
  String firstName;
  String lastName;
  String id;
  String position;
  String email;

  public Employee(String firstName, String lastName, String id, String position, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
    this.position = position;
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  static class OutPut {

    static int maxId = 15;
    static int maxFirstName = 20;
    static int maxLastName = 20;
    static int maxPosition = 25;
    static int maxEmail = 30;

    static int headerLineLength = 0;

    public static void printEmployeeDetail(Employee employee) {
      System.out.println(
              "\n" +"-".repeat(50) +
              "\n:: Employee Detail "+ employee.id +" :: " +
              "\n" +"-".repeat(50) +
              "\nID           : "+ employee.id +
              "\nFirst name: "+ employee.firstName +
              "\nLast name : " + employee.lastName +
              "\nPosition  : " + employee.position +
              "\nEmail     : " + employee.email +
              "\n" +"-".repeat(50) + "\n ");
    }

    public static void printNotFoundEmployee(String inputString) {
      System.out.println(
              "\n" +"-".repeat(50) +
              "\n::  \""+ inputString +"\" is not found :: , Please try again!!" +
              "\n" +"-".repeat(50) + "\n ");
    }
    public static String addWhiteSpace(String text, int maxAmount){
      if(text.length() > maxAmount){
        return text.substring(0, maxAmount - 3) + "...";
      }
      return text + " ".repeat(maxAmount - text.length());
    }

    public static void printHeadLine(){
      String headline = addWhiteSpace("No.", maxId) + "| " +
              addWhiteSpace("First Name", maxFirstName) + "| " +
              addWhiteSpace("Last Name", maxLastName) + "| " +
              addWhiteSpace( "Position", maxPosition) + "| " +
              addWhiteSpace( "Email", maxEmail);

      //System.out.println();
      headerLineLength = headline.length();
      System.out.println("-".repeat(headerLineLength));
      System.out.println(headline);
      System.out.println("-".repeat(headerLineLength));
    }

    public static void printTaskRow(Employee employee) {
      String taskRow = Task.output.addWhiteSpace(employee.id + ".", maxId) + "| " +
              Task.output.addWhiteSpace(employee.firstName, maxFirstName) + "| " +
              Task.output.addWhiteSpace(employee.lastName, maxLastName) + "| " +
              Task.output.addWhiteSpace( employee.position, maxPosition) + "| " +
              Task.output.addWhiteSpace( employee.email, maxEmail);
      System.out.println(taskRow);
    }


    public static void printEmptyRecord() {
      System.out.println(" ".repeat(40) + " No Task ");
    }

    public static void printDashLine(){
      System.out.println("-".repeat(headerLineLength));
    }

  }
}
