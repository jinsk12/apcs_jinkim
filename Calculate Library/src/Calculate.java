//Jin Kim
//September 6, 2017
//Self written math library
public class Calculate {
//Part One
//Squares an Integer
		public static int square(int operand) {
			int squared = operand*operand;
			return squared;
		}
//Cubes an Integer	
		public static int cube(int operand2) {
			int cube = operand2*operand2*operand2;
			return cube;
		}
//Average Double For Two Doubles
		public static double average2(double operand3, double operand4) {
			double average2 = (operand3+operand4)/2;
			return average2;
		}
//Average Double For Three Doubles
		public static double average3(double operand5, double operand6, double operand7) {
			double average3 = (operand5+operand6+operand7)/3;
			return average3;
		}
//Radians change to Degrees
		public static double toDegrees(double operand8) {
			double toDegrees = (operand8*(180/3.14159));
			return toDegrees;
		}
//Degrees change to Radians
		public static double toRadians(double operand9) {
			double toRadians = (operand9*(3.14159/180));
			return toRadians;
		}
//Takes three integers to find discriminant
		public static double discriminant(double integer1, double integer2, double integer3) {
			double discriminant = (integer2*integer2)-(4*integer1*integer3); //b^2 - 4ac
			return discriminant;
		}
//From Mixed Number to Improper Fraction
		public static String toImproperFrac(int WholeNum, int Numerator, int Denominator) {
			int NewNumorator = WholeNum*Denominator+Numerator;
			return (NewNumorator+"/"+Denominator);
		}
//From Improper Fraction to Mixed Number
		public static String toMixedNum(int Numerator, int Denominator) {
			int wholeNum = Numerator/Denominator;
			int newNumerator = Numerator%Denominator;
			return (wholeNum+"_"+newNumerator+"/"+Denominator);
		}
//FOILs an equation of integers
		public static String foil(int a,int b,int c, int d) {
			int first = a*c;
			int second = (a*d)+(b*c);
			int third = b*d;
			return (first+"x^2"+"+"+second+"x"+"+"+third);
		}
//Part Two
//Gives value whether true or false for a fraction containing integers
		public static boolean isDivisibleBy(int a, int b){
			if(b ==0) {
				throw new IllegalArgumentException("Denominator cannot be zero, because you cannot divide by zero.") ;
			}
			if(a % b == 0){ //makes sure that it is zero
				return true;
			}else{ //other case will be not divisible
				return false;
			}
			}
//Calculates the Absolute Value of a Double
		public static double absValue(double a){
			double x  = a - 0;
			if(x > 0){ //if its a positive value it must be able to subtract zero
				return x;
			}else{ //will be negative in this case
				return (0 - a);
			}
		}
//Displays the bigger number of the two integers
		public static int max(int a, int b){
			if(a > b){
				return a;
			}else{ //assumes that the larger of the two is b
				return b;
			}
		}
//Displays the biggest number of the three integers
		public static double max(double a, double b, double c){
			if(a > b && a > c){
				return a;
			}else if(b > a && b > c){
				return b;
			}else { //anything else assumes that c is the largest value
				return c;
			}
}
//Returns the minimum value of the two integers
		public static int min(int a, int b) {
			if(a>b) {
				return b;
			}else { //assumes that a is the smallest value
				return a;
			}
		}
//Rounds a Number by two decimals
		public static double round2(double num) {
			if(num >0) { //greater than zero than number needs to be rounded up
				double newNum = num*100 + .5;
				int num1 = (int) (newNum);
				return ((double) (num1))/100;
			}else{ //needs to be rounded down in the other case
				double newNum = num*100 - .5;
				int num1 = (int) (newNum);
				return ((double) (num1))/100;
			}
			
		}
//Part Three
//Takes the first number and takes it to the second number's power
		public static double exponent(int base, double power){
			double answer = 1.0;
			if(power<0) {
				throw new IllegalArgumentException("Cannot take negative exponent values");
			}
			if(power == 0){ //anything to the zero power is zero
						return (1);
					}
					for(int i = 1; i <= power; i++){
						answer *= base;
					}
					return(answer);
		}
//Displays the factorial value of a positive integer
		public static int factorial(int x){
			int answer = 1;
			if(x<0) {
				throw new IllegalArgumentException("Cannot take factorial of negative numbers");
			}
			if(x == 0){
				return(1);
			}
			for(int i = 1; i <= x; i++){ //setting loop to multiply until itself
				answer *=i;
			}
			return answer;
		}
//Displays a true or false value whether the integer is true or false
		public static boolean isPrime(int num){ //prime is whether divisible or not
			boolean testedValue;
			for(int i = num - 1; i > 1; i--){
				testedValue = Calculate.isDivisibleBy(num, i);
				if(testedValue == true){
					return(false);
				}
			}
			return(true);
		}
//Shows the Greatest Common Factor of two integers
		public static int gcf(int a, int b){
			int gfc = 1;
			for(int i=1; i<= a; i++){
				if(isDivisibleBy(a,i) && isDivisibleBy(b, i)){
					gfc =1; //checking if divisible
				}
			}
			return(gfc); //returning final value
		}
//Returns the square root of a double
		public static double sqrt(double number) {
		if(number < 0) { //setting restrictions
			throw new IllegalArgumentException("Cannot square root negative values");
		}else if(number == 0) { //root zero is zero
			return 0;
		}
		double intValue = 0; //setting variable
		while(intValue * intValue <number) {
			intValue++;
		}
		if((intValue *intValue) % number == 0) {
			return intValue; //finding root
		}else { //rounding number
			return .5 * (number/intValue + intValue);
		}
	}
//Quadratic Formula method
		public static String quadForm(int a, int b, int c) {
			double discriminant = discriminant(a,b,c);
			if(a == 0) {
				throw new IllegalArgumentException("Is not a quadratic function");
			}else { //if its zero for the squared then it cannot be quadratic
				if(discriminant < 0) { //if the discriminant is less than one there will be no roots
					return ("no real roots");
				}
			}
			double rootNum1 = (-b+ sqrt(discriminant))/(2*a);
			double rootNum2 = (-b- sqrt(discriminant))/(2*a);
			if(rootNum1 != rootNum2) {
				rootNum1 = round2(rootNum1);
				rootNum2 = round2(rootNum2);
				if(rootNum1 > rootNum2) {
					return rootNum2 + " and " + rootNum1;
				}else{
					return rootNum1 + " and " + rootNum2;
				}
			}else{
				rootNum1 = round2(rootNum1);
				return rootNum1 +"";
			}
		}
	}
