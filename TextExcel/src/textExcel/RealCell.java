package textExcel;
//Jin Kim
//2nd Period Dreyer
//Work on
//Note to self: make sure that abbreviatedCellText covers everything
//make sure that filler adds the right amount of zeroes
public abstract class RealCell implements Cell {
	//couple fields
	private String input = "";
	private int co = 0;
	//so that other subclasses have to make
	public abstract double getDoubleValue();
	//Note to self: very important fix this asap
	public String filler(String space){
		//formats abbreviatedCellText to length 10 if its too short
		while(space.length() < 10){
			space=space+ " ";
		}
		return space;
	}
	//getter
	public String getRealCell(){
		return input;
	}
	//setter
	public void setRealCell(String value){
		input = value;
	}
	public String abbreviatedCellText() {
		if(input.length() < 10){
			//has to be percent with this sign
			while(input.contains("%")){
				//makes sure the full thing isn't messed up
				String holder = input.substring(0, input.indexOf(".")) + "%";
				//formats to have 10 spaces
				return filler(holder);
			}
			//simply adds spaces rather than doing anything crazy
			while(input.equals("0.0")){
				input = filler(input);
				return input;
			}
			//makes sure that it is not a percent or formula cell
			while(!input.contains(".") && !input.contains("(")){
				//turns the entire whole number into a double
				String holderTwo = input + ".0";
				return filler(holderTwo);
			}
			//adds a .0 if theres nothing after the decimal
			while(input.charAt(input.length()-1) == '.'){
				input = input + "0";
			}
			input = filler(input);
			//if longer than 10, shortens to 10
		}else if(input.length() > 10){
			return input.substring(0, 10);
		}
		return input;
	}
}
