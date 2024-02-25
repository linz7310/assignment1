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
                    if (stack.size() < 2) {
                        throw new ArithmeticException("Invalid expression: insufficient operands.");
                    }
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
                    try {
                        double num = Double.parseDouble(token);
                        stack.push(num);
                    } catch (NumberFormatException e) {
                        throw new ArithmeticException("Invalid token: " + token);
                    }
                    break;
            }
        }
        if (stack.size() != 1) {
            throw new ArithmeticException("Invalid expression: too many operands.");
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
                {"1","/","/"},
                {"1","/","/","2","5"},
                {"/","2","/"}
        };
        Double[] expectedResults = {7.0, 6.6, 36.0, 9.0, 14.0, 42.0, 16.0, 8.0, -1.0, 3.125,Double.NaN,Double.NaN,Double.NaN};

        for (int i = 0; i < testCases.length; i++) {
            try {
                double result = evalRPN(testCases[i]);
                boolean isCorrect = Double.isNaN(expectedResults[i]) || result == expectedResults[i];
                System.out.println("Test Case " + (i + 1) + ": " + (isCorrect ? "Passed" : "Failed") + " (Expected: " + expectedResults[i] + ", Got: " + result + ")");
            } catch (ArithmeticException e) {
                if (Double.isNaN(expectedResults[i])) {
                    System.out.println("Test Case " + (i + 1) + ": Passed (Expected: Division by zero error, Got: " + e.getMessage() + ")");
                } else {
                    System.out.println("Test Case " + (i + 1) + ": Failed (Expected: " + expectedResults[i] + ", Got: " + e.getMessage() + ")");
                }
            }
        }
    }
}