//Jin Kim
//2nd Period
//3/22/18
package textExcel;

import java.util.Arrays;

public class Spreadsheet implements Grid
{
	//field needed; creates the main spreadsheet array
	private Cell[][] spreadsheetArray;
	public Spreadsheet() {
		//Makes array for sheet (20x12) as requested by packet
		spreadsheetArray=new Cell[20][12];
		//Utilizes nested for loop to create empty cells in all the
		//designated cells before phrases are placed in certain cells
		for(int i=0;i<spreadsheetArray.length;i++) {
			for (int j=0;j<spreadsheetArray[i].length;j++) {
				spreadsheetArray[i][j]=new EmptyCell();
			}
		}
	}
	//Checkpoint 2 Note: If user enters certain commands into the main method,
	//the command will be processed by this method; it should include the following:
	//clear();, assignCell();, and inspectCell();
	public String processCommand(String command)
	{
		if(command.equalsIgnoreCase("clear")) {
			clear();
			return getGridText();
		}else if(command.contains("=")) {
			assignCell(command);
			return getGridText();
		}else if(command.length()==2||command.length()==3) {
			Location position=new SpreadsheetLocation(command);
			return inspectCell(position);
		//clear cell
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
		String[] assignment=input.split("=", 2);
		Location loc=new SpreadsheetLocation(assignment[0].substring(0,assignment[0].indexOf(" ")));
		if(assignment[1].contains("\"")) {
			spreadsheetArray[loc.getRow()][loc.getCol()]=new TextCell(assignment[1].substring(1));
		}else if(assignment[1].contains("(")&&assignment[1].contains(")")){
			spreadsheetArray[loc.getRow()][loc.getCol()]=new FormulaCell(assignment[1].substring(1).toLowerCase());
		}else if(assignment[1].contains("%")) {
			spreadsheetArray[loc.getRow()][loc.getCol()]=new PercentCell(assignment[1].substring(1));
		}else {
			spreadsheetArray[loc.getRow()][loc.getCol()]=new ValueCell(assignment[1].substring(1));
		}
		
		return getGridText();
		
	}
	public String clear() {
		for (int i=0;i<spreadsheetArray.length;i++) {
			for (int j=0; j<spreadsheetArray[i].length;j++) {
				spreadsheetArray[i][j]=new EmptyCell();
			}
		}
		return getGridText();
	}
	public String clearCell(Location loc) {
		spreadsheetArray[loc.getRow()][loc.getCol()]=new EmptyCell();
		return getGridText();
	}

	public int getRows()
	{
		return 20;
	}

	public int getCols()
	{
		return 12;
	}

	public Cell getCell(Location loc)
	{
		return spreadsheetArray[loc.getRow()][loc.getCol()];
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
				result+=spreadsheetArray[k-1][l].abbreviatedCellText();
				result+="|";
			}
			result+="\n";
		}
		return result;
	}

}