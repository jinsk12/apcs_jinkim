package textExcel;

public class EmptyCell implements Cell{
	private String text;
	public EmptyCell() {
		this.text="";
	}
//A full cell box would have nothing inside it
		public String fullCellText() {
			return "";
		}
//An empty cell will hold ten spaces
	public String abbreviatedCellText() { 
		return "          ";
	}
}