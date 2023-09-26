package com.wgoweb.powerFizzProject.basicCms;

public class Member {
  String firstName;
  String lastName;

  public Member(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMemberInfo(){
    return firstName + " " + lastName;
  }
  public String objectToLineFormat(){
    return  firstName + "," + lastName;
  }


  static class OutPut {
    static int maxFirstName = 25;
    static int maxLastName = 25;
    static int headlineLength = 50;

    public static void printHeadLine(){
      String headline = addWhiteSpace("No.", 3) + "| " +
              addWhiteSpace("First Name", maxFirstName) + "| " +
              addWhiteSpace( "Last Name", maxLastName) + "| ";

      headlineLength = headline.length();
      printDashLine(headlineLength);
      System.out.println(headline);
      printDashLine(headlineLength);
    }

    public static void printRow(int rowIndex, Member current) {
      String taskRow = addWhiteSpace((rowIndex+1) + ".", 3) + "| " +
             addWhiteSpace(current.firstName, maxFirstName) + "| " +
              addWhiteSpace( current.lastName, maxLastName) + "| " ;
      System.out.println(taskRow);
    }

    public static void printDashLine(int length){
      System.out.println("-".repeat(length));
    }
    public static void printEmptyRecord() {
      System.out.println(" ".repeat(10) +
              "+".repeat(10)  +
              " No Items " +
              "+".repeat(10) +
              " ".repeat(10));
    }
    public static void printEndOfList() {
      System.out.println( "+".repeat(20) + " End of the list " + "+".repeat(20));
    }

    public static String addWhiteSpace(String text, int maxAmount){
      if(text.length() > maxAmount){
        return text.substring(0, maxAmount - 3) + "...";
      }
      return text + " ".repeat(maxAmount - text.length());
    }
  }
}
