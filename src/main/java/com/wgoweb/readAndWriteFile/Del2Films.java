package com.wgoweb.readAndWriteFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Del2Films {
  String filepath;

  public Del2Films(String filepath) {
    this.filepath = filepath;
  }

  // ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
  // 2. Get Movies (get every 3rd movie title)
  public void getMovies(){
    System.out.println(":::::::::::::::::::: Get Movie every 3rd in the list :::::::::::::::::::");
    String filename = filepath + "films.txt";
    Scanner contentLines;
    try {
      contentLines  = new Scanner(new File(filename));
      int loop = 0;
      while (contentLines.hasNextLine()) {
        String rad = contentLines.nextLine();
        if (++loop%3 == 0) System.out.println(loop + "-" + rad);
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found " + ex);
    }

  }
}
