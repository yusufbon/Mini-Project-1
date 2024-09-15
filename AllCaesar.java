package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * Main class that encodes and decodes using the Caesar cipher.
 * Takes input to encode or decode the given string.
 */

public class AllCaesar {
  private static final int EXPECTED_NUM_PARAMS = 2;

  /**
   * Main method to execute encoding or decoding 
   *
   * @param args Command-line arguments: encode/decode and the string.
   */
  public static void main(String[] args) {
      PrintWriter pen = new PrintWriter(System.out, true);

      //output an error if the right number of params isnt entered
      if (args.length != EXPECTED_NUM_PARAMS) { // if
          System.err.println("Error: Incorrect number of parameters.");
          pen.close();
          return; 
      } // if

      String choice = args[0];
      String str = args[1];

      
      if (!choice.equals("encode") && !choice.equals("decode")) { // if
          System.err.println("Error: Invalid option: \"" + choice + "\". Valid options are \"encode\" or \"decode\".");
          pen.close();
          return; 
      } // if

      // validate input string.
      if (!str.matches("[a-z]*")) { // if
          System.err.println("Error: String contains characters other than lowercase letters.");
          pen.close();
          return; 
      } // if

      // Perform encoding or decoding for all 26 possible shifts.
      for (char ch = 'a'; ch <= 'z'; ch++) { 
        String result = choice.equals("encode")
                        ? CipherUtils.caesarEncrypt(str, ch)
                        : CipherUtils.caesarDecrypt(str, ch); 
        pen.printf("n = %c: %s\n", ch, result); 
    } // for


      pen.close(); 
  } // main
} // AllCaesar