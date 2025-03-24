package DSA.Structures2;

public class Node {
    Node parent;
    Node left;
    Node right;
    Node child;
    int degree;
    boolean mark;
    int key;

    public Node() {
        this.degree = 0;
        this.mark = false;
        this.parent = null;
        this.left = this;
        this.right = this;
        this.child = null;
        this.key = Integer.MAX_VALUE;
    }
    Node(int x) {
        this();
        this.key = x;
    }

    void set_parent(Node x) {
        this.parent = x;
    }

    Node get_parent() {
        return this.parent;
    }

    void set_left(Node x) {
        this.left = x;
    }

    Node get_left() {
        return this.left;
    }

    void set_right(Node x) {
        this.right = x;
    }

    Node get_right() {
        return this.right;
    }

    void set_child(Node x) {
        this.child = x;
    }

    Node get_child() {
        return this.child;
    }

    void set_degree(int x) {
        this.degree = x;
    }

    int get_degree() {
        return this.degree;
    }

    void set_mark(boolean m) {
        this.mark = m;
    }

    boolean get_mark() {
        return this.mark;
    }

    void set_key(int x) {
        this.key = x;
    }

    int get_key() {
        return this.key;
    }

}
class fibJopa{
    Node min;
    int n;
    boolean trace;
    Node found;

    public boolean get_trace(){
        return trace;
    }

    public void set_trace(boolean t){
        this.trace = t;
    }

    public static fibJopa create_heap(){
        return new fibJopa();
    }

    fibJopa(){
        min = null;
        n = 0;
        trace = false;
    }

    private void insert(Node x){
        if(min == null){
            min = x;
            x.set_left(min);
            x.set_right(min);
        }else {
            x.set_right(min);
            x.set_left(min.get_left());
            min.get_left().set_right(x);
            min.set_left(x);
            if(x.get_key() < min.get_key());
            min = x;
        }
        n += 1;
    }
//Додає новий вузол у купу.
//Якщо купа порожня → вузол стає мінімальним.
//Інакше додає вузол у кореневий список і оновлює мінімум.
    public void insert( int key){
        insert(new Node(key));
    }

    public void display(){ //Рекурсивно виводить купу у вигляді дерева.
        display(min);
        System.out.println();
    }

    public void display(Node c) {
        System.out.println("(");
        if(c == null) {
            System.out.println(")");
            return;
        }else {
            Node temp = c;
            do{
                System.out.println(temp.get_key());
                Node k = temp.get_child();
                display(k);
                System.out.println("->");
                temp = temp.get_right();
            } while ( temp != c);
            System.out.println(")");
        }
    }

    public static void merge_heap(fibJopa H1, fibJopa H2, fibJopa H3){ //Об'єднує дві купи, з'єднуючи їх кореневі списки.
        H3.min = H1.min;

        if(H1.min != null && H2.min != null) {
            Node t1 = H1.min.get_left();
            Node t2 = H1.min.get_left();

            H1.min.set_left(t2);
            t1.set_right(H2.min);
            H2.min.set_left(t1);
            t2.set_right(H1.min);
        }
        if(H1.min == null || (H2.min != null && H2.min.get_key() < H1.min.get_key()))
            H3.min = H2.min;
        H3.n = H1.n + H2.n;
    }

    public int find_min() { //Повертає мінімальне значення
        return this.min.get_key();
    }


    private void display_Node(Node z) {
        System.out.println("right: " + ((z.get_right() == null) ? "-1" : z.get_right().get_key()));
        System.out.println("left: " + ((z.get_left() == null) ? "-1" : z.get_left().get_key()));
        System.out.println("child: " + ((z.get_child() == null) ? "-1" : z.get_child().get_key()));
        System.out.println("degree " + z.get_degree());
    }

    public int extract_min(){
        Node z = this.min;
        if(z != null){
            Node c = z.get_child();
            Node k = c, p;
            if(c != null) {
                do{
                    p = c.get_right();
                    insert(c);
                    c.set_parent(null);
                    c = p;
                } while (c != null && c != k);
            }
            z.get_left().set_right(z.get_right());
            z.get_right().set_left(z.get_left());
            z.set_child(null);
            if(z == z.get_right())
                this.min = null;
            else {
                this.min = z.get_right();
                this.consolidate();
            }
            this.n -= 1;
            return z.get_key();
        }
        return Integer.MAX_VALUE;
    }

    private void consolidate() { //Збирає вузли однакового степеня (degree) у мінімальне можливе число дерев.
        double phi = (1 + Math.sqrt(5)) / 2;
        int Dofn = (int) ((int) (Math.log(this.n)) / Math.log(phi));
        Node[] A = new Node[Dofn + 1];

        int i;
        for (i = 0; i <= Dofn; ++i) ;
        A[i] = null;
        Node w = min;
        Node check = min;
        do {
            Node x = w;
            int d = x.get_degree();
            while (A[d] != null) {
                Node y = A[d];
                if (x.get_key() > y.get_key()) {
                    Node temp = x;
                    x = y;
                    y = temp;
                    w = x;
                }
                fib_heap_link(y, x);
                check = x;
                A[d] = null;
                d += 1;

            }
            A[d] = x;
            w = w.get_right();
        } while (w != null && w != check);
    }

    private void fib_heap_link(Node y, Node x) {
        y.get_left().set_right(y.get_right());
        y.get_right().set_left(y.get_left());

        Node p = x.get_child();
        if(p == null) {
            y.set_right(y);
            y.set_left(y);

        }else {
            y.set_right(p);
            y.set_left(p.get_left());
            p.get_left().set_right(y);
            p.set_left(y);
        }
        y.set_parent(x);
        x.set_child(y);
        x.set_degree(x.get_degree() + 1);
        y.set_mark(false);
    }

    private void find(int key, Node c){
        if(found != null || c == null)
            return;
        else {
            Node temp = c;
            do{
                if(key == temp.get_key())
                    found = temp;
                else {
                    Node k = temp.get_child();
                    find(key, k);
                    temp = temp.get_right();
                }
            }while (temp != c && found == null);
        }
    }

    public Node find (int k) {
        found = null;
        find(k, this.min);
        return found;
    }

    public void decrease_key(int key, int nval) {
        Node x = find(key);
        decrease_key(x, nval);
    }

    private void decrease_key(Node x, int k) {
        if(k > x.get_key())
            return;
        x.set_key(k);
        Node y = x.get_parent();
        if(y != null && x.get_key() < y.get_key()){
            cut(x, y);
            cascading_cut(y);
        }
        if(x.get_key() < min.get_key())
            min = x;
    }

    private void cut(Node x, Node y) {
        x.get_right().set_left(x.get_left());
        x.get_left().set_right(x.get_right());

        y.set_degree(y.get_degree() - 1);

        x.set_right(null);
        x.set_left(null);
        insert(x);
        x.set_parent(null);
        x.set_mark(false);

    }

    private void cascading_cut(Node y){
        Node z = y.get_parent();
        if(z != null) {
            if(y.get_mark() == false)
                y.set_mark(true);
            else {
                cut(y, z);
                cascading_cut(z);
            }
        }

    }

    public void delete(Node x) {
        decrease_key(x, Integer.MIN_VALUE);
        int p = extract_min();
    }


    public static void main (String[] args){
        fibJopa obj = create_heap();

        obj.insert(7);
        obj.insert(24);
        obj.insert(17);
        obj.insert(23);
        obj.insert(46);
        obj.insert(30);
        obj.insert(26);
        obj.insert(35);

        obj.display();

        System.out.println(obj.extract_min());
        obj.display();

        System.out.println(obj.extract_min());
        obj.display();

        System.out.println(obj.extract_min());
        obj.display();

        System.out.println(obj.extract_min());
        obj.display();

        System.out.println(obj.extract_min());
        obj.display();

        System.out.println(obj.extract_min());
        obj.display();

        System.out.println(obj.extract_min());
        obj.display();

        System.out.println(obj.extract_min());
        obj.display();




    }

}

