package com.nataliagalin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.*;

/**
 * Created by ngalin on 12/09/2014.
 */
public class PostFixCalculator {
    static String endCalculation = "EOF";
    Stack myStack = new Stack();

    public void operateOn(String token) {
        if (!operator(token)) pushTokenToStack(token);
    }

    boolean operator(String token) {
        if (token.equals("+"))  performAddition();
        else if (token.equals("-"))  performSubtraction();
        else if (token.equals("*"))  performMultiplication();
        else if (token.equals("/"))  performDivision();
        else return false;

        return true;
    }

    void pushTokenToStack(String token) {
        try {
            myStack.push(Float.parseFloat(token));
        } catch(NumberFormatException e) {
            System.out.println("Ooops, you didn't enter a number");
        }
    }

    void print(float value) {
        myStack.push(value);
        System.out.println("Evaluated: " + value);
    }

    void performAddition() {
        float result = myStack.pop() + myStack.pop();
        print(result);
    }

    void performSubtraction() {
        float result = - myStack.pop() + myStack.pop();
        print(result);
    }

    void performMultiplication() {
        float result = myStack.pop() * myStack.pop();
        print(result);
    }

    void performDivision() {
        float result = myStack.pop() / myStack.pop();
        print(result);
    }

    public static void main (String args[]) {

        try{
            PostFixCalculator myCalcy = new PostFixCalculator();

            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));

            String input;

            while ((input=br.readLine())!=null) {
                if (input.equals(endCalculation)) {
                    break;
                } else {
                    String[] tokens = input.split("\\s+");
                    for (String token : tokens) myCalcy.operateOn(token);
                }
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}

//    static public boolean operator(String token) {
//
//        switch (token) {
//            case "+":
//                performAddition();
//                return true;
//            case "-":
//                performSubtraction();
//                return true;
//            case "*":
//                performMultiplication();
//                return true;
//            case "/":
//                performDivision();
//                return true;
//            default:
//                System.out.println("Have not implemented operator: " + token);
//                return false;
//        }
//        return false;//how did i get here?
//    }
