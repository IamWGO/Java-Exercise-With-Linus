package com.wgoweb.powerFizzProject.Colors;

public abstract class Color {
  public String background = getBackground();
  public String text = getText();

  abstract String getText();
  abstract String getBackground();
}
