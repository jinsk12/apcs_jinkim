package textExcel;
//Jin Kim
//2nd Period Dreyer
//Work On: Sum method, and fix instanceOf issue by Sunday
//also fix the while issue loops
public class FormulaCell extends RealCell{
		//couple fields
		private String value = "";
		private Cell[][] sheet;
		//constructor
		public FormulaCell(String input, Cell[][] array){
			value = input;
			sheet = array;
		}
		public String fullCellText(){
			return value;
		}
		public String abbreviatedCellText() {
			String text = getDoubleValue() + "";
			//cuts off the cell to just 10 to fit the box
			if (text.length() > 10) {
				return text.substring(0, 10);
			//adds empty spaces to make them all fit	
			}else{
				for (int i = text.length(); i < 10; i++) {
					text =text+ " ";
				}
				return text;
			}
		}
		public double getDoubleValue(){
			//starts at zero
			double sum = 0.0;
			String takeAwayPar = value.substring(2, value.length() - 2);
			//split at space
			String[] altered = takeAwayPar.split(" ");
			//avg and sum for ckpt 5
			if(altered.length == 1){
				return Double.parseDouble(altered[0]);
				}else if(altered[0].equalsIgnoreCase("avg") || altered[0].equalsIgnoreCase("sum")){
					//get the beginning cell and ending cell
					int counter = 0;
					String startingPoint = altered[1].toUpperCase().substring(0, altered[1].indexOf('-'));
					String endingPoint = altered[1].toUpperCase().substring(altered[1].indexOf('-') + 1);
					//if its average
					if(altered[0].equalsIgnoreCase("avg")){
						String hold = startingPoint;
						
						while(!(hold.equals(endingPoint))){
							SpreadsheetLocation loc = new SpreadsheetLocation(hold);
							//change the column -> its the same row
							
							if(hold.substring(1).equals(endingPoint.substring(1))){
								//changes letter by letter
								hold = ((char)(hold.charAt(0) + 1)) + startingPoint.substring(1);
								if(sheet[loc.getRow()][loc.getCol()] instanceof RealCell){
									//checks to see if its a realcell and adds counter for average
									counter++;
								}
							}else{
								//same thing but moves row
								hold = hold.charAt(0) + "" + (Integer.parseInt(hold.substring(1)) + 1);
								if(sheet[loc.getRow()][loc.getCol()] instanceof RealCell){
									counter++;
								}
							}
					}
						//sum/counter=average  
					return (sum(startingPoint, startingPoint, endingPoint)) / (counter+1);
				}else if(altered[0].equalsIgnoreCase("sum")){
					return (sum(startingPoint,startingPoint,endingPoint));
				}
			}else{
				//"sum"
				//checks to see if its a cell or number
				//essentially checks to see if it's greater than A or less than L which would make it a valid cell
				if(altered[0].toUpperCase().charAt(0) >= 'A' && altered[0].toUpperCase().charAt(0) <='L'){
					SpreadsheetLocation cell = new SpreadsheetLocation(altered[0].toUpperCase());
					//if its a RealCell ->casts->adds the value into the sum
					if(sheet[cell.getRow()][cell.getCol()] instanceof RealCell){
						sum = ((RealCell) sheet[cell.getRow()][cell.getCol()]).getDoubleValue();
					}
				}else{
					//if not, it is parsed into a double to be directly added to the sum
					sum = Double.parseDouble(altered[0]);
				}
				for(int i = 1; i < altered.length - 1; i =i+ 2 ){
					//does the same thing for the next cell
					double appliedNumber=0.0;
					if(altered[i + 1].toUpperCase().charAt(0) >= 'A' && altered[i + 1].toUpperCase().charAt(0) <='L'){
							altered[i + 1] = altered[i + 1].toUpperCase();
							SpreadsheetLocation loc = new SpreadsheetLocation(altered[i + 1]);
							if(sheet[loc.getRow()][loc.getCol()] instanceof RealCell){
								//real cell then doubleValue
								appliedNumber = ((RealCell)sheet[loc.getRow()][loc.getCol()]).getDoubleValue();
							}
					}else{
						appliedNumber = Double.parseDouble(altered[i + 1]);
					}
					//separates by given sign
					if(altered[i].contains("/")){
						sum =sum/appliedNumber;
					}else if(altered[i].contains("+")){
						sum =sum+appliedNumber;
					}
					else if(altered[i].contains("*")){
						sum =sum*appliedNumber;
					}else{
						sum =sum-appliedNumber;
					}
				}
			}
			return sum;
		}
	//sum method for above	
	public double sum(String beginning, String altCell, String end){	
			SpreadsheetLocation loc = new SpreadsheetLocation(altCell);
			while(altCell.equals(end)){
				if(sheet[loc.getRow()][loc.getCol()] instanceof RealCell){
					return ((RealCell)sheet[loc.getRow()][loc.getCol()]).getDoubleValue();
				}else{
					return 0.0;
				}
			}
			//altCell
			//moves vertically if columns are same and adds
			if(Character.toUpperCase(beginning.charAt(0)) == Character.toUpperCase(end.charAt(0))
					&& Integer.parseInt(beginning.substring(1)) <= Integer.parseInt(end.substring(1))){
				altCell = Character.toString(beginning.charAt(0)) + (Integer.parseInt(altCell.substring(1)) + 1);
				//columns are different-> moves horizontally to add
			
			}else if(Character.toUpperCase(beginning.charAt(0)) != Character.toUpperCase(end.charAt(0)) 
			&& Integer.parseInt(beginning.substring(1)) == Integer.parseInt(end.substring(1))){
				altCell = ((char)(altCell.charAt(0) + 1)) + beginning.substring(1);
				//if the columns and the rows aren't the same, move through all of the cells
			
			}else{
				//row<ending row-> goes down
				if(Integer.parseInt(altCell.substring(1)) < Integer.parseInt(end.substring(1))){
					altCell = Character.toString(altCell.charAt(0)) + (Integer.parseInt(altCell.substring(1)) + 1);
					//same->reset
				}else if(Integer.parseInt(altCell.substring(1)) == Integer.parseInt(end.substring(1))){
					altCell = ((char)(altCell.charAt(0) + 1)) + "" + beginning.substring(1);
				}
			}
			//gets the value of the cell returns it
			double first =0.0;
			if(sheet[loc.getRow()][loc.getCol()] instanceof RealCell){
				 first = ((RealCell)sheet[loc.getRow()][loc.getCol()]).getDoubleValue();
				return (first + sum(beginning, altCell, end));
			}else{
				return sum(beginning, altCell, end);
			}
		}
	}