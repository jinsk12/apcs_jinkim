package textExcel;
import java.util.Scanner;
//Jin Kim
//2nd Period Dreyer
public class TextExcel{
	public static void main(String[] args){
		//makes new spreadsheet object
		Spreadsheet newsheet = new Spreadsheet();
		Scanner getInput = new Scanner(System.in);
		String userInput = getInput.nextLine();
		//loop runs until user types quit
		while(!userInput.equalsIgnoreCase("quit")){
			System.out.println(newsheet.processCommand(userInput));
			userInput = getInput.nextLine();
		}
		//done now!!!!
	}
}