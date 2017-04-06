
import java.util.Scanner;

public class Password
{
    public static void main(String[] args) {
		
        Scanner reader = new Scanner(System.in);
		
		String realPW = "carrot";
		
		String secret = "Beware the mark of the beast...";
		
	while (true){
		
	System.out.print("Type the password: ");
		
			String Pword = reader.nextLine();
			
	if (Pword.equals (realPW)) {
		
		break;
	
	}	else {
			System.out.println("Incorrect! Try again ");
		}
	}
		System.out.print("The secret message is " + secret);
	}
	
	
}