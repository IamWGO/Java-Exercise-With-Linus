package com.wgoweb.readAndWriteFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Del3Lyrics {
  // ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
  //3. Write example sentence from a specific word in lyrics
  ArrayList<SpecificWord> specificWords = new ArrayList<>();
  String lyricsText = "";
  Scanner scan = new Scanner(System.in);
  String filepath;

  public Del3Lyrics(String filepath) {
    this.filepath = filepath;
  }

  public void writeSentenceFromSpecificWord(){
    // Save words to ArrayList
    getLyricsFromTextFile();

    SpecificWord.OutPut.printDashLine();
    System.out.println(lyricsText);

    // Sort the ArrayList in ascending order
    SpecificWord.OutPut.printHeader();
    for (int i = 0; i < specificWords.size(); i++) {
      SpecificWord.OutPut.printWord(i, specificWords.get(i));
    }

    SpecificWord.OutPut.printDashLine();

    while (true) {
      // random a word
      int randomIndex = randomNumber(0, specificWords.size() -1);
      String randomWord = specificWords.get(randomIndex).getWord();
      System.out.println(
              "Q - Go back or\n" +
                      "Use \""+ randomWord +"\" write your own text");

      System.out.print("Your Text: ");
      String inputString = scan.nextLine();

      // quit while loop if user type q
      if(inputString.equalsIgnoreCase("q")){
        break; // exit search
      }

      if (getIsTextContainSpecificWord(inputString, randomWord)) {
        System.out.println(" >> You use \""+ randomWord +"\" in your text.");
      } else {
        System.out.println(" >> The \""+ randomWord +"\" is not contain in your text.");
      }

      SpecificWord.OutPut.printDashLine();

    }
  }

  private boolean getIsTextContainSpecificWord(String inputText, String randomWord) {
    String[] words = inputText.split(" ");
    for (String word : words) {
      if (word.equalsIgnoreCase(randomWord)) {
        return true;
      }
    }
    return  false;
  }

  static int randomNumber(int min, int max) {
    int range = max - min;
    return  (int)(Math.random() * range) + min;
  }

  private void getLyricsFromTextFile(){
    String filename = filepath + "lyrics.txt";
    Scanner contentLines;
    try {
      contentLines  = new Scanner(new File(filename));
      while (contentLines.hasNextLine()) {
        String contentLine = contentLines.nextLine();
        lyricsText = lyricsText.concat(contentLine + "\n");
        setCountSpecificWord(contentLine);
      }
    } catch (FileNotFoundException ex) {
      System.out.println("File not found " + ex);
    }
  }
  private void setCountSpecificWord(String contentLine){
    // Remove all special characters and numbers using a regular expression
    String cleanedString = contentLine.replaceAll("[0-9,()]", "");

    String[] words = cleanedString.split(" ");

    for (String word : words) {
      boolean isContain = false;

      if (word.length() == 1 || word.isEmpty()) continue;

      if (specificWords != null) {
        for (SpecificWord specificWord : specificWords) {
          if (word.equalsIgnoreCase(specificWord.word)) {
            specificWord.setCount();
            isContain = true;
            break;
          }
        }
      }

      if (!isContain) {
        assert specificWords != null;
        specificWords.add(new SpecificWord(word));
      }

    }

  }
}
