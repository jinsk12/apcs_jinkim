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
	}

}
