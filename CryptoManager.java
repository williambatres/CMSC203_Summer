

public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		
		Boolean true_false_flag = false;
		
		for(int i = 0; i < plainText.length() ; i++)
		{
			if(plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND)//tests if the char is in the allowable bounds
			{
				true_false_flag = false;
				i = plainText.length(); // breaks the for loop if outside of bounds
			}
			else
				true_false_flag = true;
		}
		if(true_false_flag == false)
			return false;
		else
			return true;
		
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//variables
		char encryptedChar;
		String encryptedString ="";
		
		if(stringInBounds(plainText) == false)//confirms the string is in bounds 
			return "";
		for(int i = 0; i < plainText.length(); i ++)
		{
			encryptedChar = plainText.charAt(i);
			encryptedChar += key;
			while(encryptedChar > UPPER_BOUND) //Sets the char within bonds 
			{
				encryptedChar -= RANGE; //subtracts the value of char by the value of range
			}
			encryptedString += encryptedChar;
		}
		
		return encryptedString;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {

		//variables
		String finalEncryptedString = "";
		int bellasoStringLength = bellasoStr.length(); 
		

		for (int i = 0; i < plainText.length(); i++) {
			
			char tempChar = plainText.charAt(i);
			int newEncryptedChar = tempChar + (int)bellasoStr.charAt(i % bellasoStringLength);
			
			while(newEncryptedChar > UPPER_BOUND) 
				{
				newEncryptedChar -= RANGE;
				}
			
			finalEncryptedString += (char) newEncryptedChar;
		}


		return finalEncryptedString;
	}
	
	
		

	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {

		String dencryptedString ="";
		for(int i = 0; i < encryptedText.length(); i ++)
		{
			char dencryptedChar = encryptedText.charAt(i);
			int decChar = (int) dencryptedChar - key;
			while(decChar < LOWER_BOUND)
			{
				decChar += RANGE;
			}
			dencryptedString += (char)decChar;
		}
	
		return dencryptedString;
	}
	
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {

		String finalDencryptedString = "";
		int bellasoStringLength = bellasoStr.length(); 
		int lb = (int) LOWER_BOUND;

		for (int i = 0; i < encryptedText.length(); i++) {
			
			char tempChar = encryptedText.charAt(i);
			int newDencryptedChar = (int) tempChar - (int)bellasoStr.charAt(i % bellasoStringLength);
			
			while (newDencryptedChar < lb)
			{ 
				newDencryptedChar += RANGE;
			}

			
			finalDencryptedString += (char) newDencryptedChar;
		}

	
		return finalDencryptedString;

	}

}