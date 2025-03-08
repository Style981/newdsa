package DSA.practice.days;

import java.util.Stack;

public class ReversWorld {
    public static String reversWorld(String fiona) {

        Stack<Character> stack = new Stack<>();

        for (char ch : fiona.toCharArray()) {
            stack.push(ch);

        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static void main(String[] args) {

        String fiona = "Fiona";

        System.out.println("Original name: " + fiona);

        System.out.println("Reversed name: " + reversWorld(fiona));

        String fiona2 = "Shrek";


        System.out.println("Original name: " + fiona2);

        System.out.println("Reversed name: " + reversWorld(fiona2));

    }

//GIT разобратся и выложить


}
