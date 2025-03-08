package DSA.practice.days;

import java.util.Scanner;
import java.util.Stack;

public class Lifo {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch); //Якщо це відкрита дужка, додаємо її в стек
            }else{
                if(stack.isEmpty()) return false; //Якщо стек порожній, а закриваюча дужка є - помилка
                char top = stack.pop(); //Витягуємо верхній елемент зі стека
                if ((ch == ')' && top != '(') ||
                        (ch =='}' && top != '{') ||
                        (ch == ']' && top != '[')){
                    return false; //Якщо дужки не співпадають, рядок неправильний
                }


            }
        }
        return stack.isEmpty(); // Якщо після всього стек порожній – дужки правильні
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ведіть рядок: ");
        String input = sc.nextLine(); // Отримуємо рядок від користувача

        if (isValid(input)) {
            System.out.println("Correct");

        }else System.out.println("Wrong");

    }





}
