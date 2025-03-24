package DSA.TreeBasedDSA;

public class TreeTraversalNode {
    int item;
    TreeTraversalNode left, right;

    public TreeTraversalNode(int key) {
        item = key;
        left = right = null;
    }
}

    class BinaryTree{
        TreeTraversalNode root;

        BinaryTree(){
            root = null;
        }

        void postorder(TreeTraversalNode node){
            if(node == null)
                return;
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.item + "->");
        }

        void inorder(TreeTraversalNode node) {
            if(node == null)
                return;

            inorder(node.left);
            System.out.println(node.item + "->");
            inorder(node.right);
        }

        void preorder(TreeTraversalNode node) {
            if(node == null)
                return;

            System.out.println(node.item + "->");

            preorder(node.left);
            preorder(node.right);
        }

        public static void main(String[] args) {
            BinaryTree tree = new BinaryTree();

            tree.root = new TreeTraversalNode(1);
            tree.root.left = new TreeTraversalNode(12);
            tree.root.right = new TreeTraversalNode(9);

            tree.root.left.left = new TreeTraversalNode(5);
            tree.root.left.right = new TreeTraversalNode(6);

            System.out.println("Inorder traversal");
            tree.inorder(tree.root);

            System.out.println("\nPreorder traversal");
            tree.preorder(tree.root);

            System.out.println("\nPostorder traversal");
            tree.postorder(tree.root);
        }


    }
