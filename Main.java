import mypkg.Calculator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        System.out.println("=== Calculator using Package ===");
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();

        System.out.println("Choose operation: ");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        int choice = sc.nextInt();

        try {
            switch (choice) {
                case 1: System.out.println("Result = " + calc.add(a, b)); break;
                case 2: System.out.println("Result = " + calc.subtract(a, b)); break;
                case 3: System.out.println("Result = " + calc.multiply(a, b)); break;
                case 4: System.out.println("Result = " + calc.divide(a, b)); break;
                default: System.out.println("Invalid choice!");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
