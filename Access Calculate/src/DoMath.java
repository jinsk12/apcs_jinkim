//Jin Kim
//Calculator
//September 6,2017
public class DoMath {

	public static void main(String[] args) {
		Calculate.square(5);
		System.out.println("Square:");
		System.out.println(Calculate.square(2));
		System.out.println("Cube:");
		System.out.println(Calculate.cube(3));
		System.out.println("Average of Two Doubles:");
		System.out.println(Calculate.average2(4.0,3.0));
		System.out.println("Average of Three Doubles:");
		System.out.println(Calculate.average3(2.3,4.6,1.2));
		System.out.println("Change to Degrees:");
		System.out.println(Calculate.toDegrees(3.14));
		System.out.println("Change to Radians:");
		System.out.println(Calculate.toRadians(180));
		System.out.println("Discriminant:");
		System.out.println(Calculate.discriminant(3,2,1));
		System.out.println("To Improper Fraction:");
		System.out.println(Calculate.toImproperFrac(2, 5, 7));
		System.out.println("To Mixed Number:");
		System.out.println(Calculate.toMixedNum(3,5));
		System.out.println("FOIL:");
		System.out.println(Calculate.foil(3, 2, 1, 5));
		System.out.println("Is it Divisible?");
		System.out.println(Calculate.isDivisibleBy(3,5));
		System.out.println("Absolute Value:");
		System.out.println(Calculate.absValue(-23));
		System.out.println("Maximum of Two:");
		System.out.println(Calculate.max(34, 3));
		System.out.println("Maximum of Three:");
		System.out.println(Calculate.max(3, 2.4, -8));
		System.out.println("Minimum of Two:");
		System.out.println(Calculate.min(3,-8));
		System.out.println("Round a Number:");
		System.out.println(Calculate.round2(2.33));
		System.out.println("Exponent:");
		System.out.println(Calculate.exponent(2,6));
		System.out.println("Factorial:");
		System.out.println(Calculate.factorial(5));
		System.out.println("Prime:");
		System.out.println(Calculate.isPrime(15));
		System.out.println("GCF:");
		System.out.println(Calculate.gcf(34,3));
		System.out.println("Square:");
		System.out.println(Calculate.sqrt(5));
	}
}
