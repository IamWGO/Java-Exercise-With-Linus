package com.wgoweb.powerFizzProject.basicCms;

import com.wgoweb.powerFizzProject.utility.Colors.AdminColor;
import com.wgoweb.powerFizzProject.utility.Theme;

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
    static Theme set = new Theme(new AdminColor());
    static int maxFirstName = 25;
    static int maxLastName = 25;
    static int headlineLength = 50;

    public static void printHeadLine(){
      String headline =
              OutPut.set.color.text
              + OutPut.set.addWhiteSpace("No.", 3) + "| "
              + OutPut.set.addWhiteSpace("First Name", maxFirstName) + "| "
              + OutPut.set.addWhiteSpace( "Last Name", maxLastName) + "| "
              + OutPut.set.color.reset;

      headlineLength = headline.length();
      OutPut.set.printDashLine(headlineLength);
      System.out.println(headline);
      OutPut.set.printDashLine(headlineLength);
    }

    public static void printRow(int rowIndex, Member current) {
      String taskRow =
              OutPut.set.color.text
              + OutPut.set.addWhiteSpace((rowIndex+1) + ".", 3) + "| "
              + OutPut.set.addWhiteSpace(current.firstName, maxFirstName) + "| "
              + OutPut.set.addWhiteSpace( current.lastName, maxLastName) + "| "
              + OutPut.set.color.reset;
      System.out.println(taskRow);
    }

    public static void printMenu(){
      System.out.print("""

             :::::::::::::::::::: MENU :::::::::::::::::::
              1. All records
              2. Insert
              3. Update
              4. Delete
              
              Q. Exit Program
              :::::::::::::::::::::::::::::::::::::::::::::::::::::::
             Select :\s""");
    }

    public static void printInsertUpdateMenu(boolean isNewItem, String firstName, String lastName){
      System.out.print(":::::: "+ (isNewItem ? "NEW MEMBER" : "UPDATE MEMBER") +" ::::::" +
              "\n1. First Name       - " + firstName +
              "\n2. Last Name - " + lastName +
              "\n3. " + (isNewItem ? "save" : "update") +
              "\nQ. Go back" +
              "\n\n Select choice : ");
    }

    public static void printSuccessUpdate(Member member){
      Member.OutPut.set.printInfo(" ::  \""+ member.getMemberInfo() +"\" is Updated :: ");
    }

    public static void printSuccessDelete(Member member) {
      Member.OutPut.set.printInfo(" ::  \""+ member.getMemberInfo() +"\" is removed :: ");
    }
  }
}
