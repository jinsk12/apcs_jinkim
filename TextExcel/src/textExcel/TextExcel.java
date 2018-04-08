package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextExcel{
	public static void main(String[] args){
		Spreadsheet excel = new Spreadsheet();	
		
		Scanner input = new Scanner(System.in);
		String command = "";
		while(command.equalsIgnoreCase("quit") != true){
			System.out.println("Command:");
			command = input.nextLine();
			System.out.println(excel.processCommand(command));
		}
	}
}