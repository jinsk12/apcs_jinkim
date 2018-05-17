package textExcel;
//Jin Kim
//2nd Period Dreyer
//Note: Ms. Dreyer said to make clear() so that I wouldn't have to copy code
//over multiple times
public class Spreadsheet implements Grid{
	//some more fields
	private int rows = 20;
	private int cols = 12;
	//constructor
	public Spreadsheet(){
		//fills the sheet with the same empty cells
		 for(int i = 0; i < rows; i++){
			 for(int j = 0; j < cols; j++){
				 cells[i][j] = new EmptyCell();
			 }
		 }
	}
	//getters
	public int getRows(){
		return this.rows;
	}
	public int getCols(){
		return this.cols;
	}
	public Cell getCell(Location loc){
		return cells[loc.getRow()][loc.getCol()];
	}
	public Cell[][] getCellArray() {
		return cells;
	}
	//makes the new sheet
	private Cell [][] cells = new Cell[rows][cols];

	//same as setting the initial sheet
	public void clear(){
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++){
				cells[i][j] = new EmptyCell();
			}
		}
	}
	public void clearOne(String cell){
		//similar to clear() except makes just one empty cell
		SpreadsheetLocation userInput = new SpreadsheetLocation(cell);
		cells[userInput.getRow()][userInput.getCol()] = new EmptyCell();
	}
	//2d array for rows and columns
	public String processCommand(String command){
		String[] separateCommand = command.split(" ");
		//makes it upper case
		separateCommand[0] = separateCommand[0].toUpperCase();
		if(command.length()==0){
			return "";
		}else if(separateCommand.length >= 3){
			String userInput = separateCommand[2] + "";
			int coun = 3;
			while(coun < separateCommand.length){
				//adds the space that was taken out and the next part of the value
				userInput =userInput+  " " + separateCommand[coun];
				coun++;
			}
			String cell = separateCommand[0];
			assignCells(userInput, cell);
			return getGridText();
			//3 or less would mean InspectCell() method
		}else if(command.length() <= 3){
			return InspectCell(separateCommand[0]);
			//check if the user input has clear, has been changed to uppercase
		} else if (separateCommand[0].equalsIgnoreCase("clear")){
			//one or less wipes out the entire screen
			if(separateCommand.length == 1){
				 clear();
				 return getGridText();
				 //the others would assume that it would clear one cell: can use the first split
				 //to determine which one to wipe
			}else{
				//in case the cell isnt uppercased
				clearOne(separateCommand[1].toUpperCase());
				return getGridText();
			}
		}
		return "";
	}
	public String getGridText(){
		String sheet = "   |";
		//makes the first row of capital letters
		for(int i = 0; i < cols; i++){
			//ten spaces, |, then the letter
			sheet = sheet+ (char) ('A' + i) + "         |";
		}
		//fills in the grid
		for(int i = 1; i <= rows; i++){
			//makes new line at end of row and adds the number
			sheet += "\n" + i;
			//if it's less than ten, it prints out one more to compensate for the one digit less
			if(i >= 10){
				sheet = sheet+ " |";
			}else{
				sheet = sheet+  "  |";
			}
			//sets values
			for(int k = 0; k < cols; k++){
				//i-1 bc zero based
				sheet = sheet + cells[i-1][k].abbreviatedCellText() + "|";
			}
		}
		//each row is reset to the next to begin the next row
		sheet = sheet+ "\n";
		//returns the entire sheet
		return sheet;
	}
	public String InspectCell(String cell){
		//displays cell text of the location given
		SpreadsheetLocation a = new SpreadsheetLocation(cell);
		return cells[a.getRow()][a.getCol()].fullCellText();
	}
	//assigns the cell
	//note to self: fix formulacell
	public void assignCells(String input, String cell){
		SpreadsheetLocation random = new SpreadsheetLocation(cell);
		//assigns cell accordingly
		//% -> percent cell
		if(input.contains("%")){
			cells[random.getRow()][random.getCol()] = new PercentCell(input);
		//" -> textcell
		}else if(input.contains("\"")){
			cells[random.getRow()][random.getCol()] = new TextCell(input);
		//( -> formulacell
		}else if(input.contains("(")){
			cells[random.getRow()][random.getCol()] = new FormulaCell(input, cells);
			//anything else is value cell
		}else{
			cells[random.getRow()][random.getCol()] = new ValueCell(input);
		}
	}
}