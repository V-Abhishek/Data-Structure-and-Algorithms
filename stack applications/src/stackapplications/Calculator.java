/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackapplications;

/**
 *
 * @author Abhishek
 */
public class Calculator {

    public static void main(String[] args) {
        PostfixEvaluator input = new PostfixEvaluator("(300 + 23) * (43 - 21) / (84 + 7)");
        System.out.println("Post Fix expression:"+ input.getPostfix());
        System.out.println("Postfix Result:" + PostfixEvaluator.postfixResult(input.getPostfix()));
    }

}
