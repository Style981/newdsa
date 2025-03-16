package DSA.Strucrures1;

    public class Deque {
        static final int Max = 100; //аксимальний розмір масиву
        int arr[];//масив у якому зберіграются єлементи
        int front; //індекс першого єлемента
        int rear; //індекс останнього єлемента
        int size; // фактичний розмір деку

        //конструктор
        public Deque(int size){
            arr = new int[Max]; //створюється масив для зберігання елементів.
            front = -1;  //означає, що дек спочатку порожній.
            rear = 0; //початкове значення заднього індексу.
            this.size = size; //зберігається максимальна кількість елементів у деці.
        }

        boolean isFull() {
            return((front == 0 && rear == size - 1) //Якщо front == 0 && rear == size - 1 — масив заповнений з обох сторін.
                    || front == rear + 1); //Якщо front == rear + 1 — масив заповнений циклічно.
        }

        boolean isEmpty(){
            return(front == -1); //перевіряє чи дек порожній
        }

        void insertfront(int key){
            if(isFull()) {
                System.out.println("Overflow");
            }
            // Якщо дек порожній, встановлюємо
            if(front == - 1) {
                front = 0;
                rear = 0;
            }
            else if (front == 0) //Якщо front == 0, потрібно зробити циклічне перенесення (front = size - 1).
                front = size - 1;
            else
                front = front - 1; //Інакше просто зменшуємо front.
            arr[front] = key;
        }

        void insertrear(int key) {
            if(isFull()) {
                System.out.println("OverFlow");
                return;
            }

            if(front == -1){
                front = 0;
                rear = 0;

            }
            else if (rear == size -1) //Якщо rear == size - 1, то переходимо в початок масиву (rear = 0).
                rear = 0;
            else
                rear = rear + 1; //Інакше просто збільшуємо rear.

            arr[rear] = key;
        }

        void deletefront() {
            if(isEmpty()) {
                System.out.println("Queue UnderFlow");
                return;
            }

            if(front == rear) { //Якщо front == rear, дек містить лише один елемент → очищаємо.
                front = -1;
                rear = -1;

            }
            else if ( front == size - 1) //Якщо front на кінці, переносимо його на початок (front = 0).
                front = 0;
            else
                front = front + 1; //Інакше просто збільшуємо front.
        }

        void deleterear(){
            if(isEmpty()) {
                System.out.println("Underflow");
                return;
            }

            if(front == rear){
                front = -1;
                rear = - 1;
            }
            else if ( rear == 0) //Якщо rear == 0, то повертаємося в кінець (rear = size - 1).
                rear = size -1;
            else
                rear = rear -1; //Інакше просто зменшуємо
        }

        int getFront() { //повертає перший елемент.
            if(isEmpty()) {
                System.out.println("UnderFlow");
                return -1;
            }
            return arr[front];
        }

        int getRear() { // повертає останній елемент.
            if(isEmpty()|| rear < 0) {
                System.out.println("Underflow");
                return - 1;
            }
            return arr[rear];
        }

        public static void main(String[] args) {
            Deque dq = new Deque(4);

            System.out.println("Insert element at rear end : 12 ");
            dq.insertrear(12);

            System.out.println("Insert element at rear end : 14 ");
            dq.insertrear(14);

            System.out.println("Get rear element : " + dq.getRear());

            dq.deleterear();
            System.out.println("After delete rear element new rear become : " + dq.getRear());

            System.out.println("Inserting element at front end");
            dq.insertfront(13);

            System.out.println("Get front element: " + dq.getFront());

            dq.deletefront();
            System.out.println("After delete front element new front become : " + dq.getFront());
        }


    }
