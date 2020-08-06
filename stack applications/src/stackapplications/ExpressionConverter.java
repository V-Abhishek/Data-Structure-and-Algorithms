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
public class ExpressionConverter {

    private final String infixExpression;
    private String postfixExpression;
    private Stack<Character> operatorStack = null;

    public ExpressionConverter(String infixExpression) {
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
                postfixExpression += operatorStack.pop();
            }
            if (operatorStack.peek() == '(') {
                operatorStack.pop();
            }
        } else {
            while (!operatorStack.empty() && precedenceOutput(temp) <= precedenceOutput(operatorStack.peek())) {
                postfixExpression += operatorStack.pop();
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
                    postfixExpression += charUnderCheck;
                } else if (charUnderCheck == ' ') {
                    continue;
                } else {
                    pushOperatorStack(charUnderCheck);
                }
            }
        }
        while (!operatorStack.isEmpty()) {
            postfixExpression += operatorStack.pop();
        }
        return postfixExpression;
    }
}
