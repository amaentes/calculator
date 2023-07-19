import java.util.logging.Logger;

class Calculator {
    private CalculatorOperation operation;
    private Logger logger;

    public Calculator(Logger logger) {
        this.logger = logger;
    }

    // Установка операции калькулятора
    public void setOperation(CalculatorOperation operation) {
        this.operation = operation;
    }

    // Выполнение операции калькулятора
    public double calculate(double a, double b) {
        double result = operation.execute(a, b);
        logger.info(String.format("Calculation: %f %s %f = %f", a, operation.getClass().getSimpleName(), b, result));
        return result;
    }
}