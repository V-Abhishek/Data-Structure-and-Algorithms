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
public class InfixToPostfix {

    public static void main(String[] args) {
        ExpressionConverter infix = new ExpressionConverter("A * B / C + (D + E - (F * (G / H)))");
        System.out.println("Post-Fix Expression:" + infix.getPostfix());
    }
}
