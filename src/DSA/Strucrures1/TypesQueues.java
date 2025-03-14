package DSA.Strucrures1;

public class TypesQueues {
    int size = 5; //размер круговой очереди
    int front, rear;
    int items[] = new int [size];

    TypesQueues() {
        front = -1;
        rear = -1;
    }

    //провірити заповнена черга чи ні
    boolean isFull(){
        if(front == 0 && rear == size - 1){
            return true;
        }
        if(front == rear + 1){
            return true;
        }
        return false;
    }

    //проверить пуста черга
    boolean isEmpty(){
        if(front == -1)
            return true;
        else
            return false;
    }

    //Добовляем элемент
    void enQueue(int element){
        if(isFull()){
            System.out.println("Queue is full");
        }else{
            if(front == -1)
                front = 0;
            boolean b = rear == (rear + 1) % size;
            items[rear] = element;
            System.out.println("Insetted " + element);

        }
    }

    //Видаленя элемента
    int deQueue(){
        int element;
        if(isEmpty()){
            System.out.println("Queue is empty");
            return (-1);
        }else {
            element = items[front];
            if(front == rear) {
                front = -1;
                rear = -1;
            } //Q имеет только один элемент, поэтому мы сбрасываем очередь после его удаления.
            else{
                front = (front + 1) % size;
            }
            return element;
        }
    }

    void display(){
        int i;
        if(isEmpty()){
            System.out.println("Queue is empty");
        }else {
            System.out.println("front -> " + front);
            System.out.println("Items -> ");
            for(i = front; i != rear; i = (i + 1) % size)
                System.out.print(items[i] + " ");
            System.out.println(items[i]);
            System.out.println("Rear -  > " + rear);
        }
    }

    public static void main(String[] args) {
        TypesQueues obj = new TypesQueues();

        obj.deQueue();


        obj.enQueue(1);
        obj.enQueue(2);
        obj.enQueue(3);
        obj.enQueue(4);
        obj.enQueue(5);

        obj.enQueue(6);


        obj.display(); //вивиде 12345

        int elem = obj.deQueue();

        if(elem != -1){
            System.out.println("Deleted element " + elem);
        }
        obj.display();

        obj.enQueue(7);

        obj.display();

        obj.enQueue(8);

        //1 єлемент видалено. замисть нього 2 єлемнет  стає первим і показує 23456
    }
}
