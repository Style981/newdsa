package DSA;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            //Меню для вибора алгоритму
        while(true) {
            System.out.println("\n Choise algorithm: ");
            System.out.println("1- Додавання двох чисел: ");
            System.out.println("2- Найбільше із трьох чисел: ");
            System.out.println("0 - Exit: ");
            System.out.println("Введіть номер алгоритму: ");

            int choice = sc.nextInt();

            //Виклик потрібного метода в  залежності від вибору

            switch(choice) {
                case 1:
                    AddTwoNumbers add = new AddTwoNumbers();
                    add.addTwoNumbers();
                    break;
                    case 2:
                        FindMaxNumber findMax = new FindMaxNumber();
                        findMax.findMaxNumber();
                        break;
                        case 0:
                            System.out.println("Exit");
                            sc.close();
                            return;
                            default:
                                System.out.println("Wrong choice");


            }
        }

    }
}