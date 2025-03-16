package DSA.Strucrures1;

import java.util.ArrayList;

public class PriorityQueues {
    //функция для создания дерева
    void heapify  (ArrayList<Integer> hT, int i){
        int size = hT.size();
        //Найдите самый больой корневой среди левых и правих дочерних элементов
        int largest = i;
        int left = 2 * i + 1; // Левый потомок
        int right = 2 * i + 2;// Правый потомок

// Если левый потомок больше корня
        if(left < size && hT.get(left) > hT.get(largest))
            largest = left;
        // Если правый потомок больше текущего наибольшего
        if(right < size && hT.get(right) > hT.get(largest))
            largest = right;

        //Поменяйте места и продолжайте создание кучи  если  корень не самый  большой

        if(largest != i) {
            int temp = hT.get(largest);
            hT.set(largest, hT.get(i));
            hT.set(i, temp);

            heapify(hT, largest);
        }
    }

    //Функция для вставки элемента в  дерево
    void insert(ArrayList<Integer> hT, int newNum) {
        int size = hT.size();
        if(size == 0) {
            hT.add(newNum);

        }else {
            hT.add(newNum);
            for (int i = size / 2 - 1; i >= 0; i--){
                heapify(hT,i);
            }
        }

    }
    //Функция удаление элемента их дерева
    void deletNode(ArrayList<Integer> hT, int num) {
        int size = hT.size();
        int i;
        for(i = 0; i < size; i++) {
            if(num == hT.get(i))
                break;
        }

        int temp = hT.get(i);
        hT.set(i, hT.get(size - 1));
        hT.set(size - 1, temp);

        hT.remove(size -1);
        for(int j = size / 2 -1; j >= 0; j--) {
            heapify(hT, j);
        }
    }

    void printArray(ArrayList<Integer> array, int size) {
        for (Integer i : array){
            System.out.println(i + "");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        ArrayList<Integer> array = new ArrayList<>();
        int size = array.size();

        PriorityQueues p = new PriorityQueues();

        p.insert(array, 3);
        p.insert(array, 4);
        p.insert(array, 9);
        p.insert(array, 5);
        p.insert(array, 2);
        p.insert(array, 22);
        p.insert(array, 1);

        System.out.println("Max-Heap array: ");
        p.printArray(array, size);

        p.deletNode(array, 9);
        System.out.println("after deleting an element: ");
        p.printArray(array, size);

    }



}


