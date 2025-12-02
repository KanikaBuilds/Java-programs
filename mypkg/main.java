import mypkg.Calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int x = 5, y = 3;
        System.out.println("Sum: " + calc.add(x, y));
        System.out.println("Product: " + calc.multiply(x, y));
    }
}
