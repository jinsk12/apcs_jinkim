package textExcel;

public class SpreadsheetLocation implements Location
{
	private int row;
	private int column;
	
    @Override
    public int getRow(){
    	//zero indexing
        return row - 1;
    }
    @Override
    public int getCol(){
        return column;
    }
    public SpreadsheetLocation(String cellName)
    {
    	column = cellName.charAt(0);
    	//subtracts the value of 'A' to get the location of the column based on the character used
    	column = Character.toUpperCase(column) - 'A';
    	//changes the string number at the end to an integer
    	row = Integer.parseInt(cellName.substring(1));
    }
}