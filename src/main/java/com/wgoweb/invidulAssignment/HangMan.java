package com.wgoweb.invidulAssignment;

import java.util.Objects;
import java.util.Scanner;

public class HangMan {
  static final Scanner input = new Scanner(System.in);
  static final int maxRounds = 7;
  static final String[] secretWords = new String[]
          {
                  "Afghanistan", "Australia", "Bangladesh", "Belgium", "Bulgaria",
                  "Colombia", "Denmark", "England", "Finland", "Germany",
                  "Hungary", "Indonesia", "Luxembourg", "Madagascar", "Malaysia",
                  "Philippines", "Portugal", "Romania", "Scotland", "Singapore",
                  "Switzerland", "Thailand", "Ukraine", "Venezuela", "Zimbabwe"
          };
  //{"Thailand"};  // for testing

  // control parameters
  static int round; // number of trying
  static boolean isCorrect;
  static char[] guessResultArray;
  static String secretWord;
  static char[] historyArray = new char[maxRounds];
  static int historyIndex = 0;

  public static void main(String[] args) {
    do {
      // Reset value
      resetValues();
      // Start game
      runJob();
      // Ask if you want to continue ....
      System.out.print("\n\n==== Do you want to exit ==== \n  [0]  to exit , [any key]  to continue -> ");
      String command = input.nextLine();

      if (Objects.equals(command, "0")) break;

    } while (true);

    System.out.println("\n **** Program is ended *** ");

  }

  static void runJob(){
    secretWord = getRandomWord(); // random a country
    guessResultArray = getEmptyResultInCharArray();  // start with format "_ _ _ _ _ _"

    System.out.println("\n= Start Game =");
    System.out.println("<<<< Guess a country >>>>");

    while (round < maxRounds) {
      System.out.println("\n\n> Guess the secret word: " + getResultAsString() +
              "\n> Attempts left : " + (maxRounds - round) +
              "\n> Wrong letters - "+ getHistoryArray() + " ");
      System.out.print("Guess a letter or word : ");
      String inputString = input.nextLine();

      if (inputString.isEmpty()) {
        System.out.println("Input a letter or guess what is the secret word.");
        continue;
      }

      // check if inputString = secretWord
      if (inputString.equalsIgnoreCase(secretWord)) {
        //secretWord to char[] with uppercase : T H A I L A N D
        guessResultArray = secretWord.toUpperCase().toCharArray();
        // for skip Game Over text
        isCorrect = true;
        printResult(inputString,true); // result
        printCongratulation(); // print congratulation text
        break;
      } else  {
        // compare inputString with secret word
        boolean isContains = doCompareCharWithSecretWord(inputString);
        printResult(inputString,isContains);
      }  // if statement

      round++;

    } // while statement

    //Show Game over
    if (!isCorrect) printGameOver();
  }

  // Reset control parameters
  static void resetValues(){
    round = 0;
    isCorrect = false;
    historyArray = new char[maxRounds];
    historyIndex = 0;
  }

  static boolean doCompareCharWithSecretWord(String inputString){
    boolean isContains = false;
    // ignore if inputString.length() > 1
    if (inputString.length() == 1) {
      String keyword = secretWord.toUpperCase();
      // convert type String to char  ******
      char guessChar = inputString.toUpperCase().charAt(0);
      // check if already guess
      boolean isAlreadyGuess = getIsAlreadyGuess(guessChar);

      if (!isAlreadyGuess) {

        historyArray[historyIndex] = guessChar;
        historyIndex++;
        // compare if guessChar contains in secretWord
        isContains = keyword.contains(Character.toString(guessChar));
        // check if input character is containing the answer
        if (isContains) {
          char[] result = getResult(guessChar);
          // merge with guessResult
          for (int i=0; i<result.length;i++) {
            if (result[i] != '_') guessResultArray[i] = result[i];
          }
        }
      }
    }
    return isContains;
  }

  //get Result as char[] ->ex.  B A _ _ _ A D E _ _
  static char[] getResult(char guessChar){
    char[] result = new char[secretWord.length()];
    char[] arrayKeyword = secretWord.toUpperCase().toCharArray();

    for (int i=0; i<arrayKeyword.length;i++) {
      char key = arrayKeyword[i];
      if (key == guessChar){
        result[i] = guessChar;
      } else {
        result[i] = '_';
      }
    }
    return  result;
  }

  // get a secret word from array
  static String getRandomWord() {
    int position = (int)(Math.random() * secretWords.length);
    return secretWords[position];
  }

  // Get empty result : "_ _ _ _ _ _ _"
  static char[] getEmptyResultInCharArray(){
    char[] guessResult = secretWord.toCharArray();
    char[] result = new char[guessResult.length];

    for (int i=0; i<guessResult.length;i++) {
      result[i] = '_';
    }

    return result;
  }

  // Check if inputString is already guess
  static boolean getIsAlreadyGuess(char guessChar){
    if (historyIndex == 0) return false;
    // ignore the last guess
    for (int i=0; i < historyIndex-1 ; i++) {
      if (historyArray[i] == guessChar) {
        return true;
      }
    }
    return false;
  }

  // Get guess in string format [Wrong letters - A,A,B ....]
  static String getHistoryArray(){
    String history = "";
    for (int i=0; i < historyIndex; i++) {
      boolean isContains = secretWord.toUpperCase().contains(Character.toString(historyArray[i]));
      // check if input character is containing the answer
      if (!isContains) {
        history = history.concat(historyArray[i] + ",");
      }
    }

    String returnString = history;
    // Ignore the last character
    if (returnString.length() > 1) {
      return returnString.substring(0, returnString.length() - 1);
    } else {
      return returnString;
    }
  }

  static String getResultAsString(){
    String result = "";
    for (char c : guessResultArray) {
      result = result.concat(c + " ");
    }
    return result;
  }

  /** --------------------  Print Out Section ----------------------**/

  //Print information after user input something
  static void printResult(String inputString, boolean isRight){
    boolean isAlreadyGuess = getIsAlreadyGuess(inputString.toUpperCase().charAt(0));
    if (isAlreadyGuess) {
      System.out.println("> Already guessed " + inputString.toUpperCase() + "!");
    } else {
      System.out.println((isRight ? "> Correct guess!" : "> Wrong guess!"));
    }
  }

  //Print after user win
  static void printCongratulation(){
    System.out.println(
            """
                        
                        (***)      (***)
                       (*****)    (*****)
                      (*********)(********)
                       (*****************)
                        (***************)
                          (************)
                           (**********)
                             (*******)
                              (*****)
                                (*)\
                    """
    );
    System.out.println("\n Correct! the secret word is \"" + secretWord + "\".");
  }

  //Print after program is over
  static void printGameOver(){
    System.out.println(
            """
                        
                        (***)        (***)
                       (*****)       (*****)
                      (*********)   (********)
                       (*********   ********)
                        (*******   ********)
                          (****   ********)
                           (******  ****)
                             (***  ****)
                              (**  ***)
                                (*)\
                    """
    );
    System.out.println("\n Game OVER!! You have already try " + maxRounds + " times." +
            "\n The secret word is \"" + secretWord + "\".");
  }
}
