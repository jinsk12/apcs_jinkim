package textExcel;

public class PercentCell extends RealCell{
	
	private String percent;
	
	//puts percent into super class of RealCell
	public PercentCell(String percent){
		this.percent = percent;
		setRealCell(percent);
	}
	
	//Changes the percentage sign into a decimal
	public double getDoubleValue(){
		String returnVal = getRealCell();
		returnVal = returnVal.substring(0, returnVal.length() - 1);
		return Double.parseDouble(returnVal) / 100.0;
	}
	
	
}