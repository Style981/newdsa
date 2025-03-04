package DSA;

import java.util.Scanner;

public class FindMaxNumber {

    public void findMaxNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введіть 3 числа ");

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int max = Math.max(a, Math.max(b, c ));
        System.out.println("Найбільше число : " + max);
    }
}
