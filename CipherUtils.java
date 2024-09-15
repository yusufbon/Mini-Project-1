package edu.grinnell.csc207.util;

/**
 * Utility class for encryption and decryption using Caesar and Vigenere ciphers.
 */
public class CipherUtils {

  /**
   * Converts a lowercase letter to an integer based its position in the alphabet.
   *
   * @param letter The lowercase letter to convert.
   * @return The integer representation of the letter (0 for 'a', ..., 25 for 'z').
   */
  private static int letter2int(char letter) {
      return letter - 'a'; 
  } // letter2int

  /**
   * Converts an integer to the corresponding lowercase letter.
   *
   * @param i The integer to convert (0 for 'a', ..., 25 for 'z').
   * @return The corresponding lowercase letter.
   */
  private static char int2letter(int i) {
      return (char) (i + 'a'); 
  } // int2letter

  /**
   * Encrypts a string using the Caesar cipher.
   *
   * @param str The string to encrypt only lowercase letters.
   * @param letter The letter used as the key for encryption.
   * @return The encrypted string.
   */
  public static String caesarEncrypt(String str, char letter) {
      int shift = letter2int(letter);
      char[] encrypted = new char[str.length()];

      for (int i = 0; i < str.length(); i++) { 
          char ch = str.charAt(i);
          encrypted[i] = int2letter((letter2int(ch) + shift) % 26);
      } // for

      return new String(encrypted); 
  } // caesarEncrypt

  /**
   * Decrypts a string using the Caesar cipher.
   *
   * @param str The string to decrypt 
   * @param letter The letter used as the key for decryption.
   * @return The decrypted string.
   */
  public static String caesarDecrypt(String str, char letter) {
      int shift = letter2int(letter);
      char[] decrypted = new char[str.length()];

      for (int i = 0; i < str.length(); i++) { 
          char ch = str.charAt(i);
          decrypted[i] = int2letter((letter2int(ch) - shift + 26) % 26);
      } // for

      return new String(decrypted); 
  } // caesarDecrypt

  /**
   * Encrypts a string using the Vigenere cipher.
   *
   * @param str The string to encrypt 
   * @param key The key used for encryption.
   * @return The encrypted string
   */
  public static String vigenereEncrypt(String str, String key) {
      char[] encrypted = new char[str.length()];

      for (int i = 0; i < str.length(); i++) { 
          char ch = str.charAt(i);
          char keyChar = key.charAt(i % key.length());
          encrypted[i] = int2letter((letter2int(ch) + letter2int(keyChar)) % 26);
      } // for

      return new String(encrypted); 
  } // vigenereEncrypt

  /**
   * Decrypts a string using the Vigenere cipher.
   *
   * @param str The string to decrypt.
   * @param key The key used for decryption.
   * @return The decrypted string.
   */
  public static String vigenereDecrypt(String str, String key) {
      char[] decrypted = new char[str.length()];

      for (int i = 0; i < str.length(); i++) { 
          char ch = str.charAt(i);
          char keyChar = key.charAt(i % key.length());
          decrypted[i] = int2letter((letter2int(ch) - letter2int(keyChar) + 26) % 26);
      } // for

      return new String(decrypted); 
  } // vigenereDecrypt
} // CipherUtils
