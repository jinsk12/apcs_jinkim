package textExcel;
//Jin Kim
//2nd Period Dreyer
//Work on committing issues :(
public class TextCell implements Cell {
		//more fields
		private String text = "";
		private String abbreviated = "";
		//contructor
		public TextCell(String strcontents){
			this.text = strcontents;
		}
		//setters
		public void setText(String strcontents){
			this.text = strcontents;
		}
		//auto generated
		public void setAbbreviated(String abbreviated) {
			this.abbreviated = abbreviated;
		}
		//getter
		public String getAbbreviated() {
			return abbreviated;
		}
		public String abbreviatedCellText() {
			//so that fullCellText is unaffected
					String shortenedStr = "";
					//gets rid of quotes
					while(text.contains("\"")){
						shortenedStr = text.substring(1, text.length() - 1);
					}
					//Reduces string to first 10
					if(shortenedStr.length() > 10){
						shortenedStr = shortenedStr.substring(0, 10);
						return shortenedStr;
					}else{
						//fills in the spaces so total length will be 10
						for(int i=0; i<10-shortenedStr.length(); i++){
							shortenedStr += " ";
						}
						return shortenedStr;
					}
		}
		//returns the whole string
		public String fullCellText() {
			return text;
		}
	}