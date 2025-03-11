package DSA.practice.days;

public class calculateFactorial  {

     static int calculateFactorial(int num) {
        if(num !=0)
            return num*calculateFactorial(num-1);
        else return 1;
    }
    public static void main(String[] args) {
         int number = 5, result;
         result = calculateFactorial(number);
         System.out.println(number + "factorial = " + result);
    }

}

