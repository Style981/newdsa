package DSA.TreeBasedDSA;

public class FixingTraversal {
    int item;
    FixingTraversal left,right;

    public FixingTraversal(int key) {
        item = key;
        left = right = null;
    }

    class BinaryTree{
        FixingTraversal root;

        BinaryTree(){
            root = null;
        }
    }
//Реалізація обходів дерева
    void inorder(FixingTraversal node){
        if(node == null)
            return;

        inorder(node.left); // Обхід лівого піддерева
        System.out.println(node.item + "-->");//Вивід кореня
        inorder(node.right); //ОБхід правого підерева

    }

    void preorder(FixingTraversal node){
        if(node == null)
            return;

        System.out.println(node.item + "-->"); //Вивід кореня
        preorder(node.left);
        preorder(node.right);


    }

    void postorder(FixingTraversal node){
        if(node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.println(node.item + "-->");//Вивід кореня
    }

    public  FixingTraversal countNodes(FixingTraversal node){
        FixingTraversal count = node;
        System.out.println("count node:" + count);
        return count;

    }
    public void findMax(FixingTraversal item){
        
    }




}
