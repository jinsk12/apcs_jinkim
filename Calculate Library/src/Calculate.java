//Jin Kim
//September 6, 2017
//Self written math library
public class Calculate {
//Square	
		public static int square(int operand) {
			int squared = operand*operand;
			return squared;
		}
//Cube		
		public static int cube(int operand2) {
			int cube = operand2*operand2*operand2;
			return cube;
		}
//Average For Two Doubles
		public static double average(double operand3, double operand4) {
			double average = (operand3+operand4)/2;
			return average;
		}
//Average For Three Doubles
		public static double average(double operand5, double operand6, double operand7) {
			double average = (operand5+operand6+operand7)/3;
			return average;
		}
//Change to Degrees
		public static double toDegrees(double operand8) {
			double toDegrees = (operand8*(180/3.14159));
			return toDegrees;
		}
//Change to Radians
		public static double toRadians(double operand9) {
			double toRadians = (operand9*(3.14159/180));
			return toRadians;
		}
//Discriminant
		public static double discriminant(double integer1, double integer2, double integer3) {
			double discriminant = (integer2*integer2)-(4*integer1*integer3);
			return discriminant;
		}
//To Improper Fraction
		public static String toImproperFrac(int WholeNum, int Numerator, int Denominator) {
			int NewNumorator = WholeNum*Denominator+Numerator;
			return (NewNumorator+"/"+Denominator);
		}
//To Mixed Number
		public static String toMixedNum(int Numerator, int Denominator) {
			int wholeNum = Numerator/Denominator;
			int newNumerator = Numerator%Denominator;
			return (wholeNum+"_"+newNumerator+"/"+Denominator);
		}
//To FOIL
		public static String foil(int a,int b,int c, int d) {
			int first = a*c;
			int second = (a*d)+(b*c);
			int third = b*d;
			return (first+"x^2"+"+"+second+"x"+"+"+third);
		}
//Is it Divisible?
		public static boolean isDivisibleBy(int a, int b){
			if(a % b == 0){
				return true;
			}else{
				return false;
			}
		}
//Absolute Value of a Number
		public static double absValue(double a){
			double x  = a - 0;
			if(x > 0){
				return x;
			}else{
				return (0 - a);
			}
		}
//Maximum of Two
		public static int max(int a, int b){
			if(a > b){
				return a;
			}else{
				return b;
			}
		}
//Maximum of Three
		public static double max(double a, double b, double c){
			if(a > b && a > c){
				return a;
			}
			if(b > a && b > c){
				return b;
			}
			if(c > a && c > b){
				return c;
			}
			return(2.3);
		}
//Round a Number
		public static double round2(double num1){
			num1 = num1 * 100;
			num1 += .5;
			return(num1 / 100);
		}
}
