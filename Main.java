import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("CalculatorLogger");
        Calculator calculator = new Calculator(logger);
        try (Scanner scanner = new Scanner(System.in)) {
            double a, b;
            String operation;

            System.out.print("Enter the first number: ");
            a = scanner.nextDouble();

            System.out.print("Enter the operation (+, *, /): ");
            operation = scanner.next();

            System.out.print("Enter the second number: ");
            b = scanner.nextDouble();

            switch (operation) {
                case "+":
                    calculator.setOperation(new AdditionOperation());
                    break;
                case "*":
                    calculator.setOperation(new MultiplicationOperation());
                    break;
                case "/":
                    calculator.setOperation(new DivisionOperation());
                    break;
                default:
                    System.out.println("Invalid operation");
                    return;
            }

            try {
                double result = calculator.calculate(a, b);
                System.out.println(String.format("%f %s %f = %f", a, operation, b, result));
            } catch (IllegalArgumentException e) {
                logger.warning(e.getMessage());
            }
        }
    }
}
