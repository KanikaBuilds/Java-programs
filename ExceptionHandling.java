import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Taking input from the user
            System.out.print("Enter numerator: ");
            int numerator = sc.nextInt();

            System.out.print("Enter denominator: ");
            int denominator = sc.nextInt();

            // Division operation
            int result = numerator / denominator;
            System.out.println("Result: " + result);
        } 
        catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed!");
        } 
        catch (InputMismatchException e) {
            System.out.println("Error: Invalid input! Please enter integers only.");
        } 
        finally {
            System.out.println("Execution completed. Thank you!");
            sc.close();
        }
    }
}
