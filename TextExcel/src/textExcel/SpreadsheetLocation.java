package textExcel;
//Jin Kim
//2nd Period Dreyer
//Update this file with your own code.
public class SpreadsheetLocation implements Location{
	//just some more fields
	private char ch;
    private int num;
    //getters that I need
    public int getRow(){
    	return num-1;
    }
    public int getCol(){
    //subtracts bc capital letters start differently
    	return ch-65;
    }
    //constructor
    public SpreadsheetLocation(String place) {
    	//gotta make the sheet capital for the header
    	String letter=place.substring(0,1).toUpperCase();
    	ch=letter.charAt(0);
    	//gotta make it an int afterwards
    	num=Integer.parseInt(place.substring(1));
    }
    //note to self: somehow get it this file to commit to github
}