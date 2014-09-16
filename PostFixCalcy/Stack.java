package com.nataliagalin;

/**
 * Created by ngalin on 12/09/2014.
 */
public class Stack {
    int stackLength = 0;
    static int MAX_STACK_LENGTH = 100;
    Float[] stackOfNumbers = new Float[MAX_STACK_LENGTH];

    //why had to use 'this'?

    public void push (Float number) {
        if (stackFull()) {
            System.out.println("Start computing - no more space on stack!");
        }
        else {
            this.stackLength += 1;
            stackOfNumbers[stackLength] = number;
        }
    }
    public Float pop() {
        if (stackEmpty()) {
            System.out.println("Stack empty");
            return Float.NaN;
        }
        else {
            this.stackLength -= 1;
            return stackOfNumbers[stackLength+1];
        }
    }

    boolean stackFull() {
        if (this.stackLength == MAX_STACK_LENGTH) return true;
        else return false;
    }

    boolean stackEmpty() {
        if (this.stackLength == 0) return true;
        else return false;
    }
}
