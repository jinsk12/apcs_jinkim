package textExcel;

public class FormulaCell extends RealCell{
	
	private String formula;
	private Cell[][] grid;

	public FormulaCell(String formula, Cell[][] spreadsheet) {
		// TODO Auto-generated constructor stub
		this.formula = formula;
		this.grid = spreadsheet;
		setRealCell(formula);
	}
	public double getDoubleValue(){
		String[] formula = getRealCell().split(" ");
		if(formula.length == 3){
			System.out.println(formula[1]);
			return Double.parseDouble(formula[1]);
		}
		if((formula[1].toUpperCase().equals("AVG")) || (formula[1].toUpperCase().equals("SUM"))){
			if(formula[1].toUpperCase().equals("AVG")){
				double count = 0.0;
				formula[2] = formula[2].toUpperCase();

				int startRow = Integer.parseInt(formula[2].toUpperCase().substring(1, formula[2].indexOf('-')));
				char startCol = (char)(formula[2].charAt(0));
				int endRow = Integer.parseInt(formula[2].toUpperCase().substring(formula[2].indexOf('-') + 2));
				char endCol = (char) (formula[2].charAt(formula[2].indexOf('-') + 1));
				for(char i = startCol; i <= endCol; i++ ){
					if(startCol != endCol){
						for(int j = startRow; j <= 20; j++){
							SpreadsheetLocation cell = new SpreadsheetLocation(i + "" + j);
							if(grid[cell.getRow()][cell.getCol()] instanceof RealCell){
								count++;
							}
					
						}
						startRow = 1;
					}else{
						for(int j = startRow; j <= endRow; j++){
							SpreadsheetLocation cell = new SpreadsheetLocation(i + "" + j);
							if(grid[cell.getRow()][cell.getCol()] instanceof RealCell){
								count++;
							}
							
						}
					}
				}
			
				return (sum(formula[2].toUpperCase().substring(0, formula[2].indexOf('-')), 
						formula[2].toUpperCase().substring(formula[2].indexOf('-') + 1))) / count;
			}else{
				
				return (sum(formula[2].toUpperCase().substring(0, formula[2].indexOf('-')), 
						formula[2].toUpperCase().substring(formula[2].indexOf('-') + 1)));
			}
		}else{
			double storeVal = 0.0;
			for(int i = 1; i < formula.length - 2; i += 2 ){
				double num = 0.0;
				double secondNum = 0.0;
				
				if(formula[i].toUpperCase().charAt(0) >= 'A' && formula[i].toUpperCase().charAt(0) <='L'){
						formula[i] = formula[i].toUpperCase();
		
						SpreadsheetLocation cell = new SpreadsheetLocation(formula[i]);
						if(grid[cell.getRow()][cell.getCol()] instanceof RealCell){
							formula[i] = Double.toString(((RealCell)grid[cell.getRow()][cell.getCol()]).getDoubleValue());
						}else{
							formula[i] = "0.0";
						}
				}
				if(formula[i+2].toUpperCase().charAt(0) >= 'A' && formula[i+2].toUpperCase().charAt(0) <= 'L'){
						formula[i+2] = formula[i+2].toUpperCase();
						SpreadsheetLocation cell = new SpreadsheetLocation(formula[i + 2]);
					
						if(grid[cell.getRow()][cell.getCol()] instanceof RealCell){
							formula[i+2] = Double.toString(((RealCell)grid[cell.getRow()][cell.getCol()]).getDoubleValue());
							System.out.println("Double value at " + cell.getRow() + "" + cell.getCol() + " " + storeVal);
						}else{
							formula[i+2] = "0.0";
						}
						
				}
				num = Double.parseDouble(formula[i]);
				System.out.println(num);
				secondNum = Double.parseDouble(formula[i + 2]);
				System.out.println(secondNum);
				if(formula[i + 1].equals("*")){
					storeVal = num * secondNum;
				}else if(formula[i + 1].equals("/")){
					storeVal = num / secondNum;
				}else if(formula[i + 1].equals("+")){
					storeVal = num + secondNum;
				}else{
					storeVal = num - secondNum;
				}
				formula[i+2] = Double.toString(storeVal);
			
			}

			return storeVal;
		}
	}
	
	public double sum(String cell, String end){	
		SpreadsheetLocation loc = new SpreadsheetLocation(cell);
		if(cell.equals(end)){
			System.out.println("exit");
			return ((RealCell)grid[loc.getRow()][loc.getCol()]).getDoubleValue();
		}
		String newCell = "";
		
		if(cell.charAt(0) != end.charAt(0) 
				&& Integer.parseInt(cell.substring(1)) == Integer.parseInt(end.substring(1))){
			
			newCell = ((char)(cell.charAt(0) + 1)) + cell.substring(1);
			System.out.println("new Cell value" + newCell);
		}else if(cell.charAt(0) == end.charAt(0) 
				&& Integer.parseInt(cell.substring(1)) <= Integer.parseInt(end.substring(1))){
			newCell = cell.charAt(0) + "";
			newCell += Integer.parseInt(cell.substring(1)) + 1;
		
		}else if(cell.charAt(0) != end.charAt(0) 
				&& Integer.parseInt(cell.substring(1)) <= Integer.parseInt(end.substring(1))){
			if(Integer.parseInt(cell.substring(1)) < Integer.parseInt(end.substring(1))){
				newCell = cell.charAt(0) + "";
				newCell += Integer.parseInt(cell.substring(1)) + 1;
				System.out.println("diff char and int # 1 " + newCell);
			}else if(Integer.parseInt(cell.substring(1)) == 20){
				newCell = ((char)(cell.charAt(0) + 1)) + "" + 1;
				System.out.println("diff char and int  # 2" + newCell);
			}else{
				newCell = ((char)(cell.charAt(0) + 1)) + "" + cell.substring(1);
				System.out.println("diff char and int  # 3 " + newCell);
				
			}
		}

		double first = 0.0;
		if(grid[loc.getRow()][loc.getCol()] instanceof RealCell ){
			 first = ((RealCell)grid[loc.getRow()][loc.getCol()]).getDoubleValue();
			System.out.println("part of recursion " + first);
			return (first + sum(newCell, end));
		}else{
			return sum(newCell, end);
		}
	}

}