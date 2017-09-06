
public class DoMath {

	public static void main(String[] args) {
		Calculate.square(5);
		System.out.println("Square:");
		System.out.println(Calculate.square(2));
		System.out.println("Cube:");
		System.out.println(Calculate.cube(3));
		System.out.println("Average of Two Doubles:");
		System.out.println(Calculate.average2(4.0,3.0));
		System.out.println("Average of Three Doubles");
		System.out.println(Calculate.average3(2.3,4.6,1.2));
	}

}
