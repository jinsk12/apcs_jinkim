package textExcel;
//Jin Kim
//2nd Period Dreyer
public class ValueCell extends RealCell{
	private String value = "";
	public ValueCell(String val){
		value = val;
		//stores value
		setRealCell(val);
	}
	public double getDoubleValue(){
		//changes string to double
		double placeHolder = Double.parseDouble(value);
		return placeHolder;
	}
	@Override//auto generated
	public String fullCellText() {
		// TODO Auto-generated method stub
		return value;
	}

}