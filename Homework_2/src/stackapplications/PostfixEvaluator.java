/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackapplications;

import java.util.Stack;

/**
 *
 * @author Abhishek
 */
public class PostfixEvaluator {

    private final String infixExpression;
    private String postfixExpression;
    private Stack<Character> operatorStack = null;

    public PostfixEvaluator(String infixExpression) {
        this.infixExpression = infixExpression;
    }

    public int precedenceOutput(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public void pushOperatorStack(char temp) {
        if (temp == '(') {
            operatorStack.push('(');
        } else if (temp == ')') {
            while (!operatorStack.empty() && operatorStack.peek() != '(') {
                postfixExpression = postfixExpression + operatorStack.pop() + " ";
            }
            if (operatorStack.peek() == '(') {
                operatorStack.pop();
            }
        } else {
            while (!operatorStack.empty() && precedenceOutput(temp) <= precedenceOutput(operatorStack.peek())) {
                postfixExpression = postfixExpression + operatorStack.pop() + " ";
            }
            operatorStack.push(temp);
        }

    }

    public String getPostfix() {
        postfixExpression = "";
        operatorStack = new Stack<>();
        if (infixExpression != null) {
            for (int i = 0; i < infixExpression.length(); i++) {
                char charUnderCheck = infixExpression.charAt(i);
                if (Character.isLetterOrDigit(charUnderCheck)) {
                    if (Character.isAlphabetic(charUnderCheck)) {
                        postfixExpression = postfixExpression + charUnderCheck + " ";
                    } else {
                        int number = 0;
                        while (infixExpression.charAt(i) != ' ' && infixExpression.charAt(i) != '(' && infixExpression.charAt(i) != ')') {
                            number = number * 10 + Integer.parseInt(infixExpression.charAt(i) + "");
                            i++;
                        }
                        i=i-1;
                        postfixExpression = postfixExpression + String.valueOf(number) + " ";
                    }

                } else if (charUnderCheck == ' ') {
                    continue;
                } else {
                    pushOperatorStack(charUnderCheck);
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            postfixExpression = postfixExpression + operatorStack.pop() + " ";
        }
        return postfixExpression;
    }

    public static int postfixResult(String postFixExpression) {
        Stack<Integer> operation = new Stack<>();
        int result = 0;
        for (int i = 0; i < postFixExpression.length(); i++) {
            char input = postFixExpression.charAt(i);
            if (Character.isDigit(input)) {
                int number = 0;
                while (Character.isDigit(input)) {
                    number = number * 10 + Integer.parseInt(input + "");
                    i++;
                    input = postFixExpression.charAt(i);
                }
                i--;
                operation.push(number);
            } else if (input == ' ') {
                continue;
            } else {
                int number1 = operation.pop();
                int number2 = operation.pop();

                switch (input) {
                    case '+':
                        operation.push(number1 + number2);
                        break;
                    case '-':
                        operation.push(number2 - number1);
                        break;
                    case '*':
                        operation.push(number2 * number1);
                        break;
                    case '/':
                        operation.push(number2 / number1);
                        break;
                }
            }
        }
        if (!operation.empty()) {
            result = operation.pop();
            return result;
        }

        System.out.println("Invalid input data");
        System.exit(1);
        return -1;
    }

}
