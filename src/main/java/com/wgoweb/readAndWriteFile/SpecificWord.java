package com.wgoweb.readAndWriteFile;

import com.wgoweb.todoList.Task;

public class SpecificWord {
  String word;
  int count;

  public SpecificWord(String word) {
    this.word = word.toLowerCase();
    this.count = 1;
  }

  public void setCount() {
    this.count++;
  }

  public int getCount() {
    return count;
  }

  public String getWord() {
    return word;
  }

  static class OutPut {

    static int maxWordLength = 15;

    public static String addWhiteSpace(String text, int maxAmount){
      if(text.length() > maxAmount){
        return text.substring(0, maxAmount - 3) + "...";
      }
      return text + " ".repeat(maxAmount - text.length());
    }

    public static void printWord(int index, SpecificWord word){
      System.out.print(SpecificWord.OutPut.addWhiteSpace(word.getCount() + ":" + word.getWord(), maxWordLength));
      //System.out.print(SpecificWord.OutPut.addWhiteSpace(word.getCount() + "  ", maxCountLength));

      if ((index + 1)%10 == 0) System.out.println("\n");
    }

    public static void printHeader(){
      System.out.println(":".repeat(30) +
              " Count specific words appears in a text file  " +
              ":".repeat(30)
              );
    }

    public static void printDashLine(){
      System.out.println("\n" + "-".repeat(50));
    }

  }
}
