package DSA;


public class DataStructure {

        class Plate {
            private int arr[];
            private int top;
            private int capacity;

            Plate(int size) {
                arr = new int[size];
                capacity = size;
                top = -1;
            }

            public void push(int x) {
                if (isFull()) {
                    System.out.println("Overflow: ");
                    return;
                }
                System.out.println("Inserting: " + x);
                arr[++top] = x;
            }

            public int pop() {
                if (isEmpty()) {
                    System.out.println("Stack Empty");
                    return -1;
                }
                return arr[top--];
            }

            public boolean isEmpty() {
                return top == -1;
            }

            public boolean isFull() {
                return top == capacity - 1;
            }

            public void printPlate() {
                for (int i = 0; i <= top; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }

        // Метод main для тестування стеку
        public static void main(String[] args) {
            DataStructure ds = new DataStructure();
            Plate stack = ds.new Plate(5);

            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);

            stack.printPlate();

            stack.pop();
            System.out.println("After popping one element:");
            stack.printPlate();
        }
    }

