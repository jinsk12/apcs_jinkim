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
		String toBePrinted = getRealCell();
		//-1 bc it is a percent key at the end
		toBePrinted = toBePrinted.substring(0, toBePrinted.length() - 1);
		//makes it a double decimal by dividing by 100.0
		return Double.parseDouble(toBePrinted) / 100.0;
	}
	
	
}