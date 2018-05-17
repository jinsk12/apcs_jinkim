package textExcel;
//Jin Kim
//2nd Period Dreyer
public class EmptyCell implements Cell {
	//prints out ten spaces because there are ten spaces in an empty cell
	public String abbreviatedCellText() {
		return "          ";
	}
	//a full one would have absolutely nothing inside
	public String fullCellText() {
		return "";
	}
}