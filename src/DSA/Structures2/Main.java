package DSA.Structures2;

class FibonacciHeapNode {
    int key; //значення вузла.
    int degree; //degree — кількість дітей у вузла.
    FibonacciHeapNode parent, child, left, right;
    boolean mark; //mark — використовується для операції decrease_key().


    public FibonacciHeapNode(int key) {
        this.key = key;
        this.degree = 0;
        this.parent = null;
        this.child = null;
        this.mark = false;
        this.left = this;
        this.right = this;
    }
}


class FibonacciHeap{
    private  FibonacciHeapNode min;
    private int n;


    public FibonacciHeap(){
        min = null; // вказує на вузол з найменшим значенням.
        n = 0; //n — кількість вузлів у купі.
    }

    public void insert(int key) {
        FibonacciHeapNode node = new FibonacciHeapNode(key);
        if(min == null){
            min = node;
        }else{
            mergeLists(min,node);
            if(node.key < min.key){
                min = node;
            }
        }
        n++;
    }

    public int findMin(){
        return min != null ? min.key : -1;
    }

    //операція
    public int extractMin(){
        FibonacciHeapNode oldMin = min;
        if(oldMin != null) {
            if(oldMin.child !=null) {
                FibonacciHeapNode child = oldMin.child;
                do {
                    FibonacciHeapNode next = child.right;
                    mergeLists(min,child);
                    child.parent = null;
                    child = next;

                }while (child != oldMin.child);

            }
        }
        removeNode(oldMin);
        if(oldMin == oldMin.right) {
            min = null;
        }else {
            min = oldMin.right;
            consolidate();
        }
        n--;
        return oldMin != null ? oldMin.key : -1;
    }


    private void consolidate() {
    }

    private void removeNode(FibonacciHeapNode node) {
        node.left.right = node.right;
        node.right.left = node.left;

    }


    private void mergeLists(FibonacciHeapNode a, FibonacciHeapNode b) {
        FibonacciHeapNode temp = a.right;
        a.right = b.right;
        b.right.left = a;
        b.right = temp;
        temp.left = b;

    }

}

public class Main {
    public static void main(String[] agrs) {
        FibonacciHeap heap = new FibonacciHeap();
        heap.insert(3);
        heap.insert(23);
        heap.insert(7);
        heap.insert(21);
        heap.insert(18);
        heap.insert(39);
        heap.insert(52);
        heap.insert(38);
        heap.insert(41);
        heap.insert(17);
        heap.insert(30);
        heap.insert(24);
        heap.insert(26);
        heap.insert(35);
        heap.insert(46);

        System.out.println("Min: " + heap.findMin());
        System.out.println("Extract Min: " + heap.extractMin());
        System.out.println("New Min: " + heap.findMin());
    }
}