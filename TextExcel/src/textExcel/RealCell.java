package textExcel;

abstract class RealCell implements Cell {
	
	private String text;
	
	public String getRealCell(){
		return text;
	}
	public void setRealCell(String value){
		text = value;
	}
	public String abbreviatedCellText() {
		return truncate();
	}
	public String fullCellText() {

		String returnVal = text;
		double holder = 0.0;
		
		//checks to see if the value is a percentage or just a number
		if(returnVal.contains("%")){
			holder = getDoubleValue();
			//if its a formula, just return the cell value, doesn't change it
		}else if(returnVal.indexOf(")") == returnVal.length() - 1){
			return returnVal;
			//if the content of the cell is 0, doesn't change it, just return 0
		}else if(returnVal.equals("0")){
			return "0";
		}else{
			holder = Double.parseDouble(returnVal);
		}
		
		//converts the number to a string
		returnVal = Double.toString(holder);
		
		//checks to see if the number ends with a .0
		if(returnVal.substring(returnVal.length() - 2, returnVal.length()).equals(".0")){
			
			//checks to see if the number is negative, or if it only has 1 whole number in it
			if(returnVal.substring(0 , returnVal.indexOf(".0")).length() <= 1 || returnVal.contains("-")){
				return returnVal;
				
				//if the number isn't just one whole number or negative, then cuts off the .0
			}else{
				return returnVal.substring(0,returnVal.length() - 2);
			}
		//if it doesn't end in a .0, then checks for unnecessary zeroes to possibly cut out
		}else{
			return checkZeroes(returnVal);
		}

	}
	public String truncate(){
		String returnsThis = text;
		if(returnsThis.charAt(0) == '('){
			returnsThis = Double.toString(getDoubleValue());
		}
		//if its a whole number without a percent, make it a double by adding .0 to it
		if(!returnsThis.contains(".") && !returnsThis.contains("%") ){
			returnsThis += ".0";
		}
		
		//gets rid of unnecessary zeroes at the end of the value
		returnsThis = checkZeroes(returnsThis);
		//checks for unnecessary zeroes again and cuts off the last one to make it a .0 if there is
		if(returnsThis.indexOf(".00") + 3 == returnsThis.length()){
			returnsThis = returnsThis.substring(0, returnsThis.length() - 1);
		}

		//checks to see if there is a percent sign and takes off the decimal point
		if(returnsThis.contains("%")){
			returnsThis = returnsThis.substring(0, returnsThis.indexOf('.'));
			returnsThis += "%";
		}
		//checks to see if the value is longer than 10, if it is it cuts it off at the tenth character,
		//or adds spaces to fill it up to ten spaces
		if(returnsThis.length() >= 10){
			returnsThis = returnsThis.substring(0, 10);
		}else{
			while(returnsThis.length() != 10){
				returnsThis += " ";
			}
		}
		return returnsThis;
	}
	abstract double getDoubleValue();

	public String checkZeroes(String value){
		int continuousZero = 0;
		int countZero = 0;
		int count = value.length() - 1;
		
		// continues loop until the count hits the start of the value or zero
		while(count != 0){
			//checks for two zeroes in a row and saves the value to continuosZero
			if(countZero >= 2){
				continuousZero = countZero;
			}
			//checks for zeros or if the value is at a .0 (which it doesn't count)
			if(value.charAt(count) == '0' && value.charAt(count - 1) != '.'){
				countZero++;
			}else{
				// if its anything but a zero without a decimal point near it reset the count for zeroes
				countZero = 0;
			}
			//decrement by one to go down the value
			count--;
		}
		//returns the value after substring the amount of unnecessary zereos
		return value.substring(0, value.length() - continuousZero);
	}
	
}