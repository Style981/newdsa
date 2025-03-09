package DSA.practice.days;

import java.util.Scanner;

public class Queue {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Ведіть число: ");
        int n = sc.nextInt(); // Отримуємо число від користувача

        System.out.println("Прості чсила: ");
        for(int i = 2; i <=n; i++){ // Перебираємо всі числа від 2 до N
            if(isNum(i)){ // Перевіряємо, чи число i є простим
                System.out.print(i + " "); // Виводимо просте число
            }
        }




    }

    private static boolean isNum (int num1) {
        if (num1 < 2) return false; // Числа менше 2 не є простими

        for(int i = 2; i * i <= num1; i++) { // Перевіряємо, чи є дільники
            if (num1 % i == 0) return false; // Якщо ділиться без залишку – не просте
        }
        return true; // Якщо жодного дільника не знайшли – число просте
    }


       /* Scanner user = new Scanner(System.in);
        System.out.println("Введіть рядок: ");

        int number = user.nextInt(); // Отримуємо число від користувача

        if(isNumber(number)){
            System.out.println("Це число Армстронга: ");
        }else{
            System.out.println("Це не число Армстронга:  ");
        }


    }

    private static boolean isNumber(int number) {
        int origNum = number; // Зберігаємо початкове число
        int sum = 0;
        int digit = String.valueOf(number).length(); // Визначаємо кількість цифр6

        while(number > 0){
            int digits = number % 10;
            sum += Math.pow(digits, digit);
            number /= 10;
        }
        return sum == origNum;
    }*/


}
