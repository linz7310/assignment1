package algorithm.stack;
import datastructure.stack.Mystack;

public class RPNCalculator {

    /**
     * Evaluates the  reverse Polish notation expression.
     *
     * @param tokens An array of strings representing the RPN expression
     * @return The evaluation result of the RPN expression
     */
    public static double evalRPN(String[] tokens) {
        Mystack<Double> stack = new Mystack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    double num2 = stack.pop(); // Note: The second popup is the second operand
                    double num1 = stack.pop();
                    switch (token) {
                        case "+":
                            stack.push(num1 + num2);
                            break;
                        case "-":
                            stack.push(num1 - num2);
                            break;
                        case "*":
                            stack.push(num1 * num2);
                            break;
                        case "/":
                            if (num2 == 0) {
                                throw new ArithmeticException("Invalid expression: division by zero.");
                            }
                            stack.push(num1 / num2);
                            break;
                    }
                    break;
                default:
                    stack.push(Double.parseDouble(token));
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: too many operands.");
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[][] testCases = {
                {"4", "3", "+"},
                {"4", "13", "5", "/", "+"},
                {"10", "6", "-", "9", "*"},
                {"2", "1", "+", "3", "*"},
                {"5", "1", "2", "+", "4", "*", "+", "3", "-"},
                {"42"},
                {"1", "2", "+", "3", "4", "+", "*", "5", "-"},
                {"0", "3", "/", "4", "2", "*", "+"},
                {"5", "3", "-", "2", "1", "+", "-"},
                {"5", "9", "1", "-", "/", "2", "3", "+", "*"},
                {"0", "0", "/"}
        };
        Double[] expectedResults = {7.0, 6.6, 36.0, 9.0, 14.0, 42.0, 16.0, 8.0, -1.0, 3.125};


    }
}