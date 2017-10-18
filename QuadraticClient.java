	import java.util.*;
	public class QuadraticClient {
		public static void main(String [] args) { //main method for scanner
			Scanner input = new Scanner(System.in);
			System.out.println("Welcome to the Quadratic Describer! \nProvide values for the coefficients a, b, c to calculate characteristics");
			boolean done = false;
				while(!done) {
				System.out.println("a:");
				double a = input.nextDouble();
				System.out.println("b:");
				double b = input.nextDouble();
				System.out.println("c:");
				double c = input.nextDouble();
				System.out.println(quadDescriber(a,b,c));
				System.out.println("Do you want to keep going? \nType \"done\" to end>");
				String finished = input.next();
				if(finished.equals("done")) {
					done = true;
					input.close();
				}
			}
		}
		public static String quadDescriber(double a, double b, double c) {
			String summaryOfQuad = "Description of the graph of:\ny = " + a +"x^2 + " + b + "x + " + c +"\n\n";
			double yInt=c;
			//gives direction of graph
			if(a > 0) {
				summaryOfQuad += "Opens: up \n";
			}else if(a <0) {
				summaryOfQuad += "Opens: down \n";
			}
			//used for the axis of symmetry
			//make sure to use escape function after every method for better presentation of data
			double axisForQuad = -b/(2*a);
			summaryOfQuad += "Axis of Symmetry: " + Quadratic.round2(axisForQuad) +"\n";
			//roots
			String roots = Quadratic.quadForm(a,b,c);
			if(roots.equals("no real roots")) {
				roots = "No roots";
			}
			summaryOfQuad += "x-intercepts : " + roots +"\n";
			//y-intercept
			summaryOfQuad += "y-intercept : " + c + "\n\n";
			return summaryOfQuad;
			//calculates vertex
			double valueOfY= (a * Quadratic.exponent(axisForQuad, 2)) + (b *axisForQuad) + c;
			summaryOfQuad += "Vertex: <" + axisForQuad + "," +Quadratic.round2(valueOfY) + ">\n";
		}

	}

