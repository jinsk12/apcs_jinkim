//Jin Kim
//2nd Period
//3/22/18
package textExcel;
//Note to self:
//Purpose is to correspond and locate area for phrase to be placed
//Uses char and int to place string into designated area
public class SpreadsheetLocation implements Location{
    //fields:char represents 'A' to 'L'
	//int represents the numbers going down to 20
	private char columnLetter;
    private int correspondingNumber;
    //Starts at 'A' and goes to 'L'
    //'A' is 65, so this 
    public int getCol(){
       return columnLetter-65;
    }
    //Starts at 1 and goes up to 20
    public int getRow(){
        return correspondingNumber-1;
    }    
    public SpreadsheetLocation(String placement) {
    	//Manipulates first letter into uppercase and into the column letter for
    	//display on the spreadsheet
    	columnLetter=placement.substring(0,1).toUpperCase().charAt(0);
    	//Parse for String -> Int
    	correspondingNumber=Integer.parseInt(placement.substring(1));
    }
}