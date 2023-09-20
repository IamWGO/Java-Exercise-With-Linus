package com.wgoweb.todoList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Task {
  String title;
  String description;
  int hour;
  int minute;
  boolean isDone;

  static int maxIsDone = 8;
  static int maxTime = 8;
  static int maxTitle = 25;
  static int maxDescription = 50;

  public Task(String title, String description, int time, int minute, boolean isDone) {
    this.title = title;
    this.description = description;
    this.hour = time;
    this.minute = minute;
    this.isDone = isDone;
  }

  public void updateStatus() {
    this.isDone = !this.isDone;
  }

  public String getTitle() {
    return title;
  }


  public String printTaskRow(int rowIndex) {
    return output.addWhiteSpace((rowIndex+1) + ".", 3) + "| " +
            output.addWhiteSpace((isDone ? "Yes" : "No"), Task.maxIsDone) + "| " +
            output.addWhiteSpace(output.getTime(hour,minute), Task.maxTime) + "| " +
            output.addWhiteSpace( ((!title.isEmpty()) ? title : "-"), Task.maxTitle) + "| " +
            output.addWhiteSpace( ((!description.isEmpty()) ? description : "-"), Task.maxDescription);
  }

  // Subclass for output
  public static class output {
    public static String addWhiteSpace(String text, int maxAmount){
      if(text.length() > maxAmount){
        return text.substring(0, maxAmount - 3) + "...";
      }
      return text + " ".repeat(maxAmount - text.length());
    }

    public static void printHeadLine(){
      String headline = addWhiteSpace("No.", 3) + "| " +
              addWhiteSpace("Done", Task.maxIsDone) + "| " +
              addWhiteSpace("Time", Task.maxTime) + "| " +
              addWhiteSpace( "Title", Task.maxTitle) + "| " +
              addWhiteSpace( "Description", Task.maxDescription);
      System.out.println(headline);
      System.out.println("-".repeat(headline.length()));
    }

    public static String getTime(int hour, int minute){
      return String.format("%02d", hour) + ":" + String.format("%02d", minute);
    }

    public static String emptyRecord() {
       return " ".repeat(40) + " No Task ";
    }

    public static ArrayList<Task> sortList(ArrayList<Task> taskList){
      // Define a custom comparator based on the 'value' field
      Comparator<Task> comparator = Comparator.comparing(Task::getTitle);
      // Sort the ArrayList using the custom comparator
      taskList.sort(comparator);

      return taskList;
    }
  }

}



