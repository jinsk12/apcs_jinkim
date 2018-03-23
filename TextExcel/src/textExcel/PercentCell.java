package textExcel;

public class PercentCell extends ValueCell{
	private double decimal;
	public PercentCell(String cellText) {
		super(cellText);
		decimal=Double.parseDouble(cellText.substring(0,cellText.length()-1));
		String percentDecimal=(decimal/100.0)+"";
		setCellText(percentDecimal);
	}
	public String abbreviatedCellText() {
		String realDecimal=decimal+"";
		String realDecimalPart=realDecimal.substring(0,realDecimal.indexOf("."));
		String result=realDecimalPart;
		if(realDecimal.length()<9) {
			result+="%";
			for(int i=0; i<9-realDecimalPart.length();i++) {
				result+=" ";
			}
			return result;
		}else {
			return realDecimal.substring(0, 9)+"%";
		}
	
	}
}