package DSA.Strucrures1;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxHeap {
    public static void heapify(int[] arr, int n, int i){
        int root = i;
        int l = 2 * i + 1; //лев потомок
        int r = 2 * i + 2; //прав потомок

        //якщо лівий отомок більше текущего наібільшого узла
        if(l < n && arr[l] > arr[root])
            root = l;

        if(r < n && arr[r] > arr[root])
            root = r;

        //якщо найбільший єлемент змінився, міняїм містами і рекурсивно применяем heapify
        if(root!= i){
            int swap = arr[i];
            arr[i] = arr[root];
            arr[root] = swap;
// Рекурсивно heapify на изменённом поддереве
            heapify(arr, n, root);
        }

    }

    public static void buildMax(int[] arr) {
        int n = arr.length;

        // Обрабатываем только нелистовые узлы
        for(int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void main(String[] args) {
        int[] arr ={1,12,9,5,6,10};

        buildMax(arr);
        System.out.println("Max-heap: " + Arrays.toString(arr));

    }

}
