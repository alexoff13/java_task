package com.company;

public class Main {
    public static void main(String[] args) throws StackException {
        // Конструктор
        try {
            Stack<String> stack = new Stack<>(-1);
        } catch (StackException e) {
            System.out.println(e.getMessage() + ": Вызов конструктора с размером < 0");
        }
        try {
            Stack<Integer> stack = new Stack<>(0);
        } catch (StackException e) {
            System.out.println(e.getMessage() + ": Вызов конструктора с размером = 0");
        }

        int size = 13;
        Stack<String> stack = new Stack<>(size);

        // Pop testing
        try {
            stack.pop();
        } catch (StackException e) {
            System.out.println(e.getMessage() + ": pop | пустой стек");
        }


        // Push testing
        try {
            for (int i = 0; i < size + 1; ++i) {
                stack.push(Integer.toString(i * i));
            }
        } catch (StackException e) {
            System.out.println(e.getMessage() + ": переполненине");
        }

        // Find testing
        System.out.println("Find(9) in " + stack + " = " + stack.find("9"));
        System.out.println("Find(1) in " + stack + " = " + stack.find("1"));
        System.out.println("Find(2) in " + stack + " = " + stack.find("2"));
        try {
            stack.pop();
            stack.push("9");
            stack.find("9");
        } catch (StackException e) {
            System.out.println(e.getMessage() + ": there are several 9 on the stack: " + stack);
        }
    }
}