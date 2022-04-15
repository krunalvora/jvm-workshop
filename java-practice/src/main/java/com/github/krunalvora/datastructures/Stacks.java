package com.github.krunalvora.datastructures;


import java.util.Stack;

public class Stacks {
    
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();
        
        stack.add(1);
        System.out.println(stack.toString());

        stack.add(2);
        System.out.println(stack.toString());

        System.out.println("Peeking: " + stack.peek());

        System.out.println("Popping: " + stack.pop());

        System.out.println(stack.toString());
        
    }
}
