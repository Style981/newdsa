package DSA.practice.days;

import java.util.Scanner;
import java.util.Stack;

public class IphonSeria {

    public static void main(String[] args) {

            Stack<String> st = new Stack<>();
            st.push("Iphon 11seria Black");
            st.push("Iphon 12seria Wiet");
            st.push("Iphon 13seria Pink");
            st.push("Iphon 14seria Blue");
            st.push("Iphon 15seria Reed");

            System.out.println("upper element: " + st.peek());

            System.out.println("Delet element: " + st.pop());
            System.out.println("New upper element: " + st.peek());

            System.out.println("void stack: " + st.isEmpty());

            System.out.println("size of stack: " + st.size());

    }


}







