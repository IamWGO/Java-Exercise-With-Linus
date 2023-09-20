package com.wgoweb.todoList;


import java.util.ArrayList;
import java.util.Comparator;

public class Task {
  String title;
  String description;
  int hour;
  int minute;
  boolean isDone;

  public Task(String title, String description, int time, int minute, boolean isDone) {
    this.title = title;
    this.description = description;
    this.hour = time;
    this.minute = minute;
    this.isDone = isDone;
  }

  public void setDone() {
    this.isDone = !this.isDone;
  }

  public String getTitle() {
    return title;
  }

  // Subclass for output
  public static class output {

    static int maxIsDone = 8;
    static int maxTime = 8;
    static int maxTitle = 25;
    static int maxDescription = 50;
    public static String addWhiteSpace(String text, int maxAmount){
      if(text.length() > maxAmount){
        return text.substring(0, maxAmount - 3) + "...";
      }
      return text + " ".repeat(maxAmount - text.length());
    }

    public static void printHeadLine(){
      String headline = addWhiteSpace("No.", 3) + "| " +
              addWhiteSpace("Done", maxIsDone) + "| " +
              addWhiteSpace("Time", maxTime) + "| " +
              addWhiteSpace( "Title", maxTitle) + "| " +
              addWhiteSpace( "Description", maxDescription);

      //System.out.println();
      System.out.println("-".repeat(headline.length()));
      System.out.println(headline);
      System.out.println("-".repeat(headline.length()));
    }

    public static void printTaskRow(int rowIndex, Task currentTask) {
      String taskRow = output.addWhiteSpace((rowIndex+1) + ".", 3) + "| " +
              output.addWhiteSpace((currentTask.isDone ? "Yes" : "No"), output.maxIsDone) + "| " +
              output.addWhiteSpace(output.getTime(currentTask.hour,currentTask.minute), output.maxTime) + "| " +
              output.addWhiteSpace( ((!currentTask.title.isEmpty()) ? currentTask.title : "-"), output.maxTitle) + "| " +
              output.addWhiteSpace( ((!currentTask.description.isEmpty()) ? currentTask.description : "-"), output.maxDescription);
      System.out.println(taskRow);
    }
    public static String getTime(int hour, int minute){
      return String.format("%02d", hour) + ":" + String.format("%02d", minute);
    }

    public static String emptyRecord() {
       return " ".repeat(40) + " No Task ";
    }

  }

}



