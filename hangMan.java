import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class hangMan{
	
	public static void main(String[] args) throws FileNotFoundException{
		//create file object for file to be modified
			File hangmanF = new File("C:\\Users\\Pavilion G7\\Desktop\\hangman.txt");
			
		//create array to store tokens from file 
			String[] sArray = fileMod.fileToArray(hangmanF);
			
			//create charArray to hold String value from sArray at specified index			
			char[] cA = fileMod.arrayToChar(sArray[5]);
			
			//print first char of sArray's String value at the selected index above
			System.out.println(cA.length);
			int correct = 0;
			
			
				
				System.out.print("Enter a character guess: ");
				// scanner object "in" takes user guess as type char and puts it into "charEnt" var.
				Scanner in = new Scanner(System.in);
				char charEnt = in.next().charAt(0);		
		
	}
}

class fileMod{
	// DATA FIELDS
	
	//method that converts file object into array of file contents
	static String[] fileToArray(File f) throws FileNotFoundException {
		try {
		Scanner content = new Scanner(f);
		String[] arr = new String[20];
		for(int i=0; content.hasNext(); i++){
			String text = content.next();	
			arr[i] = text; 
			}
			return arr;
		}	
		catch (FileNotFoundException ex){
			System.out.print(ex.getMessage());
			}
			return null;
		}
			
	//method that takes String parameter and returns number of chars
	 static int numOfChar(String word){
		char[] charArray = word.toCharArray();
		int numOfChar = charArray.length;
	return numOfChar;	
	}
	
	//method that takes String and coverts it to charArray
	static char[] arrayToChar(String s){
		
			char[] arr = new char[20];
				
			arr = s.toCharArray();
			
			return arr;
		}
			
	
}