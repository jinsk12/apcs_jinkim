package textExcel;

import java.util.Arrays;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] cellArray;
	public Spreadsheet() {
		cellArray=new Cell[20][12];
		for(int i=0;i<cellArray.length;i++) {
			for (int j=0;j<cellArray[i].length;j++) {
				cellArray[i][j]=new EmptyCell();
			}
		}
	}

	public String processCommand(String command){
		//note to sellf:
		if(command.toLowerCase().equals("clear")) {
			//clears all
			for(int i=0;i<cellArray.length;i++) {
				for (int j=0;j<cellArray[i].length;j++) {
					cellArray[i][j]=new EmptyCell();
				}
			}
			return getGridText();
		}else if(command.contains("=")) {
			assignCell(command);
			return getGridText();
		}else if(command.length()==2) {
			Location position=new SpreadsheetLocation(command);
			return inspectCell(position);
		}else if(command.length()==3) {
			Location position=new SpreadsheetLocation(command);
			return inspectCell(position);
		//clear cell at one cell
		}else if (command.toLowerCase().contains("clear")&& command.length()>5){
			Location position=new SpreadsheetLocation(command.substring(6));
			clearCell(position);
			return getGridText();
		}else {
			return "";
		}
	}
	public String inspectCell(Location loc) {
		return getCell(loc).fullCellText();
	}
	public String assignCell(String input) {
		String[] command=input.split("=", 2);
		//splits by spaces to simplify command
		Location loc=new SpreadsheetLocation(command[0].substring(0,command[0].indexOf(" ")));
		if(command[1].contains("\"")) {
			cellArray[loc.getRow()][loc.getCol()]=new TextCell(command[1].substring(1));
		}else if(command[1].contains("(")){
			cellArray[loc.getRow()][loc.getCol()]=new FormulaCell(command[1].substring(1), cellArray);
		}else if(command[1].contains("%")) {
			cellArray[loc.getRow()][loc.getCol()]=new PercentCell(command[1].substring(1));
		}else {
			cellArray[loc.getRow()][loc.getCol()]=new ValueCell(command[1].substring(1));
		}
		
		return getGridText();
		
	}
	public String clear() {
		for (int i=0;i<cellArray.length;i++) {
			for (int j=0; j<cellArray[i].length;j++) {
				cellArray[i][j]=new EmptyCell();
			}
		}
		return getGridText();
	}
	//empties out one cell
	public String clearCell(Location loc) {
		cellArray[loc.getRow()][loc.getCol()]=new EmptyCell();
		return getGridText();
	}
//checkpoint one getters
	public int getRows(){
		return 20;
	}

	public int getCols(){
		return 12;
	}

	public Cell getCell(Location loc){
		return cellArray[loc.getRow()][loc.getCol()];
	}

	public String getGridText()
	{
		String result="";
		//top row header
		result+="   |";
		for (int i=65; i<=76;i++) {
			result+=(char)i;
			for(int j=0; j<9; j++) {
				result+=" ";
			}
			result+="|";
		}
		result+="\n";
		for(int k=1;k<=20;k++) {
			if(k<10) {
				result+=k+"  ";
			}else {
				result+=k+" ";
			}
			result+="|";
			for(int l=0;l<12;l++) {
				result+=cellArray[k-1][l].abbreviatedCellText();
				result+="|";
			}
			result+="\n";
		}
		return result;
	}

	public Cell[][] getCellArray() {
		return cellArray;
	}
}