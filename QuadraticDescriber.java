
public class QuadraticDescriber {
	public static double sqrt(double firstoperand) {
		if(firstoperand < 0) { //cannot be rooted
			throw new IllegalArgumentException("Cannot square root negatives");
		}else if(firstoperand == 0) { //square root of zero is zero
			return 0;
		}
		double secondoperand = 0;
		while(secondoperand * secondoperand <firstoperand) {
			secondoperand++;
		}
		if((secondoperand *secondoperand) % firstoperand == 0) {
			return secondoperand;
		}else {
			return .5 * (firstoperand/secondoperand +secondoperand);
		}
	}
	public static double discriminant(double a, double b, double c) { //used for quadratic
		return b*b - (4*a*c);
	}
	public static double round2(double operand) {
		if(operand >0) {
			double newOperand = operand*100 + .5;
			int num = (int) (newOperand); //turn into integer
			return ((double) (num))/100; //round up
		}else {
			double newOperand = operand*100 - .5;
			int num = (int) (newOperand);
			return ((double) (num))/100; //round down
		}
	}
	public static String quadForm(double a, double b, double c) {
		double discriminant = discriminant(a,b,c);
		if(discriminant < 0) {
			return ("no real roots"); //does not cross x axis at all
		}else {
			if(a == 0) {
				throw new IllegalArgumentException("Not a quadratic equation");
			}
			double firstRoot = (-b+ sqrt(discriminant))/(2*a); //-b/2a
			double secondRoot = (-b- sqrt(discriminant))/(2*a); //same as above
			if(firstRoot != secondRoot) {
				firstRoot = round2(firstRoot);
				secondRoot = round2(secondRoot);
				if(firstRoot > secondRoot) {
					return secondRoot + " and " + firstRoot;
				}else {
					return firstRoot + " and " + secondRoot;
				}
			}else {
				firstRoot = round2(firstRoot);
				return firstRoot +"";
			}
		}
	}
	public static double exponent(double operand, int exponent) {
		if(exponent < 0) { //negatives not included
			throw new IllegalArgumentException("Cannot take negative exponents");
		}
		if(exponent ==0) {
			return 1; //anything to the zero power is one
		}
		double multiply = operand;
		for(int i = 1; i<exponent;i++) {
			operand *= multiply; //multiplies itself until the exponent is done
		}
		return operand;
	}

}
//check work before you submit!