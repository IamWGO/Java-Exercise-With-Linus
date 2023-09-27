package com.wgoweb.powerFizzProject.utility;

import com.wgoweb.powerFizzProject.utility.Colors.Color;

public class Theme {
  public Color color;

  public Theme(Color color) {
    this.color = color;
  }

  public void printDashLine(int length){
    System.out.println(
            color.text
            + "-".repeat(length)
            + color.reset);
  }
  public  void printEmptyItem() {
    System.out.println(
            " ".repeat(10)
            + color.background
            + "+".repeat(10)
            + " No Items "
            + "+".repeat(10)
            + color.reset
            + " ".repeat(10)
    );
  }
  public void printSuccess(String text){
    System.out.println(
            color.successText
            + text
            + color.reset);
  }

  public void printWarning(String text){
    System.out.println(
            color.warningText
            + text
            + color.reset);
  }

  public void printInfo(String text) {
    System.out.println(
            color.infoText
            + text
            + color.reset);
  }

  public void printEndOfList() {
    System.out.println(
            color.text
            + "+".repeat(20) + " End of the list " + "+".repeat(20)
            + color.reset);
  }

  public String addWhiteSpace(String text, int maxAmount){
    if(text.length() > maxAmount){
      return text.substring(0, maxAmount - 3) + "...";
    }
    return text + " ".repeat(maxAmount - text.length());
  }
}
