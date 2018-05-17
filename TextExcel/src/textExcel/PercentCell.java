package textExcel;
//Jin Kim
//2nd Period Dreyer
//Note to self: add unimplemented methods so it won't crash
public class PercentCell extends RealCell{
	private String input = "";
	private double newForm = 0.0;
	public PercentCell(String input){
		this.input = input;
		//stores value in parent class
		setRealCell(input);
	}
	public double getDoubleValue(){
		//in decimal form
		newForm = Double.parseDouble(input.substring(0, input.length()-1))/100;
		return newForm;
	}
	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return input;
	}
}
