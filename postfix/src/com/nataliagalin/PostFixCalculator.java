package com.nataliagalin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Nat and Alex's calculator.
 */
public class PostFixCalculator {
    private final Deque<Float> stack = new ArrayDeque<>();

    public float evaluate(List<String> tokens) {
        for (String token : tokens) {
            acceptToken(token);
        }
        Float result = stack.pop();
        if (!stack.isEmpty()) {
            throw new IllegalStateException("Expression not complete, stack: " + stack);
        }
        return result;
    }

    private void acceptToken(String token) {
        float result = applyToken(token);
        stack.push(result);
    }

    private float applyToken(String token) {
        switch (token) {
            case "+":
                return stack.pop() + stack.pop();
            case "-":
                return -stack.pop() + stack.pop();
            case "*":
                return stack.pop() * stack.pop();
            case "/":
                return stack.pop() / stack.pop();
            default:
                return Float.parseFloat(token);
        }
    }

    @SuppressWarnings("unused")
    private static void debug(float value) {
        System.out.println("Evaluated: " + value);
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            String[] tokens = input.split("\\s+");
            PostFixCalculator myCalcy = new PostFixCalculator();
            try {
                float result = myCalcy.evaluate(Arrays.asList(tokens));
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(String.format("Invalid expression %s: %s", input, e.getMessage()));
            }
        }
    }
}

