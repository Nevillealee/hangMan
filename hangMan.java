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
						
			// create charArray full of *'s the length of the present guess word	
			char[] cA2 = fileMod.starArray(fileMod.numOfChar(sArray[5]));
			// print contents of cA2 as test
				
			int misses = 0;	
			// int var declarations for iterating through arrays with for loops inside the while loop below
			int w = 0;
			int t = 0;
			char choice = 'y';
		while(choice == 'y'){
			//loop prompts user for guesses until they miss 9 times or get answer right and array cA & cA2 match
		while( misses < 10 && (java.util.Arrays.equals(cA2,cA)) == false){
				System.out.print("\nEnter a character guess: ");
				// scanner object "in" takes user guess as type char and puts it into "charEnt" var.
				Scanner in = new Scanner(System.in);
				char charEnt = in.next().charAt(0);
				System.out.print("\n");
				//compares users input to every letter in guess word. if letter not in word prints * array without update
				if(sArray[5].indexOf(charEnt) == -1){
					//loop to print * array contents
					for(w =0; w < cA2.length; w++){
					System.out.print(cA2[w]);
					}
					// print message showing incorrectly guessed word 
					System.out.print(" " + "("+ charEnt +")" + "  is not in the word :( ");
					misses++; // increments user misses 
					System.out.print("\n");
					}
				else{ 
					// if user guesses correct letter, charArray containing guess word swaps letter with * array index cA2
					cA2[sArray[5].indexOf(charEnt)] = cA[sArray[5].indexOf(charEnt)];
					cA2[sArray[5].lastIndexOf(charEnt)] = cA[sArray[5].lastIndexOf(charEnt)];
					System.out.print("\n");
					//prints updated array with guessed letters revealed instead of hidden as a *
					for(t =0; t < cA2.length; t++){
					System.out.print(cA2[t]);
						}
					System.out.print("\n");
					}
		
				}
			// prints "Game over" if user guesses wrong 9 times	
			if(misses == 10){
				System.out.println("\n Game over");
				System.out.print("Continue? \n Enter y or n");
				Scanner in2 = new Scanner(System.in);
				choice = in2.next().charAt(0);
			}
			// prints "You guessed it" if user guess' word with in 9 trys and both the * array "cA2" and the guess word charArray "cA" match
			else{
				System.out.println("\nYou guessed it!!!");
				System.out.print("Continue? \nEnter y or n");
				Scanner in3 = new Scanner(System.in);
				choice = in3.next().charAt(0);
				}
			 
			}
		
	
	}				
	
}

class fileMod{

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
			
	// method that creates a charArray full of "*" the length of the int value passed in as a parameter
	static char[] starArray(int len) {
		
		char[] starCArray = new char[len];
		for(int n =0; n < starCArray.length; n++){
			starCArray[n] = '*';	
		}
		return starCArray;
	}
}