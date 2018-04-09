package textExcel;

import java.util.Arrays;

// Update this file with your own code.
public class Spreadsheet implements Grid
{
	private Cell[][] cell;
	public Spreadsheet() {
		cell=new Cell[20][12];
		//makes blank sheet to start
		for(int i=0;i<cell.length;i++) {
			for (int j=0;j<cell[i].length;j++) {
				cell[i][j]=new EmptyCell();
			}
		}
	}
	public String inspectCell(Location loc) {
		return getCell(loc).fullCellText();
	}
	public String clear() {
		for (int i=0;i<cell.length;i++) {
			for (int j=0; j<cell[i].length;j++) {
				cell[i][j]=new EmptyCell();
			}
		}
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
		return cell[loc.getRow()][loc.getCol()];
	}
	public Cell[][] getCellArray() {
		return cell;
	}
	public String getGridText(){
		String toBePrinted="";
		//top for chars
		toBePrinted+="   |";
		for (int i=65; i<=76;i++) {
			toBePrinted+=(char)i;
			//every ten characters requires a '|'
			for(int j=0; j<9; j++) {
				toBePrinted+=" ";
			}
			toBePrinted+="|";
		}
		//adds new line every time to create more rows
		toBePrinted=toBePrinted+"\n";
		for(int k=1;k<=20;k++) {
			if(k<10) {
				//essentially makes the side parts from the packet
				//if less than 10, it will only take up 1 space
				toBePrinted=toBePrinted+k+"  ";
			}else{
				//it will take two, but no more bc it is up to 20
				toBePrinted=toBePrinted+k+" ";
			}
			toBePrinted+="|";
			//prints out empty spaces
			for(int l=0;l<12;l++) {
				toBePrinted=toBePrinted+cell[k-1][l].abbreviatedCellText();
				toBePrinted=toBePrinted+"|";
			}
			toBePrinted=toBePrinted+"\n";
		}
		return toBePrinted;
	}
	public String assign(String input) {
		//note to self: default: empty cell
		String[] command=input.split("=", 2);
		//splits by spaces to simplify command
		Location loc=new SpreadsheetLocation(command[0].substring(0,command[0].indexOf(" ")));
		if(command[1].contains("\"")) {
			//quotation refers to a text cell
			cell[loc.getRow()][loc.getCol()]=new TextCell(command[1].substring(1));
		}else if(command[1].contains("%")) {
			//percent obviously turns to a percent cell
			cell[loc.getRow()][loc.getCol()]=new PercentCell(command[1].substring(1));
		}else if(command[1].contains("(")){
			//if it has the open parenthesis, means that there must be some sort of formula
			cell[loc.getRow()][loc.getCol()]=new FormulaCell(command[1].substring(1), cell);
		}else{
			//has to be a value cell
			cell[loc.getRow()][loc.getCol()]=new ValueCell(command[1].substring(1));
		}
		return getGridText();
	}
	public String processCommand(String command){
		//note to self: requires clear(individual cell and whole cell), assign value, and inspect
		if(command.equalsIgnoreCase("clear")) {
			//clears all
			clear();
			return getGridText();
		}else if(command.contains("=")) {
			assign(command);
			return getGridText();
		}else if(command.length()==2||command.length()==3) {
			Location position=new SpreadsheetLocation(command);
			return inspectCell(position);
		}else{
			return "";
		}
	}
}