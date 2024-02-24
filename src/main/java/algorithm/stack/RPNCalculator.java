package algorithm.stack;
import datastructure.stack.Mystack;

public class RPNCalculator {

    /**
     * Evaluates the reverse Polish notation expression.
     *
     * @param tokens An array of strings representing the RPN expression
     * @return The evaluation result of the RPN expression
     */
    public static int evalRPN(String[] tokens) {
        Mystack<Integer> stack = new Mystack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int num2 = stack.pop(); // 注意：第二个弹出的是第二个操作数
                    int num1 = stack.pop();
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
                            stack.push(num1 / num2); // 假设这里不会出现除以0的情况
                            break;
                    }
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens)); // 输出9
    }
}